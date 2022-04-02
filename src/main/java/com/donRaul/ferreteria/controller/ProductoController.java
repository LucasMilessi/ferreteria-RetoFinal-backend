package com.donRaul.ferreteria.controller;

import com.donRaul.ferreteria.model.Producto;
import com.donRaul.ferreteria.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
public class ProductoController {

    @Autowired
    IProductoService productoService;

    @GetMapping(value = "/Productos")
    private Flux<Producto> findAllProductos() {
        return this.productoService
                .findAllProducto();
    }

    @PostMapping("/Producto")
    private Mono<Producto> addProducto(@RequestBody Producto producto) {
        return this.productoService
                .addProducto(producto);
    }

    @PutMapping("/{id}/Producto")
    private Mono<ResponseEntity<Producto>> updateProducto(@RequestBody Producto producto, @PathVariable("id") String productoId) {
        return this.productoService
                .updateProducto(producto, productoId)
                .flatMap(producto1 ->
                        Mono.just(ResponseEntity.ok(producto1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound()
                        .build()));
    }
}
