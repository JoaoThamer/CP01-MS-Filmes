package com.github.joaothamer.filme.controller;

import com.github.joaothamer.filme.model.Personagem;
import com.github.joaothamer.filme.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemRepository repository;

    @PostMapping
    public ResponseEntity<Personagem> create (@RequestBody Personagem personagem){

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(personagem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personagem> findById(@PathVariable Long id){

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Personagem>> findAll(){

        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personagem> update(@PathVariable Long id, @RequestBody Personagem personagem){

        Optional<Personagem> optPersonagem = repository.findById(id);

        if (optPersonagem.isPresent()){
            personagem.setId(id);
            Personagem personagemAlterado = repository.save(personagem);
            return ResponseEntity.ok(personagemAlterado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
