package com.enesberkantozer.photocollageapp;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class hazir_sablon_2 extends AppCompatActivity {

    ImageView sablon2_1img;
    ImageView sablon2_2img;
    ImageView saveimagesablon2;

    OutputStream outputStreamsablon2;

    static Boolean tıklandımı=false;
    static Boolean tıklandımı2=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hazir_sablon2);

        sablon2_1img=findViewById(R.id.sablon2_1img);
        sablon2_2img=findViewById(R.id.sablon2_2img);
        saveimagesablon2=findViewById(R.id.saveimagesablon2);

        EditText editTextsablon2=findViewById(R.id.editTextsablon2);
        EditText editTextDateSablon2=findViewById(R.id.editTextDatesablon2);
        TextView sablon2toptext=findViewById(R.id.sablon2toptext);
        TextView sablon2bottomtext=findViewById(R.id.sablon2bottomtext);
        Button sablon2addbtn=findViewById(R.id.sablon2addbtn);
        Button btnsavesablon2=findViewById(R.id.btnsavesablon2);
        FrameLayout sablonframe2=findViewById(R.id.sablonframe2);

        Calendar calendarsablon2= Calendar.getInstance();
        DatePickerDialog.OnDateSetListener datesablon2= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                calendarsablon2.set(calendarsablon2.YEAR, year);
                calendarsablon2.set(calendarsablon2.MONTH,month);
                calendarsablon2.set(calendarsablon2.DAY_OF_MONTH, dayOfMonth);

                SimpleDateFormat simpleDateFormatsablon2= new SimpleDateFormat("dd.MM.yyyy");
                editTextDateSablon2.setText(simpleDateFormatsablon2.format(calendarsablon2.getTime()));
            }
        };
        editTextDateSablon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(hazir_sablon_2.this,datesablon2,calendarsablon2.get(Calendar.YEAR),
                        calendarsablon2.get(Calendar.MONTH),calendarsablon2.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        editTextsablon2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (tıklandımı==false){
                    editTextsablon2.setText("");
                    tıklandımı=true;
                }
                return false;
            }
        });

        sablon2addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sablon2toptext.setText(editTextsablon2.getText().toString());
                sablon2bottomtext.setText(editTextDateSablon2.getText().toString());
                tıklandımı2=true;
            }
        });

        btnsavesablon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tıklandımı2==false){
                    sablon2toptext.setText("");
                    sablon2bottomtext.setText("");
                }
                Bitmap bitmap=Bitmap.createBitmap(sablonframe2.getWidth(),sablonframe2.getHeight(),Bitmap.Config.ARGB_8888);
                Canvas canvas= new Canvas(bitmap);
                sablonframe2.draw(canvas);
                saveimagesablon2.setImageBitmap(bitmap);

                BitmapDrawable drawable= (BitmapDrawable) saveimagesablon2.getDrawable();
                Bitmap bitmap1=drawable.getBitmap();

                File filepath= Environment.getExternalStorageDirectory();
                File dir= new File(filepath.getAbsolutePath()+"/Fotoğraf Kolaj/Hazır Şablonlar/");
                dir.mkdirs();
                Date date= new Date();
                DateFormat dateFormat=new SimpleDateFormat("yyyy_MM_dd_HH_mm_SS");
                String time= dateFormat.format(date);
                File file= new File(dir,time+".jpg");

                try {
                    outputStreamsablon2= new FileOutputStream(file);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                bitmap1.compress(Bitmap.CompressFormat.JPEG,100,outputStreamsablon2);
                Toast.makeText(hazir_sablon_2.this, "Başarıyla Kaydedildi", Toast.LENGTH_SHORT).show();

                try {
                    outputStreamsablon2.flush();
                }catch (IOException e){
                    e.printStackTrace();
                }
                try {
                    outputStreamsablon2.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        sablon2_1img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mGetContent.launch("image/*");
                return false;
            }
        });
        sablon2_2img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mGetContent2.launch("image/*");
                return false;
            }
        });
    }
    ActivityResultLauncher<String> mGetContent =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    sablon2_1img.setImageURI(result);
                }
            });
    ActivityResultLauncher<String> mGetContent2 =registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    sablon2_2img.setImageURI(result);
                }
            });
}