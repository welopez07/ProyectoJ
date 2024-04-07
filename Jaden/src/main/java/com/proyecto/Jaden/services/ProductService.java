package com.proyecto.Jaden.services;

import com.proyecto.Jaden.models.ProductModel;
import com.proyecto.Jaden.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//Servicio de Spring, contiene la logica de negocio y realiza operciones con los datos
public class ProductService {

    @Autowired //Anotacion para inyeccion de dependencias, aca se esta inyectando ProductRepository en ProductService
    //usa los metodos definidos en ProductRepository para interactuar con la base de datos
    private IProductRepository productRepository;

    //Este metodo obtiene todos los datos almacenados en BD, usa el metodo findAll de ProductRepository y devuelve una lista de ProductModel
    public List<ProductModel> obtenerTodos(){
        return productRepository.findAll();
    }

    //metodo para crear un nuevo producto en BD, usa save apra guardar el producto
    public ProductModel crearProducto(ProductModel producto){
        return productRepository.save(producto);
    }

    public ProductModel obtenerPorId(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public void eliminarPorId(Long id){
        productRepository.deleteById(id);
    }

    public ProductModel actualizarProducto(Long id, ProductModel productoActualizar){
        ProductModel productoExistente = productRepository.findById(id).orElse(null);

        if (productoExistente != null){
            productoExistente.setNombre(productoActualizar.getNombre());
            productoExistente.setPrecio(productoActualizar.getPrecio());
            productoExistente.setDescripcion(productoActualizar.getDescripcion());
            productoExistente.setCategoria(productoActualizar.getCategoria());
            productoExistente.setStock(productoActualizar.getStock());
            productoExistente.setDisponible(productoActualizar.isDisponible());
            return productRepository.save(productoExistente);
        }
        return null;

    }

}
