package com.fiap.ec.global_soluction_1_backend;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fiap.ec.global_soluction_1_backend.model.AlertaCritico;
import com.fiap.ec.global_soluction_1_backend.model.Sensor;
import com.fiap.ec.global_soluction_1_backend.model.SistemaMonitorado;
import com.fiap.ec.global_soluction_1_backend.repository.AlertaCriticoRepository;
import com.fiap.ec.global_soluction_1_backend.repository.SensorRepository;
import com.fiap.ec.global_soluction_1_backend.repository.SistemaMonitoradoRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final SensorRepository sensorRepository;
    private final SistemaMonitoradoRepository sistemaRepository;
    private final AlertaCriticoRepository alertaRepository;

    public DataLoader(SensorRepository sensorRepository, 
                      SistemaMonitoradoRepository sistemaRepository,
                      AlertaCriticoRepository alertaRepository) {
        this.sensorRepository = sensorRepository;
        this.sistemaRepository = sistemaRepository;
        this.alertaRepository = alertaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        if (sensorRepository.count() == 0) {
            sensorRepository.saveAll(List.of(
                new Sensor("Sensor Térmico Alpha", "Temperatura", "Módulo de Propulsão", true),
                new Sensor("Detector de Radiação Beta", "Radiação", "Painel Solar Externo", true),
                new Sensor("Manômetro Gama", "Pressão", "Cabine Principal", false)
            ));
        }

        if (sistemaRepository.count() == 0) {
            sistemaRepository.saveAll(List.of(
                new SistemaMonitorado("Suporte de Vida", "Operacional", "Eng. Chefe"),
                new SistemaMonitorado("Navegação", "Operacional", "Piloto Automático"),
                new SistemaMonitorado("Propulsão", "Em Manutenção", "Equipe Técnica")
            ));
        }

        if (alertaRepository.count() == 0) {
            alertaRepository.saveAll(List.of(
                new AlertaCritico("ALTO", "Desvio de rota detectado no quadrante 4", LocalDateTime.now().minusHours(2), false),
                new AlertaCritico("MEDIO", "Oscilação térmica no reator secundário", LocalDateTime.now().minusMinutes(30), true)
            ));
        }

        System.out.println("DataLoader: Dados simulados da missão espacial injetados com sucesso.");
    }
}