/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.padaria.controle;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Cleiton
 */
public class JpaUtil {
    
    private static EntityManagerFactory factory;
    
    static {
        factory = Persistence.createEntityManagerFactory("PadariaRealPU");
    }
    
    public static EntityManager getEm(){
        return factory.createEntityManager();
    }
    
    public static void finalizarConexao(){
        factory.close();
    }
}
