package com.twolak.springframework.springecommercebackend.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_category")
// @Data
@Getter
@Setter
public class ProductCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "category_name")
  private String categoryName;

  @OneToMany(mappedBy = "category", 
            cascade = CascadeType.ALL, 
            orphanRemoval = true)
  private Set<Product> products;
}
