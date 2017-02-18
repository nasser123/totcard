/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nasser
 */
@Entity
@Table(name = "parcelas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parcelas.findAll", query = "SELECT p FROM Parcelas p"),
    @NamedQuery(name = "Parcelas.findByIdparcelas", query = "SELECT p FROM Parcelas p WHERE p.idparcelas = :idparcelas"),
    @NamedQuery(name = "Parcelas.findByVencimento", query = "SELECT p FROM Parcelas p WHERE p.vencimento = :vencimento"),
    @NamedQuery(name = "Parcelas.findByValorbruto", query = "SELECT p FROM Parcelas p WHERE p.valorbruto = :valorbruto"),
    @NamedQuery(name = "Parcelas.findByValorliquido", query = "SELECT p FROM Parcelas p WHERE p.valorliquido = :valorliquido"),
    @NamedQuery(name = "Parcelas.findByDatapgto", query = "SELECT p FROM Parcelas p WHERE p.datapgto = :datapgto"),
    @NamedQuery(name = "Parcelas.findByHistorico", query = "SELECT p FROM Parcelas p WHERE p.historico = :historico"),
    @NamedQuery(name = "Parcelas.findBySituacao", query = "SELECT p FROM Parcelas p WHERE p.situacao = :situacao")})
public class Parcelas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idparcelas")
    private Integer idparcelas;
    @Column(name = "vencimento")
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorbruto")
    private BigDecimal valorbruto;
    @Column(name = "valorliquido")
    private BigDecimal valorliquido;
    @Column(name = "datapgto")
    @Temporal(TemporalType.DATE)
    private Date datapgto;
    @Column(name = "historico")
    private String historico;
    @Column(name = "situacao")
    private Short situacao;
    @JoinColumn(name = "idvenda", referencedColumnName = "idvenda")
    @ManyToOne(optional = false)
    private Venda idvenda;

    public Parcelas() {
    }

    public Parcelas(Integer idparcelas) {
        this.idparcelas = idparcelas;
    }

    public Integer getIdparcelas() {
        return idparcelas;
    }

    public void setIdparcelas(Integer idparcelas) {
        this.idparcelas = idparcelas;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public BigDecimal getValorbruto() {
        return valorbruto;
    }

    public void setValorbruto(BigDecimal valorbruto) {
        this.valorbruto = valorbruto;
    }

    public BigDecimal getValorliquido() {
        return valorliquido;
    }

    public void setValorliquido(BigDecimal valorliquido) {
        this.valorliquido = valorliquido;
    }

    public Date getDatapgto() {
        return datapgto;
    }

    public void setDatapgto(Date datapgto) {
        this.datapgto = datapgto;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Short getSituacao() {
        return situacao;
    }

    public void setSituacao(Short situacao) {
        this.situacao = situacao;
    }

    public Venda getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Venda idvenda) {
        this.idvenda = idvenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparcelas != null ? idparcelas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parcelas)) {
            return false;
        }
        Parcelas other = (Parcelas) object;
        if ((this.idparcelas == null && other.idparcelas != null) || (this.idparcelas != null && !this.idparcelas.equals(other.idparcelas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Parcelas[ idparcelas=" + idparcelas + " ]";
    }
    
}
