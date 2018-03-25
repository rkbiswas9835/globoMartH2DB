package com.sepient.globoMartH2DB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCatalogRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE LOWER(p.type) = LOWER(:type)")
	public List<Product> findByType(@Param("type") String type);

}
