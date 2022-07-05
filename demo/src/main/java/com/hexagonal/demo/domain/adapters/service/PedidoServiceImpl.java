package com.hexagonal.demo.domain.adapters.service;

import com.hexagonal.demo.domain.dtos.EstoqueDTO;
import com.hexagonal.demo.domain.dtos.ProdutoDTO;
import com.hexagonal.demo.domain.model.Produto;
import com.hexagonal.demo.domain.ports.interfaces.ProdutoServicePort;
import com.hexagonal.demo.domain.ports.repository.ProdutoRepositoryPort;
import javassist.NotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PedidoServiceImpl implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepository;

    public PedidoServiceImpl(ProdutoRepositoryPort produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        this.produtoRepository.salvar(produto);
    }

    @Override
    public List<ProdutoDTO> buscarProdutos() {
        List<Produto> produtos = this.produtoRepository.buscarTodos();
        return produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
    }

    @Override
    public void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws NotFoundException {
        Produto produto = this.produtoRepository.buscarPeloSku(sku);

        if (Objects.isNull(produto))
            throw new NotFoundException("Produto não encontrado");

        produto.atualizarEstoque(estoqueDTO.getQuantidade());

        this.produtoRepository.salvar(produto);
    }
}
