/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.myapp.gui;

import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author ihebl
 */
public class HomeForm extends Form{
     public HomeForm() {
        
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnListAnalyse = new Button("List Covoiturage");
       
      
        Button btnListLabo = new Button("List Participation");
        
        btnListAnalyse.addActionListener(e-> new ListCovoiturageForm(this).show());
        btnListLabo.addActionListener(e-> new ListParticipantForm(this).show());
        addAll(btnListAnalyse,btnListLabo);
        
        
    }}
    

