package com.fiap.ec.global_soluction_1_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sistemas_monitorados")
public class SistemaMonitorado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String status; 

    private String responsavel;

    public SistemaMonitorado() {}

    public SistemaMonitorado(String nome, String status, String responsavel) {
        this.nome = nome;
        this.status = status;
        this.responsavel = responsavel;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getStatus() { return status; }
    public String getResponsavel() { return responsavel; }

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setStatus(String status) { this.status = status; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
}