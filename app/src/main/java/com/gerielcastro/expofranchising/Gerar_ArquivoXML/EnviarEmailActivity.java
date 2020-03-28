package com.gerielcastro.expofranchising.Gerar_ArquivoXML;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.gerielcastro.expofranchising.HomeActivity;
import com.gerielcastro.expofranchising.R;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class EnviarEmailActivity extends AppCompatActivity {

    private ImageView back;
    private EditText email, mensagem, assunto;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_email);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        back = (ImageView) findViewById(R.id.arrow_back_email);
        email = (EditText) findViewById(R.id.edit_text_email2);
        mensagem = (EditText) findViewById(R.id.edit_text_mensagem);
        assunto = (EditText) findViewById(R.id.edit_text_assunto2);
        enviar = (Button) findViewById(R.id.btnemail);

        arquivo_aleatorio();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnviarEmailActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (email.getText().toString().isEmpty()) {
                    Toast.makeText(view.getContext(), "Campo Email Vazio", Toast.LENGTH_SHORT).show();
                } else if (assunto.getText().toString().isEmpty()) {
                    Toast.makeText(view.getContext(), "Campo Assunto Vazio", Toast.LENGTH_SHORT).show();
                } else if (mensagem.getText().toString().isEmpty()) {
                    Toast.makeText(view.getContext(), "Campo Mensagem Vazio", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(EnviarEmailActivity.this, EnviarEmail2Activity.class);
                    intent.putExtra("email", email.getText().toString());
                    intent.putExtra("assunto", assunto.getText().toString());
                    intent.putExtra("mensagem", mensagem.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    public void arquivo_aleatorio() {

        File file = new File(getExternalFilesDir("Arquivo"), "tpk12562asdaduhygasdbjnl.xls");
        WritableWorkbook wb = null;

        try {
            wb = Workbook.createWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        wb.createSheet("Plan1", 0);
        WritableSheet plan = wb.getSheet(0);

        Label label = new Label(0, 0, "Primeira célula");
        Label label2 = new Label(0, 1, "Segunda célula");

        try {
            plan.addCell(label);
            plan.addCell(label2);
            wb.write();
            wb.close();

        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
