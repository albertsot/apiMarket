package com.soto.marketspring.domain.repository;

import com.soto.marketspring.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

     List<Purchase> getAll();
     Optional<List<Purchase>> getByClient(String clientId);
     Purchase save(Purchase purchase);
}
