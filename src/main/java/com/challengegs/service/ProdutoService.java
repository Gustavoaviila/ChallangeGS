package com.challengegs.service;

import com.challengegs.entity.Produto;
import com.challengegs.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public void createProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    public Produto getProdutoById(Integer idSchedule) {
        return produtoRepository.findById(idSchedule).orElse(null);
    }
}
