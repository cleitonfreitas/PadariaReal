/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.padaria.controle;

import br.padaria.modelo.Orcamento;
import br.padaria.modelo.OrcamentoItem;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Cleiton
 */
public class ControllerOrcamento implements Serializable {
    
    EntityManager em = JpaUtil.getEm();
    
    public List listagemOrcamento(){
        List<Orcamento> orcList = null;
        try{
            em.getTransaction().begin();
            Query query = em.createQuery("select o from Orcamento o");
            orcList = query.getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            
        }finally{
            em.close();
        }
        
        return orcList;
    }
    
    public void salvarOrcamento(Orcamento orc) {
        try {
            em.getTransaction().begin();
            em.persist(orc);
            em.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            em.close();
        }
    }
    
    public void salvarItensOrcamento(OrcamentoItem itms){
        try{
            em.getTransaction().begin();
            em.persist(itms);
            em.getTransaction().commit();
        }catch(Exception e){
            
        }finally{
            em.close();
        }
    }
}
