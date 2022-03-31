package com.donRaul.ferreteria.repository;

import com.donRaul.ferreteria.model.Volante;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVolanteRepository extends ReactiveMongoRepository<Volante, String> {
}
