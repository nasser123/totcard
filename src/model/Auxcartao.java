/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nasser
 */
@Entity
@Table(name = "auxcartao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auxcartao.findAll", query = "SELECT a FROM Auxcartao a"),
    @NamedQuery(name = "Auxcartao.findByIdtauxcartao", query = "SELECT a FROM Auxcartao a WHERE a.idtauxcartao = :idtauxcartao"),
    @NamedQuery(name = "Auxcartao.findByNrparcelas", query = "SELECT a FROM Auxcartao a WHERE a.nrparcelas = :nrparcelas"),
    @NamedQuery(name = "Auxcartao.findByTaxa", query = "SELECT a FROM Auxcartao a WHERE a.taxa = :taxa"),
    @NamedQuery(name = "Auxcartao.findByPrazo", query = "SELECT a FROM Auxcartao a WHERE a.prazo = :prazo")})
public class Auxcartao implements Serializable {

    @Basic(optional = false)
    @Column(name = "nrparcelas")
    private int nrparcelas;
    @Basic(optional = false)
    @Column(name = "prazo")
    private int prazo;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtauxcartao")
    private Integer idtauxcartao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taxa")
    private BigDecimal taxa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtauxcartao")
    private List<Venda> vendaList;
    @JoinColumn(name = "idadministradora", referencedColumnName = "idadministradora")
    @ManyToOne(optional = false)
    private Administradora idadministradora;
    @JoinColumn(name = "idbandeira", referencedColumnName = "idbandeira")
    @ManyToOne(optional = false)
    private Bandeira idbandeira;

    public Auxcartao() {
    }

    public Auxcartao(Integer idtauxcartao) {
        this.idtauxcartao = idtauxcartao;
    }

    public Integer getIdtauxcartao() {
        return idtauxcartao;
    }

    public void setIdtauxcartao(Integer idtauxcartao) {
        this.idtauxcartao = idtauxcartao;
    }


    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }


    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    public Administradora getIdadministradora() {
        return idadministradora;
    }

    public void setIdadministradora(Administradora idadministradora) {
        this.idadministradora = idadministradora;
    }

    public Bandeira getIdbandeira() {
        return idbandeira;
    }

    public void setIdbandeira(Bandeira idbandeira) {
        this.idbandeira = idbandeira;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtauxcartao != null ? idtauxcartao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auxcartao)) {
            return false;
        }
        Auxcartao other = (Auxcartao) object;
        if ((this.idtauxcartao == null && other.idtauxcartao != null) || (this.idtauxcartao != null && !this.idtauxcartao.equals(other.idtauxcartao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Auxcartao[ idtauxcartao=" + idtauxcartao + " ]";
    }

    public int getNrparcelas() {
        return nrparcelas;
    }

    public void setNrparcelas(int nrparcelas) {
        this.nrparcelas = nrparcelas;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }
    
}
