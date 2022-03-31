package com.donRaul.ferreteria.controller;

import com.donRaul.ferreteria.model.Cliente;
import com.donRaul.ferreteria.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteService;


    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Cliente> addCliente(@RequestBody Cliente cliente) {
        return this.clienteService.addCliente(cliente);
    }

    @GetMapping(value = "/clientes")
    private Flux<Cliente> findAllClientes() {
        return this.clienteService.findAllCliente();
    }
}
