package com.donRaul.ferreteria.service.impl;

import com.donRaul.ferreteria.model.Inventario;
import com.donRaul.ferreteria.repository.IInventarioRepository;
import com.donRaul.ferreteria.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InventarioServiceImpl implements IInventarioService {

    @Autowired
    IInventarioRepository inventarioRepository;


    @Override
    public Mono<Inventario> addInventario(Inventario inventario){
        return this.inventarioRepository
                .save(inventario);
    }

    @Override
    public Flux<Inventario> findAllInventario(){
        return this.inventarioRepository
                .findAll();
    }

    @Override
    public Mono<Inventario> updateInventario(Inventario inventario, String inventarioId){
        return this.inventarioRepository
                .findById(inventarioId)
                .flatMap(update -> {
                    update.setInventarioId(inventarioId);
                    return addInventario(inventario);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Inventario> deleteInventario(String inventarioId){
        return this.inventarioRepository
                .findById(inventarioId)
                .flatMap(delete -> this.inventarioRepository
                        .deleteById(delete.getInventarioId())
                        .thenReturn(delete));
    }
}
