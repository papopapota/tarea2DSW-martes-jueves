package com.example.examen.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.examen.entity.Libro;

public interface LibroRepository extends MongoRepository<Libro, ObjectId> {
    

    @Query("{ 'authors' : { $in: ?0 } }")
    public abstract List<Libro> listaPorAutores(List<String> authors);

    public abstract List<Libro> findByTitle(String title);
    
    @Query("{ 'categories' : { $in: ?0 } }")
    public abstract List<Libro> findByCategories(List<String> titles);
    
}
