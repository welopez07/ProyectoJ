package com.proyecto.Jaden.services;

import com.proyecto.Jaden.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;


}
