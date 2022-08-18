package com.soto.marketspring.web.controllers;

import com.soto.marketspring.domain.Purchase;
import com.soto.marketspring.domain.service.PurchaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket Purchases")
    @ApiResponse(code = 200,message = "OK")
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/clients/{clientId}")
    @ApiOperation("Search a purchases with an ID Client")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 400,message = "NOT_FOUND")
    })
    public ResponseEntity<List<Purchase>> getByCliente(@PathVariable(name = "clientId" )String clientId){
        return purchaseService.getByClient(clientId)
                .map(clients -> new ResponseEntity<>(clients,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Save a Purchase")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase),HttpStatus.CREATED);
    }
}
