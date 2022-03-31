package com.donRaul.ferreteria.controller;

import com.donRaul.ferreteria.model.Proveedor;
import com.donRaul.ferreteria.model.Volante;
import com.donRaul.ferreteria.service.IVolanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class VolanteController {

    @Autowired
    IVolanteService volanteService;

    @GetMapping(value = "/Volante")
    private Flux<Volante> findAllVolante() {
        return this.volanteService
                .findAllProveedor();
    }

    @PostMapping("/Volantes")
    private Mono<Volante> addVolante(@RequestBody Volante volante) {
        return this.volanteService
                .addProveedor(volante);
    }

    @PutMapping("/{id}/Volante")
    private Mono<ResponseEntity<Volante>> updateVolante(@RequestBody Volante volante, @PathVariable("id") String volanteId) {
        return this.volanteService
                .updateProveedor(volante, volanteId)
                .flatMap(volante1 ->
                        Mono.just(ResponseEntity.ok(volante1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound()
                        .build()));
    }

    @DeleteMapping("/Volante/{id}")
    private Mono<ResponseEntity<Volante>> deleteVolante(@PathVariable("id") String volanteId) {
        return this.volanteService
                .deleteProveedor(volanteId)
                .flatMap(volante1 ->
                        Mono.just(ResponseEntity.ok(volante1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound()
                        .build()));
    }
}
