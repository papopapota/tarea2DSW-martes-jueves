package com.example.examen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.entity.Curso;
import com.example.examen.repository.CursoRepository;


@Service
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoRepository repository;
	
	@Override
	public List<Curso> listaCursoPorNombre(String nombre) {
		return repository.listaCursoPorNombre(nombre);
	}

	@Override
	public Curso agregarActualizarCurso(Curso curso) {
		return repository.save(curso);
	}

	@Override
	public void eliminarCurso(int id) {
		repository.deleteById(id);
	}

	@Override
	public Curso buscaCursoPorPK(int idCurso) {
		return repository.findById(idCurso).orElse(null);
	}

	@Override
	public List<Curso> listaCursoPorIDCursoYNombre(int idCurso, String nombre) {
		return repository.listaCursoPorIDCursoYNombre(idCurso, nombre);
	}


}
