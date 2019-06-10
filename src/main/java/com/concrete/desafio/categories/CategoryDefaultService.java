package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryDefaultService implements CategoryService {

  private CategoryRepository categoryRepository;
  private static final String MOBILE_MARKET_ID = "MOB";

  @Autowired
  public CategoryDefaultService(final CategoryRepository categoryResponse) {
    this.categoryRepository = categoryResponse;
  }

  @Override
  public List<CategoryResponse> topCategories() {
    List<SubcategoryLvTwo> subcategoryLvTwo = sortSubCategoryLvTwo();
    return mapCategories(subcategoryLvTwo).stream().limit(5).collect(Collectors.toList());
  }

  private List<SubcategoryLvTwo> sortSubCategoryLvTwo() {
    CategoryThree categoryThree = categoryRepository.getCategoryThree().getBody();

    if (categoryThree == null) {
      throw new IllegalArgumentException("CategoryThree can not be null");
    }

    return FilterMobileCategories(categoryThree.getSubcategories()).getSubcategories().stream()
        .sorted(Comparator.comparing(SubcategoryLvTwo::getRelevance))
        .collect(Collectors.toList());
  }

  private Subcategory FilterMobileCategories(List<Subcategory> subcategories) {
    if (subcategories == null) {
      throw new IllegalArgumentException("SubCategories can not be null");
    }

    return subcategories.stream()
        .filter(subcategory -> MOBILE_MARKET_ID.equalsIgnoreCase(subcategory.getId()))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Mobile market category not found"));
  }

  private List<CategoryResponse> mapCategories(List<SubcategoryLvTwo> subCategories) {
    return subCategories.stream()
        .map(
            sub ->
                new CategoryResponse(
                    sub.getId(),
                    sub.getName(),
                    sub.getRelevance(),
                    sub.getIconImageUrl(),
                    mapSmallImageUrl(sub.getSubcategories())))
        .collect(Collectors.toList());
  }

  private String mapSmallImageUrl(List<SubcategoryLvThree> subcategoryLvThreeList) {
    return subcategoryLvThreeList.stream()
        .findFirst()
        .map(SubcategoryLvThree::getSmallImageUrl)
        .orElse("");
  }
}