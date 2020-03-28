package com.gerielcastro.expofranchising.Delete;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gerielcastro.expofranchising.Gerar_ArquivoXML.InformacaoActivity;
import com.gerielcastro.expofranchising.HomeActivity;
import com.gerielcastro.expofranchising.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class DeleteMemoriaActivity extends AppCompatActivity {

    private TextView text1;
    private ListView lvInternalStorage;
    private ArrayList<String> listItem;
    private ArrayAdapter<String> adapter;
    private String[] itens;
    private File file;
    private List<String> minhaLista;
    private ImageView back;
    private String itemValue = "";
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_memoria);

        text1 = (TextView) findViewById(R.id.arquivoescolhido);
        lvInternalStorage = (ListView) findViewById(R.id.listarquivo);
        back = (ImageView) findViewById(R.id.arrow_back_deletememoria);

        arquivo_aleatorio();

        delete();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeleteMemoriaActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void delete() {

        minhaLista = new ArrayList<String>();

        String root_sd = Environment.getExternalStorageDirectory().toString();
        file = new File(root_sd + "/Android/data/com.gerielcastro.expofranchising/files/Arquivo");
        File list[] = file.listFiles();

        for (int i = 0; i < list.length; i++) {

            if (list[i].getName().contains("tpk12562asdaduhygasdbjnl.xls") == false) {
                minhaLista.add(list[i].getName());
            }
        }
        if (minhaLista.isEmpty()) {
            text1.setText("Lista Vazia");
        } else if (minhaLista.contains("tpk12562asdaduhygasdbjnl.xls")) {
            text1.setText("Lista Vazia");
        }
        adapter = new ArrayAdapter<String>(this, R.layout.mytextview, minhaLista);
        adapter.notifyDataSetChanged();
        lvInternalStorage.setAdapter(adapter);

        lvInternalStorage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                itemValue = (String) lvInternalStorage.getItemAtPosition(i);

                AlertDialog.Builder builder = new AlertDialog.Builder(DeleteMemoriaActivity.this);
                builder.setTitle("Confirma Exclusão ?");
                builder.setMessage("Você deseja Excluir - " + itemValue + " ?");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        File file = new File(getExternalFilesDir("Arquivo"), itemValue);
                        boolean p = new File(String.valueOf(file)).delete();
                        if (p) {
                            text1.setText("Deletado com sucesso!");

                        } else {
                            text1.setText("Arquivo não deletado!");
                        }
                        delete();
                    }
                });

                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DeleteMemoriaActivity.this, "Arquivo não excluido", Toast.LENGTH_LONG).show();
                    }
                });

                alerta = builder.create();
                alerta.show();

            }
        });
    }

    public void arquivo_aleatorio() {

        File file = new File(
                getExternalFilesDir("Arquivo"),
                "tpk12562asdaduhygasdbjnl.xls");

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

