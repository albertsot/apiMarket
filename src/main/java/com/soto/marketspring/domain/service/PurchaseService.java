package com.soto.marketspring.domain.service;

import com.soto.marketspring.domain.Purchase;
import com.soto.marketspring.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
       return purchaseRepository.getAll();
    }
    public Optional<List<Purchase>> getByClient(String clientId){
        Optional<List<Purchase>> Listpurchases=purchaseRepository.getByClient(clientId);
            if(Listpurchases.isPresent()){
                return Listpurchases;
            }
            else{
                throw new  ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Cliente %s no existe",clientId));
            }
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
