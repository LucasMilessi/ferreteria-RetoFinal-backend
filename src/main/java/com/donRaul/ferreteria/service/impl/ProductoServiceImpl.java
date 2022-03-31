package com.donRaul.ferreteria.service.impl;

import com.donRaul.ferreteria.model.Producto;
import com.donRaul.ferreteria.repository.IProductoRepository;
import com.donRaul.ferreteria.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    IProductoRepository productoRepository;

    @Override
    public Mono<Producto> addProducto(Producto producto){
        return this.productoRepository
                .save(producto);
    }

    @Override
    public Flux<Producto> findAllProducto(){
        return this.productoRepository
                .findAll();
    }

    @Override
    public Mono<Producto> updateProducto(Producto producto, String productoId){
        return this.productoRepository
                .findById(productoId)
                .flatMap(update -> {
                    update.setProductoId(productoId);
                    return addProducto(producto);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Producto> deleteProducto(String productoId){
        return this.productoRepository
                .findById(productoId)
                .flatMap(delete -> this.productoRepository
                        .deleteById(delete.getProductoId())
                        .thenReturn(delete));
    }
}
