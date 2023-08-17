package com.template.data.repository;

import com.template.data.entity.Dados;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosRepository extends JpaRepository<Dados, Id> {
    Dados dados = new Dados(dados.getCidade(),
            dados.getDia(),
            dados.getTurno(),
            dados.getMaxima(),
            dados.getMinima(),
            dados.getUmidade(),
            dados.getPrecipitacao(),
            dados.getVelocidadeDoTempo());

    static long findById(long id) {
        return id;
    }

    static void deleteByCidade(String cidade) {
    }

    static void deleteAllCidade() {
    }

    static String findAllCidade(String cidade) {
        return cidade;
    }

    static Dados getDados() {
        return dados;
    }

    static Dados Dados(Dados dados) {
        return dados;
    }

    static long findAllId(long id) {
        return id;
    }
}