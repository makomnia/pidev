/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.myapp.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ihebl
 */
public class Covoiturage {
    int id;
   private String adresse_depart;
   private String adresse_arrive;
   private Date date_depart;
   private String heure_depart;
   private int nb_place;
   private float prix;
   private String description;
   private String nom_conducteur;
   private Participation participation;

    public Covoiturage() {
    }

    public Covoiturage(String adresse_depart, String arrive, Date date_depart, String heure_depart, int nb_place, float prix, String description, String nom_conducteur, Participation participation) {
        this.adresse_depart = adresse_depart;
        this.adresse_arrive = arrive;
        this.date_depart = date_depart;
        this.heure_depart = heure_depart;
        this.nb_place = nb_place;
        this.prix = prix;
        this.description = description;
        this.nom_conducteur = nom_conducteur;
        this.participation = participation;
    }

    public Covoiturage(int id, String adresse_depart, String arrive, Date date_depart, String heure_depart, int nb_place, float prix, String description, String nom_conducteur, Participation participation) {
        this.id = id;
        this.adresse_depart = adresse_depart;
        this.adresse_arrive = arrive;
        this.date_depart = date_depart;
        this.heure_depart = heure_depart;
        this.nb_place = nb_place;
        this.prix = prix;
        this.description = description;
        this.nom_conducteur = nom_conducteur;
        this.participation = participation;
    }

    public Covoiturage(String adresse_depart, String arrive, String heure_depart, int nb_place, float prix, String description, String nom_conducteur) {
        this.adresse_depart = adresse_depart;
        this.adresse_arrive = arrive;
        this.heure_depart = heure_depart;
        this.nb_place = nb_place;
        this.prix = prix;
        this.description = description;
        this.nom_conducteur = nom_conducteur;
    }

    public Covoiturage(int id, String adresse_depart, String arrive, String heure_depart, int nb_place, float prix, String description, String nom_conducteur, Participation participation) {
        this.id = id;
        this.adresse_depart = adresse_depart;
        this.adresse_arrive = arrive;
        this.heure_depart = heure_depart;
        this.nb_place = nb_place;
        this.prix = prix;
        this.description = description;
        this.nom_conducteur = nom_conducteur;
        this.participation = participation;
    }

    public Covoiturage(String adresse_depart, String arrive, String heure_depart, int nb_place, float prix, String description, String nom_conducteur, Participation participation) {
        this.adresse_depart = adresse_depart;
        this.adresse_arrive = arrive;
        this.heure_depart = heure_depart;
        this.nb_place = nb_place;
        this.prix = prix;
        this.description = description;
        this.nom_conducteur = nom_conducteur;
        this.participation = participation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse_depart() {
        return adresse_depart;
    }

    public void setAdresse_depart(String adresse_depart) {
        this.adresse_depart = adresse_depart;
    }

    public String getArrive() {
        return adresse_arrive;
    }

    public void setArrive(String arrive) {
        this.adresse_arrive = arrive;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public String getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(String heure_depart) {
        this.heure_depart = heure_depart;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom_conducteur() {
        return nom_conducteur;
    }

    public void setNom_conducteur(String nom_conducteur) {
        this.nom_conducteur = nom_conducteur;
    }

    public Participation getParticipation() {
        return participation;
    }

    public void setParticipation(Participation participation) {
        this.participation = participation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.adresse_depart);
        hash = 37 * hash + Objects.hashCode(this.adresse_arrive);
        hash = 37 * hash + Objects.hashCode(this.date_depart);
        hash = 37 * hash + Objects.hashCode(this.heure_depart);
        hash = 37 * hash + this.nb_place;
        hash = 37 * hash + Float.floatToIntBits(this.prix);
        hash = 37 * hash + Objects.hashCode(this.description);
        hash = 37 * hash + Objects.hashCode(this.nom_conducteur);
        hash = 37 * hash + Objects.hashCode(this.participation);
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
        final Covoiturage other = (Covoiturage) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nb_place != other.nb_place) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        if (!Objects.equals(this.adresse_depart, other.adresse_depart)) {
            return false;
        }
        if (!Objects.equals(this.adresse_arrive, other.adresse_arrive)) {
            return false;
        }
        if (!Objects.equals(this.heure_depart, other.heure_depart)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.nom_conducteur, other.nom_conducteur)) {
            return false;
        }
        if (!Objects.equals(this.date_depart, other.date_depart)) {
            return false;
        }
        return Objects.equals(this.participation, other.participation);
    }

    @Override
    public String toString() {
        return "Covoiturage{" + "id=" + id + ", adresse_depart=" + adresse_depart + ", arrive=" + adresse_arrive + ", date_depart=" + date_depart + ", heure_depart=" + heure_depart + ", nb_place=" + nb_place + ", prix=" + prix + ", description=" + description + ", nom_conducteur=" + nom_conducteur + ", participation=" + participation + '}';
    }
   
   
    
}
