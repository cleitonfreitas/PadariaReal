/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.padaria.controle;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import br.padaria.modelo.Cliente;
import br.padaria.modelo.Venda;

/**
 *
 * @author Cleiton
 */
public class ControllerVenda extends ControladorMaster<Venda> {

    EntityManager em = getEM();

    public Venda inicializarVenda(Venda v) {
        try {
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Venda não encontrada!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }
        return v;
    }

    public Cliente buscarPorId(int id) {
        
        Cliente cliente = null;
        try {
            em.getTransaction().begin();
            cliente = em.find(Cliente.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }
        return cliente;
    }
}
