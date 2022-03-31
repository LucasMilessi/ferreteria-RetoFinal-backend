package com.donRaul.ferreteria.repository;

import com.donRaul.ferreteria.model.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends ReactiveMongoRepository<Producto, String> {
}
