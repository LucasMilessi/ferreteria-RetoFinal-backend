package com.donRaul.ferreteria.service;

import com.donRaul.ferreteria.model.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClienteService {

    Mono<Cliente> addCliente(Cliente cliente);

    Flux<Cliente> findAllCliente();
}
