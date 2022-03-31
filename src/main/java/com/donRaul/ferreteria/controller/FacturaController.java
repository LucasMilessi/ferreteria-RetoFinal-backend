package com.donRaul.ferreteria.controller;

import com.donRaul.ferreteria.model.Factura;
import com.donRaul.ferreteria.service.IFacturaService;
import com.donRaul.ferreteria.service.impl.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class FacturaController {

    @Autowired
    IFacturaService facturaService;


    @GetMapping(value = "/facturas")
    private Flux<Factura> findAllFacturas() {
        return this.facturaService.findAllFactura();
    }

    @PostMapping("/factura")
    private Mono<Factura> addFacturas(@RequestBody Factura factura) {
        return this.facturaService.addFactura(factura);
    }

    @PutMapping("/{id}/factura")
    private Mono<ResponseEntity<Factura>> updateFactura(@RequestBody Factura factura, @PathVariable("id") String facturaId) {
        return this.facturaService
                .updateFactura(factura, facturaId)
                .flatMap(factura1 ->
                        Mono.just(ResponseEntity.ok(factura1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound()
                        .build()));
    }

    @DeleteMapping("/factura/{id}")
    private Mono<ResponseEntity<Factura>> deleteCliente(@PathVariable("id") String facturaId) {
        return this.facturaService
                .deleteFactura(facturaId)
                .flatMap(factura1 ->
                        Mono.just(ResponseEntity.ok(factura1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound()
                        .build()));
    }


}
