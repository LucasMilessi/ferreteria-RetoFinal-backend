package com.donRaul.ferreteria.repository;

import com.donRaul.ferreteria.model.Factura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacturaRepository extends ReactiveMongoRepository<Factura, String> {
}
