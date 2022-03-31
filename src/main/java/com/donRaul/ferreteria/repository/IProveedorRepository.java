package com.donRaul.ferreteria.repository;

import com.donRaul.ferreteria.model.Proveedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProveedorRepository extends ReactiveMongoRepository<Proveedor, String> {
}
