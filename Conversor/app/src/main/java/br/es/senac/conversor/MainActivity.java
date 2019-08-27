package br.es.senac.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

 // metodo que declara uma classe - extends esta herdando a classe appCompaActivity
public class MainActivity extends AppCompatActivity {

    // Metodo que desclara o ciclo de criação da tela...

    @Override // é uma notação que sobrescreve um metodo
    //declaração de metodo
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Metodo que liga a activity.java
        setContentView(R.layout.activity_main);
    }
}
