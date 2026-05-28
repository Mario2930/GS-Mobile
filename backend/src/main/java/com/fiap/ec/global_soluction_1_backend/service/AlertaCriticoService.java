package com.fiap.ec.global_soluction_1_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.ec.global_soluction_1_backend.model.AlertaCritico;
import com.fiap.ec.global_soluction_1_backend.repository.AlertaCriticoRepository;

@Service
public class AlertaCriticoService {
    
    private final AlertaCriticoRepository repository;

    public AlertaCriticoService(AlertaCriticoRepository repository) {
        this.repository = repository;
    }

    public AlertaCritico salvar(AlertaCritico alerta) {
        return repository.save(alerta);
    }

    public List<AlertaCritico> listar() {
        return repository.findAll();
    }

    public AlertaCritico buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado"));
    }
    
    public AlertaCritico atualizar(Long id, AlertaCritico alertaAtualizado) {
        AlertaCritico alertaExistente = buscarPorId(id);
        alertaExistente.setNivel(alertaAtualizado.getNivel());
        alertaExistente.setDescricao(alertaAtualizado.getDescricao());
        alertaExistente.setDataAlerta(alertaAtualizado.getDataAlerta());
        alertaExistente.setResolvido(alertaAtualizado.getResolvido());
        return repository.save(alertaExistente);
    }

    public void deletar(Long id) {
        AlertaCritico alerta = buscarPorId(id);
        repository.delete(alerta);
    }
}