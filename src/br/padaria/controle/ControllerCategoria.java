/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.padaria.controle;

import br.padaria.modelo.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class ControllerCategoria extends ControladorMaster<Categoria> {

    EntityManager em = getEM();

    public List busarCategorias() {
        List<Categoria> categoria = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("select c from Categoria c");
            categoria = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar a Categoria." + e);
        } finally {
            em.close();
        }
        return categoria;
    }

    public List pesquisarRelease(String str) {

        EntityManager em = getEM();
        List<Categoria> categoria = null;

        try {
            em.getTransaction().begin();
            Query query = em.createQuery(str);
            categoria = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
        return categoria;
    }

    public Categoria localizarPorCodigoBarras(String codBarras) {
        EntityManager em = getEM();
        Categoria categoria = null;
        try {
            categoria = em.find(Categoria.class, codBarras);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Categoria não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }
        return categoria;
    }
}
