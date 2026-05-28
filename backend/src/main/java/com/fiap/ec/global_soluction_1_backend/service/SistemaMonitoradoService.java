package com.fiap.ec.global_soluction_1_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.ec.global_soluction_1_backend.model.SistemaMonitorado;
import com.fiap.ec.global_soluction_1_backend.repository.SistemaMonitoradoRepository;

@Service
public class SistemaMonitoradoService {
    
    private final SistemaMonitoradoRepository repository;

    public SistemaMonitoradoService(SistemaMonitoradoRepository repository) {
        this.repository = repository;
    }

    public SistemaMonitorado salvar(SistemaMonitorado sistema) {
        return repository.save(sistema);
    }

    public List<SistemaMonitorado> listar() {
        return repository.findAll();
    }

    public SistemaMonitorado buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sistema não encontrado"));
    }
    
    public SistemaMonitorado atualizar(Long id, SistemaMonitorado sistemaAtualizado) {
        SistemaMonitorado sistemaExistente = buscarPorId(id);
        sistemaExistente.setNome(sistemaAtualizado.getNome());
        sistemaExistente.setStatus(sistemaAtualizado.getStatus());
        sistemaExistente.setResponsavel(sistemaAtualizado.getResponsavel());
        return repository.save(sistemaExistente);
    }

    public void deletar(Long id) {
        SistemaMonitorado sistema = buscarPorId(id);
        repository.delete(sistema);
    }
}