package com.gerielcastro.expofranchising.Formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gerielcastro.expofranchising.HomeActivity;
import com.gerielcastro.expofranchising.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formulario1Activity extends AppCompatActivity {
    private EditText nome_empresa, resposavel, cargo, empresa_expositora, cidade;
    private TextView data1, resumo;
    private Button btn_proximo;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario1);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        back = (ImageView) findViewById(R.id.arrow_back_formulario1);
        btn_proximo = (Button) findViewById(R.id.btnAvanca);
        nome_empresa = (EditText) findViewById(R.id.Edit_text_empresa);
        resposavel = (EditText) findViewById(R.id.Edit_text_responsavel);
        cargo = (EditText) findViewById(R.id.Edit_text_cargo);
        cidade = (EditText) findViewById(R.id.Edit_text_cidade);
        empresa_expositora = (EditText) findViewById(R.id.Edit_text_expositora);
        data1 = (TextView) findViewById(R.id.data_text);
        resumo = (TextView) findViewById(R.id.resumo);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Formulario1Activity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        SimpleDateFormat formataData = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        SimpleDateFormat ano = new SimpleDateFormat("yyyy");
        Date data = new Date();
        String dataFormatada = formataData.format(data);
        final String anoFormatada = ano.format(data);
        data1.setText(dataFormatada);

        resumo.setText("Com o objetivo de aprimorar o serviço que prestamos, é fundamental sabermos sua opinião sobre o desempenho da feira Expo Franchising ABF Rio "+anoFormatada+".\n" +
                "Agradeceríamos se preenchesse por alguns minutos a nossa Pesquisa de Satisfação.\n" +
                "Sua opinião fica registrada e torna-se uma ferramenta muito importante para o nosso relacionamento.");

        btn_proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nome_empresa.getText().toString().isEmpty()) {
                    Toast.makeText(Formulario1Activity.this, "Campo Vazio", Toast.LENGTH_LONG).show();
                } else if (resposavel.getText().toString().isEmpty()) {
                    Toast.makeText(Formulario1Activity.this, "Campo Vazio", Toast.LENGTH_LONG).show();
                } else if (cargo.getText().toString().isEmpty()) {
                    Toast.makeText(Formulario1Activity.this, "Campo Vazio", Toast.LENGTH_LONG).show();
                } else if (cidade.getText().toString().isEmpty()) {
                    Toast.makeText(Formulario1Activity.this, "Campo Vazio", Toast.LENGTH_LONG).show();
                } else if (empresa_expositora.getText().toString().isEmpty()) {
                    Toast.makeText(Formulario1Activity.this, "Campo Vazio", Toast.LENGTH_LONG).show();
                } else {

                    Intent intent = new Intent(Formulario1Activity.this, Formulario2Activity.class);
                    intent.putExtra("NomeEmpresa", nome_empresa.getText().toString());
                    intent.putExtra("Responsavel", resposavel.getText().toString());
                    intent.putExtra("Cargo", cargo.getText().toString());
                    intent.putExtra("Cidade", cidade.getText().toString());
                    intent.putExtra("EmpresaExpositora", cargo.getText().toString());
                    intent.putExtra("Data", data1.getText().toString());
                    intent.putExtra("Ano", anoFormatada);
                    startActivity(intent);
                }
            }
        });
    }
}
