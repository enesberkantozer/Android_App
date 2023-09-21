package com.enesberkantozer.photocollageapp;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hazir_sablon_1 extends AppCompatActivity {

    ImageView sablon1_1img;
    ImageView sablon1_2img;
    ImageView sablon1_3img;
    ImageView saveimagesablon1;
    OutputStream outputStreamsablon1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hazir_sablon1);

        sablon1_1img=findViewById(R.id.sablon2_1img);
        sablon1_2img=findViewById(R.id.sablon2_2img);
        sablon1_3img=findViewById(R.id.sablon1_3img);
        saveimagesablon1=findViewById(R.id.saveimagesablon1);
        Button btnsavesablon1=findViewById(R.id.btnsavesablon1);
        FrameLayout sablonframe1=findViewById(R.id.sablonframe2);
        btnsavesablon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap=Bitmap.createBitmap(sablonframe1.getWidth(),sablonframe1.getHeight(),Bitmap.Config.ARGB_8888);
                Canvas canvas= new Canvas(bitmap);
                sablonframe1.draw(canvas);
                saveimagesablon1.setImageBitmap(bitmap);

                BitmapDrawable drawable= (BitmapDrawable) saveimagesablon1.getDrawable();
                Bitmap bitmap1=drawable.getBitmap();

                File filepath= Environment.getExternalStorageDirectory();
                File dir= new File(filepath.getAbsolutePath()+"/Fotoğraf Kolaj/Hazır Şablonlar/");
                dir.mkdirs();
                Date date= new Date();
                DateFormat dateFormat=new SimpleDateFormat("yyyy_MM_dd_HH_mm_SS");
                String time= dateFormat.format(date);
                File file= new File(dir,time+".jpg");

                try {
                    outputStreamsablon1= new FileOutputStream(file);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                bitmap1.compress(Bitmap.CompressFormat.JPEG,100,outputStreamsablon1);
                Toast.makeText(hazir_sablon_1.this, "Başarıyla Kaydedildi", Toast.LENGTH_SHORT).show();

                try {
                    outputStreamsablon1.flush();
                }catch (IOException e){
                    e.printStackTrace();
                }
                try {
                    outputStreamsablon1.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        sablon1_1img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mGetContent.launch("image/*");
                return false;
            }
        });
        sablon1_2img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mGetContent2.launch("image/*");
                return false;
            }
        });
        sablon1_3img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mGetContent3.launch("image/*");
                return false;
            }
        });
    }
    ActivityResultLauncher<String> mGetContent =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    sablon1_1img.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent2 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    sablon1_2img.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent3 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    sablon1_3img.setImageURI(result);
                }
            });
}