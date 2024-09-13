package com.lanchenlayer.controllers;

import com.lanchenlayer.entities.Produto;
import com.lanchenlayer.facade.ProdutoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos") 
public class ProdutoController {


    @Autowired
    private ProdutoFacade produtoFacade;

    @GetMapping
    public List<Produto> buscarTodos() {
        return produtoFacade.buscarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable int id) {
        return produtoFacade.buscarPorId(id);
    }

    @GetMapping("/buscarProdutos")
    public ResponseEntity<ArrayList<Produto>> buscarTodosProdutos() {
        ArrayList<Produto> produtos = produtoFacade.buscarTodos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/buscarProduto/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable int id) {
        Produto produto = produtoFacade.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }
}
