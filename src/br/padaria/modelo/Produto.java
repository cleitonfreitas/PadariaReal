/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.padaria.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Cleiton
 */
@Entity
public class Produto implements EntidadeBase, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduto")
    private Integer id;
    private String nome;
    private String descricao;
    @Column(name = "cod_barras")
    private String codigoBarras;
    @Column(name = "qtde_estoque")
    private double qtdeEstoque;
    @Column(name = "est_minimo")
    private double estoqueMinimo;
    @Column(name = "est_maximo")
    private double estoqueMaximo;
    @Column(name = "preco_compra")
    private double precoCompra;
    @Column(name = "preco_venda")
    private double precoVenda;
    private String inativo;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date data;
    
        
    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;
    
    @OneToMany(mappedBy = "produto")
    private List<OrcamentoItem>itensOrc;
    
    @OneToMany(mappedBy = "produto")
    private List<VendaItem> vitens;

    public Produto() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public double getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(double qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public double getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(double estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public double getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(double estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getInativo() {
        return inativo;
    }

    public void setInativo(String inativo) {
        this.inativo = inativo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<OrcamentoItem> getItensOrc() {
        return itensOrc;
    }

    public void setItensOrc(List<OrcamentoItem> itensOrc) {
        this.itensOrc = itensOrc;
    }

    public List<VendaItem> getVitens() {
        return vitens;
    }

    public void setVitens(List<VendaItem> vitens) {
        this.vitens = vitens;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", codigoBarras=" + codigoBarras + ", qtdeEstoque=" + qtdeEstoque + ", estoqueMinimo=" + estoqueMinimo + ", estoqueMaximo=" + estoqueMaximo + ", precoCompra=" + precoCompra + ", precoVenda=" + precoVenda + ", inativo=" + inativo + ", data=" + data + ", categoria=" + categoria + ", itensOrc=" + itensOrc + ", vitens=" + vitens + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
