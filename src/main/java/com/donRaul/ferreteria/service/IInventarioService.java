package com.donRaul.ferreteria.service;

import com.donRaul.ferreteria.model.Inventario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IInventarioService {

    Mono<Inventario> addInventario(Inventario inventario);

    Flux<Inventario> findAllInventario();

    Mono<Inventario> updateInventario(Inventario inventario, String inventarioId);

    Mono<Inventario> deleteInventario(String inventarioId);
}
