package com.softhub.mailappplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Mail_profile extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView name, last, username, password, confirm_password, show_password, next;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_profile);
        image = findViewById(R.id.image);
        TextView profile = findViewById(R.id.profile);
        ImageView edit_image = findViewById(R.id.edit_profile);

        edit_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(Mail_profile.this);
                dialog.setContentView(R.layout.popup);
                ImageView camera = dialog.findViewById(R.id.camera);
                ImageView gallery = dialog.findViewById(R.id.gallery);

                camera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        startActivityForResult(intent, 100);
                        Toast.makeText(Mail_profile.this, "open camera", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                gallery.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(intent, 101);
                        Toast.makeText(Mail_profile.this, "open gallary", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }


                });

                dialog.show();
            }
        });


        name = findViewById(R.id.text1);
        last = findViewById(R.id.text2);
        username = findViewById(R.id.text3);
        sharedPreferences = getSharedPreferences("MYAPP", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        name.setText(sharedPreferences.getString("name", null));
        last.setText(sharedPreferences.getString("lastname", null));
        username.setText(sharedPreferences.getString("username", null));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 100:
                    Log.e("TAG", "onActivityResult: " + data.getExtras().get("data"));
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    image.setImageBitmap(bitmap);
                    break;
                case 101:
                    Log.e("TAG", "onActivityResult: " + data.getData());
                    image.setImageURI(data.getData());
                    break;
            }
        } else {
            Toast.makeText(this, "Error setting image.", Toast.LENGTH_SHORT).show();
        }
    }
}