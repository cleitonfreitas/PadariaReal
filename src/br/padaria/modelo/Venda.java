/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.padaria.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
public class Venda implements EntidadeBase, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvenda")
    private Integer id;
    @Column(name = "valor_venda")
    private double valorVenda;
    @Column(name = "valor_desconto")
    private double valorDesconto;
    @Column(name = "valor_pago")
    private double valorPago;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_venda")
    private Date dataVenda;
         
    @ManyToOne
    @JoinColumn(name = "forma_id")
    private FormaPgto formapgto;
    
    @OneToMany(mappedBy = "venda")
    private List<VendaItem> vitens;
    
    @OneToMany
    @JoinColumn(name = "ficha_id")
    private Ficha ficha;

    public Venda() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public FormaPgto getFormapgto() {
        return formapgto;
    }

    public void setFormapgto(FormaPgto formapgto) {
        this.formapgto = formapgto;
    }

    public List<VendaItem> getVitens() {
        return vitens;
    }

    public void setVitens(List<VendaItem> vitens) {
        this.vitens = vitens;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
}
