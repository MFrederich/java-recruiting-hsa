package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.CategoryRepository;
import com.concrete.desafio.utils.ErrorHandler;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

    @Mock private CategoryRepository categoryRepository;
    private CategoryService categoryService;
    private CategoryController categoryController;
    private ErrorHandler errorHandler;


    @Before
    public void setup(){
        errorHandler = new ErrorHandler();
        categoryService = new CategoryDefaultService(categoryRepository);
        categoryController = new CategoryController(categoryService, errorHandler);
    }

    
}
