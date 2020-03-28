package com.gerielcastro.expofranchising.Delete;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gerielcastro.expofranchising.Classes.ListaAdapter;
import com.gerielcastro.expofranchising.Classes.Pesquisa;
import com.gerielcastro.expofranchising.HomeActivity;
import com.gerielcastro.expofranchising.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class DeleteBancoActivity extends AppCompatActivity {

    private MaterialSearchView searchView;
    private ListView listView;
    private DatabaseReference firebase;
    private String information = "".toLowerCase();
    private ListaAdapter mAdapter;
    private List<Pesquisa> mUploads;
    private ProgressBar mProgressCircle;
    private ValueEventListener mDBListener;
    private ImageView back;
    private Pesquisa excluir;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_banco);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        Toolbar toolbar = findViewById(R.id.toolbar56);
        searchView = (MaterialSearchView) findViewById(R.id.search_view2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        listView = (ListView) findViewById(R.id.listadado);
        mProgressCircle = findViewById(R.id.progressBar3);

        mUploads = new ArrayList<>();
        mAdapter = new ListaAdapter(DeleteBancoActivity.this, (ArrayList<Pesquisa>) mUploads);
        listView.setAdapter(mAdapter);
        back = (ImageView) findViewById(R.id.arrow_back_deletebanco);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeleteBancoActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        searchView(information);

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(final String newText) {
                searchView(newText);
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                excluir = mAdapter.getItem(i);

                AlertDialog.Builder builder = new AlertDialog.Builder(DeleteBancoActivity.this);
                builder.setTitle("Confirma Exclusão ?");
                builder.setMessage("Você deseja Excluir - " + excluir.getNomeEmpresa() + " ?");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        firebase = FirebaseDatabase.getInstance().getReference("Pesquisa");
                        firebase.child(excluir.getmKey()).removeValue();
                        Toast.makeText(DeleteBancoActivity.this, "Dados excluido com sucesso", Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DeleteBancoActivity.this, "Dados não excluido", Toast.LENGTH_LONG).show();
                    }
                });

                alerta = builder.create();
                alerta.show();
            }
        });
    }

    private void searchView(final String string) {

        firebase = FirebaseDatabase.getInstance().getReference("Pesquisa");
        firebase.keepSynced(true);
        mDBListener = firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mUploads.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Pesquisa lista_empresa = postSnapshot.getValue(Pesquisa.class);

                    String pesquisa_lista = lista_empresa.getNomeEmpresa().toLowerCase();

                    if (lista_empresa.getmKey().contains("teste") == false) {
                        if (string.isEmpty()) {
                            mUploads.add(lista_empresa);
                        } else if (pesquisa_lista.contains(string)) {
                            mUploads.add(lista_empresa);
                        }
                    }
                }
                mAdapter.notifyDataSetChanged();
                mProgressCircle.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("error=" + databaseError.getMessage());
                mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebase.removeEventListener(mDBListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }
}
