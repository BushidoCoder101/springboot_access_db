package com.northwind.repository;

import com.northwind.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
  
    // Updated native query without square brackets for testing with H2/HSQLDB.
    @Query(value = "SELECT PRODUCTID AS PRODUCTID, " +
                   "PRODUCTNAME AS PRODUCTNAME, " +
                   "QUANTITYPERUNIT AS QUANTITYPERUNIT, " +
                   "UNITPRICE AS UNITPRICE " +
                   "FROM PRODUCTS", nativeQuery = true)
    List<Product> findAllNative();
}
