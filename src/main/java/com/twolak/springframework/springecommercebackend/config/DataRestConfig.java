package com.twolak.springframework.springecommercebackend.config;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import com.twolak.springframework.springecommercebackend.domain.Country;
import com.twolak.springframework.springecommercebackend.domain.Product;
import com.twolak.springframework.springecommercebackend.domain.ProductCategory;
import com.twolak.springframework.springecommercebackend.domain.State;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

  private EntityManager entityManager;

  public DataRestConfig(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
    
    final HttpMethod[] theUnsuportedHttpMethods = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.PATCH};

    disableHttpMethod(Product.class, config, theUnsuportedHttpMethods);
    disableHttpMethod(ProductCategory.class, config, theUnsuportedHttpMethods);
    disableHttpMethod(Country.class, config, theUnsuportedHttpMethods);
    disableHttpMethod(State.class, config, theUnsuportedHttpMethods);
    
    config.exposeIdsFor(entityManager.getMetamodel().getEntities()
      .stream().map(EntityType::getJavaType).collect(Collectors.toList()).toArray(Class[]::new));
  }

  private void disableHttpMethod(Class theClass, RepositoryRestConfiguration config, final HttpMethod[] theUnsuportedHttpMethods) {
    config.getExposureConfiguration().forDomainType(theClass)
      .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsuportedHttpMethods))
      .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsuportedHttpMethods));
  }
}