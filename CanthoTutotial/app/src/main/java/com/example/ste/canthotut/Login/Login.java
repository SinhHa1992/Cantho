package com.example.ste.canthotut.Login;

import android.app.Dialog;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ste.canthotut.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class Login extends AppCompatActivity {

    Dialog dialog ;
    EditText idUser;
    EditText pasUser ;

    final String FileName = "USER.txt";

    TextView create ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idUser =(EditText) findViewById(R.id.ed_id);
        pasUser = (EditText) findViewById(R.id.ed_pass);

        final Button loginButon = (Button) findViewById(R.id.bt_login);
        loginButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        create = (TextView) findViewById( R.id.tv_signup) ;
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(Login.this);
                dialog.setContentView(R.layout.activity_dialog_singup);
                dialog.setTitle("Đăng Kí");
                dialog.show();
            }
        });


    }
}
