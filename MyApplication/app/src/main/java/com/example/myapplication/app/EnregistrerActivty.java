package com.example.myapplication.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Created by jeromeroy on 2014-05-30.
 */
public class EnregistrerActivty extends Activity {
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
setContentView(R.layout.activity_enregistrer);

        Button bouton=(Button)findViewById(R.id.btnRevenir);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EnregistrerActivty.this,MainActivity.class);
            }
        });
        String temp=null;


        try


        {


         //   File fichier = new File(getFilesDir(), "membres.txt");
           // BufferedWriter buf=new BufferedWriter(new FileWriter(fichier));




OutputStreamWriter out=new OutputStreamWriter(openFileOutput("membres.tx",0));


            ArrayList<Membre> membres=getIntent().getParcelableArrayListExtra(MainActivity.CLE_LISTE_MEMEBRE);

            for(Parcelable p:membres)

            {

                   Membre membre = (Membre) p;
                   out.write(membre.getNom() + ";");
                out.write(membre.getPrenom() + ";");
                out.write(membre.getSexe());

                out.write(membre.getFonction());
                out.write(membre.getCommentaire());



                   Toast.makeText(getApplicationContext(), membre.getNom(), Toast.LENGTH_LONG).show();
               }


            out.close();

        }
catch(FileNotFoundException fexc)

    {
        Log.v("probeme","Fichier introuvable");

    }
        catch (IOException iox)
        {
            Log.v("probleme", "ssasa");
            iox.printStackTrace();

        }



    }
}
