package com.challengegs.controller;


import com.challengegs.entity.Produto;
import com.challengegs.repository.ProdutoRepository;
import com.challengegs.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduto (@RequestBody Produto produto){
        produtoService.createProduto(produto);
    }
}
