package org.example.controllers;

import org.example.DBManager.ObjectUtil;
import org.example.models.Alumno;

import javax.persistence.TypedQuery;
import java.text.DecimalFormat;
import java.util.Iterator;

public class AlumnoDAO implements I_ComandaDAO {
    public boolean insertAlumno(Alumno alumno) {
        boolean result;
        var em = ObjectUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(alumno);
            em.getTransaction().commit();
            result = true;
        } catch (Exception exception) {
            result = false;
        } finally {
            em.close();
        }
        return result;
    }

    public void listAll() {
        var em = ObjectUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Alumno> query = em.createQuery("select a from Alumno a", Alumno.class);

        var result = query.getResultList();
        em.close();
        Iterator<Alumno> it = result.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }

    }

    public void listSuspended() {
        var em = ObjectUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Alumno> query = em.createQuery("select a from Alumno a where a.nDI<:s_DI or a.nAD<:s_AD", Alumno.class);
        query.setParameter("s_DI", 5.00);
        query.setParameter("s_AD", 5.00);
        var result = query.getResultList();
        em.close();
        result.forEach(alumno -> {
            System.out.println(alumno.nombre);
            System.out.println(alumno.nAD);
            System.out.println(alumno.nDI);
            System.out.println("*************************************");
        });
    }

    public void gradeAverage(String module) {
        var em = ObjectUtil.getEntityManagerFactory().createEntityManager();
        var df = new DecimalFormat("#.##");
        TypedQuery<Double> query;
        if (module.equals("AD")) {
            query = em.createQuery("select AVG(a.nAD) from Alumno a", Double.class);
        } else {
            query = em.createQuery("select AVG(a.nDI) from Alumno a", Double.class);
        }
        var result = query.getSingleResult();
        em.close();
        System.out.println("la nota media del modulo "+module+" es: "+df.format(result));
    }

    @Override
    public void ratioPassed() {
        var em = ObjectUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Long> query1 = em.createQuery("select COUNT(a) from Alumno a where a.nAD>:a_AD and a.nDI>:a_DI", Long.class);
        query1.setParameter("a_DI", 5.00);
        query1.setParameter("a_AD", 5.00);
        TypedQuery<Long> query2 = em.createQuery("select COUNT(a) from Alumno a", Long.class);
        var totalPassed=(double) query1.getSingleResult();
        var alumnos =(double) query2.getSingleResult();
        em.close();
        System.out.println("El ratio de alumnos aprobados es: "+(totalPassed/alumnos));
    }
}
