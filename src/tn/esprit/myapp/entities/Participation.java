/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.myapp.entities;

import java.util.Objects;

/**
 *
 * @author ihebl
 */
public class Participation {
    private int id;
    private String nom_participant;
    private String mail;
    private Covoiturage covoiturage;

    public Participation() {
    }

    public Participation(String nom_participant, String mail, Covoiturage covoiturage) {
        this.nom_participant = nom_participant;
        this.mail = mail;
        this.covoiturage = covoiturage;
    }

    public Participation(int id, String nom_participant, String mail, Covoiturage covoiturage) {
        this.id = id;
        this.nom_participant = nom_participant;
        this.mail = mail;
        this.covoiturage = covoiturage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_participant() {
        return nom_participant;
    }

    public void setNom_participant(String nom_participant) {
        this.nom_participant = nom_participant;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Covoiturage getCovoiturage() {
        return covoiturage;
    }

    public void setCovoiturage(Covoiturage covoiturage) {
        this.covoiturage = covoiturage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.nom_participant);
        hash = 37 * hash + Objects.hashCode(this.mail);
        hash = 37 * hash + Objects.hashCode(this.covoiturage);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participation other = (Participation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom_participant, other.nom_participant)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        return Objects.equals(this.covoiturage, other.covoiturage);
    }

    @Override
    public String toString() {
        return "Participation{" + "id=" + id + ", nom_participant=" + nom_participant + ", mail=" + mail + ", covoiturage=" + covoiturage + '}';
    }
    
    
}
