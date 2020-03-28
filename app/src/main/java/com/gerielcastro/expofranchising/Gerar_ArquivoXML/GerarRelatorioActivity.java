package com.gerielcastro.expofranchising.Gerar_ArquivoXML;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gerielcastro.expofranchising.Classes.Pesquisa;
import com.gerielcastro.expofranchising.HomeActivity;
import com.gerielcastro.expofranchising.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class GerarRelatorioActivity extends AppCompatActivity {

    private DatabaseReference firebase;
    private ValueEventListener mDBListener;
    private Button pasta, salvar;
    private ImageView back;
    private TextView arquivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerar_relatorio);

        back = (ImageView) findViewById(R.id.excel_back);
        arquivo = (TextView) findViewById(R.id.arquivogerado1);
        pasta = (Button) findViewById(R.id.btnabrirpasta);
        salvar = (Button) findViewById(R.id.btngerarexcel1);

        SimpleDateFormat ano = new SimpleDateFormat("yyyy");
        Date data2 = new Date();
        final String dataFormatada = ano.format(data2);

        final int a = Integer.parseInt(dataFormatada)+1;


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GerarRelatorioActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        pasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());
                //intent.setDataAndType(uri, "application/vnd.ms-excel");
                Intent intent;
                Uri uri = Uri.fromFile(new File(new File(String.valueOf(getExternalFilesDir("Arquivo"))).getParent()));
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(uri, "resource/folder");

                if (intent.resolveActivityInfo(getPackageManager(), 0) != null) {
                    startActivity(intent);
                } else {

                    intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.setDataAndType(uri, "file/*");
                    startActivity(Intent.createChooser(intent, "Open folder"));
                }

            }
        });

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebase = FirebaseDatabase.getInstance().getReference("Pesquisa");
                firebase.keepSynced(true);
                mDBListener = firebase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        List<String> list1 = new ArrayList<>();
                        List<String> list2 = new ArrayList<>();
                        List<String> list3 = new ArrayList<>();
                        List<String> list4 = new ArrayList<>();
                        List<String> list5 = new ArrayList<>();
                        List<String> list6 = new ArrayList<>();
                        List<String> list7 = new ArrayList<>();
                        List<String> list8 = new ArrayList<>();
                        List<String> list9 = new ArrayList<>();
                        List<String> list10 = new ArrayList<>();
                        List<String> list11 = new ArrayList<>();
                        List<String> list12 = new ArrayList<>();
                        List<String> list13 = new ArrayList<>();
                        List<String> list14 = new ArrayList<>();
                        List<String> list15 = new ArrayList<>();
                        List<String> list16 = new ArrayList<>();
                        List<String> list17 = new ArrayList<>();
                        List<String> list18 = new ArrayList<>();
                        List<String> list19 = new ArrayList<>();
                        List<String> list20 = new ArrayList<>();
                        List<String> list21 = new ArrayList<>();
                        List<String> list22 = new ArrayList<>();
                        List<String> list23 = new ArrayList<>();
                        List<String> list24 = new ArrayList<>();
                        List<String> list25 = new ArrayList<>();
                        List<String> list26 = new ArrayList<>();
                        List<String> list27 = new ArrayList<>();
                        List<String> list28 = new ArrayList<>();
                        List<String> list29 = new ArrayList<>();
                        List<String> list30 = new ArrayList<>();
                        List<String> list31 = new ArrayList<>();

                        File file = new File(getExternalFilesDir("Arquivo"), "MeuRelatorio.xls");
                        WritableWorkbook wb = null;

                        try {
                            wb = Workbook.createWorkbook(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        wb.createSheet("Plan1", 0);
                        WritableSheet plan = wb.getSheet(0);

                        Label um = new Label(0, 0, "Nome da Empresa");
                        Label dois = new Label(1, 0, "Responsável");
                        Label tres = new Label(2, 0, "Cargo");
                        Label quatro = new Label(3, 0, "Cidade de Origem");
                        Label cinco = new Label(4, 0, "Empresa Expositora");
                        Label seis = new Label(5, 0, "Data");
                        Label sete = new Label(6, 0, "1) Qual o maior objetivo de sua participação no evento?");
                        Label oito = new Label(7, 0, "2) Como o evento correspondeu às suas expectativas em relação à captação de futuros franqueados?");
                        Label nove = new Label(8, 0, "3) Qual a sua expectativa em volume total de negócios gerados a partir da Expo Franchising ABF Rio "+dataFormatada+"?");
                        Label dez = new Label(9, 0, "4) Quantas e quais marcas você está expondo na Expo Franchising ABF Rio "+dataFormatada+"?");
                        Label onze = new Label(10, 0, "5) Qual o setor de atuação e o faturamento anual da empresa?");
                        Label doze = new Label(11, 0, "6) Participa de outras feiras do setor? Quais?");
                        Label treze = new Label(12, 0, "7) Como a feira correspondeu às suas expectativas com relação à: A) Quantidade de visitantes");
                        Label catorze = new Label(13, 0, "7) Como a feira correspondeu às suas expectativas com relação à: B) Quantidade de visitantes");
                        Label quinze = new Label(14, 0, "8) Em qual mês e local você sugere que ocorra a Expo Franchising ABF Rio "+a+"?");
                        Label dezesseis = new Label(15, 0, "9) O que você achou da divulgação para público geral? Justifique");
                        Label dezessete = new Label(16, 0, "10) Os convites digitais foram repassados aos seus clientes para divulgação de seu estande na feira? Se não enviou, por qual motivo?");
                        Label dezoito = new Label(17, 0, "11) Avaliação de tópicos: A) Organização geral da feira:");
                        Label dezenove = new Label(18, 0, "11) Avaliação de tópicos: B) Atendimento ao Expositor:");
                        Label vinte = new Label(19, 0, "11) Avaliação de tópicos: C) Departamento Financeiro:");
                        Label vinteum = new Label(20, 0, "11) Avaliação de tópicos: D) Departamento Comercial:");
                        Label vintedois = new Label(21, 0, "11) Avaliação de tópicos: E) Limpeza da Feira:");
                        Label vintetres = new Label(22, 0, "11) Avaliação de tópicos: F) Segurança da Feira:");
                        Label vintequatro = new Label(23, 0, "11) Avaliação de tópicos: G) Montadora Oficial:");
                        Label vintecinco = new Label(24, 0, "11) Avaliação de tópicos: H) Área de Alimentação:");
                        Label vinteseis = new Label(25, 0, "12) Levando em consideração todos os fatores, sua participação na Expo Franchising ABF Rio "+dataFormatada+" foi: Justifique ?");
                        Label vintesete = new Label(26, 0, "13) Participaria da próxima edição? Justifique");
                        Label vinteoito = new Label(27, 0, "14) Você pretende aumentar, manter ou diminuir a área de seu estande? Caso tenha respondido diminuir, favor justificar?");
                        Label vintenove = new Label(28, 0, "15) Que nota você daria ao evento, sendo nota 1 muito ruim e nota 5 ótimo:");
                        Label trinta = new Label(29, 0, "16) Na sua opinião, quais foram os pontos POSITIVOS da Expo Franchising ABF Rio "+dataFormatada+"?");
                        Label trintaum = new Label(30, 0, "17) Na sua opinião, quais foram os pontos a serem melhorados da Expo Franchising ABF Rio "+dataFormatada+"?");

                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            Pesquisa lista_empresa = postSnapshot.getValue(Pesquisa.class);

                            if (lista_empresa.getmKey().contains("teste") == false) {

                                list1.add((String) postSnapshot.child("nomeEmpresa").getValue());
                                list2.add((String) postSnapshot.child("responsavel").getValue());
                                list3.add((String) postSnapshot.child("cargo").getValue());
                                list4.add((String) postSnapshot.child("cidade").getValue());
                                list5.add((String) postSnapshot.child("empresaExpositora").getValue());
                                list6.add((String) postSnapshot.child("data").getValue());
                                list7.add((String) postSnapshot.child("resposta1").getValue());
                                list8.add((String) postSnapshot.child("resposta2").getValue());
                                list9.add((String) postSnapshot.child("resposta3").getValue());
                                list10.add((String) postSnapshot.child("resposta4").getValue());
                                list11.add((String) postSnapshot.child("resposta5").getValue());
                                list12.add((String) postSnapshot.child("resposta6").getValue());
                                list13.add((String) postSnapshot.child("resposta7A").getValue());
                                list14.add((String) postSnapshot.child("resposta7B").getValue());
                                list15.add((String) postSnapshot.child("resposta8").getValue());
                                list16.add((String) postSnapshot.child("resposta9").getValue());
                                list17.add((String) postSnapshot.child("resposta10").getValue());
                                list18.add((String) postSnapshot.child("resposta11A").getValue());
                                list19.add((String) postSnapshot.child("resposta11B").getValue());
                                list20.add((String) postSnapshot.child("resposta11C").getValue());
                                list21.add((String) postSnapshot.child("resposta11D").getValue());
                                list22.add((String) postSnapshot.child("resposta11E").getValue());
                                list23.add((String) postSnapshot.child("resposta11F").getValue());
                                list24.add((String) postSnapshot.child("resposta11G").getValue());
                                list25.add((String) postSnapshot.child("resposta11H").getValue());
                                list26.add((String) postSnapshot.child("resposta12").getValue());
                                list27.add((String) postSnapshot.child("resposta13").getValue());
                                list28.add((String) postSnapshot.child("resposta14").getValue());
                                list29.add((String) postSnapshot.child("resposta15").getValue());
                                list30.add((String) postSnapshot.child("resposta16").getValue());
                                list31.add((String) postSnapshot.child("resposta17").getValue());

                                for (int z = 1; z <= list1.size(); z++) {
                                    Label label1 = new Label(0, z, list1.get(z - 1));
                                    Label label2 = new Label(1, z, list2.get(z - 1));
                                    Label label3 = new Label(2, z, list3.get(z - 1));
                                    Label label4 = new Label(3, z, list4.get(z - 1));
                                    Label label5 = new Label(4, z, list5.get(z - 1));
                                    Label label6 = new Label(5, z, list6.get(z - 1));
                                    Label label7 = new Label(6, z, list7.get(z - 1));
                                    Label label8 = new Label(7, z, list8.get(z - 1));
                                    Label label9 = new Label(8, z, list9.get(z - 1));
                                    Label label10 = new Label(9, z, list10.get(z - 1));
                                    Label label11 = new Label(10, z, list11.get(z - 1));
                                    Label label12 = new Label(11, z, list12.get(z - 1));
                                    Label label13 = new Label(12, z, list13.get(z - 1));
                                    Label label14 = new Label(13, z, list14.get(z - 1));
                                    Label label15 = new Label(14, z, list15.get(z - 1));
                                    Label label16 = new Label(15, z, list16.get(z - 1));
                                    Label label17 = new Label(16, z, list17.get(z - 1));
                                    Label label18 = new Label(17, z, list18.get(z - 1));
                                    Label label19 = new Label(18, z, list19.get(z - 1));
                                    Label label20 = new Label(19, z, list20.get(z - 1));
                                    Label label21 = new Label(20, z, list21.get(z - 1));
                                    Label label22 = new Label(21, z, list22.get(z - 1));
                                    Label label23 = new Label(22, z, list23.get(z - 1));
                                    Label label24 = new Label(23, z, list24.get(z - 1));
                                    Label label25 = new Label(24, z, list25.get(z - 1));
                                    Label label26 = new Label(25, z, list26.get(z - 1));
                                    Label label27 = new Label(26, z, list27.get(z - 1));
                                    Label label28 = new Label(27, z, list28.get(z - 1));
                                    Label label29 = new Label(28, z, list29.get(z - 1));
                                    Label label30 = new Label(29, z, list30.get(z - 1));
                                    Label label31 = new Label(30, z, list31.get(z - 1));

                                    try {
                                        plan.addCell(label1);
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
                                    } catch (WriteException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }

                        try {
                            plan.addCell(um);
                            plan.addCell(dois);
                            plan.addCell(tres);
                            plan.addCell(quatro);
                            plan.addCell(cinco);
                            plan.addCell(seis);
                            plan.addCell(sete);
                            plan.addCell(oito);
                            plan.addCell(nove);
                            plan.addCell(dez);
                            plan.addCell(onze);
                            plan.addCell(doze);
                            plan.addCell(treze);
                            plan.addCell(catorze);
                            plan.addCell(quinze);
                            plan.addCell(dezesseis);
                            plan.addCell(dezessete);
                            plan.addCell(dezoito);
                            plan.addCell(dezenove);
                            plan.addCell(vinte);
                            plan.addCell(vinteum);
                            plan.addCell(vintedois);
                            plan.addCell(vintetres);
                            plan.addCell(vintequatro);
                            plan.addCell(vintecinco);
                            plan.addCell(vinteseis);
                            plan.addCell(vintesete);
                            plan.addCell(vinteoito);
                            plan.addCell(vintenove);
                            plan.addCell(trinta);
                            plan.addCell(trintaum);

                            wb.write();
                            wb.close();

                        } catch (RowsExceededException e) {
                            e.printStackTrace();
                        } catch (WriteException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(GerarRelatorioActivity.this, "Excel Gerado com Sucesso", Toast.LENGTH_LONG).show();
                        arquivo.setText("Arquivo Gerado : MeuRelatorio.xls");
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("error=" + databaseError.getMessage());
                    }
                });
            }
        });
    }
}
