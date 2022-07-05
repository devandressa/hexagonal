package com.hexagonal.demo.application.adapters.controller;

import com.hexagonal.demo.domain.dtos.EstoqueDTO;
import com.hexagonal.demo.domain.dtos.ProdutoDTO;
import com.hexagonal.demo.domain.ports.interfaces.ProdutoServicePort;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    void criarProdutos(@RequestBody ProdutoDTO produtoDTO) {
        produtoServicePort.criarProduto(produtoDTO);
    }

    @GetMapping
    List<ProdutoDTO> getProdutos() {
        return produtoServicePort.buscarProdutos();
    }

    @PutMapping(value = "/{sku}")
    void atualizarEstoque(@PathVariable String sku, @RequestBody EstoqueDTO estoqueDTO) throws NotFoundException {
        produtoServicePort.atualizarEstoque(sku, estoqueDTO);
    }
}