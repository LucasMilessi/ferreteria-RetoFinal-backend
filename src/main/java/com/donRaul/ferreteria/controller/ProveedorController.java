package com.donRaul.ferreteria.controller;

import com.donRaul.ferreteria.model.Proveedor;
import com.donRaul.ferreteria.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProveedorController {

    @Autowired
    IProveedorService proveedorService;


    @GetMapping(value = "/Proveedores")
    private Flux<Proveedor> findAllProveedor() {
        return this.proveedorService
                .findAllProveedor();
    }

    @GetMapping("/{id}/Proveedor")
    private Mono<Proveedor> proveedorById(@PathVariable("id") String idProveedor){
        return this.proveedorService
                .proveedorById(idProveedor);
    }

    @PostMapping("/Proveedor")
    private Mono<Proveedor> addProveedor(@RequestBody Proveedor proveedor) {
        return this.proveedorService
                .addProveedor(proveedor);
    }

    @PutMapping("/{id}/Proveedor")
    private Mono<ResponseEntity<Proveedor>> updateProveedor(@RequestBody Proveedor proveedor, @PathVariable("id") String proveedorId) {
        return this.proveedorService
                .updateProveedor(proveedor, proveedorId)
                .flatMap(proveedor1 ->
                        Mono.just(ResponseEntity.ok(proveedor1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound()
                        .build()));
    }

    @DeleteMapping("/Proveedor/{id}")
    private Mono<ResponseEntity<Proveedor>> deleteProveedor(@PathVariable("id") String proveedorId) {
        return this.proveedorService
                .deleteProveedor(proveedorId)
                .flatMap(proveedor1 ->
                        Mono.just(ResponseEntity.ok(proveedor1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound()
                        .build()));
    }
}
