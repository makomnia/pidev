/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundBorder;
import java.util.ArrayList;
import tn.esprit.myapp.entities.Covoiturage;
import tn.esprit.myapp.entities.Participation;
import tn.esprit.myapp.services.ServiceCovoiturage;
import tn.esprit.myapp.services.ServiceParticipant;

/**
 *
 * @author ihebl
 */
public class ListParticipantForm extends Form{
     public ListParticipantForm(Form previous) {
        setTitle("List Participant");

        Container participantContainer = new Container();

        ArrayList<Participation> partis = ServiceParticipant.getInstance().getAllParts();

         getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ADD, e -> {
                new AddParticipant(this,true,new Participation()).show();
            
        });
           getToolbar().addMaterialCommandToSideMenu("Participation List ", FontImage.MATERIAL_BOOK, e -> 
                new ListParticipantForm(this).show()
        );
              getToolbar().addMaterialCommandToSideMenu("Home ", FontImage.MATERIAL_HOME, e -> 
                new HomeForm().show()
        );
        
        
        for (Participation s : partis) {
         participantContainer.add(this.addReservationsHolders(s,previous));
        }
                
        this.addAll(participantContainer);

        getToolbar().addCommandToLeftBar("Back", null, ev -> previous.showBack());
    }

  

   private Container addReservationsHolders(Participation r, Form previous) {
    Container holderContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
    Container detailsContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    Container buttonContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));

    SpanLabel spNom = new SpanLabel("nom_participant:");
    Label lbNom_participant = new Label(r.getNom_participant());
    lbNom_participant.getAllStyles().setFgColor(0x333333);
    SpanLabel spMail = new SpanLabel("mail:");
    Label lbMail = new Label(r.getMail());
    lbMail.getAllStyles().setFgColor(0x333333);

    Button btDelete = new Button("Supprimer");
    btDelete.getAllStyles().setBorder(
            RoundBorder.create().
                    rectangle(true).
                    color(0xFF0000).
                    strokeColor(0).
                    strokeOpacity(120).
                    stroke(new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1)));
    btDelete.getAllStyles().setFgColor(0xffffff);
    btDelete.getAllStyles().setBgTransparency(255);
    btDelete.getAllStyles().setBgColor(0x007AFF);

    buttonContainer.addAll(btDelete);
    detailsContainer.addAll(spNom, lbNom_participant, spMail, lbMail, buttonContainer);
    holderContainer.addAll(detailsContainer);

    // CSS styling
    spNom.getAllStyles().setFgColor(0x999999);
    spMail.getAllStyles().setFgColor(0x999999);
    buttonContainer.getAllStyles().setMargin(0, 0, 0, 16);
    detailsContainer.getAllStyles().setPadding(0, 0, 0, 16);

    // Attach an action listener to the delete button to show a confirmation dialog and delete the participation
    btDelete.addActionListener(e -> {
        if (Dialog.show("Confirmation", "Are you sure you want to delete this participation?", "Yes", "No")) {
            boolean success = ServiceParticipant.getInstance().deleteParticipation(r.getId());
            if (success) {
                Dialog.show("Success", "Participation deleted successfully", "OK", null);
                new ListParticipantForm(previous).showBack();
            } else {
                Dialog.show("Error", "Failed to delete the participation", "OK", null);
            }
        }
    });

    return holderContainer;
}



}

    