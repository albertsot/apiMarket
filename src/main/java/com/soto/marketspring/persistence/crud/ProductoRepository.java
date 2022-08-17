package com.soto.marketspring.persistence.crud;

import com.soto.marketspring.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int categoriaId){
        return productoCrudRepository.findByIdCategoriaOrderByNombreProductoAsc(categoriaId);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,true);
    }

    public Optional<Producto> getProducto(int productoId){
        return productoCrudRepository.findById(productoId);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }
    public void delete(int productoId){
        productoCrudRepository.deleteById(productoId);
    }
}
