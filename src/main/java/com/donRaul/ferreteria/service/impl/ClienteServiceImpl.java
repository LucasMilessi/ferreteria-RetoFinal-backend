package com.donRaul.ferreteria.service.impl;

import com.donRaul.ferreteria.model.Cliente;
import com.donRaul.ferreteria.repository.IClienteRepository;
import com.donRaul.ferreteria.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    IClienteRepository clienteRepository;


    @Override
    public Mono<Cliente> addCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Flux<Cliente> findAllCliente() {
        return this.clienteRepository.findAll();
    }

    public Mono<Cliente> clienteById(String clienteId){
        return this.clienteRepository
                .findById(clienteId);
    }

    @Override
    public Mono<Cliente> updateCliente(String clienteId, Cliente cliente) {
        return this.clienteRepository
                .findById(clienteId)
                .flatMap(clienteUpdate -> {
                    cliente.setClienteId(clienteId);
                    return addCliente(cliente);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Cliente> deleteCliente(String clienteId) {
        return this.clienteRepository
                .findById(clienteId)
                .flatMap(clienteDelete -> this.clienteRepository.deleteById(clienteDelete.getClienteId())
                        .thenReturn(clienteDelete));
    }
}
