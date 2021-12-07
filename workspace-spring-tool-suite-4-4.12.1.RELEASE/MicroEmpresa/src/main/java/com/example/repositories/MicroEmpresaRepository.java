package com.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.documents.MicroEmpresa;

public interface MicroEmpresaRepository extends MongoRepository<MicroEmpresa, String> {


	

}
