/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.padaria.controle;

import br.padaria.modelo.Fornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class ControllerFornecedor extends ControladorMaster<Fornecedor> {

    EntityManager em = getEM();

    public List buscarForneceores() {

        List<Fornecedor> fornecedor = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("select f from Fornecedor f");
            fornecedor = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar fornecedores: " + e);
        } finally {
            em.close();
        }
        return fornecedor;
    }

    public List pesquisarRelease(String str) {

        List<Fornecedor> fornecedor = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery(str);
            fornecedor = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
        return fornecedor;
    }

    public Fornecedor localizarPorCpf(String cpf) {

        Fornecedor fornecedor = null;
        try {
            fornecedor = em.find(Fornecedor.class, cpf);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }
        return fornecedor;
    }
}
