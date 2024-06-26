package com.example.examen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
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

import com.example.examen.entity.Libro;
import com.example.examen.service.LibroService;

@RestController
@RequestMapping("/rest/libro")
public class LibroController {
 
    
    @Autowired
    private LibroService service;
    
    //CRUD
	@PostMapping("/registraLibro")
	@ResponseBody
	public ResponseEntity<?> inserta(@RequestBody Libro obj) {
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
            Libro objSalida = service.agregarActualizarLibro(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Error al registrar");
			} else {
				salida.put("mensaje", "Registro exitoso de ID >> " + objSalida.get_id() ); ;
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al registrar");
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizaLibro/{id}")
	@ResponseBody
	public ResponseEntity<?> actualiza(@PathVariable("id") String id, @RequestBody Libro objLibro) {
		Map<String, Object> salida = new HashMap<String, Object>();
        try {
            ObjectId objId = new ObjectId(id);
            objLibro.set_id(objId);
			Libro objSalida = service.agregarActualizarLibro(objLibro);
			if (objSalida == null) {
				salida.put("mensaje", "Error al actualizar");
			} else {
				salida.put("mensaje", "Actualización exitosa de ID >> " + objSalida.get_id() ); ;
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al actualizar");
		}
		return ResponseEntity.ok(salida);
	}

	@DeleteMapping("/eliminaLibro/{id}")
	@ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaEjemplo(@PathVariable("id") String id) {
        Map<String, Object> salida = new HashMap<>();
        try {
            ObjectId objId = new ObjectId(id);
            Libro objBusqueda = service.buscaLibroPorPK(objId);
            if (objBusqueda == null) {
                salida.put("mensaje", "ID no encontrado");
                return ResponseEntity.ok(salida);
            } else {
                service.eliminarLibro(objId);
                salida.put("mensaje", "Eliminación exitosa . Libro de ID ==> " + id + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "Error al eliminar");
        }
        return ResponseEntity.ok(salida);
    }
    
    @GetMapping("/buscaPorPk/{id}")
    @ResponseBody
    public Libro listaPorPK(@PathVariable("id") String id) {
        ObjectId objId = new ObjectId(id);
        return service.buscaLibroPorPK(objId);
    }

    @GetMapping("/listaLibroPorTitulo/{var}")
	@ResponseBody
    public List<Libro> listaPorTitulo(@PathVariable("var") String titulo) {
        return service.listaPorTitulo(titulo);
    }
    
    @GetMapping("/listaLibroPorAutores")
	@ResponseBody
	public List<Libro> lista(@RequestParam("authors") List<String> authors) {
        return service.listaPorAutores(authors);
	}

	@GetMapping("/listaLibroPorCategorias")
	@ResponseBody
	public List<Libro> listaPorCategorias(@RequestParam("categories") List<String> categories) {
        return service.listaPorCategorias(categories);
	}
}
