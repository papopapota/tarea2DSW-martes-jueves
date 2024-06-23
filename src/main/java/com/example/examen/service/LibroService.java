package com.example.examen.service;

import java.util.List;

import com.example.examen.entity.Libro;

public interface LibroService {
    
     public abstract List<Libro> listaPorAutores(List<String> authors);
}
