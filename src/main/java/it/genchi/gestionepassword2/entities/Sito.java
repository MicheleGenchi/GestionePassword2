/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.genchi.gestionepassword2.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JAVASE
 */
@Entity
@Table(name = "sito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sito.findAll", query = "SELECT s FROM Sito s")
    , @NamedQuery(name = "Sito.findByIdSito", query = "SELECT s FROM Sito s WHERE s.idSito = :idSito")
    , @NamedQuery(name = "Sito.findByDescrizione", query = "SELECT s FROM Sito s WHERE s.descrizione = :descrizione")
    , @NamedQuery(name = "Sito.findByIndirizzo", query = "SELECT s FROM Sito s WHERE s.indirizzo = :indirizzo")
    , @NamedQuery(name = "Sito.findByUtente", query = "SELECT s FROM Sito s WHERE s.utente = :utente")
    , @NamedQuery(name = "Sito.findByPassword", query = "SELECT s FROM Sito s WHERE s.password = :password")
    , @NamedQuery(name = "Sito.Gruppi", query = "SELECT DISTINCT(s.idTipo) FROM Sito s")
    , @NamedQuery(name = "Siti.findByTipo", query = "SELECT s FROM Sito s WHERE s.idTipo = :idTipo")
})
public class Sito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSito")
    private Integer idSito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "descrizione")
    private String descrizione;
    @Size(max = 100)
    @Column(name = "indirizzo")
    private String indirizzo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "utente")
    private String utente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "idTipo", referencedColumnName = "idTipo")
    @ManyToOne(optional = false)
    private Tipo idTipo;
    @JoinColumn(name = "Login", referencedColumnName = "Utente")
    @ManyToOne(optional = false)
    private Login login;
    @OneToMany(mappedBy = "idSito")
    private List<Prodotto> prodottoList;

    public Sito() {
    }

    public Sito(Integer idSito) {
        this.idSito = idSito;
    }

    public Sito(Integer idSito, String descrizione, String utente, String password) {
        this.idSito = idSito;
        this.descrizione = descrizione;
        this.utente = utente;
        this.password = password;
    }

    public Integer getIdSito() {
        return idSito;
    }

    public void setIdSito(Integer idSito) {
        this.idSito = idSito;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        this.idTipo = idTipo;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @XmlTransient
    public List<Prodotto> getProdottoList() {
        return prodottoList;
    }

    public void setProdottoList(List<Prodotto> prodottoList) {
        this.prodottoList = prodottoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSito != null ? idSito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sito)) {
            return false;
        }
        Sito other = (Sito) object;
        if ((this.idSito == null && other.idSito != null) || (this.idSito != null && !this.idSito.equals(other.idSito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.genchi.gestionepassword2.entities.Sito[ idSito=" + idSito + " ]";
    }
    
}
