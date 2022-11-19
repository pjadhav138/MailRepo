package com.softhub.mailappplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cross_check extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView name , password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_check);
        EditText editText = findViewById(R.id.user1);
        TextView textView = findViewById(R.id.mail);
        EditText editText1 = findViewById(R.id.password1);
        Button login = findViewById(R.id.Login);

        sharedPreferences = getSharedPreferences("MYAPP",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        login.setText("Login");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String inputemail = editText.getText().toString()+textView.getText().toString();
               String inputpassword = editText1.getText().toString();

               if (!inputemail.equals(sharedPreferences.getString("username",""))){
                   Toast.makeText(Cross_check.this, "Wrong Email", Toast.LENGTH_SHORT).show();
                   return;
               }
               if (!inputpassword.equals(sharedPreferences.getString("password",""))){
                   Toast.makeText(Cross_check.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                   return;
               }
               Intent intent = new Intent(Cross_check.this,Instagram_application.class);
               startActivity(intent);

            }
        });


    }

}