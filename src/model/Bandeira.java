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
@Table(name = "bandeira")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bandeira.findAll", query = "SELECT b FROM Bandeira b"),
    @NamedQuery(name = "Bandeira.findByIdbandeira", query = "SELECT b FROM Bandeira b WHERE b.idbandeira = :idbandeira"),
    @NamedQuery(name = "Bandeira.findByDescricao", query = "SELECT b FROM Bandeira b WHERE b.descricao = :descricao")})
public class Bandeira implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbandeira")
    private Integer idbandeira;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbandeira")
    private List<Auxcartao> auxcartaoList;

    public Bandeira() {
    }

    public Bandeira(Integer idbandeira) {
        this.idbandeira = idbandeira;
    }

    public Integer getIdbandeira() {
        return idbandeira;
    }

    public void setIdbandeira(Integer idbandeira) {
        Integer oldIdbandeira = this.idbandeira;
        this.idbandeira = idbandeira;
        changeSupport.firePropertyChange("idbandeira", oldIdbandeira, idbandeira);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
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
        hash += (idbandeira != null ? idbandeira.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bandeira)) {
            return false;
        }
        Bandeira other = (Bandeira) object;
        if ((this.idbandeira == null && other.idbandeira != null) || (this.idbandeira != null && !this.idbandeira.equals(other.idbandeira))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bandeira[ idbandeira=" + idbandeira + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
