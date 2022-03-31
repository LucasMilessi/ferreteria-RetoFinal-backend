package com.donRaul.ferreteria.service.impl;

import com.donRaul.ferreteria.model.Volante;
import com.donRaul.ferreteria.repository.IVolanteRepository;
import com.donRaul.ferreteria.service.IVolanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VolanteServiceImpl implements IVolanteService {

    @Autowired
    IVolanteRepository volanteRepository;

    @Override
    public Mono<Volante> addProveedor(Volante volante){
        return this.volanteRepository
                .save(volante);
    }

    @Override
    public Flux<Volante> findAllProveedor(){
        return this.volanteRepository
                .findAll();
    }

    @Override
    public Mono<Volante> updateProveedor(Volante volante, String volanteId){
        return this.volanteRepository
                .findById(volanteId)
                .flatMap(update -> {
                    update.setVolanteId(volanteId);
                    return addProveedor(volante);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Volante> deleteProveedor(String volanteId){
        return this.volanteRepository
                .findById(volanteId)
                .flatMap(delete -> this.volanteRepository
                        .deleteById(delete.getVolanteId())
                        .thenReturn(delete));
    }
}
