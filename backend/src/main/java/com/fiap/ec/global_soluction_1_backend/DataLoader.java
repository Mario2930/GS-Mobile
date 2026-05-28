package com.fiap.ec.global_soluction_1_backend;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fiap.ec.global_soluction_1_backend.model.Sensor;
import com.fiap.ec.global_soluction_1_backend.repository.SensorRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final SensorRepository sensorRepository;

    public DataLoader(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (sensorRepository.count() > 0) {
            System.out.println("DataLoader: Sensores já existem, pulando seed.");
            return;
        }

        sensorRepository.saveAll(List.of(
            new Sensor("Sensor Térmico Alpha", "Temperatura", "Módulo de Propulsão", true),
            new Sensor("Detector de Radiação Beta", "Radiação", "Painel Solar Externo", true),
            new Sensor("Manômetro Gama", "Pressão", "Cabine Principal", false)
        ));

        System.out.println("DataLoader: Dados simulados da missão espacial injetados com sucesso.");
    }
}