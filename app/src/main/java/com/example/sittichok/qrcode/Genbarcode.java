package com.example.sittichok.qrcode;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Random;

public class Genbarcode extends AppCompatActivity {
    EditText text;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genbarcode);

        text = (EditText) findViewById(R.id.editText);

        image = (ImageView) findViewById(R.id.imageView);

    }

        public void onClick(View v) {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            try {
                // สุ่มตัวเลข แล้วเอาค่า Barcode ไปกำหนดค่า ให้กับ Qrcode
                Random random = new Random();
                int random_int = random.nextInt((384000000 - 125000000) + 1) + 125000000;
                String Barcode = Integer.toString(random_int);

                BitMatrix bitMatrix = multiFormatWriter.encode(Barcode, BarcodeFormat.QR_CODE,1000,300);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                image.setImageBitmap(bitmap);
            } catch (WriterException e) {
                e.printStackTrace();
            }

        }

}
