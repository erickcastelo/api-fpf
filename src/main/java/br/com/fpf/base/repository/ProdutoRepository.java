package br.com.fpf.base.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fpf.base.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
