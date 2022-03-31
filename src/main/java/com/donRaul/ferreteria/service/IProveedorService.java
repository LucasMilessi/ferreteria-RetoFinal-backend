package com.donRaul.ferreteria.service;

import com.donRaul.ferreteria.model.Proveedor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProveedorService {

    Mono<Proveedor> addProveedor(Proveedor proveedor);

    Flux<Proveedor> findAllProveedor();

    Mono<Proveedor> updateProveedor(Proveedor proveedor, String proveedorId);

    Mono<Proveedor> deleteProveedor(String proveedorId);
}
