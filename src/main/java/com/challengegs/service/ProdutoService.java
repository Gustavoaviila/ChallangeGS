package com.challengegs.service;

import com.challengegs.entity.Produto;
import com.challengegs.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public void createProduto(Produto produto) {
        produtoRepository.save(produto);
    }
}
