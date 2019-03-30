/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.genchi.gestionepassword2.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JAVASE
 */
@Entity
@Table(name = "prodotto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prodotto.findAll", query = "SELECT p FROM Prodotto p")
    , @NamedQuery(name = "Prodotto.findByIdProdotto", query = "SELECT p FROM Prodotto p WHERE p.idProdotto = :idProdotto")
    , @NamedQuery(name = "Prodotto.findByArticolo", query = "SELECT p FROM Prodotto p WHERE p.articolo = :articolo")
    , @NamedQuery(name = "Prodotto.findByMarca", query = "SELECT p FROM Prodotto p WHERE p.marca = :marca")
    , @NamedQuery(name = "Prodotto.findByDataAcquisto", query = "SELECT p FROM Prodotto p WHERE p.dataAcquisto = :dataAcquisto")
    , @NamedQuery(name = "Prodotto.findByDuratagaranzia", query = "SELECT p FROM Prodotto p WHERE p.duratagaranzia = :duratagaranzia")})
public class Prodotto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "idProdotto")
    private String idProdotto;
    @Size(max = 45)
    @Column(name = "Articolo")
    private String articolo;
    @Size(max = 20)
    @Column(name = "Marca")
    private String marca;
    @Column(name = "Data_Acquisto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAcquisto;
    @Column(name = "Durata garanzia")
    private Integer duratagaranzia;
    @JoinColumn(name = "idSito", referencedColumnName = "idSito")
    @ManyToOne
    private Sito idSito;

    public Prodotto() {
    }

    public Prodotto(String idProdotto) {
        this.idProdotto = idProdotto;
    }

    public String getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(String idProdotto) {
        this.idProdotto = idProdotto;
    }

    public String getArticolo() {
        return articolo;
    }

    public void setArticolo(String articolo) {
        this.articolo = articolo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(Date dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public Integer getDuratagaranzia() {
        return duratagaranzia;
    }

    public void setDuratagaranzia(Integer duratagaranzia) {
        this.duratagaranzia = duratagaranzia;
    }

    public Sito getIdSito() {
        return idSito;
    }

    public void setIdSito(Sito idSito) {
        this.idSito = idSito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdotto != null ? idProdotto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prodotto)) {
            return false;
        }
        Prodotto other = (Prodotto) object;
        if ((this.idProdotto == null && other.idProdotto != null) || (this.idProdotto != null && !this.idProdotto.equals(other.idProdotto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.genchi.gestionepassword2.entities.Prodotto[ idProdotto=" + idProdotto + " ]";
    }
    
}
