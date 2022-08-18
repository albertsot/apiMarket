package com.soto.marketspring.persistence;

import com.soto.marketspring.domain.Purchase;
import com.soto.marketspring.domain.repository.PurchaseRepository;
import com.soto.marketspring.persistence.crud.ComprasCrudRepository;
import com.soto.marketspring.persistence.entity.Compra;
import com.soto.marketspring.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    ComprasCrudRepository comprasCrudRepository;
    @Autowired
    PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>) comprasCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return comprasCrudRepository.findByIdCliente(clientId)
                .map(compras->purchaseMapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra=purchaseMapper.toCompra(purchase);
        /*
        para guardarse en cascada, debemos estar seguros de que Compra conoce los productos
        y los productos conocen a que compra pertenecen
         */
        compra.getProductos().forEach(products->products.setCompras(compra));
        return purchaseMapper.toPurchase(comprasCrudRepository.save(compra));
    }
}
