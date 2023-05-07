/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import java.util.ArrayList;
import tn.esprit.myapp.entities.Covoiturage;
import tn.esprit.myapp.services.ServiceCovoiturage;

/**
 *
 * @author ihebl
 */
public class ListCovoiturageForm extends Form {
     public ListCovoiturageForm(Form previous) {
        setTitle("List Covoiturage");

        Container covoiturageContainer = new Container();

        ArrayList<Covoiturage> covoits = ServiceCovoiturage.getInstance().getAllCovoits();

         getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ADD, e -> {
                new AddCovoiturage(this,true,new Covoiturage()).show();
            
        });
           getToolbar().addMaterialCommandToSideMenu("Covoiturage List ", FontImage.MATERIAL_BOOK, e -> 
                new ListCovoiturageForm(this).show()
        );
              getToolbar().addMaterialCommandToSideMenu("Home ", FontImage.MATERIAL_HOME, e -> 
                new HomeForm().show()
        );
        
        
        for (Covoiturage s : covoits) {
         covoiturageContainer.add(this.addReservationsHolders(s,previous));
        }
                
        this.addAll(covoiturageContainer);

        getToolbar().addCommandToLeftBar("Back", null, ev -> previous.showBack());
    }

  

    private Container addReservationsHolders(Covoiturage r, Form previous) {
Container holderContainer = new Container(BoxLayout.x());
Container detailsContainer = new Container(BoxLayout.y());
Container buttonContainer = new Container(BoxLayout.x());
  
 
   SpanLabel spAdresseDepart = new SpanLabel("Adresse de départ:");
Label lbAdresseDepart = new Label(r.getAdresse_depart());
SpanLabel spArrive = new SpanLabel("Arrivée:");
Label lbArrive = new Label(r.getArrive());
SpanLabel spDateDepart = new SpanLabel("Date de départ:");
Label lbDateDepart = new Label(String.valueOf(r.getDate_depart()));
SpanLabel spHeureDepart = new SpanLabel("Heure de départ:");
Label lbHeureDepart = new Label(String.valueOf(r.getHeure_depart()));
SpanLabel spNbPlace = new SpanLabel("Nombre de places:");
Label lbNbPlace = new Label(String.valueOf(r.getNb_place()));
SpanLabel spPrix = new SpanLabel("Prix:");
Label lbPrix = new Label(String.valueOf(r.getPrix()));
SpanLabel spDescription = new SpanLabel("Description:");
Label lbDescription = new Label(String.valueOf(r.getDescription()));
SpanLabel spNomConducteur = new SpanLabel("Nom du conducteur:");
Label lbNomConducteur = new Label(String.valueOf(r.getNom_conducteur()));

 


Button btDelete = new Button("Supprimer");
btDelete.getAllStyles().setBorder(RoundBorder.create().
    rectangle(true).
    color(0xFF0000).
    strokeColor(0).
    strokeOpacity(120).
    stroke(new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1)));
btDelete.getAllStyles().setFgColor(0xffffff);

buttonContainer.addAll(btDelete);
detailsContainer.addAll(spAdresseDepart, lbAdresseDepart, spArrive, lbArrive, spDateDepart, lbDateDepart, spHeureDepart, lbHeureDepart, spNbPlace, lbNbPlace, spPrix, lbPrix, spDescription, lbDescription, spNomConducteur, lbNomConducteur, buttonContainer);
holderContainer.addAll(detailsContainer);

// Attach an action listener to the delete button to show a confirmation dialog and delete the covoiturage
btDelete.addActionListener(e -> {
    if (Dialog.show("Confirmation", "Êtes-vous sûr(e) de vouloir supprimer ce covoiturage ?", "Oui", "Non")) {
        boolean success = ServiceCovoiturage.getInstance().deleteCovoituarge(r.getId());
        if (success) {
            Dialog.show("Succès", "Le covoiturage a été supprimé avec succès", "OK", null);
            new ListCovoiturageForm(previous).showBack();
        } else {
            Dialog.show("Erreur", "Impossible de supprimer le covoiturage", "OK", null);
        }
    }
});

// Apply CSS styling







     return holderContainer;
}
    
}
