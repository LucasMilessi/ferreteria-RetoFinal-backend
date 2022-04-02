package com.donRaul.ferreteria.service.impl;

import com.donRaul.ferreteria.model.Factura;
import com.donRaul.ferreteria.repository.IFacturaRepository;
import com.donRaul.ferreteria.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FacturaServiceImpl implements IFacturaService {

    @Autowired
    IFacturaRepository facturaRepository;


    @Override
    public Flux<Factura> findAllFactura(){
        return this.facturaRepository.findAll();
    }

    @Override
    public Mono<Factura> addFactura(Factura factura){
        return this.facturaRepository.save(factura);
    }

    @Override
    public Mono<Factura> updateFactura(Factura factura, String facturaId){
        return this.facturaRepository
                .findById(facturaId)
                .flatMap(updateFac -> {
                    factura.setConsecutivo(facturaId);
                    return addFactura(factura);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Factura> deleteFactura(String facturaId){
        return this.facturaRepository
                .findById(facturaId)
                .flatMap(deleteFact -> this.facturaRepository
                        .deleteById(deleteFact.getConsecutivo())
                        .thenReturn(deleteFact));
    }
}
