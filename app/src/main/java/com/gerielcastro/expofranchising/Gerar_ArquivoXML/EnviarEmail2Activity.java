package com.gerielcastro.expofranchising.Gerar_ArquivoXML;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gerielcastro.expofranchising.HomeActivity;
import com.gerielcastro.expofranchising.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EnviarEmail2Activity extends AppCompatActivity {

    private String itemValue = "";
    private TextView arquivo;
    private ListView lvInternalStorage;
    private ImageView back;
    private ArrayList<String> listItem;
    private ArrayAdapter<String> adapter;
    private String[] itens;
    private File file;
    private List<String> minhaLista;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_email2);

        lvInternalStorage = (ListView) findViewById(R.id.listarquivo);
        arquivo = (TextView) findViewById(R.id.information_arquivo1);
        back = (ImageView) findViewById(R.id.arrow_back_enviaremail12);
        enviar = (Button) findViewById(R.id.btnemailenviar);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnviarEmail2Activity.this, EnviarEmailActivity.class);
                startActivity(intent);
                finish();
            }
        });

        minhaLista = new ArrayList<String>();
        String root_sd = Environment.getExternalStorageDirectory().toString();
        file = new File(root_sd + "/Android/data/com.gerielcastro.expofranchising/files/Arquivo");
        File list[] = file.listFiles();

        for (int i = 0; i < list.length; i++) {
            if (list[i].getName().contains("tpk12562asdaduhygasdbjnl.xls") == false) {
                minhaLista.add(list[i].getName());
            }
        }

        adapter = new ArrayAdapter<String>(this, R.layout.mytextview, minhaLista);
        adapter.notifyDataSetChanged();
        lvInternalStorage.setAdapter(adapter);

        lvInternalStorage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                itemValue = (String) lvInternalStorage.getItemAtPosition(i);
                arquivo.setText(itemValue);

            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());

                final Bundle extra = getIntent().getExtras();
                String email = extra.getString("email");
                String assunto = extra.getString("assunto");
                String mensagem = extra.getString("mensagem");

                if (itemValue.isEmpty()) {
                    Toast.makeText(view.getContext(), "Escolhe o Arquivo", Toast.LENGTH_SHORT).show();
                } else {

                    File file = new File(getExternalFilesDir("Arquivo"), itemValue);
                    Uri path = Uri.fromFile(file);

                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setType("vnd.android.cursor.dir/email");
                    String to[] = {email};
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
                    emailIntent.putExtra(Intent.EXTRA_STREAM, path);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, assunto);
                    emailIntent.putExtra(Intent.EXTRA_TEXT, mensagem);

                    startActivity(Intent.createChooser(emailIntent, "enviando email..."));
                }
            }
        });
    }
}
