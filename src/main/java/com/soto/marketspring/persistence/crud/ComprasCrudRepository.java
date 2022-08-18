package com.soto.marketspring.persistence.crud;

import com.soto.marketspring.domain.Purchase;
import com.soto.marketspring.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ComprasCrudRepository extends CrudRepository<Compra,Integer> {
    public Optional<List<Compra>> findByIdCliente(String idCliente);
}
