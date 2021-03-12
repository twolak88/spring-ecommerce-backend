package com.twolak.springframework.springecommercebackend.repositories;

import java.util.List;

import com.twolak.springframework.springecommercebackend.domain.State;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StateRepository extends JpaRepository<State, Integer> {
  List<State> findByCountryCode(@Param("code") String code);
}
