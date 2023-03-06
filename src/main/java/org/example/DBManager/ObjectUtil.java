package org.example.DBManager;

import lombok.val;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObjectUtil {
    private static EntityManagerFactory entityManagerFactory;

    static{
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("data.odb");
            System.out.println("Conexión realizada con exito");
        }catch(Exception ex){
            System.out.println("Hubo error al iniciar en entityManager");
            System.out.println(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
