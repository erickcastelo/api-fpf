package br.com.fpf.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fpf.base.model.Categoria;
import br.com.fpf.base.repository.CategoriaRepository;

@RestController
@RequestMapping("/api")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	public CategoriaController() {
	}
	
	@RequestMapping(value = "/categorias", method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> listar() {
		Iterable<Categoria> categorias = repository.findAll();
		
		Categoria categoria = new Categoria();
		List<Categoria> listCategorias = categoria.listaCategorias(categorias);
	    
		return new ResponseEntity<List<Categoria>>(listCategorias, HttpStatus.OK);		
	}
}
