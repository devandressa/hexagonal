package com.hexagonal.demo.domain.ports.repository;

import com.hexagonal.demo.domain.model.Produto;

import java.util.List;

public interface ProdutoRepositoryPort {

    List<Produto> buscarTodos();

    Produto buscarPeloSku(String sku);

    void salvar(Produto produto);
}
