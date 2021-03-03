package com.twolak.springframework.springecommercebackend.config;

import com.twolak.springframework.springecommercebackend.domain.Product;
import com.twolak.springframework.springecommercebackend.domain.ProductCategory;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
    
    final HttpMethod[] theUnsuportedHttpMethods = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.PATCH};

    config.getExposureConfiguration().forDomainType(Product.class)
      .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsuportedHttpMethods))
      .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsuportedHttpMethods));

    config.getExposureConfiguration().forDomainType(ProductCategory.class)
      .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsuportedHttpMethods))
      .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsuportedHttpMethods));
  }
}
