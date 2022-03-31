package com.donRaul.ferreteria.service.impl;

import com.donRaul.ferreteria.model.Proveedor;
import com.donRaul.ferreteria.repository.IProveedorRepository;
import com.donRaul.ferreteria.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    IProveedorRepository proveedorRepository;

    @Override
    public Mono<Proveedor> addProveedor(Proveedor proveedor){
        return this.proveedorRepository
                .save(proveedor);
    }

    @Override
    public Flux<Proveedor> findAllProveedor(){
        return this.proveedorRepository
                .findAll();
    }

    @Override
    public Mono<Proveedor> updateProveedor(Proveedor proveedor, String proveedorId){
        return this.proveedorRepository
                .findById(proveedorId)
                .flatMap(update -> {
                    update.setProveedoresId(proveedorId);
                    return addProveedor(proveedor);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Proveedor> deleteProveedor(String proveedorId){
        return this.proveedorRepository
                .findById(proveedorId)
                .flatMap(delete -> this.proveedorRepository
                        .deleteById(delete.getProveedoresId())
                        .thenReturn(delete));
    }
}
