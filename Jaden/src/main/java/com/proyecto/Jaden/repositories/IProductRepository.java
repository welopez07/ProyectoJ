package com.proyecto.Jaden.repositories;

import com.proyecto.Jaden.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository <ProductModel, Long > {

}
