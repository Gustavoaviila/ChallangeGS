package com.challengegs.controller;


import com.challengegs.entity.Produto;
import com.challengegs.repository.ProdutoRepository;
import com.challengegs.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping ("{id_produto}")
    public Produto getProdutoById(@PathVariable("id_produto") Integer id){
        return produtoService.getProdutoById(id);
    }
    @GetMapping
    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    /*@DeleteMapping ("{id_produto")
    public Produto delete (@PathVariable("{id_produto") Produto produto){
        produtoRepository.delete(produto);

    }
*/
    @GetMapping("/nome")
    public Produto findByName(String name) {
        return produtoRepository.findByName(name);
    }
}

