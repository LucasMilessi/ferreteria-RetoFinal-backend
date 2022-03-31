package com.donRaul.ferreteria.repository;

import com.donRaul.ferreteria.model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IClienteRepository extends ReactiveMongoRepository<Cliente, String> {
}
