package com.fiap.ec.global_soluction_1_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.ec.global_soluction_1_backend.model.SistemaMonitorado;
import com.fiap.ec.global_soluction_1_backend.service.SistemaMonitoradoService;

@RestController
@RequestMapping("/sistemas")
@CrossOrigin(origins = "*")
public class SistemaMonitoradoController {
    
    private final SistemaMonitoradoService service;

    public SistemaMonitoradoController(SistemaMonitoradoService service) {
        this.service = service;
    }

    @PostMapping
    public SistemaMonitorado criar(@RequestBody SistemaMonitorado sistema) {
        return service.salvar(sistema);
    }

    @GetMapping
    public List<SistemaMonitorado> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public SistemaMonitorado buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public SistemaMonitorado atualizar(@PathVariable Long id, @RequestBody SistemaMonitorado sistema) {
        return service.atualizar(id, sistema);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}