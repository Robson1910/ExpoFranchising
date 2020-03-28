package com.gerielcastro.expofranchising.Formulario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.gerielcastro.expofranchising.Classes.Pesquisa;
import com.gerielcastro.expofranchising.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Formulario2Activity extends AppCompatActivity {

    private RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup7A, radioGroup7B, radioGroup9, radioGroup10,
            radioGroup11A, radioGroup11B, radioGroup11C, radioGroup11D, radioGroup11E, radioGroup11F, radioGroup11G,
            radioGroup11H, radioGroup12, radioGroup13, radioGroup14, radioGroup15;

    private RadioButton radioButton1, radioButton2, radioButton3, radioButton7A, radioButton7B, radioButton9, radioButton10,
            radioButton11A, radioButton11B, radioButton11C, radioButton11D, radioButton11E, radioButton11F, radioButton11G,
            radioButton11H, radioButton12, radioButton13, radioButton14, radioButton15;

    private EditText resposta1Outros, resposta4, resposta5, resposta6, resposta8, resposta9Jus, resposta10Jus, resposta12Jus,
            resposta13Jus, resposta14Jus, resposta16, resposta17;

    private String resposta1 = " ", resposta2 = " ", resposta3 = " ", resposta7A = " ", resposta7B = " ", resposta9 = " ",
            resposta10 = " ", resposta11A = " ", resposta11B = " ", resposta11C = " ", resposta11D = " ", resposta11E = " ",
            resposta11F = " ", resposta11G = " ", resposta11H = " ", resposta12 = " ", resposta13 = " ", resposta14 = " ",
            resposta15 = " ";

    private Button cadastrar;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabaseRef1;
    private ImageView back;
    private TextView texto3, texto4, texto8, texto12, texto16, texto17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario2);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        back = (ImageView) findViewById(R.id.arrow_back_formulario2);
        cadastrar = (Button) findViewById(R.id.btnGravar);
        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
        radioGroup7A = (RadioGroup) findViewById(R.id.radioGroup7A);
        radioGroup7B = (RadioGroup) findViewById(R.id.radioGroup7B);
        radioGroup9 = (RadioGroup) findViewById(R.id.radioGroup9);
        radioGroup10 = (RadioGroup) findViewById(R.id.radioGroup10);
        radioGroup11A = (RadioGroup) findViewById(R.id.radioGroup11A);
        radioGroup11B = (RadioGroup) findViewById(R.id.radioGroup11B);
        radioGroup11C = (RadioGroup) findViewById(R.id.radioGroup11C);
        radioGroup11D = (RadioGroup) findViewById(R.id.radioGroup11D);
        radioGroup11E = (RadioGroup) findViewById(R.id.radioGroup11E);
        radioGroup11F = (RadioGroup) findViewById(R.id.radioGroup11F);
        radioGroup11G = (RadioGroup) findViewById(R.id.radioGroup11G);
        radioGroup11H = (RadioGroup) findViewById(R.id.radioGroup11H);
        radioGroup12 = (RadioGroup) findViewById(R.id.radioGroup12);
        radioGroup13 = (RadioGroup) findViewById(R.id.radioGroup13);
        radioGroup14 = (RadioGroup) findViewById(R.id.radioGroup14);
        radioGroup15 = (RadioGroup) findViewById(R.id.radioGroup15);
        resposta1Outros = (EditText) findViewById(R.id.Edit_text_outros1);
        resposta4 = (EditText) findViewById(R.id.Edit_text_4);
        resposta5 = (EditText) findViewById(R.id.Edit_text_5);
        resposta6 = (EditText) findViewById(R.id.Edit_text_6);
        resposta8 = (EditText) findViewById(R.id.Edit_text_8);
        resposta9Jus = (EditText) findViewById(R.id.Edit_text_9);
        resposta10Jus = (EditText) findViewById(R.id.Edit_text_10);
        resposta12Jus = (EditText) findViewById(R.id.Edit_text_12);
        resposta13Jus = (EditText) findViewById(R.id.Edit_text_13);
        resposta14Jus = (EditText) findViewById(R.id.Edit_text_14);
        resposta16 = (EditText) findViewById(R.id.Edit_text_16);
        resposta17 = (EditText) findViewById(R.id.Edit_text_17);
        texto3 = (TextView) findViewById(R.id.text_view_3);
        texto4 = (TextView) findViewById(R.id.text_view_4);
        texto8 = (TextView) findViewById(R.id.text_view_8);
        texto12 = (TextView) findViewById(R.id.text_view_12);
        texto16 = (TextView) findViewById(R.id.text_view_16);
        texto17 = (TextView) findViewById(R.id.text_view_17);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Formulario2Activity.this, Formulario1Activity.class);
                startActivity(intent);
                finish();
            }
        });

        Bundle extra = getIntent().getExtras();
        final String nome_empresa = extra.getString("NomeEmpresa");
        final String responsavel = extra.getString("Responsavel");
        final String cargo = extra.getString("Cargo");
        final String cidade = extra.getString("Cidade");
        final String empresa_expositora = extra.getString("EmpresaExpositora");
        final String data = extra.getString("Data");
        final String ano = extra.getString("Ano");

        int a = Integer.parseInt(ano)+1;

        texto3.setText("3) Qual a sua expectativa em volume total de negócios gerados a partir da Expo Franchising ABF Rio "+ano+"?");
        texto4.setText("4) Quantas e quais marcas você está expondo na Expo Franchising ABF Rio "+ano+"?");
        texto8.setText("8) Em qual mês e local você sugere que ocorra a Expo Franchising ABF Rio "+a+"?");
        texto12.setText("12) Levando em consideração todos os fatores, sua participação na Expo Franchising ABF Rio "+ano+" foi: Justifica?");
        texto16.setText("16) Na sua opinião, quais foram os pontos POSITIVOS da Expo Franchising ABF Rio "+ano+"?");
        texto17.setText("17) Na sua opinião, quais foram os pontos a serem melhorados da Expo Franchising ABF Rio "+ano+"?");

        mDatabaseRef1 = FirebaseDatabase.getInstance().getReference("Pesquisa");
        mDatabaseRef1.keepSynced(true);
        firebaseAuth = FirebaseAuth.getInstance();

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Pesquisa pesquisa = new Pesquisa();
                pesquisa.setUserId(firebaseAuth.getCurrentUser().getUid());
                pesquisa.setNomeEmpresa(nome_empresa);
                pesquisa.setResponsavel(responsavel);
                pesquisa.setCargo(cargo);
                pesquisa.setCidade(cidade);
                pesquisa.setEmpresaExpositora(empresa_expositora);
                pesquisa.setData(data);
                pesquisa.setResposta1(resposta1 + ", " + resposta1Outros.getText().toString());
                pesquisa.setResposta2(resposta2);
                pesquisa.setResposta3(resposta3);
                pesquisa.setResposta4(resposta4.getText().toString());
                pesquisa.setResposta5(resposta5.getText().toString());
                pesquisa.setResposta6(resposta6.getText().toString());
                pesquisa.setResposta7A(resposta7A);
                pesquisa.setResposta7B(resposta7B);
                pesquisa.setResposta8(resposta8.getText().toString());
                pesquisa.setResposta9(resposta9 + ", " + resposta9Jus.getText().toString());
                pesquisa.setResposta10(resposta10 + ", " + resposta10Jus.getText().toString());
                pesquisa.setResposta11A(resposta11A);
                pesquisa.setResposta11B(resposta11B);
                pesquisa.setResposta11C(resposta11C);
                pesquisa.setResposta11D(resposta11D);
                pesquisa.setResposta11E(resposta11E);
                pesquisa.setResposta11F(resposta11F);
                pesquisa.setResposta11G(resposta11G);
                pesquisa.setResposta11H(resposta11H);
                pesquisa.setResposta12(resposta12 + ", " + resposta12Jus.getText().toString());
                pesquisa.setResposta13(resposta13 + ", " + resposta13Jus.getText().toString());
                pesquisa.setResposta14(resposta14 + ", " + resposta14Jus.getText().toString());
                pesquisa.setResposta15(resposta15);
                pesquisa.setResposta16(resposta16.getText().toString());
                pesquisa.setResposta17(resposta17.getText().toString());

                String uploadId = mDatabaseRef1.push().getKey();
                pesquisa.setmKey(uploadId);
                mDatabaseRef1.child(uploadId).setValue(pesquisa).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Intent intent = new Intent(Formulario2Activity.this, Formulario3Activity.class);
                        intent.putExtra("Titulo", "Falha");
                        intent.putExtra("RespostaBanco", "Dados não salvo!. OBS:. Problema pode ser conexão com o Banco ou a Internet do aparelho");
                        startActivity(intent);
                        finish();
                    }
                });

                Intent intent = new Intent(Formulario2Activity.this, Formulario3Activity.class);
                intent.putExtra("Titulo", "Sucesso");
                intent.putExtra("RespostaBanco", "Dados salvo com sucesso!");
                startActivity(intent);
                finish();

            }
        });
    }

    public void onClickPergunta1(View v) {
        int radioId = radioGroup1.getCheckedRadioButtonId();
        radioButton1 = findViewById(radioId);
        resposta1 = radioButton1.getText().toString();
    }

    public void onClickPergunta2(View v) {
        int radioId = radioGroup2.getCheckedRadioButtonId();
        radioButton2 = findViewById(radioId);
        resposta2 = radioButton2.getText().toString();
    }

    public void onClickPergunta3(View v) {
        int radioId = radioGroup3.getCheckedRadioButtonId();
        radioButton3 = findViewById(radioId);
        resposta3 = radioButton3.getText().toString();
    }

    public void onClickPergunta7A(View v) {
        int radioId = radioGroup7A.getCheckedRadioButtonId();
        radioButton7A = findViewById(radioId);
        resposta7A = radioButton7A.getText().toString();
    }

    public void onClickPergunta7B(View v) {
        int radioId = radioGroup7B.getCheckedRadioButtonId();
        radioButton7B = findViewById(radioId);
        resposta7B = radioButton7B.getText().toString();
    }

    public void onClickPergunta9(View v) {
        int radioId = radioGroup9.getCheckedRadioButtonId();
        radioButton9 = findViewById(radioId);
        resposta9 = radioButton9.getText().toString();
    }

    public void onClickPergunta10(View v) {
        int radioId = radioGroup10.getCheckedRadioButtonId();
        radioButton10 = findViewById(radioId);
        resposta10 = radioButton10.getText().toString();
    }

    public void onClickPergunta11A(View v) {
        int radioId = radioGroup11A.getCheckedRadioButtonId();
        radioButton11A = findViewById(radioId);
        resposta11A = radioButton11A.getText().toString();
    }

    public void onClickPergunta11B(View v) {
        int radioId = radioGroup11B.getCheckedRadioButtonId();
        radioButton11B = findViewById(radioId);
        resposta11B = radioButton11B.getText().toString();
    }

    public void onClickPergunta11C(View v) {
        int radioId = radioGroup11C.getCheckedRadioButtonId();
        radioButton11C = findViewById(radioId);
        resposta11C = radioButton11C.getText().toString();
    }

    public void onClickPergunta11D(View v) {
        int radioId = radioGroup11D.getCheckedRadioButtonId();
        radioButton11D = findViewById(radioId);
        resposta11D = radioButton11D.getText().toString();
    }

    public void onClickPergunta11E(View v) {
        int radioId = radioGroup11E.getCheckedRadioButtonId();
        radioButton11E = findViewById(radioId);
        resposta11E = radioButton11E.getText().toString();
    }

    public void onClickPergunta11F(View v) {
        int radioId = radioGroup11F.getCheckedRadioButtonId();
        radioButton11F = findViewById(radioId);
        resposta11F = radioButton11F.getText().toString();
    }

    public void onClickPergunta11G(View v) {
        int radioId = radioGroup11G.getCheckedRadioButtonId();
        radioButton11G = findViewById(radioId);
        resposta11G = radioButton11G.getText().toString();
    }

    public void onClickPergunta11H(View v) {
        int radioId = radioGroup11H.getCheckedRadioButtonId();
        radioButton11H = findViewById(radioId);
        resposta11H = radioButton11H.getText().toString();
    }

    public void onClickPergunta12(View v) {
        int radioId = radioGroup12.getCheckedRadioButtonId();
        radioButton12 = findViewById(radioId);
        resposta12 = radioButton12.getText().toString();
    }

    public void onClickPergunta13(View v) {
        int radioId = radioGroup13.getCheckedRadioButtonId();
        radioButton13 = findViewById(radioId);
        resposta13 = radioButton13.getText().toString();
    }

    public void onClickPergunta14(View v) {
        int radioId = radioGroup14.getCheckedRadioButtonId();
        radioButton14 = findViewById(radioId);
        resposta14 = radioButton14.getText().toString();
    }

    public void onClickPergunta15(View v) {
        int radioId = radioGroup15.getCheckedRadioButtonId();
        radioButton15 = findViewById(radioId);
        resposta15 = radioButton15.getText().toString();
    }
}
