package br.padaria.controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import br.padaria.modelo.Produto;

public class ControllerProduto extends ControladorMaster<Produto> {

    EntityManager em = getEM();

    public List buscarProdutos() {
        List<Produto> produto = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("select p from Produto p");
            produto = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar Produtos: " + e);
        } finally {
            em.close();
        }
        return produto;
    }

    public List pesquisarRelease(String str) {
        List<Produto> produto = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery(str);
            produto = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO " + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
        return produto;
    }

    public List localizarPorCodigoBarras(String barras) {
        
        List<Produto> produto = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("select p from Produto p WHERE p.codigoBarras = :codigoBarras");
            query.setParameter("codigoBarras", barras);
            query.setMaxResults(1);
            produto = query.getResultList();
            em.getTransaction().commit();

//            String consulta = "select p from Produto p p.codigoBarras = :codigoBarras";
//            TypedQuery<Produto> query = em.createQuery(consulta, Produto.class);
//            query.setParameter("codigoBarras", codBarras);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }
        return produto;
    }

    public Produto localizarProdutoBarras(String barras) {
        
        Produto produto = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("select p from Produto p WHERE p.codigoBarras = :codigoBarras");
            query.setParameter("codigoBarras", barras);
            produto = (Produto) query.getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
        } finally {
            em.close();
        }
        return produto;
    }
}
