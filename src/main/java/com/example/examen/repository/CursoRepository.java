package com.example.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.examen.entity.Curso;



public interface CursoRepository extends MongoRepository<Curso, Integer>{

}
