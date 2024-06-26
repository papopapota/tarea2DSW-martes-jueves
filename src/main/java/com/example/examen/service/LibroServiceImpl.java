package com.example.examen.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.entity.Libro;
import com.example.examen.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {
    
    @Autowired
    private LibroRepository repository;
    
    @Override
    public List<Libro> listaPorAutores(List<String> authors) {
        return repository.listaPorAutores(authors);
    }

    @Override
    public Libro agregarActualizarLibro(Libro objLibro) {
        return repository.save(objLibro);
    }

    @Override
    public void eliminarLibro(ObjectId id) {
        repository.deleteById(id);  
    }

    @Override
    public Libro buscaLibroPorPK(ObjectId idLibro) {
        return repository.findById(idLibro).orElse(null);
    }

    @Override
    public List<Libro> listaPorTitulo(String titulo) {
        return repository.findByTitle(titulo);
    }

    @Override
    public List<Libro> listaPorCategorias(List<String> categories) {
        return repository.findByCategories(categories);
    }

    
}
