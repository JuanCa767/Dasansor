package com.proyectodsansor.dsansor_aplicativo_web.service;

import java.util.ArrayList;
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
        List<ejecucion_dao> ejecuciones = new ArrayList<>();
        Session session = crearSesion();
        try {
        ejecuciones = session.createQuery("from ejecucion", ejecucion_dao.class).list();
        session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ejecuciones;



        public ejecucion_dao ejecucionxNum_orden(int Num_orden) {
            Session session = crearSesion();
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
            String message = "";
            Session session = crearSesion();
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
            Session session = crearSesion();
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
            Session session = crearSesion();
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
        
        public Calendar StringToCalendar(String fecha_asignacion, String fecha_instalacion, 
        String fecha_integracion, String fecha_documentacion) {
            String[] dateString = fecha_asignacion.split("/");
            String[] dateString = fecha_instalacion.split("/");
            String[] dateString = fecha_integracion.split("/");
            String[] dateString = fecha_documentacion.split("/");
            int year = Integer.parseInt(dateString[2]);
            int month = Integer.parseInt(dateString[1]) - 1;
            int date = Integer.parseInt(dateString[0]);
            Calendar fecha_asignacionCalendar = Calendar.getInstance();
            fecha_asignacionCalendar.set(year, month, date);
            return fecha_asignacionCalendar;
        }


    }

}