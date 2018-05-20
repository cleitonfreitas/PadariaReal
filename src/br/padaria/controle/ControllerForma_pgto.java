/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.padaria.controle;

import br.padaria.modelo.FormaPgto;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class ControllerForma_pgto extends ControladorMaster<FormaPgto> {

    EntityManager em = getEM();

    public FormaPgto buscarFormaPagamento(Long id) {
        FormaPgto forma = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("select f from FormaPgto f where f.id :id");
            query.setParameter(":id", id);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro : " + e);
        } finally {
            em.close();
        }
        return forma;
    }

    public FormaPgto buscandoComFind(int id) {
        FormaPgto forma = null;
        try {
            em.getTransaction().begin();
            forma = em.find(FormaPgto.class, 1);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro : " + e);
        }
        return forma;
    }
}
