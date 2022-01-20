package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
    @Query("SELECT pt FROM ProductType pt")
    List<ProductType> findAllProductTypes();
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
    @Query("Select pt from ProductType pt where pt.name like :name")
    ProductType getProductType(String name);
    @Query("Select p from Product p where p.price<:price ")
    List<Product> getProductsCheaperThan(Double price);
}
