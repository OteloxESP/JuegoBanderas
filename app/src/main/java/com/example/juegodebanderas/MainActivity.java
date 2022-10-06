package com.example.juegodebanderas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int [] banderas = new int[]{R.drawable.es,
            R.drawable.ca,
            R.drawable.cn,
            R.drawable.us,
            R.drawable.mx,
            R.drawable.ru};

    String [] nomBanderas = new String[]{"España",
            "Canada",
            "China",
            "EstadosUnidos",
            "Mexico",
            "Rusia"};

    String banderaElegida;
    int puntuacion = 0;
    TextView texto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generacionBanderas();

    }
    public void generacionBanderas(){
        ImageButton btn_Bandera1 = findViewById(R.id.btnBandera1);
        ImageButton btn_Bandera2 = findViewById(R.id.btnBandera2);
        texto = findViewById(R.id.textBandera);

        double posi1 = Math.random()*6;

        btn_Bandera1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobacion((int)posi1);
            }
        });
        double posi2 = Math.random()*6;
        while ((int)posi1 == (int)posi2){
            posi2 = Math.random()*6;
        }

        int posi2b = (int)posi2;
        btn_Bandera2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobacion(posi2b);
            }
        });

        btn_Bandera1.setImageResource(banderas[(int)posi1]);
        btn_Bandera2.setImageResource(banderas[(int)posi2]);

        double pos3 = Math.random()*2;


        if ((int)pos3 == 0){
            banderaElegida = nomBanderas[(int)posi1];
            texto.setText(banderaElegida);
        }else{
            banderaElegida = nomBanderas[(int)posi2];
            texto.setText(banderaElegida);
        }
    }
    public void comprobacion(int i){
        if (banderaElegida.equals(nomBanderas[i])){
            puntuacion++;
            generacionBanderas();
        }else{
            if (puntuacion > 0){
                puntuacion = puntuacion-1;
            }
            Toast.makeText(getApplicationContext()
                    ,"Has perdido. Puntuación: "+puntuacion
                    ,Toast.LENGTH_SHORT).show();
            puntuacion = 0;
        }
    }



}