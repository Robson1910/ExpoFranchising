package com.gerielcastro.expofranchising.Gerar_ArquivoXML;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gerielcastro.expofranchising.HomeActivity;
import com.gerielcastro.expofranchising.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class InformacaoActivity extends AppCompatActivity {

    private TextView resposta1, resposta2, resposta3, resposta4, resposta5, resposta6, resposta7A, resposta7B,
            resposta8, resposta9, resposta10, resposta11A, resposta11B, resposta11C, resposta11D, resposta11E,
            resposta11F, resposta11G, resposta11H, resposta12, resposta13, resposta14, resposta15, resposta16,
            resposta17, nomeEmpresa, responsavel, cargo, cidade, empresaExpositora, data,
            texto3, texto4, texto8, texto12, texto16, texto17;

    private Button gerarArquivo;

    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao);
        back = (ImageView) findViewById(R.id.arrow_back_informacao);
        gerarArquivo = (Button) findViewById(R.id.btnGerarArquivo);
        resposta1 = (TextView) findViewById(R.id.reposta_text_1);
        resposta2 = (TextView) findViewById(R.id.reposta_text_2);
        resposta3 = (TextView) findViewById(R.id.reposta_text_3);
        resposta4 = (TextView) findViewById(R.id.reposta_text_4);
        resposta5 = (TextView) findViewById(R.id.reposta_text_5);
        resposta6 = (TextView) findViewById(R.id.reposta_text_6);
        resposta7A = (TextView) findViewById(R.id.reposta_text_7A);
        resposta7B = (TextView) findViewById(R.id.reposta_text_7B);
        resposta8 = (TextView) findViewById(R.id.reposta_text_8);
        resposta9 = (TextView) findViewById(R.id.reposta_text_9);
        resposta10 = (TextView) findViewById(R.id.reposta_text_10);
        resposta11A = (TextView) findViewById(R.id.reposta_text_11A);
        resposta11B = (TextView) findViewById(R.id.reposta_text_11B);
        resposta11C = (TextView) findViewById(R.id.reposta_text_11C);
        resposta11D = (TextView) findViewById(R.id.reposta_text_11D);
        resposta11E = (TextView) findViewById(R.id.reposta_text_11E);
        resposta11F = (TextView) findViewById(R.id.reposta_text_11F);
        resposta11G = (TextView) findViewById(R.id.reposta_text_11G);
        resposta11H = (TextView) findViewById(R.id.reposta_text_11H);
        resposta12 = (TextView) findViewById(R.id.reposta_text_12);
        resposta13 = (TextView) findViewById(R.id.reposta_text_13);
        resposta14 = (TextView) findViewById(R.id.reposta_text_14);
        resposta15 = (TextView) findViewById(R.id.reposta_text_15);
        resposta16 = (TextView) findViewById(R.id.reposta_text_16);
        resposta17 = (TextView) findViewById(R.id.reposta_text_17);
        nomeEmpresa = (TextView) findViewById(R.id.nomeEmpresa_text);
        responsavel = (TextView) findViewById(R.id.responsavel_text);
        cargo = (TextView) findViewById(R.id.Cargo_text);
        cidade = (TextView) findViewById(R.id.cidadeOrigem_text);
        empresaExpositora = (TextView) findViewById(R.id.empresaExpositora_text);
        data = (TextView) findViewById(R.id.dataPesquisa_text);

        texto3 = (TextView) findViewById(R.id.text_3);
        texto4 = (TextView) findViewById(R.id.text_4);
        texto8 = (TextView) findViewById(R.id.text_8);
        texto12 = (TextView) findViewById(R.id.text_12);
        texto16 = (TextView) findViewById(R.id.text_16);
        texto17 = (TextView) findViewById(R.id.text_17);


        SimpleDateFormat ano = new SimpleDateFormat("yyyy");
        Date data2 = new Date();
        final String dataFormatada = ano.format(data2);

        final int a = Integer.parseInt(dataFormatada)+1;

        texto3.setText("3) Qual a sua expectativa em volume total de negócios gerados a partir da Expo Franchising ABF Rio "+dataFormatada+"?");
        texto4.setText("4) Quantas e quais marcas você está expondo na Expo Franchising ABF Rio "+dataFormatada+"?");
        texto8.setText("8) Em qual mês e local você sugere que ocorra a Expo Franchising ABF Rio "+a+"?");
        texto12.setText("12) Levando em consideração todos os fatores, sua participação na Expo Franchising ABF Rio "+dataFormatada+" foi: Justifique ?");
        texto16.setText("16) Na sua opinião, quais foram os pontos POSITIVOS da Expo Franchising ABF Rio "+dataFormatada+"?");
        texto17.setText("17) Na sua opinião, quais foram os pontos a serem melhorados da Expo Franchising ABF Rio "+dataFormatada+"?");


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformacaoActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        final Bundle extra = getIntent().getExtras();
        final String pergunta1 = extra.getString("resposta1");
        final String pergunta2 = extra.getString("resposta2");
        final String pergunta3 = extra.getString("resposta3");
        final String pergunta4 = extra.getString("resposta4");
        final String pergunta5 = extra.getString("resposta5");
        final String pergunta6 = extra.getString("resposta6");
        final String pergunta7A = extra.getString("resposta7A");
        final String pergunta7B = extra.getString("resposta7B");
        final String pergunta8 = extra.getString("resposta8");
        final String pergunta9 = extra.getString("resposta9");
        final String pergunta10 = extra.getString("resposta10");
        final String pergunta11A = extra.getString("resposta11A");
        final String pergunta11B = extra.getString("resposta11B");
        final String pergunta11C = extra.getString("resposta11C");
        final String pergunta11D = extra.getString("resposta11D");
        final String pergunta11E = extra.getString("resposta11E");
        final String pergunta11F = extra.getString("resposta11F");
        final String pergunta11G = extra.getString("resposta11G");
        final String pergunta11H = extra.getString("resposta11H");
        final String pergunta12 = extra.getString("resposta12");
        final String pergunta13 = extra.getString("resposta13");
        final String pergunta14 = extra.getString("resposta14");
        final String pergunta15 = extra.getString("resposta15");
        final String pergunta16 = extra.getString("resposta16");
        final String pergunta17 = extra.getString("resposta17");
        final String nome_empresa1 = extra.getString("nome_empresa");
        final String responsavel1 = extra.getString("responsavel");
        final String cargo1 = extra.getString("cargo");
        final String cidade1 = extra.getString("cidade");
        final String empresa_expositora1 = extra.getString("empresa_expositora");
        final String data1 = extra.getString("data");

        resposta1.setText(pergunta1);
        resposta2.setText(pergunta2);
        resposta3.setText(pergunta3);
        resposta4.setText(pergunta4);
        resposta5.setText(pergunta5);
        resposta6.setText(pergunta6);
        resposta7A.setText(pergunta7A);
        resposta7B.setText(pergunta7B);
        resposta8.setText(pergunta8);
        resposta9.setText(pergunta9);
        resposta10.setText(pergunta10);
        resposta11A.setText(pergunta11A);
        resposta11B.setText(pergunta11B);
        resposta11C.setText(pergunta11C);
        resposta11D.setText(pergunta11D);
        resposta11E.setText(pergunta11E);
        resposta11F.setText(pergunta11F);
        resposta11G.setText(pergunta11G);
        resposta11H.setText(pergunta11H);
        resposta12.setText(pergunta12);
        resposta13.setText(pergunta13);
        resposta14.setText(pergunta14);
        resposta15.setText(pergunta15);
        resposta16.setText(pergunta16);
        resposta17.setText(pergunta17);
        nomeEmpresa.setText(nome_empresa1);
        responsavel.setText(responsavel1);
        cargo.setText(cargo1);
        cidade.setText(cidade1);
        empresaExpositora.setText(empresa_expositora1);
        data.setText(data1);

        gerarArquivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                File file = new File(getExternalFilesDir("Arquivo"), nome_empresa1 + ".xls");

                WritableWorkbook wb = null;
                try {
                    wb = Workbook.createWorkbook(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                wb.createSheet("Plan1", 0);
                WritableSheet plan = wb.getSheet(0);
                Label label = new Label(0, 0, "Nome da Empresa");
                Label label2 = new Label(1, 0, "Responsável");
                Label label3 = new Label(2, 0, "Cargo");
                Label label4 = new Label(3, 0, "Cidade de Origem");
                Label label5 = new Label(4, 0, "Empresa Expositora");
                Label label6 = new Label(5, 0, "Data");

                Label label7 = new Label(0, 1, nome_empresa1);
                Label label8 = new Label(1, 1, responsavel1);
                Label label9 = new Label(2, 1, cargo1);
                Label label10 = new Label(3, 1, cidade1);
                Label label11 = new Label(4, 1, empresa_expositora1);
                Label label12 = new Label(5, 1, data1);

                Label label13 = new Label(0, 2, "Nº");
                Label label14 = new Label(1, 2, "Perguntas");
                Label label15 = new Label(2, 2, "Respostas");
                Label label16 = new Label(0, 3, "1)");
                Label label17 = new Label(1, 3, "Qual o maior objetivo de sua participação no evento?");
                Label label18 = new Label(2, 3, pergunta1);
                Label label19 = new Label(0, 4, "2)");
                Label label20 = new Label(1, 4, "Como o evento correspondeu às suas expectativas em relação à captação de futuros franqueados?");
                Label label21 = new Label(2, 4, pergunta2);
                Label label22 = new Label(0, 5, "3)");
                Label label23 = new Label(1, 5, "Qual a sua expectativa em volume total de negócios gerados a partir da Expo Franchising ABF Rio "+dataFormatada+"?");
                Label label24 = new Label(2, 5, pergunta3);
                Label label25 = new Label(0, 6, "4)");
                Label label26 = new Label(1, 6, "Quantas e quais marcas você está expondo na Expo Franchising ABF Rio "+dataFormatada+"?");
                Label label27 = new Label(2, 6, pergunta4);
                Label label28 = new Label(0, 7, "5)");
                Label label29 = new Label(1, 7, "Qual o setor de atuação e o faturamento anual da empresa?");
                Label label30 = new Label(2, 7, pergunta5);
                Label label31 = new Label(0, 8, "6)");
                Label label32 = new Label(1, 8, "Participa de outras feiras do setor? Quais?");
                Label label33 = new Label(2, 8, pergunta6);
                Label label34 = new Label(0, 9, "7)");
                Label label35 = new Label(1, 9, "Como a feira correspondeu às suas expectativas com relação à:");
                Label label36 = new Label(0, 10, "7 -A)");
                Label label37 = new Label(1, 10, "Quantidade de visitantes");
                Label label38 = new Label(2, 10, pergunta7A);
                Label label39 = new Label(0, 11, "7 -B)");
                Label label40 = new Label(1, 11, "Qualidade dos visitantes");
                Label label41 = new Label(2, 11, pergunta7B);
                Label label42 = new Label(0, 12, "8)");
                Label label43 = new Label(1, 12, "Em qual mês e local você sugere que ocorra a Expo Franchising ABF Rio "+a+"?");
                Label label44 = new Label(2, 12, pergunta8);
                Label label45 = new Label(0, 13, "9)");
                Label label46 = new Label(1, 13, "O que você achou da divulgação para público geral? Justifique");
                Label label47 = new Label(2, 13, pergunta9);
                Label label48 = new Label(0, 14, "10)");
                Label label49 = new Label(1, 14, "Os convites digitais foram repassados aos seus clientes para divulgação de seu estande na feira? Se não enviou, por qual motivo?");
                Label label50 = new Label(2, 14, pergunta10);
                Label label51 = new Label(0, 15, "11)");
                Label label52 = new Label(1, 15, "Avaliação de tópicos:");
                Label label53 = new Label(0, 16, "11 -A)");
                Label label54 = new Label(1, 16, "Organização geral da feira:");
                Label label55 = new Label(2, 16, pergunta11A);
                Label label56 = new Label(0, 17, "11 -B)");
                Label label57 = new Label(1, 17, "Atendimento ao Expositor:");
                Label label58 = new Label(2, 17, pergunta11B);
                Label label59 = new Label(0, 18, "11 -C)");
                Label label60 = new Label(1, 18, "Departamento Financeiro:");
                Label label61 = new Label(2, 18, pergunta11C);
                Label label62 = new Label(0, 19, "11 -D)");
                Label label63 = new Label(1, 19, "Departamento Comercial:");
                Label label64 = new Label(2, 19, pergunta11D);
                Label label65 = new Label(0, 20, "11 -E)");
                Label label66 = new Label(1, 20, "Limpeza da Feira:");
                Label label67 = new Label(2, 20, pergunta11E);
                Label label68 = new Label(0, 21, "11 -F)");
                Label label69 = new Label(1, 21, "Segurança da Feira:");
                Label label70 = new Label(2, 21, pergunta11F);
                Label label71 = new Label(0, 22, "11 -G)");
                Label label72 = new Label(1, 22, "Montadora Oficial:");
                Label label73 = new Label(2, 22, pergunta11G);
                Label label74 = new Label(0, 23, "11 -H)");
                Label label75 = new Label(1, 23, "Área de Alimentação:");
                Label label76 = new Label(2, 23, pergunta11H);
                Label label77 = new Label(0, 24, "12)");
                Label label78 = new Label(1, 24, "Levando em consideração todos os fatores, sua participação na Expo Franchising ABF Rio "+dataFormatada+" foi: Justifique?");
                Label label79 = new Label(2, 24, pergunta12);
                Label label80 = new Label(0, 25, "13)");
                Label label81 = new Label(1, 25, "Participaria da próxima edição? Justifique");
                Label label82 = new Label(2, 25, pergunta13);
                Label label83 = new Label(0, 26, "14)");
                Label label84 = new Label(1, 26, "Você pretende aumentar, manter ou diminuir a área de seu estande? Caso tenha respondido diminuir, favor justificar?");
                Label label85 = new Label(2, 26, pergunta14);
                Label label86 = new Label(0, 27, "15)");
                Label label87 = new Label(1, 27, "Que nota você daria ao evento, sendo nota 1 muito ruim e nota 5 ótimo:");
                Label label88 = new Label(2, 27, pergunta15);
                Label label89 = new Label(0, 28, "16)");
                Label label90 = new Label(1, 28, "Na sua opinião, quais foram os pontos POSITIVOS da Expo Franchising ABF Rio "+dataFormatada+"?");
                Label label91 = new Label(2, 28, pergunta16);
                Label label92 = new Label(0, 29, "17)");
                Label label93 = new Label(1, 29, "Na sua opinião, quais foram os pontos a serem melhorados da Expo Franchising ABF Rio "+dataFormatada+"?");
                Label label94 = new Label(2, 29, pergunta17);

                try {
                    plan.addCell(label);
                    plan.addCell(label2);
                    plan.addCell(label3);
                    plan.addCell(label4);
                    plan.addCell(label5);
                    plan.addCell(label6);
                    plan.addCell(label7);
                    plan.addCell(label8);
                    plan.addCell(label9);
                    plan.addCell(label10);
                    plan.addCell(label11);
                    plan.addCell(label12);
                    plan.addCell(label13);
                    plan.addCell(label14);
                    plan.addCell(label15);
                    plan.addCell(label16);
                    plan.addCell(label17);
                    plan.addCell(label18);
                    plan.addCell(label19);
                    plan.addCell(label20);
                    plan.addCell(label21);
                    plan.addCell(label22);
                    plan.addCell(label23);
                    plan.addCell(label24);
                    plan.addCell(label25);
                    plan.addCell(label26);
                    plan.addCell(label27);
                    plan.addCell(label28);
                    plan.addCell(label29);
                    plan.addCell(label30);
                    plan.addCell(label31);
                    plan.addCell(label32);
                    plan.addCell(label33);
                    plan.addCell(label34);
                    plan.addCell(label35);
                    plan.addCell(label36);
                    plan.addCell(label37);
                    plan.addCell(label38);
                    plan.addCell(label39);
                    plan.addCell(label40);
                    plan.addCell(label41);
                    plan.addCell(label42);
                    plan.addCell(label43);
                    plan.addCell(label44);
                    plan.addCell(label45);
                    plan.addCell(label46);
                    plan.addCell(label47);
                    plan.addCell(label48);
                    plan.addCell(label49);
                    plan.addCell(label50);
                    plan.addCell(label51);
                    plan.addCell(label52);
                    plan.addCell(label53);
                    plan.addCell(label54);
                    plan.addCell(label55);
                    plan.addCell(label56);
                    plan.addCell(label57);
                    plan.addCell(label58);
                    plan.addCell(label59);
                    plan.addCell(label60);
                    plan.addCell(label61);
                    plan.addCell(label62);
                    plan.addCell(label63);
                    plan.addCell(label64);
                    plan.addCell(label65);
                    plan.addCell(label66);
                    plan.addCell(label67);
                    plan.addCell(label68);
                    plan.addCell(label69);
                    plan.addCell(label70);
                    plan.addCell(label71);
                    plan.addCell(label72);
                    plan.addCell(label73);
                    plan.addCell(label74);
                    plan.addCell(label75);
                    plan.addCell(label76);
                    plan.addCell(label77);
                    plan.addCell(label78);
                    plan.addCell(label79);
                    plan.addCell(label80);
                    plan.addCell(label81);
                    plan.addCell(label82);
                    plan.addCell(label83);
                    plan.addCell(label84);
                    plan.addCell(label85);
                    plan.addCell(label86);
                    plan.addCell(label87);
                    plan.addCell(label88);
                    plan.addCell(label89);
                    plan.addCell(label90);
                    plan.addCell(label91);
                    plan.addCell(label92);
                    plan.addCell(label93);
                    plan.addCell(label94);
                    wb.write();
                    wb.close();
                    Toast.makeText(view.getContext(), "Excel Gerado = " + nome_empresa1 + ".xls", Toast.LENGTH_SHORT).show();
                } catch (RowsExceededException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
