package com.fiap.ec.global_soluction_1_backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alertas_criticos")
public class AlertaCritico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nivel; // Ex: ALTO, MEDIO, BAIXO

    @Column(nullable = false)
    private String descricao;

    private LocalDateTime dataAlerta;

    private Boolean resolvido;

    public AlertaCritico() {}

    public AlertaCritico(String nivel, String descricao, LocalDateTime dataAlerta, Boolean resolvido) {
        this.nivel = nivel;
        this.descricao = descricao;
        this.dataAlerta = dataAlerta;
        this.resolvido = resolvido;
    }

    public Long getId() { return id; }
    public String getNivel() { return nivel; }
    public String getDescricao() { return descricao; }
    public LocalDateTime getDataAlerta() { return dataAlerta; }
    public Boolean getResolvido() { return resolvido; }

    public void setId(Long id) { this.id = id; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setDataAlerta(LocalDateTime dataAlerta) { this.dataAlerta = dataAlerta; }
    public void setResolvido(Boolean resolvido) { this.resolvido = resolvido; }
}