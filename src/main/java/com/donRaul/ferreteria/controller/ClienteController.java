package com.donRaul.ferreteria.controller;

import com.donRaul.ferreteria.model.Cliente;
import com.donRaul.ferreteria.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteService;


    @GetMapping(value = "/clientes")
    private Flux<Cliente> findAllClientes() {
        return this.clienteService.findAllCliente();
    }

    @GetMapping("/{id}/cliente")
    private Mono<Cliente> clienteById(@PathVariable("id") String idCliente){
        return this.clienteService
                .clienteById(idCliente);
    }

    @PostMapping("/cliente")
    private Mono<Cliente> addCliente(@RequestBody Cliente cliente) {
        return this.clienteService.addCliente(cliente);
    }

    @PutMapping("/{id}/cliente")
    private Mono<ResponseEntity<Cliente>> updateCliente(@PathVariable("id") String ClienteId, @RequestBody Cliente cliente) {
        return this.clienteService.updateCliente(ClienteId, cliente)
                .flatMap(cliente1 -> Mono.just(ResponseEntity.ok(cliente1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/cliente/{id}")
    private Mono<ResponseEntity<Cliente>> deleteCliente(@PathVariable("id") String ClienteId) {
        return this.clienteService.deleteCliente(ClienteId)
                .flatMap(cliente1 -> Mono.just(ResponseEntity.ok(cliente1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
