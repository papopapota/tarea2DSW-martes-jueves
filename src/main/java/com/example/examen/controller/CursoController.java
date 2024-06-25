package com.example.examen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.entity.Curso;
import com.example.examen.service.CursoService;


@RestController
@RequestMapping("/rest/curso")
public class CursoController {

	@Autowired
	private CursoService service;
	
	//CRUD
	@PostMapping("/registraCurso")
	@ResponseBody
	public ResponseEntity<?> inserta(@RequestBody Curso obj) {
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			Curso objSalida = service.agregarActualizarCurso(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Error al registrar");
			} else {
				salida.put("mensaje", "Registro exitoso de ID >> " + objSalida.getIdCurso() ); ;
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al registrar");
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizaCurso")
	@ResponseBody
	public ResponseEntity<?> actualiza(@RequestBody Curso obj) {
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			Curso objSalida = service.agregarActualizarCurso(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Error al actualizar");
			} else {
				salida.put("mensaje", "Actualización exitosa de ID >> " + objSalida.getIdCurso() ); ;
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al actualizar");
		}
		return ResponseEntity.ok(salida);
	}

	@DeleteMapping("/eliminaCurso/{id}")
	@ResponseBody
		public ResponseEntity<Map<String, Object>> eliminaEjemplo(@PathVariable("id") int id) {
			Map<String, Object> salida = new HashMap<>();
			try {
				service.eliminarCurso(id);
				salida.put("mensaje", "Eliminación exitosa . Curso de ID ==> " + id + ".");
			} catch (Exception e) {
				e.printStackTrace();
				salida.put("mensaje", "Error al eliminar");
			}
			return ResponseEntity.ok(salida);
	}
	@GetMapping("/listaCursoPorNombre/{var}")
	@ResponseBody
	public List<Curso> listaCursoXNombre(@PathVariable("var") String nombre) {
		return service.listaCursoPorNombre(nombre);
	}

	// Consultas
	// Consultas por parametros
	@GetMapping("/listaCursoPorDosCampos")
	@ResponseBody
	public List<Curso> listaCursoPorDosCampos(
					@RequestParam("idCurso") int idCurso, 
					@RequestParam("nombre") String nombre) {
		return service.listaCursoPorIDCursoYNombre(idCurso, nombre);
	}

}
