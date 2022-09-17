package com.proyectodsansor.dsansor_aplicativo_web.controller;

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

import com.proyectodsansor.dsansor_aplicativo_web.model.ejecucion_dao;
import com.proyectodsansor.dsansor_aplicativo_web.service.ejecucion_service;

@RestController
@RequestMapping("/ejecucion")
public class ejecucion_controller {
    // Atributos
    ejecucion_service service;

    // Constructor
    public ejecucion_controller() {
        service = new ejecucion_service();
    }

    /** ACCIONES */
    @GetMapping
    public List<ejecucion_dao> obtenerEjecucion() {
        return service.obtenerEjecucion();
    }

    @GetMapping("/{Num_orden}")
    public ejecucion_dao ejecucionxNum_orden(@PathVariable(name = "Num_orden") int Num_orden) {
        return service.ejecucionxNum_orden(Num_orden);
    }

    @PostMapping
    public String crearejecucion(@RequestBody ejecucion_dao ejecucion) {
        return service.crearejecucion(ejecucion);
    }

    @PutMapping
    @CrossOrigin("*")
    public String actualizarejecucion(@RequestBody ejecucion_dao ejecucion) {
        return service.actualizarejecucion(ejecucion);
    }

    @DeleteMapping("/{Num_orden}")
    public String eliminarejecucion(@PathVariable(name = "Num_orden") int Num_orden) {
        return service.eliminarejecucion(Num_orden);
    }
}