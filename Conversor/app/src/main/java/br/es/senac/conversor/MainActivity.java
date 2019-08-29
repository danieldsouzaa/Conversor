package br.es.senac.conversor;

import androidx.appcompat.app.AppCompatActivity;

// importando os pacotes de outras classes
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale; // importando a classe  existente no pacote java.util informa as configuraçãoes regionais


// metodo que declara uma classe - extends esta herdando a classe appCompaActivity

// Metodo que desclara o ciclo de criação da tela...

 // é uma notação que sobrescreve um metodo
//declaração de metodo

// void é vazio
// proteção

// Metodo que liga a  MainActivity.jav no activity.main.xml (tela)

public class MainActivity extends AppCompatActivity { // classe MainActivity herdando da AppCompatActivit

    int alturaEmCentimentros  = 0; //variavel recebendo valor inteiro

    @Override // reescrevendo o metodo
    protected void onCreate(Bundle savedInstanceState) { // aqui indica a criação de um metodo onCreate
        super.onCreate(savedInstanceState); // comando super chama o metodo onCreate estou indo no pai e mando executar
        setContentView(R.layout.activity_main); // o comando setContentView faz mostrar a tela ele chama a classe principal

        final TextView txtMetros = (TextView) findViewById(R.id.txtMetros); // declaração de um  objeto  , o metodo findViewById esta esta recebendo o ID do (widget) e armazenando no objeto a variavel final informa que o valor não pode ser mudado
        final TextView txtPes = (TextView) findViewById(R.id.txtPes); // procura na view o ID findViewById

        final SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax(230); //  aqui informamos o maximo de caracter pode receber  (metodo setMax)

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // aqui é criando um evento para toda vez que movimentar seekBar ele reconhecer essa mudança fica monitorando

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { // o metodo informando que esta recebendo e executando os componetes (widget), criação de variavel



                alturaEmCentimentros = progress;
                String texto = formataValorComDoisDigitos(progress /100.0);
                texto += "m.";
                txtMetros.setText(texto); // mostra uma msg na tela... setText muda o texto

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { // cria uma função obs.: public ou void ou private tudo é função... o  privado só a classe é privado só quem herda
                txtPes.setText("Toque em Converter");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double alturaEmPes = alturaEmCentimentros /30.48;
                String texto = formataValorComDoisDigitos(alturaEmPes);
                texto +="pé(s)";
                txtPes.setText(texto);
            }
        });

    }

    private String formataValorComDoisDigitos (double valor){ // aqui cria uma função tendo retorno string ( private) tipo cria a função string de nome formataValorComDoisDigitos recebendo um valor double
        return String.format(Locale.FRANCE,"%.2f", valor); // criando uma variavel string e atribuindo um valor, recebendo o valor com duas casas decimais

    }
}
