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

public class kolaj3x3 extends AppCompatActivity {

    ImageView img1_9;
    ImageView img2_9;
    ImageView img3_9;
    ImageView img4_9;
    ImageView img5_9;
    ImageView img6_9;
    ImageView img7_9;
    ImageView img8_9;
    ImageView img9_9;
    ImageView imgback9;
    ImageView saveImage9;

    OutputStream outputStream9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolaj3x3);

        img1_9=findViewById(R.id.img1_9);
        img2_9=findViewById(R.id.img2_9);
        img3_9=findViewById(R.id.img3_9);
        img4_9=findViewById(R.id.img4_9);
        img5_9=findViewById(R.id.img5_9);
        img6_9=findViewById(R.id.img6_9);
        img7_9=findViewById(R.id.img7_9);
        img8_9=findViewById(R.id.img8_9);
        img9_9=findViewById(R.id.img9_9);
        imgback9=findViewById(R.id.imgback9);
        saveImage9=findViewById(R.id.saveimg9);
        Button btnarkaplan3x3=findViewById(R.id.btnarkaplan3x3);
        Button savebtn9=findViewById(R.id.btnsave9);
        FrameLayout frameLayout3x3=findViewById(R.id.frameLayout3x3);

        savebtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap=Bitmap.createBitmap(frameLayout3x3.getWidth(),frameLayout3x3.getHeight(),Bitmap.Config.ARGB_8888);
                Canvas canvas= new Canvas(bitmap);
                frameLayout3x3.draw(canvas);
                saveImage9.setImageBitmap(bitmap);

                BitmapDrawable drawable= (BitmapDrawable) saveImage9.getDrawable();
                Bitmap bitmap1=drawable.getBitmap();

                File filepath= Environment.getExternalStorageDirectory();
                File dir= new File(filepath.getAbsolutePath()+"/Fotoğraf Kolaj/3x3 Kolajlar/");
                dir.mkdirs();
                Date date= new Date();
                DateFormat dateFormat=new SimpleDateFormat("yyyy_MM_dd_HH_mm_SS");
                String time= dateFormat.format(date);
                File file= new File(dir,time+".jpg");

                try {
                    outputStream9= new FileOutputStream(file);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                bitmap1.compress(Bitmap.CompressFormat.JPEG,100,outputStream9);
                Toast.makeText(kolaj3x3.this, "Başarıyla Kaydedildi", Toast.LENGTH_SHORT).show();

                try {
                    outputStream9.flush();
                }catch (IOException e){
                    e.printStackTrace();
                }
                try {
                    outputStream9.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        img1_9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent.launch("image/*");
                return false;
            }
        });
        img2_9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent2.launch("image/*");
                return false;
            }
        });
        img3_9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent3.launch("image/*");
                return false;
            }
        });
        img4_9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent4.launch("image/*");
                return false;
            }
        });
        img5_9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent5.launch("image/*");
                return false;
            }
        });
        img6_9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent6.launch("image/*");
                return false;
            }
        });
        img7_9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent7.launch("image/*");
                return false;
            }
        });
        img8_9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent8.launch("image/*");
                return false;
            }
        });
        img9_9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mGetContent9.launch("image/*");
                return false;
            }
        });
        btnarkaplan3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent10.launch("image/*");
            }
        });

    }
    ActivityResultLauncher<String> mGetContent =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img1_9.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent2 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img2_9.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent3 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img3_9.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent4 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img4_9.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent5 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img5_9.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent6 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img6_9.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent7 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img7_9.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent8 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img8_9.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent9 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    img9_9.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent10 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    imgback9.setImageURI(result);
                }
            });
}