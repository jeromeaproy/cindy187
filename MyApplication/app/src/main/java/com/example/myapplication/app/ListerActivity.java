package com.example.myapplication.app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ListerActivity extends Activity {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_lister);
Button button=(Button)findViewById(R.id.btnRevenir);
   button.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           startActivity(new Intent(ListerActivity.this,MainActivity.class));
       }
   });

        TextView tv = (TextView) findViewById(R.id.tvListeMembres);
        listerMembre(tv);


    }


    public void listerMembre(TextView tv)

    {String temp=null;
        StringBuffer sb=new StringBuffer();
        try

        {
            InputStream is = openFileInput("membres.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader buf=new BufferedReader(isr);
            while ((temp=buf.readLine())!=null)
            {
                sb.append(temp);

            }
            tv.setText(sb);
        } catch (Throwable throwable)

        {
            Log.i("ListerActivité", throwable.getMessage());
        }
// Intent intent=new Intent(getApplicationContext(),com.example.myapplication.app.EnregistrerActivty.class);
        // intent.putExtra(CLE_LISTE_MEMEBRE,listeMembre);
        // startActivity(intent);
    }
}