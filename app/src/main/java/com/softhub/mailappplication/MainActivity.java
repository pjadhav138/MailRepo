package com.softhub.mailappplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText1= findViewById(R.id.test1);
        EditText editText2= findViewById(R.id.test2);
        EditText editText3= findViewById(R.id.text3);
        EditText editText4 = findViewById(R.id.text4);
        EditText editText5 = findViewById(R.id.test5);
        TextView textView = findViewById(R.id.mail);
        SharedPreferences SharedPreferences = getSharedPreferences("MYAPP", MODE_PRIVATE);
        editor = SharedPreferences.edit();
        CheckBox checkBox =findViewById(R.id.radiobutton);
        Button button = findViewById(R.id.button);

        button.setText("NEXT");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();

                if (Pattern.matches("[a-zA-Z]{2,20}",name)){
                  editor.putString("name",name);
                  editor.commit();
                }
                else {
                    Toast.makeText(MainActivity.this, "Enter the valid name", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.e("Mail",name);


                String Lastname = editText2.getText().toString();
                if (Pattern.matches("[a-zA-Z]{2,20}",Lastname)){
                    editor.putString("lastname",Lastname);
                    editor.commit();
                }
                else {
                    Toast.makeText(MainActivity.this, "Enter the valid lastname", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.e("Mail",Lastname);


                String Username = editText3.getText().toString();
                String text = textView.getText().toString();

                if (Pattern.matches("[a-zA-Z0-9]{2,20}",Username)){
                    editor.putString("username",Username + text);
                    editor.commit();
                }
                else {
                    Toast.makeText(MainActivity.this, "Enter the valid username", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.e("Mail",Username);

                String Password = editText4.getText().toString();
                if (Pattern.matches("[[a-z]?[A-Z]?[0-9]?[@#!$%&*]?]{8,16}",Password)){
                    editor.putString("password",Password);
                    editor.commit();
                }
                else {
                    Toast.makeText(MainActivity.this, "Enter the valid password", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.e("Mail",Password);


                String confirm = editText5.getText().toString();
                Boolean boo = Password.equals(confirm);
                if(boo == true){
                    editor.putString("confirm",confirm);
                    editor.commit();
                }
                else{
                    Toast.makeText(MainActivity.this, "Enter the correct password", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.e("Mail",confirm);
                Intent intent = new Intent(MainActivity.this,Mail_profile.class);
                startActivity(intent);


            }

        });
        checkBox.setText("confirm Password");
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String confirmpassword = checkBox.getText().toString();
                if(isChecked){
                    Log.e("TAG", "onCheckedChanged: "+editText4.getInputType() );
                    Log.e("TAG","onCheckedChanged:"+editText5.getInputType());
                    editText5.setInputType(InputType.TYPE_CLASS_TEXT);
                    editText4.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                else{
                    Log.e("TAG", "onCheckedChanged: "+editText4.getInputType() );
                    editText4.setInputType(129);
                    Log.e("TAG","onCheckedChanged:" +editText5.getInputType());
                    editText5.setInputType(129);

                    Toast.makeText(MainActivity.this, "Select checkbox", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }
}