package com.example.ste.canthotut.Login;

import android.app.Dialog;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ste.canthotut.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Singup extends AppCompatActivity {

    EditText editEmail ;
    EditText editPas ;
    Button buttonSignup ;

    final String FileName = "user.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_singup);

        editEmail = (EditText) findViewById(R.id.ed_emailsignup);
        editPas = (EditText) findViewById(R.id.ed_passignup);

        buttonSignup = (Button) findViewById(R.id.bt_signup) ;

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editEmail.getText().toString().isEmpty()){
                    Toast.makeText(Singup.this, "mail rỗng", Toast.LENGTH_SHORT).show();
                } else if (editPas.getText().toString().isEmpty()) {
                    Toast.makeText(Singup.this, "pass rỗng", Toast.LENGTH_SHORT).show();
                } else {
                    fileWrite(editEmail.getText().toString() ,editPas.getText().toString());
                }
                Log.i("logg","xong");
                Toast.makeText(getApplication(), "xong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    void fileWrite (String mail , String pass) {
        File file = new File(Environment.getExternalStorageDirectory().getPath()+"/CanThoTut/"+FileName) ;
        try {
            FileWriter fw  = new FileWriter(file) ;

            fw.write(mail);
            fw.write(pass);

            fw.flush();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
