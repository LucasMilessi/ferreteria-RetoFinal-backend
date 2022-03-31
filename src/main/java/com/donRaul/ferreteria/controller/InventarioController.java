package com.donRaul.ferreteria.controller;

import com.donRaul.ferreteria.model.Factura;
import com.donRaul.ferreteria.model.Inventario;
import com.donRaul.ferreteria.model.Producto;
import com.donRaul.ferreteria.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class InventarioController {

    @Autowired
    IInventarioService inventarioService;

    @GetMapping(value = "/inventarios")
    private Flux<Inventario> findAllInventario() {
        return this.inventarioService
                .findAllInventario();
    }

    @PostMapping("/inventario")
    private Mono<Inventario> addInventario(@RequestBody Inventario inventario) {
        return this.inventarioService
                .addInventario(inventario);
    }

    @PutMapping("/{id}/inventario")
    private Mono<ResponseEntity<Inventario>> updateInventario(@RequestBody Inventario inventario, @PathVariable("id") String inventarioId) {
        return this.inventarioService
                .updateInventario(inventario, inventarioId)
                .flatMap(inventario1 ->
                        Mono.just(ResponseEntity.ok(inventario1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound()
                        .build()));
    }

    @DeleteMapping("/inventario/{id}")
    private Mono<ResponseEntity<Inventario>> deleteInventario(@PathVariable("id") String inventarioId) {
        return this.inventarioService
                .deleteInventario(inventarioId)
                .flatMap(inventario1 ->
                        Mono.just(ResponseEntity.ok(inventario1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound()
                        .build()));
    }

    @GetMapping(value = "/inventario/compras")
    private Flux<Inventario> productosCompradosInv() {
        return this.inventarioService
                .findAllInventario()
                .map(prodComprados -> {
                    List<Producto> listaDeProductosComprados = prodComprados.getListaDeProductos()
                            .stream()
                            .filter(listProd -> listProd.isEstadoProducto() == true).collect(Collectors.toList());
                    prodComprados.setListaDeProductos(listaDeProductosComprados);
                    return prodComprados;
                }).filter(inventario -> inventario.getListaDeProductos().size() > 0);
    }
}
