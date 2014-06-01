package com.example.myapplication.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jeromeroy on 2014-05-30.
 */
public class EnregistrerActivty extends Activity {
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);

        String temp=null;


        try


        {


            File fichier = new File(getFilesDir(), "membres.txt");
            BufferedWriter buf=new BufferedWriter(new FileWriter(fichier));


            ArrayList<Membre> membres=getIntent().getParcelableArrayListExtra(MainActivity.CLE_LISTE_MEMEBRE);

            for(Parcelable p:membres)

            {
              buf.write();
                   Membre membre = (Membre) p;
                   buf.write(membre.getNom()+";");
                buf.write(membre.getNom()+";");



                   Toast.makeText(getApplicationContext(), membre.getNom(), Toast.LENGTH_LONG).show();
               }
            }

            buf.close();

        }

        catch (IOException iox)
        {
            Log.v("probleme", "ssasa");
            iox.printStackTrace();

        }



    }
}
