package br.com.fpf.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.fpf.base.model.Categoria;
import br.com.fpf.base.model.Produto;
import br.com.fpf.base.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoController implements Filter{
	
	@Autowired
	private ProdutoRepository repository;
	
	public ProdutoController() {
	}	
	
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listar() {
		Iterable<Produto> produtos = repository.findAll();
		
		Produto produto = new Produto();
		List<Produto> listProdutos = produto.listProdutos(produtos);
	    
		return new ResponseEntity<List<Produto>>(listProdutos, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/produto", method = RequestMethod.POST)
	public String cadastrar(@Validated @RequestBody Produto produto, BindingResult result) {
		
		repository.save(produto);
	    
		return "ola deu certo";		

	}
	
	@RequestMapping(value = "/produto/{id}", method = RequestMethod.DELETE)
	public String remover(@PathVariable("id") Long id) {
		
		repository.delete(id);
	    
		return "removida com sucesso";		

	}
	
	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> buscar(@PathVariable("id") Long id) {
		
		Produto produto = repository.findOne((id));
	    
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/produto", method = RequestMethod.PUT)
	public ResponseEntity<Produto> editar(@Validated @RequestBody Produto produto) {
		Produto newProduto = repository.findOne((produto.getId()));
		
		newProduto.setDescricao(produto.getDescricao());
		newProduto.setImage(produto.getImage());
		newProduto.setOrigem(produto.getOrigem());
		newProduto.setPreco(produto.getPreco());
		newProduto.setCategoria(produto.getCategoria());
		
		repository.save(newProduto);
		
		return new ResponseEntity<Produto>(newProduto, HttpStatus.OK);		

	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

	    HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) res;

	    response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

	    chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}
}
