package org.example.controllers;

import org.example.models.Alumno;

public interface I_ComandaDAO {

    boolean insertAlumno(Alumno alumno);

    void listAll();

    void listSuspended();

    void gradeAverage(String module);

    void ratioPassed();
}
