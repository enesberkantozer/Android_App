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

public class kolaj3x2 extends AppCompatActivity {

    ImageView img1_6;
    ImageView img2_6;
    ImageView img3_6;
    ImageView img4_6;
    ImageView img5_6;
    ImageView img6_6;
    ImageView imgback6;
    ImageView saveImage6;

    OutputStream outputStream6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolaj3x2);

        img1_6=findViewById(R.id.img1_6);
        img2_6=findViewById(R.id.img2_6);
        img3_6=findViewById(R.id.img3_6);
        img4_6=findViewById(R.id.img4_6);
        img5_6=findViewById(R.id.img5_6);
        img6_6=findViewById(R.id.img6_6);
        imgback6=findViewById(R.id.imgback6);
        saveImage6=findViewById(R.id.saveimg6);
        Button btnarkaplan2x3=findViewById(R.id.btnarkaplan2x3);
        Button savebtn6=findViewById(R.id.btnsave6);
        FrameLayout frameLayout2x3=findViewById(R.id.frameLayout2x3);

        savebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap=Bitmap.createBitmap(frameLayout2x3.getWidth(),frameLayout2x3.getHeight(),Bitmap.Config.ARGB_8888);
                Canvas canvas= new Canvas(bitmap);
                frameLayout2x3.draw(canvas);
                saveImage6.setImageBitmap(bitmap);

                BitmapDrawable drawable= (BitmapDrawable) saveImage6.getDrawable();
                Bitmap bitmap1=drawable.getBitmap();

                File filepath= Environment.getExternalStorageDirectory();
                File dir= new File(filepath.getAbsolutePath()+"/Fotoğraf Kolaj/3x2 Kolajlar/");
                dir.mkdirs();
                Date date= new Date();
                DateFormat dateFormat=new SimpleDateFormat("yyyy_MM_dd_HH_mm_SS");
                String time= dateFormat.format(date);
                File file= new File(dir,time+".jpg");

                try {
                    outputStream6= new FileOutputStream(file);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                bitmap1.compress(Bitmap.CompressFormat.JPEG,100,outputStream6);
                Toast.makeText(kolaj3x2.this, "Başarıyla Kaydedildi", Toast.LENGTH_SHORT).show();

                try {
                    outputStream6.flush();
                }catch (IOException e){
                    e.printStackTrace();
                }
                try {
                    outputStream6.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        img1_6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent.launch("image/*");
                return false;
            }
        });
        img2_6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent2.launch("image/*");
                return false;
            }
        });
        img3_6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent3.launch("image/*");
                return false;
            }
        });
        img4_6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent4.launch("image/*");
                return false;
            }
        });
        img5_6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent5.launch("image/*");
                return false;
            }
        });
        img6_6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent6.launch("image/*");
                return false;
            }
        });
        btnarkaplan2x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent7.launch("image/*");
            }
        });
    }
    ActivityResultLauncher<String> mGetContent =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img1_6.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent2 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img2_6.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent3 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img3_6.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent4 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img4_6.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent5 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img5_6.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent6 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img6_6.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent7 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    imgback6.setImageURI(result);
                }
            });
}