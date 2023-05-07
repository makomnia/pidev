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
import tn.esprit.myapp.entities.Participation;
import tn.esprit.myapp.utils.Statics;

/**
 *
 * @author ihebl
 */
public class ServiceParticipant {
     private static ServiceParticipant instance = null;
    private boolean resultOK;
    private ArrayList<Participation> participations;
    private final ConnectionRequest req;

    private ServiceParticipant() {
        req = new ConnectionRequest();
    }

    public static ServiceParticipant getInstance() {
        if (instance == null) {
            instance = new ServiceParticipant();
        }
        return instance;
    }

    public boolean addPart(String nom, String mail) {
      
        
        String url = Statics.BASE_URL + "/participation/addParticipationJSON/new?nom_participant=" +nom + "&mail=" +mail + "&covoiturage=15";
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

    public ArrayList<Participation> getAllParts() {
        String url = "http://127.0.0.1:8000/participation/AllParticipation";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                participations = parseParticipation(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return participations;
    }

    private ArrayList<Participation> parseParticipation(String jsonText) {
        try {
            participations = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> participationsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) participationsListJson.get("root");
            for (Map<String, Object> obj : list) {
                Participation participation = new Participation();
                float id = Float.parseFloat(obj.get("id").toString());
                participation.setId((int) id);
                participation.setNom_participant(obj.get("nom_participant").toString());
                participation.setMail(obj.get("mail").toString());
               
                participations.add(participation);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return participations;
    }
   
   
     public boolean deleteParticipation(int id) {
         String url =  "http://127.0.0.1:8000/participation/deleteParticipationJSON/" 
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
