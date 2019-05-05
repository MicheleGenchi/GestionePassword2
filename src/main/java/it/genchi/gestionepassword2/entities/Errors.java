package it.genchi.gestionepassword2.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JAVASE
 */
public enum Errors {
    InsertFailure("I dati sono incompleti, operazione di insert fallita"),
    CampoInvalido("Questo campo deve essere digitato"), 
    PosizioneInvalida("La voce selezionata non può essere cancellata o modificata"),
    DataBaseInsesistente("Impossibile recuperare i dati dal server db"),
    LoginFallito("Utente e password non presenti nel db"),
    RegistrazioneFallita("Non é stato possibile registrare l'utente"),
    DuplicateUtente("Esiste già un utente con questo nome"),
    InvalidEmail("Impossibile convalidare l'email di registrazione"),
    DuplicateEmail("L'email é già presente nel mio archivio");
    
    final private String descrizione;
    
    private Errors(String descrizione) {
        this.descrizione=descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}

