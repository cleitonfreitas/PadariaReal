/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.padaria.controle;

import br.padaria.modelo.Ficha;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class ControllerFicha extends ControladorMaster<Ficha> {

    EntityManager em = getEM();

    public List localizar() {
        EntityManager em = getEM();
        List<Ficha> fichaList = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("select f from Ficha f");
            fichaList = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar as Fichas: " + e);
        } finally {
            em.close();
        }
        return fichaList;
    }

    public List pesquisarRelease(String str) {

        List<Ficha> fichaList = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery(str);
            fichaList = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
        return fichaList;
    }

    public Ficha localizarPorBarras(String codBarras) {

        Ficha ficha = null;
        try {
            ficha = em.find(Ficha.class, codBarras);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ficha não encontrada!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }
        return ficha;
    }

    public Ficha localizarPorId(int codigo) {

        Ficha ficha = null;
        try {
            ficha = em.find(Ficha.class, codigo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ficha não encontrada!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }

        return ficha;
    }

    public void alterarStatus(Ficha ficha) {

        try {
            em.getTransaction().begin();
            em.merge(ficha);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ficha não encontrada!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }
    }
}
