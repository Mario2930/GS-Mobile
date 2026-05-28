package com.fiap.ec.global_soluction_1_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.ec.global_soluction_1_backend.model.Sensor;
import com.fiap.ec.global_soluction_1_backend.repository.SensorRepository;

@Service
public class SensorService {
    
    private final SensorRepository repository;

    public SensorService(SensorRepository repository) {
        this.repository = repository;
    }

    public Sensor salvar(Sensor sensor) {
        return repository.save(sensor);
    }

    public List<Sensor> listar() {
        return repository.findAll();
    }

    public Sensor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor não encontrado no módulo"));
    }
    
    public Sensor atualizar(Long id, Sensor sensorAtualizado) {
        Sensor sensorExistente = buscarPorId(id);
        sensorExistente.setNome(sensorAtualizado.getNome());
        sensorExistente.setTipo(sensorAtualizado.getTipo());
        sensorExistente.setLocalizacaoModulo(sensorAtualizado.getLocalizacaoModulo());
        sensorExistente.setAtivo(sensorAtualizado.getAtivo());
        return repository.save(sensorExistente);
    }

    public void deletar(Long id) {
        Sensor sensor = buscarPorId(id);
        repository.delete(sensor);
    }
}