package com.template.data.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="dados")
   public class Dados implements Serializable {
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static String cidade;

    @Column(nullable = false)
    private String dia;

    @Column(nullable = false)
    private String tempo;

    @Column(nullable = false)
    private String turno;

    @Column(nullable = false)
    private String maxima;

    @Column(nullable = false)
    private String minima;

    @Column(nullable = false)
    private String precipitacao;

    @Column(nullable = false)
    private String umidade;

    @Column(nullable = false)
    private static String VelocidadeDoTempo;
    private String velocidadedoTempo;

    public static String getAllCidade() {
        return cidade;
    }

    public static String getVelocidadeDoTempo() {
        return VelocidadeDoTempo;
    }

public Dados(String cidade, String dia, String turno, String maxima, String minima, String umidade, String precipitacao, String velocidadeDoTempo){
}

    public void setVelocidadeDoTempo(String velocidadeDoTempo) {
        VelocidadeDoTempo = velocidadeDoTempo;
    }

    public String getVelocidadedoTempo() {
        return velocidadedoTempo;
    }

    public Dados(String cidade, String dados, String tempo, String turno, String maxima, String minima,
                 String precipitacao, String umidade, String velocidadeDoTempo) {
    this.cidade = cidade;
    this.dia = dia;
    this.tempo = tempo;
    this.turno = turno;
    this.maxima = maxima;
    this.minima = minima;
    this.precipitacao = precipitacao;
    this.umidade = umidade;
    this.VelocidadeDoTempo = VelocidadeDoTempo;
}

public String getCidade(){
    return cidade;
}

public String getDia(){
    return dia;
}

public String getTempo(){
    return tempo;
}

public String getTurno(){
    return turno;
}

public String getMaxima(){
    return maxima;
}

public String getMinima(){
    return minima;
}

public String getPrecipitacao(){
    return precipitacao;
}

public String getUmidade(){
    return umidade;
  }
    @Override
    public String toString() {
        return "Tutorial [cidade=" + cidade + ", dia=" + dia + ", tempo=" + tempo + ", turno=" + turno + ", maxima=" + maxima + ", minima=" + minima + ", precipitacao= " + precipitacao + ", umidade= " + umidade + ", VelocidadeDoVento=" + VelocidadeDoTempo + "]";
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setMaxima(String maxima) {
        this.maxima = maxima;
    }

    public void setMinima(String minima) {
        this.minima = minima;
    }

    public void setPrecipitacao(String precipitacao) {
        this.precipitacao = precipitacao;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    public void setVelocidadedoTempo(String velocidadedoTempo) {
        this.velocidadedoTempo = velocidadedoTempo;
    }

    public boolean isPresent(long id) {
        return false;
    }
}