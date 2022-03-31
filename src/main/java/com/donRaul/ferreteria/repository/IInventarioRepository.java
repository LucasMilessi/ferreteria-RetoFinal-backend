package com.donRaul.ferreteria.repository;

import com.donRaul.ferreteria.model.Inventario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventarioRepository extends ReactiveMongoRepository<Inventario, String> {
}
