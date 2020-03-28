package com.gerielcastro.expofranchising.Formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gerielcastro.expofranchising.HomeActivity;
import com.gerielcastro.expofranchising.R;

public class Formulario3Activity extends AppCompatActivity {
    private TextView titulo, informacao;
    private Button fechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario3);

        titulo = (TextView) findViewById(R.id.titulo_text);
        informacao = (TextView) findViewById(R.id.information_text);
        fechar = (Button) findViewById(R.id.btnInfobanco);

        Bundle extra = getIntent().getExtras();
        String titulo_banco = extra.getString("Titulo");
        String info_banco = extra.getString("RespostaBanco");

        titulo.setText(titulo_banco);
        informacao.setText(info_banco);

        fechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Formulario3Activity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
