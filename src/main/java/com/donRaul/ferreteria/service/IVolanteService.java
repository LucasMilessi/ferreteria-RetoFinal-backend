package com.donRaul.ferreteria.service;

import com.donRaul.ferreteria.model.Volante;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IVolanteService {

    Mono<Volante> addProveedor(Volante volante);

    Flux<Volante> findAllProveedor();

    Mono<Volante> updateProveedor(Volante volante, String volanteId);

    Mono<Volante> deleteProveedor(String volanteId);
}
