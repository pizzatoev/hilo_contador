package com.example.micontadoreva;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProbandoActivity extends AppCompatActivity {

    Button btnHilo;
    TextView tvTextoEjemplo, tvHiloAuxiliar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probando);

        btnHilo = findViewById(R.id.btnHilo);
        tvTextoEjemplo = findViewById(R.id.tvTextoEjemplo);
        tvHiloAuxiliar = findViewById(R.id.tvTextoAuxiliar);

        btnHilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {// hilo que vaya de 10 a 0
                    @Override
                    public void run() {
                        for (int i = 10; i>=0; i--){
                            int dec = i;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvTextoEjemplo.setText("Contador: " + dec);
                                }
                            });
                            try {
                                Thread.sleep(1000);// espera 1 seg
                            }
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvTextoEjemplo.setText("Proceso de hilo finalizado");
                            }
                        });
                    }
                });
                thread.start();

                Thread thread2 = new Thread(new Runnable() {// hilo que vaya de 0 a 10
                    @Override
                    public void run() {
                        for (int i = 0; i<=10; i++){
                            int dec = i;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvHiloAuxiliar.setText("Contador: " + dec);
                                }
                            });
                            try {
                                Thread.sleep(1000);// espera 1 seg
                            }
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvHiloAuxiliar.setText("Proceso de hilo finalizado");
                            }
                        });
                    }
                });
                thread2.start();
            }
        });
        // hacer un hilo que vaya de 0 a 10
        //hacer un semaforo y lo podemos hacer en image view o rectangulo que es ovalo con radio
        //son 4 fases, la primera 5 seg rojo y luego 5 gris ,
        // fase 2:
        //lo hice en la maquina de la U
    }
}