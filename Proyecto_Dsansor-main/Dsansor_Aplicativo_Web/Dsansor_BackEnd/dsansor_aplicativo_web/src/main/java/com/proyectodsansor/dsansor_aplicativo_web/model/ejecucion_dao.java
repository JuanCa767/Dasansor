package com.proyectodsansor.dsansor_aplicativo_web.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "ejecucion")
public class ejecucion_dao {

    @Id
    private int Num_orden;
    private float valor_orden;
    private Calendar fecha_asignacion;
    private String actividad;
    private String nombre_sitio;
    private Calendar fecha_instalacion;
    private Calendar fecha_integracion;
    private Calendar fecha_documentacion;

    public ejecucion_dao() {

    }

    public ejecucion_dao(int Num_orden, float valor_orden, Calendar fecha_asignacion,
            String actividad, String nombre_sitio, Calendar fecha_instalacion, Calendar fecha_integracion,
            Calendar fecha_documentacion) {
        this.Num_orden = Num_orden;
        this.valor_orden = valor_orden;
        this.fecha_asignacion = fecha_asignacion;
        this.actividad = actividad;
        this.nombre_sitio = nombre_sitio;
        this.fecha_instalacion = fecha_instalacion;
        this.fecha_integracion = fecha_integracion;
        this.fecha_documentacion = fecha_documentacion;

    }

    @Override
    public String toString() {
        String base_ejecucion = "-------------------------------\n";
        base_ejecucion += "Num_orden: " + Num_orden;
        base_ejecucion += "\nvalor_orden: " + valor_orden;
        base_ejecucion += "\nfecha_asignacion: " + fecha_asignacion;
        base_ejecucion += "\nactividad: " + actividad;
        base_ejecucion += "\nnombre_sitio: " + nombre_sitio;
        base_ejecucion += "\nfecha_instalacion: " + fecha_instalacion;
        base_ejecucion += "\nfecha_integracion: " + fecha_integracion;
        base_ejecucion += "\nfecha_documentacion: " + fecha_documentacion;
        base_ejecucion += "\n-------------------------------\n";
        return base_ejecucion;
    }

    // Consultores
    public int getNum_orden() {
        return Num_orden;
    }

    public float getValor_orden() {
        return valor_orden;
    }

    public Calendar getFecha_asignacion() {
        return fecha_asignacion;
    }

    public String getActividad() {
        return actividad;
    }

    public String getNombre_sitio() {
        return nombre_sitio;
    }

    public Calendar getFecha_instalacion() {
        return fecha_instalacion;
    }

    public Calendar getFecha_integracion() {
        return fecha_integracion;
    }

    public Calendar getFecha_documentacion() {
        return fecha_documentacion;
    }

    // modificadores
    public void setValor_orden(float valor_orden) {
        this.valor_orden = valor_orden;
    }

    public void setFecha_asignacion(Calendar fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public void setNombre_sitio(String nombre_sitio) {
        this.nombre_sitio = nombre_sitio;
    }

    public void setFecha_instalacion(Calendar fecha_instalacion) {
        this.fecha_instalacion = fecha_instalacion;
    }

    public void setFecha_integracion(Calendar fecha_integracion) {
        this.fecha_integracion = fecha_integracion;
    }

    public void setFecha_documentacion(Calendar fecha_documentacion) {
        this.fecha_documentacion = fecha_documentacion;
    }

}
