package com.example.examen.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.examen.entity.Libro;

public interface LibroRepository extends MongoRepository<Libro, Integer> {
    

    @Query("{ 'authors' : { $in: ?0 } }")
    public abstract List<Libro> listaPorAutores(List<String> authors);

    
}
