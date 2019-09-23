package com.concrete.desafio.categories.api;

import com.concrete.desafio.utils.FeignCustomConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "${feign.client.categories}", name = "categories", configuration = FeignCustomConfig.class)
public interface CategoryRepository {

  @RequestMapping(method = RequestMethod.GET, value = "/categories")
  ResponseEntity<CategoryThree> fetchCategoryThree();
}
