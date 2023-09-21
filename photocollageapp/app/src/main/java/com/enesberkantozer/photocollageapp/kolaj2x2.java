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

public class kolaj2x2 extends AppCompatActivity {

    ImageView img1_4;
    ImageView img2_4;
    ImageView img3_4;
    ImageView img4_4;
    ImageView imgback4;
    ImageView saveImage4;

    OutputStream outputStream4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolaj2x2);

        img1_4 = findViewById(R.id.img1_4);
        img2_4=findViewById(R.id.img2_4);
        img3_4=findViewById(R.id.img3_4);
        img4_4=findViewById(R.id.img4_4);
        imgback4=findViewById(R.id.imgback4);
        saveImage4=findViewById(R.id.saveimg4);
        Button btnarkaplan2x2= findViewById(R.id.btnarkaplan2x2);
        Button btnsave4= findViewById(R.id.btnsave4);
        FrameLayout frameLayout2x2= findViewById(R.id.frameLayout2x2);

        btnsave4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap=Bitmap.createBitmap(frameLayout2x2.getWidth(),frameLayout2x2.getHeight(),Bitmap.Config.ARGB_8888);
                Canvas canvas= new Canvas(bitmap);
                frameLayout2x2.draw(canvas);
                saveImage4.setImageBitmap(bitmap);

                BitmapDrawable drawable= (BitmapDrawable) saveImage4.getDrawable();
                Bitmap bitmap1=drawable.getBitmap();

                File filepath= Environment.getExternalStorageDirectory();
                File dir= new File(filepath.getAbsolutePath()+"/Fotoğraf Kolaj/2x2 Kolajlar/");
                dir.mkdirs();
                Date date= new Date();
                DateFormat dateFormat=new SimpleDateFormat("yyyy_MM_dd_HH_mm_SS");
                String time= dateFormat.format(date);
                File file= new File(dir,time+".jpg");

                try {
                    outputStream4= new FileOutputStream(file);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                bitmap1.compress(Bitmap.CompressFormat.JPEG,100,outputStream4);
                Toast.makeText(kolaj2x2.this, "Başarıyla Kaydedildi", Toast.LENGTH_SHORT).show();

                try {
                    outputStream4.flush();
                }catch (IOException e){
                    e.printStackTrace();
                }
                try {
                    outputStream4.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });


        img1_4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent.launch("image/*");
                return false;
            }
        });
        img2_4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent2.launch("image/*");
                return false;
            }
        });
        img3_4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent3.launch("image/*");
                return false;
            }
        });
        img4_4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent4.launch("image/*");
                return false;
            }
        });
        btnarkaplan2x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent5.launch("image/*");
            }
        });
    }
    ActivityResultLauncher<String> mGetContent =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img1_4.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent2 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img2_4.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent3 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img3_4.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent4 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img4_4.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent5 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    imgback4.setImageURI(result);
                }
            });
}