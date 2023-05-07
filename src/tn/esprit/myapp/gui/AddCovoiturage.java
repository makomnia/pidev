/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.myapp.gui;

import com.codename1.capture.Capture;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import static java.lang.String.valueOf;
import tn.esprit.myapp.entities.Covoiturage;
import tn.esprit.myapp.services.ServiceCovoiturage;

/**
 *
 * @author ihebl
 */
public class AddCovoiturage extends Form{
     public AddCovoiturage(Form previous,boolean add,Covoiturage f) {
        setTitle("Add a new Labo");
        setLayout(BoxLayout.y());

        TextField adresse_departField = new TextField("", "adresse_depart");
        TextField arriveField = new TextField("", "arrive");
       // TextField date_departField = new TextField("", "date_depart");
        TextField heure_departField = new TextField("", "heure_depart");
        TextField nb_placeField = new TextField("", "nb_place");
        TextField prixField = new TextField("", "prix");
        TextField descriptionField = new TextField("", "description");
        TextField nom_conducteurField = new TextField("", "nom_conducteur");
  
          if (f!=null){
        
        adresse_departField.setText(f.getAdresse_depart());
        arriveField.setText(f.getArrive());
        //date_departField.setText(valueOf(f.getDate_depart()));
        heure_departField.setText(f.getHeure_depart());
        nb_placeField.setText(valueOf(f.getNb_place()));
        prixField.setText(valueOf(f.getPrix()));
        descriptionField.setText(f.getDescription());
        nom_conducteurField.setText(f.getNom_conducteur());
        }
      
       

        Button btnValider = new Button("Add Covoiturage");
       
       
        Button btnCapture = new Button("Add Image");
        btnValider.addActionListener((ActionListener) (ActionEvent evt) -> {
            if (adresse_departField.getText().isEmpty() || arriveField.getText().isEmpty() ||  heure_departField.getText().isEmpty()
                    || nb_placeField.getText().isEmpty() || prixField.getText().isEmpty() || descriptionField.getText().isEmpty() || nom_conducteurField.getText().isEmpty() ) {
                Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
            } else {
                try {
                    
                    
                    Covoiturage covs=new Covoiturage( adresse_departField.getText(),
                            arriveField.getText(),
                            heure_departField.getText(),
                            Integer.parseInt(nb_placeField.getText()),
                            Float.parseFloat(prixField.getText()),
                            descriptionField.getText(),
                            nom_conducteurField.getText());
                    
                            
                            
                    if ( add == true){
                    if (ServiceCovoiturage.getInstance().addCov(covs)) {
                        Dialog.show("Success", "Labo added successfully", new Command("OK"));
                          new ListCovoiturageForm(previous).show();
                    } else {
                        Dialog.show("ERROR", "Error to add analyse", new Command("OK"));
                    }
                    } 
                } catch (NumberFormatException e) {
                    Dialog.show("ERROR", "Please enter a valid integer value for the tel", new Command("OK"));
                }
            }
        });

        addAll(adresse_departField, arriveField, heure_departField, nb_placeField, prixField,descriptionField,nom_conducteurField, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        
    }
    
     
      

    
    
}
