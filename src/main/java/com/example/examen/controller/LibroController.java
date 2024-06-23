package com.example.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.entity.Libro;
import com.example.examen.service.LibroService;

@RestController
@RequestMapping("/rest/libro")
public class LibroController {
 
    
    @Autowired
    private LibroService service;
    
    @GetMapping("/listaLibroPorAutores")
	@ResponseBody
	public List<Libro> lista(@RequestParam("authors") List<String> authors) {
        return service.listaPorAutores(authors);
	}
}
