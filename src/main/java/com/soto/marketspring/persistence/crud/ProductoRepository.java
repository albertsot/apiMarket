package com.soto.marketspring.persistence.crud;

import com.soto.marketspring.domain.Product;
import com.soto.marketspring.domain.repository.ProductRepository;
import com.soto.marketspring.persistence.entity.Producto;
import com.soto.marketspring.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    //ProductoRepository enfocado al DOMINIO Y NO A UNA TABLA PUNTUAL,
    //SE EVITA QUE LA BD SE ACOPLE A UNA BD PUNTUAL, USANDO MAPSTRUCT
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper productMapper;
    @Override
    public List<Product> getAll(){
        List<Producto> productos=(List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos=productoCrudRepository.findByIdCategoriaOrderByNombreProductoAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos=productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prod->productMapper.toProducts(prod));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prod->productMapper.toProduct(prod));

    }

    @Override
    public Product save(Product product) {
        Producto producto=productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productoId){

        productoCrudRepository.deleteById(productoId);
    }
}
