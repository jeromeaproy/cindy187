package com.example.myapplication.app;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import  android.app.ActionBar.TabListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import android.util.Log;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements ActionBar.TabListener{
private ArrayList<Membre> listeMembre=new ArrayList<Membre>();

    public static final String  CLE_LISTE_MEMEBRE="com.example.myapplication.app.listeMembre";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActionBar actionBar=getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

       // Drawable ajouter=(Drawable)findViewById(R.drawable.egg);

        // actionBar.addTab(actionBar.newTab().setText("Ajouter Membres").setTabListener(this));

        actionBar.addTab(actionBar.newTab().setIcon((R.drawable.egg)).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Enregistrer").setTabListener(this));

        actionBar.addTab(actionBar.newTab().setText("Lister").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Rechercher").setTabListener(this));


        actionBar.addTab(actionBar.newTab().setText("Lister par sexe").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Lister par sexe féminin et leur fonction").setTabListener(this));

        Spinner spinner=(Spinner)findViewById(R.id.spnFonction);
        String[] fonctions=new String[]{"Enseignant","Etudiant","Ingénieur","Retraité","Autre"};
ArrayAdapter<String> adapteurSpinner=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,fonctions);
        adapteurSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapteurSpinner);

        Button envoyer=(Button)findViewById(R.id.envoyer);
        envoyer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
              ajouterMembre();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {


            int position=tab.getPosition();


            switch(position){
                case 0:
                    break;

                case 1:
                    Intent intent=new Intent(getApplicationContext(),com.example.myapplication.app.EnregistrerActivty.class);
                    intent.putExtra(CLE_LISTE_MEMEBRE,listeMembre);
                    startActivity(intent);
                    break;

                case 2:

                    break;

                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;

                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;





            }


    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    public void ajouterMembre()
    {
        Membre membre=new Membre();
        EditText etNom=(EditText)findViewById(R.id.tvNom);
        String nom=etNom.getText().toString();
        membre.setNom(nom);

        EditText etPrenom=(EditText)findViewById(R.id.tvPrenom);
        String prenom=etPrenom.getText().toString();
        membre.setPrenom(prenom);



        RadioGroup rgSexe=(RadioGroup)findViewById(R.id.rgSexe);
        int idSexe=rgSexe.getCheckedRadioButtonId();
        RadioButton rbSexe=(RadioButton)findViewById(idSexe);
        membre.setSexe(rbSexe.getText().toString());
        Spinner spinner=(Spinner)findViewById(R.id.spnFonction);
       String fonction= String.valueOf(spinner.getSelectedItem());
     membre.setFonction(fonction);
        EditText etCommentaire=(EditText)findViewById(R.id.etCommentaire);
        String commentaire=etCommentaire.getText().toString();
        membre.setCommentaire(commentaire);
        listeMembre.add(membre);
    }
}
