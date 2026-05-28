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

import com.fiap.ec.global_soluction_1_backend.model.AlertaCritico;
import com.fiap.ec.global_soluction_1_backend.service.AlertaCriticoService;

@RestController
@RequestMapping("/alertas")
@CrossOrigin(origins = "*")
public class AlertaCriticoController {
    
    private final AlertaCriticoService service;

    public AlertaCriticoController(AlertaCriticoService service) {
        this.service = service;
    }

    @PostMapping
    public AlertaCritico criar(@RequestBody AlertaCritico alerta) {
        return service.salvar(alerta);
    }

    @GetMapping
    public List<AlertaCritico> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public AlertaCritico buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AlertaCritico atualizar(@PathVariable Long id, @RequestBody AlertaCritico alerta) {
        return service.atualizar(id, alerta);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}