package com.hexagonal.demo.infrastructure.config;

import com.hexagonal.demo.domain.adapters.service.PedidoServiceImpl;
import com.hexagonal.demo.domain.ports.interfaces.ProdutoServicePort;
import com.hexagonal.demo.domain.ports.repository.ProdutoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort produtoRepositoryPort) {
        return new PedidoServiceImpl(produtoRepositoryPort);
    }
}