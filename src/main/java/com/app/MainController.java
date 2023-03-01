/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import models.Libro;
import models.LibroProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    @Autowired 
    private LibroRepository repositorio;
    
    @GetMapping(path="/")
    public String index() {
        return "vista-inicio";
    }
    @GetMapping(path="/crear")
    public String crear(){ return "vista-nuevolibro";}
    @GetMapping(value = "/detalle/{id}")
    public ResponseEntity getDetalle(@PathVariable Integer id) {
        String libro = repositorio.findEstadoById(id);
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }
    @RequestMapping(path="/biblioteca", method = RequestMethod.GET)
    @ResponseBody
    public List<LibroProjection>  listado() {
        return repositorio.findAll()
                .stream()
                .map(libro -> new LibroProjection(libro.getId(), libro.getNombre()))
                .collect(Collectors.toList());
    }

    @GetMapping("/categoria/{category}")
    public ResponseEntity<List<Libro>> getBooksByCategoria(@PathVariable String category) {
        List<Libro> books = repositorio.findByCategoria(category);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<Libro>> getBooksByAutor(@PathVariable String autor) {
        List<Libro> books = repositorio.findByAutor(autor);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Libro> createBook(@RequestBody Libro libro) {
        Libro savedBook = repositorio.save(libro);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
    
}
