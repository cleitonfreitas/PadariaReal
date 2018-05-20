/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.padaria.controle;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import br.padaria.modelo.VendaItem;

/**
 *
 * @author Cleiton
 */
public class ControllerVendaItem implements Serializable {

    EntityManager em = JpaUtil.getEm();

    public List buscarItensVenda(Integer id) {
        List<VendaItem> itens = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("select i from VendaItem i where i.id = :id");
            query.setParameter(":id", id);
            itens = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Itens não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
        }finally{
            em.close();
        }
        return itens;
    }
}
