/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.padaria.controle;

import br.padaria.modelo.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class ControllerCliente extends ControladorMaster<Cliente>{

    EntityManager em = getEM();

    public List localizar() {
        
        List<Cliente> cliente = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("select c from Cliente c");
            cliente = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar a lista de Clientes: " + e);
        } finally {
            em.close();
        }
        return cliente;
    }

    public List pesquisarRelease(String str) {

        List<Cliente> cliente = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery(str);
            cliente = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
        return cliente;
    }

    public Cliente localizarPorCpf(String cpf) {
  
        Cliente cliente = null;
        try {
            cliente = em.find(Cliente.class, cpf);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }
        return cliente;
    }

    public Cliente localizarPorId(Long codigo) {
        
        Cliente cli = null;
        try {
            em.getTransaction().begin();
            cli = em.find(Cliente.class, codigo);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao localizar o Cliente " + e);
        } finally {
            em.close();
        }
        return cli;
    }
}
