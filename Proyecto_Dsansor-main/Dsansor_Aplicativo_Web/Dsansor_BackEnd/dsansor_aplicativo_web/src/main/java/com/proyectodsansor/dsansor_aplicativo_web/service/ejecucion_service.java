package com.proyectodsansor.dsansor_aplicativo_web.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.proyectodsansor.dsansor_aplicativo_web.model.ejecucion_dao;

public class ejecucion_service {

    private SessionFactory factory;

    public ejecucion_service() {
        // Crear objeto que permita fabricar sesiones
        factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(ejecucion_dao.class)
                .buildSessionFactory();
    }

    private Session crearSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public List<ejecucion_dao> obtenerEjecucion() {
        System.out.println("--------------------------");
        System.out.println("Proceso de obtener ejecucion");
        System.out.println("--------------------------");
        List<ejecucion_dao> ejecuciones = new ArrayList<>();
        Session session = crearSession();
        try {
            ejecuciones = session.createQuery("from ejecucion_dao", ejecucion_dao.class).list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ejecuciones;
    }

    public ejecucion_dao ejecucionxNum_orden(int Num_orden) {
        Session session = crearSession();
        ejecucion_dao ejecucion = new ejecucion_dao();
        try {
            ejecucion = session.find(ejecucion_dao.class, Num_orden);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ejecucion;
    }

    public String crearejecucion(ejecucion_dao ejecucion) {
        System.out.println("*******************");
        System.out.println(ejecucion.getFecha_asignacion());
        System.out.println("********************");
        String message = "";
        Session session = crearSession();
        try {
            session.persist(ejecucion);
            session.getTransaction().commit();
            message = "Numero de orden creada con éxito";
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }
        return message;
    }

    public String actualizarejecucion(ejecucion_dao ejecucion) {
        String message = "";
        Session session = crearSession();
        try {
            session.merge(ejecucion);
            session.getTransaction().commit();
            session.close();
            message = "Numero de orden actualizada con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }
        return message;
    }

    public String eliminarejecucion(int Num_orden) {
        String message = "";
        Session session = crearSession();
        try {
            session.remove(ejecucionxNum_orden(Num_orden));
            session.getTransaction().commit();
            session.close();
            message = "Numero de orden eliminada con éxito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    public List<String> objToString(List<ejecucion_dao> ejecuciones) {
        List<String> ejecucionStr = new ArrayList<>();
        for (int i = 0; i < ejecuciones.size(); i++) {
            ejecucionStr.add(ejecuciones.get(i).toString());
        }
        return ejecucionStr;
    }

    public Calendar[] StringsToCalendar(String fecha_asignacion, String fecha_instalacion,
            String fecha_integracion, String fecha_documentacion) {
        String[] asignacionString = fecha_asignacion.split("/");
        String[] instalacionString = fecha_instalacion.split("/");
        String[] integracionString = fecha_integracion.split("/");
        String[] documentacionString = fecha_documentacion.split("/");

        int[] asignacionArray = retornarEnteros(asignacionString);
        int[] instalacionArray = retornarEnteros(instalacionString);
        int[] integracionArray = retornarEnteros(integracionString);
        int[] documentacionArray = retornarEnteros(documentacionString);

        Calendar fecha_asignacionCalendar = Calendar.getInstance();
        Calendar fecha_instalacionCalendar = Calendar.getInstance();
        Calendar fecha_integracionCalendar = Calendar.getInstance();
        Calendar fecha_documentacionCalendar = Calendar.getInstance();

        fecha_asignacionCalendar.set(asignacionArray[0], asignacionArray[1], asignacionArray[2]);
        fecha_instalacionCalendar.set(instalacionArray[0], instalacionArray[1], instalacionArray[2]);
        fecha_integracionCalendar.set(integracionArray[0], integracionArray[1], integracionArray[2]);
        fecha_documentacionCalendar.set(documentacionArray[0], documentacionArray[1], documentacionArray[2]);

        Calendar[] calendarios = {
                fecha_asignacionCalendar,
                fecha_instalacionCalendar,
                fecha_integracionCalendar,
                fecha_documentacionCalendar
        };

        return calendarios;
    }

    private int[] retornarEnteros(String[] fecha) {
        int year = Integer.parseInt(fecha[2]);
        int month = Integer.parseInt(fecha[1]) - 1;
        int date = Integer.parseInt(fecha[0]);
        int[] retorno = { year, month, date };
        return retorno;
    }
}
