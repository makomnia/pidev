/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import tn.esprit.myapp.entities.Covoiturage;
import tn.esprit.myapp.utils.Statics;

/**
 *
 * @author ihebl
 */
public class ServiceCovoiturage {
    private static ServiceCovoiturage instance = null;
    private boolean resultOK;
    private ArrayList<Covoiturage> covoiturages;
    private final ConnectionRequest req;

    private ServiceCovoiturage() {
        req = new ConnectionRequest();
    }

    public static ServiceCovoiturage getInstance() {
        if (instance == null) {
            instance = new ServiceCovoiturage();
        }
        return instance;
    }

    public boolean addCov(Covoiturage covoiturage) {
        String adresse_depart = covoiturage.getAdresse_depart();
        String adresse_arrive = covoiturage.getArrive();
        Date date_depart = covoiturage.getDate_depart();
        //String heure_depart = covoiturage.getHeure_depart();
        int nb_place = covoiturage.getNb_place();
        float prix = covoiturage.getPrix();
        String description = covoiturage.getDescription();
        String nom_conducteur = covoiturage.getNom_conducteur();
        

        String url = Statics.BASE_URL + "/covoiturage/addCovoiturageJSON/new?adresse_depart=" +covoiturage.getAdresse_depart() + "&adresse_arrive=" +covoiturage.getArrive() +"&heure_depart=" + covoiturage.getHeure_depart()+"&nb_place=" +covoiturage.getNb_place()+ "&prix=" + covoiturage.getPrix()+"&description=" + covoiturage.getDescription()+"&nom_conducteur=" + covoiturage.getNom_conducteur();
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; // Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Covoiturage> getAllCovoits() {
        String url = "http://127.0.0.1:8000/covoiturage/AllCovoiturage";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                covoiturages = parseCovoiturage(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return covoiturages;
    }

    private ArrayList<Covoiturage> parseCovoiturage(String jsonText) {
        try {
            covoiturages = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> covoituragesListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) covoituragesListJson.get("root");
            for (Map<String, Object> obj : list) {
                Covoiturage covoiturage = new Covoiturage();
                float id = Float.parseFloat(obj.get("id").toString());
                covoiturage.setId((int) id);
                covoiturage.setAdresse_depart(obj.get("adresse_depart").toString());
                covoiturage.setArrive(obj.get("adresse_arrive").toString());
                covoiturage.setHeure_depart(obj.get("heure_depart").toString());
                covoiturage.setNb_place( Integer.parseInt(obj.get("nb_place").toString().substring(0, 1)) );
                 covoiturage.setDescription(obj.get("description").toString());
                covoiturage.setNom_conducteur(obj.get("nom_conducteur").toString());
                covoiturages.add(covoiturage);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return covoiturages;
    }
   
   
     public boolean deleteCovoituarge(int id) {
         String url =  "http://127.0.0.1:8000/covoiturage/deleteCovoiturageJSON/" 
               + id;
        req.setUrl(url);
        //req.addArgument("username", MyApplication.loggedUser.getUsername());
      req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
     
    
}
