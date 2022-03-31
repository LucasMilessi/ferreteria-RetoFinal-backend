package com.donRaul.ferreteria.service;

import com.donRaul.ferreteria.model.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductoService {

    Mono<Producto> addProducto(Producto producto);

    Flux<Producto> findAllProducto();

    Mono<Producto> updateProducto(Producto producto, String productoId);

    Mono<Producto> deleteProducto(String productoId);
}
