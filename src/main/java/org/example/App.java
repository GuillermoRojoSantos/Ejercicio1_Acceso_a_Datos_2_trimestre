package org.example;

import org.example.controllers.AlumnoDAO;
import org.example.models.Alumno;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        AlumnoDAO dao = new AlumnoDAO();
        Alumno alumno1=new Alumno();
        alumno1.setNombre("Guillermo Rojo");
        alumno1.setEmail("rojoguillermolfim@gmal.com");
        alumno1.setTelefono("123456879");
        alumno1.setNDI(10.0);
        alumno1.setNAD(10.0);

        Alumno alumno2=new Alumno();
        alumno2.setNombre("Alejandro");
        alumno2.setEmail("holde3@gmal.com");
        alumno2.setTelefono("456789851");
        alumno2.setNDI(4.5);
        alumno2.setNAD(9.8);

        Alumno alumno3=new Alumno();
        alumno3.setNombre("Loren");
        alumno3.setEmail("loren@gmal.com");
        alumno3.setTelefono("2354865548");
        alumno3.setNDI(2.2);
        alumno3.setNAD(4.8);

        Alumno alumno4=new Alumno();
        alumno4.setNombre("Roberto");
        alumno4.setEmail("roberto@gmal.com");
        alumno4.setTelefono("126558744");
        alumno4.setNDI(5.5);
        alumno4.setNAD(7.8);

        Alumno alumno5=new Alumno();
        alumno5.setNombre("Manuel");
        alumno5.setEmail("rojoguillermolfim@gmal.com");
        alumno5.setTelefono("123456879");
        alumno5.setNDI(5.45);
        alumno5.setNAD(1.0);


        //Prueba inserción alumnos en la BBDD
        //Tiene que devolver 5 trues
        //En un principio modifiqué el método insert para que devolviese un booleano para hacer un menú
        //Y que en le caso de que la inserción no pudiese completar, el método devolvería false
        //En ese momento el menú informaría al usuario de que la inserción ha fallado
        System.out.println(dao.insertAlumno(alumno1));
        System.out.println(dao.insertAlumno(alumno2));
        System.out.println(dao.insertAlumno(alumno3));
        System.out.println(dao.insertAlumno(alumno4));
        System.out.println(dao.insertAlumno(alumno5));

        System.out.println();
        //prueba listarAll()
        dao.listAll();

        System.out.println();

        //prueba listarSuspensos
        dao.listSuspended();

        System.out.println();

        //prueba de estadísticas (dos métodos)

        dao.gradeAverage("DA");
        dao.gradeAverage("DI");
        System.out.println("**************************");
        
        System.out.println();

        dao.ratioPassed();
    }

}
