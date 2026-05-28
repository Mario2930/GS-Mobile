package com.fiap.ec.global_soluction_1_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sensores")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo; 

    private String localizacaoModulo; 

    private Boolean ativo;

    public Sensor() {
    }

    public Sensor(String nome, String tipo, String localizacaoModulo, Boolean ativo) {
        this.nome = nome;
        this.tipo = tipo;
        this.localizacaoModulo = localizacaoModulo;
        this.ativo = ativo;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public String getLocalizacaoModulo() { return localizacaoModulo; }
    public Boolean getAtivo() { return ativo; }

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setLocalizacaoModulo(String localizacaoModulo) { this.localizacaoModulo = localizacaoModulo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}