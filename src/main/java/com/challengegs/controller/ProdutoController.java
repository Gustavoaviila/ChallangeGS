package com.challengegs.controller;


import com.challengegs.controller.dto.ProdutoUpdateDto;
import com.challengegs.entity.Produto;
import com.challengegs.repository.ProdutoRepository;
import com.challengegs.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping ("{id_produto}")
    public void delete (@PathVariable("id_produto") Integer id) {
        produtoRepository.findById(id).map(produto -> {
            produtoRepository.delete(produto);
            return Void.TYPE;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "THIS PRODUCT DOES NOT EXIST"));
    }
    @GetMapping("/nome")
    public Produto findByName(String name) {
        return produtoRepository.findByName(name);
    }

    @PutMapping("{id_produto}")
    public ProdutoUpdateDto update  (@PathVariable("id_produto") Integer id, @RequestBody ProdutoUpdateDto produtoUpdateDto){
        produtoRepository.findById(id).map(produtoSaved -> {
            produtoSaved.setDescricao(produtoUpdateDto.getDescricao());
            produtoSaved.setName(produtoUpdateDto.getName());
            produtoSaved.setValor(produtoUpdateDto.getValor());
            produtoRepository.save(produtoSaved);
            return Void.TYPE;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "THIS PRODUCT DOES NOT EXIST"));
        return produtoUpdateDto;
    }
}

