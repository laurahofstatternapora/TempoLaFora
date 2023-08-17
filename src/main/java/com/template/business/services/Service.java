package com.template.business.services;

import com.template.data.entity.Dados;
import com.template.data.repository.DadosRepository;
import com.template.data.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    TutorialRepository tutorialRepository;
    private String dadosTempo;

    public long Id(long id) {

        if (id == id) {
            return DadosRepository.findAllId(id);
        } else
            return DadosRepository.findById(id);
    }

    public long getByCidade(long id) {
        return DadosRepository.findById(id);
    }

    public Dados create(@RequestBody Dados dados) {
        return DadosRepository.Dados(new Dados(dados.getCidade(), dados.getDia(), dados.getTempo(), dados.getTurno(),
                dados.getMaxima(), dados.getMinima(), dados.getPrecipitacao(), dados.getUmidade(), dados.getVelocidadeDoTempo()));
    }

    public Optional<Dados> update(@PathVariable("id") long id, @RequestBody Dados dados) {
        id = DadosRepository.findById(id);

        if (dados.isPresent(id)) {
            Dados _dados = DadosRepository.getDados();
            _dados.setCidade(dados.getCidade());
            _dados.setDia(dados.getDia());
            _dados.setTempo(dados.getTempo());
            _dados.setTurno(dados.getTurno());
            _dados.setMaxima(dados.getMaxima());
            _dados.setMinima(dados.getMinima());
            _dados.setPrecipitacao(dados.getPrecipitacao());
            _dados.setUmidade(dados.getUmidade());
            _dados.setVelocidadedoTempo(dados.getVelocidadeDoTempo());
            return Optional.of(_dados);
        } else {
            return Optional.of(dados);
        }
    }

    public void deleteCidade(@PathVariable("cidade") String cidade) {
        DadosRepository.deleteByCidade(cidade);
    }

    public long findByCidade(long id) {
        return DadosRepository.findById(id);
    }

    public void deleteAll() {
       DadosRepository.deleteAllCidade();
    }
}