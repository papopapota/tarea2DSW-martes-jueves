package com.example.examen.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.example.examen.entity.Libro;

public interface LibroService {
    
    
    //CRUD 
    public abstract List<Libro> listaPorTitulo(String titulo);
    public abstract Libro agregarActualizarLibro(Libro libro);
    public abstract void eliminarLibro(ObjectId id);
    public abstract Libro buscaLibroPorPK(ObjectId idLibro);
    
    //Consulta usando $in 
    public abstract List<Libro> listaPorAutores(List<String> authors);

    public abstract List<Libro> listaPorCategorias(List<String> categories);
     
}
