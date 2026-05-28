package com.fiap.ec.global_soluction_1_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fiap.ec.global_soluction_1_backend.model.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long>{}