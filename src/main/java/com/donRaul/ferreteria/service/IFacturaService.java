package com.donRaul.ferreteria.service;

import com.donRaul.ferreteria.model.Factura;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFacturaService {

    Flux<Factura> findAllFactura();

    Mono<Factura> addFactura(Factura factura);

    Mono<Factura> updateFactura(Factura factura, String facturaId);

    Mono<Factura> deleteFactura(String facturaId);
}
