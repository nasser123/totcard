/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nasser
 */
@Entity
@Table(name = "administradora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administradora.findAll", query = "SELECT a FROM Administradora a"),
    @NamedQuery(name = "Administradora.findByIdadministradora", query = "SELECT a FROM Administradora a WHERE a.idadministradora = :idadministradora"),
    @NamedQuery(name = "Administradora.findByDescricao", query = "SELECT a FROM Administradora a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "Administradora.findBySite", query = "SELECT a FROM Administradora a WHERE a.site = :site"),
    @NamedQuery(name = "Administradora.findByContato", query = "SELECT a FROM Administradora a WHERE a.contato = :contato"),
    @NamedQuery(name = "Administradora.findByMaquineta", query = "SELECT a FROM Administradora a WHERE a.maquineta = :maquineta"),
    @NamedQuery(name = "Administradora.findByBanco", query = "SELECT a FROM Administradora a WHERE a.banco = :banco"),
    @NamedQuery(name = "Administradora.findByAgencia", query = "SELECT a FROM Administradora a WHERE a.agencia = :agencia"),
    @NamedQuery(name = "Administradora.findByConta", query = "SELECT a FROM Administradora a WHERE a.conta = :conta")})
public class Administradora implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idadministradora")
    private Integer idadministradora;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "site")
    private String site;
    @Column(name = "contato")
    private String contato;
    @Column(name = "maquineta")
    private String maquineta;
    @Column(name = "banco")
    private String banco;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "conta")
    private String conta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idadministradora")
    private List<Auxcartao> auxcartaoList;

    public Administradora() {
    }

    public Administradora(Integer idadministradora) {
        this.idadministradora = idadministradora;
    }

    public Integer getIdadministradora() {
        return idadministradora;
    }

    public void setIdadministradora(Integer idadministradora) {
        Integer oldIdadministradora = this.idadministradora;
        this.idadministradora = idadministradora;
        changeSupport.firePropertyChange("idadministradora", oldIdadministradora, idadministradora);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        String oldSite = this.site;
        this.site = site;
        changeSupport.firePropertyChange("site", oldSite, site);
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        String oldContato = this.contato;
        this.contato = contato;
        changeSupport.firePropertyChange("contato", oldContato, contato);
    }

    public String getMaquineta() {
        return maquineta;
    }

    public void setMaquineta(String maquineta) {
        String oldMaquineta = this.maquineta;
        this.maquineta = maquineta;
        changeSupport.firePropertyChange("maquineta", oldMaquineta, maquineta);
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        String oldBanco = this.banco;
        this.banco = banco;
        changeSupport.firePropertyChange("banco", oldBanco, banco);
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        String oldAgencia = this.agencia;
        this.agencia = agencia;
        changeSupport.firePropertyChange("agencia", oldAgencia, agencia);
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        String oldConta = this.conta;
        this.conta = conta;
        changeSupport.firePropertyChange("conta", oldConta, conta);
    }

    @XmlTransient
    public List<Auxcartao> getAuxcartaoList() {
        return auxcartaoList;
    }

    public void setAuxcartaoList(List<Auxcartao> auxcartaoList) {
        this.auxcartaoList = auxcartaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadministradora != null ? idadministradora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administradora)) {
            return false;
        }
        Administradora other = (Administradora) object;
        if ((this.idadministradora == null && other.idadministradora != null) || (this.idadministradora != null && !this.idadministradora.equals(other.idadministradora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Administradora[ idadministradora=" + idadministradora + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
