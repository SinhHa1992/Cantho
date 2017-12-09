package com.example.ste.canthotut.Login;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ste.canthotut.R;

public class dialog_singup extends AppCompatActivity {

    EditText editEmail ;
    EditText editPas ;
    Button buttonSignup ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_singup);

        editEmail = (EditText) findViewById(R.id.ed_email);
        editPas = (EditText) findViewById(R.id.ed_passignup);

        buttonSignup = (Button) findViewById(R.id.bt_signup) ;

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editEmail.getText().toString().isEmpty()){
                    Toast.makeText(dialog_singup.this, "mail rỗng", Toast.LENGTH_SHORT).show();
                } else {
                    
                }
            }
        });
    }
}
