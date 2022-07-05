package com.hexagonal.demo.domain.ports.interfaces;

import com.hexagonal.demo.domain.dtos.EstoqueDTO;
import com.hexagonal.demo.domain.dtos.ProdutoDTO;
import javassist.NotFoundException;

import java.util.List;

public interface ProdutoServicePort {

    List<ProdutoDTO> buscarProdutos();

    void criarProduto(ProdutoDTO produtoDTO);

    void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws NotFoundException;
}
