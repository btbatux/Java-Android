package com.yeniders.firstapplicationtest;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_fiyat, edt_kdv;
    Button btn_hesapla;
    //Context context = this;
    //Context context = this;
    //Context context = this;
    //Context context = this;
    //Context context = this;
    //Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_fiyat = findViewById(R.id.edt_fiyat);
        edt_kdv = findViewById(R.id.edt_kdv);
        btn_hesapla = findViewById(R.id.btn_hesapla);

        btn_hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double fiyat = Double.valueOf(edt_fiyat.getText().toString());
                double kdv = Double.valueOf(edt_kdv.getText().toString());

                double toplam_fiyat = (fiyat * kdv) +fiyat;


                Dialog dialog = new Dialog(MainActivity.this);

                dialog.setContentView(R.layout.custom_dialog);

                ImageView carpi = dialog.findViewById(R.id.carpi);
                TextView aciklama = dialog.findViewById(R.id.aciklama);
                Button tamam = dialog.findViewById(R.id.tamam);


                aciklama.setText("Girilen Fiyat: " + fiyat + "\n" + "KDV Oranı: " + kdv + "\n" + "Toplam Fiyat: " + toplam_fiyat);

                carpi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                tamam.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Hesaplandı", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }
}