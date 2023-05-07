/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import static java.lang.String.valueOf;
import tn.esprit.myapp.entities.Covoiturage;
import tn.esprit.myapp.entities.Participation;
import tn.esprit.myapp.services.ServiceCovoiturage;
import tn.esprit.myapp.services.ServiceParticipant;

/**
 *
 * @author ihebl
 */
public class AddParticipant extends Form{
     public AddParticipant(Form previous,boolean add,Participation f) {
        setTitle("Add a new Participation");
        setLayout(BoxLayout.y());

        TextField nom_participanttField = new TextField("", "nom_participant");
        TextField mailField = new TextField("", "mail");
   
          if (f!=null){
        
        nom_participanttField.setText(f.getNom_participant());
        mailField.setText(f.getMail());
       
        }
      
        Button btnValider = new Button("Add Participant");
       
        btnValider.addActionListener((ActionListener) (ActionEvent evt) -> {
            if (nom_participanttField.getText().isEmpty() || mailField.getText().isEmpty()   ) {
                Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
            } else {
                try {
                   
                            
                            
                    if ( add == true){
                    if (ServiceParticipant.getInstance().addPart(nom_participanttField.getText(),mailField.getText())) {
                        Dialog.show("Success", "Participant added successfully", new Command("OK"));
                          new ListParticipantForm(previous).show();
                    } else {
                        Dialog.show("ERROR", "Error to add ", new Command("OK"));
                    }
                    } 
                } catch (NumberFormatException e) {
                    Dialog.show("ERROR", "Please enter a valid integer value ", new Command("OK"));
                }
            }
        });

        addAll(nom_participanttField, mailField, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        
    }
    
    
}
