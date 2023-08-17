package com.template.presentation.controller;

import com.template.data.entity.Dados;
import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api")
public class DadosController {

    @Autowired
    Service service;

    @GetMapping("/dados")
    public ResponseEntity<List<Dados>> getAllDados(@RequestParam(required = false) long id) {
        try {
            String dados = Dados.getAllCidade();

            if (dados.isEmpty()) {
                return new ResponseEntity<>(NO_CONTENT);
            }

            return new ResponseEntity<Dados>(id, OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dados/{id}")
    public ResponseEntity<Optional<Dados>> getById(@PathVariable("id") long id) {

        return service.getById(dadosTempo -> new ResponseEntity<>(Optional.of(dadosTempo), OK))
                .orElseGet(() -> new ResponseEntity<>(NOT_FOUND));
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Dados> createTutorial(@RequestBody Dados dados) {
        try {
            Dados _dados = Service.create(new Dados(dados.getCidade(), dados.getDia(), dados.getTurno(),
                    dados.getMaxima(), dados.getMinima(), dados.getUmidade(), dados.getPrecipitacao(), dados.getVelocidadeDoTempo()));
            return new ResponseEntity<Dados>(_dados, CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/dados/{id}")
    public ResponseEntity<Optional<Dados>> update(@PathVariable("id") long id, @RequestBody Dados dados) {

        Optional<Dados> tutorialData = service.update(id, dados);
        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(Optional.of(dados), OK);
        } else {
            return new ResponseEntity<>(NOT_FOUND);
        }
    }

    @DeleteMapping("/dados/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/dados")
    public ResponseEntity<HttpStatus> deleteAllCidades() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dados/cidade")
    public ResponseEntity<List<Dados>> findById() {
        try {
            List<Dados> dados = Service.findById();

            if (dados.isEmpty()) {
                return new ResponseEntity<>(NO_CONTENT);
            }
            return new ResponseEntity<>(dados, OK);
        } catch (Exception e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }
}