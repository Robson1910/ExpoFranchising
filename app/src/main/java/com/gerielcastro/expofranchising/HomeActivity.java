package com.gerielcastro.expofranchising;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.gerielcastro.expofranchising.Classes.ListaAdapter;
import com.gerielcastro.expofranchising.Classes.Pesquisa;
import com.gerielcastro.expofranchising.Delete.DeleteBancoActivity;
import com.gerielcastro.expofranchising.Delete.DeleteMemoriaActivity;
import com.gerielcastro.expofranchising.Formulario.Formulario1Activity;
import com.gerielcastro.expofranchising.Gerar_ArquivoXML.EnviarEmailActivity;
import com.gerielcastro.expofranchising.Gerar_ArquivoXML.GerarRelatorioActivity;
import com.gerielcastro.expofranchising.Gerar_ArquivoXML.InformacaoActivity;

import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MaterialSearchView searchView;
    private ListView listView;
    private DatabaseReference firebase;
    private FirebaseAuth auth;
    private ValueEventListener mDBListener;
    private Toolbar toolbarTop;
    private String information = "".toLowerCase();
    private ListaAdapter mAdapter;
    private List<Pesquisa> mUploads;
    private ProgressBar mProgressCircle;
    private FloatingActionButton fab;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Toolbar toolbar = findViewById(R.id.toolbar);
        searchView = (MaterialSearchView) findViewById(R.id.search_view1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        listView = (ListView) findViewById(R.id.listCadastrados);
        mProgressCircle = findViewById(R.id.progressBar2);

        fab = (FloatingActionButton) findViewById(R.id.fab1);

        mUploads = new ArrayList<>();
        mAdapter = new ListaAdapter(HomeActivity.this, (ArrayList<Pesquisa>) mUploads);
        listView.setAdapter(mAdapter);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Formulario1Activity.class);
                startActivity(intent);
            }
        });

        checkFilePermissions();

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

                TextView nome_empresa = (TextView) view.findViewById(R.id.nome_empresa_text);
                TextView responsavel = (TextView) view.findViewById(R.id.responsave_text);
                TextView cargo = (TextView) view.findViewById(R.id.cargo_text);
                TextView cidade = (TextView) view.findViewById(R.id.cidade_text);
                TextView empresa_expositora = (TextView) view.findViewById(R.id.empresa_expositora_text);
                TextView data = (TextView) view.findViewById(R.id.nome_data_text);

                TextView resposta1 = (TextView) view.findViewById(R.id.resposta1_text);
                TextView resposta2 = (TextView) view.findViewById(R.id.resposta2_text);
                TextView resposta3 = (TextView) view.findViewById(R.id.resposta3_text);
                TextView resposta4 = (TextView) view.findViewById(R.id.resposta4_text);
                TextView resposta5 = (TextView) view.findViewById(R.id.resposta5_text);
                TextView resposta6 = (TextView) view.findViewById(R.id.resposta6_text);
                TextView resposta7A = (TextView) view.findViewById(R.id.resposta7A_text);
                TextView resposta7B = (TextView) view.findViewById(R.id.resposta7B_text);
                TextView resposta8 = (TextView) view.findViewById(R.id.resposta8_text);
                TextView resposta9 = (TextView) view.findViewById(R.id.resposta9_text);
                TextView resposta10 = (TextView) view.findViewById(R.id.resposta10_text);
                TextView resposta11A = (TextView) view.findViewById(R.id.resposta11A_text);
                TextView resposta11B = (TextView) view.findViewById(R.id.resposta11B_text);
                TextView resposta11C = (TextView) view.findViewById(R.id.resposta11C_text);
                TextView resposta11D = (TextView) view.findViewById(R.id.resposta11D_text);
                TextView resposta11E = (TextView) view.findViewById(R.id.resposta11E_text);
                TextView resposta11F = (TextView) view.findViewById(R.id.resposta11F_text);
                TextView resposta11G = (TextView) view.findViewById(R.id.resposta11G_text);
                TextView resposta11H = (TextView) view.findViewById(R.id.resposta11H_text);
                TextView resposta12 = (TextView) view.findViewById(R.id.resposta12_text);
                TextView resposta13 = (TextView) view.findViewById(R.id.resposta13_text);
                TextView resposta14 = (TextView) view.findViewById(R.id.resposta14_text);
                TextView resposta15 = (TextView) view.findViewById(R.id.resposta15_text);
                TextView resposta16 = (TextView) view.findViewById(R.id.resposta16_text);
                TextView resposta17 = (TextView) view.findViewById(R.id.resposta17_text);

                Intent intent = new Intent(HomeActivity.this, InformacaoActivity.class);

                intent.putExtra("nome_empresa", nome_empresa.getText().toString());
                intent.putExtra("responsavel", responsavel.getText().toString());
                intent.putExtra("cargo", cargo.getText().toString());
                intent.putExtra("cidade", cidade.getText().toString());
                intent.putExtra("empresa_expositora", empresa_expositora.getText().toString());
                intent.putExtra("data", data.getText().toString());

                intent.putExtra("resposta1", resposta1.getText().toString());
                intent.putExtra("resposta2", resposta2.getText().toString());
                intent.putExtra("resposta3", resposta3.getText().toString());
                intent.putExtra("resposta4", resposta4.getText().toString());
                intent.putExtra("resposta5", resposta5.getText().toString());
                intent.putExtra("resposta6", resposta6.getText().toString());
                intent.putExtra("resposta7A", resposta7A.getText().toString());
                intent.putExtra("resposta7B", resposta7B.getText().toString());
                intent.putExtra("resposta8", resposta8.getText().toString());
                intent.putExtra("resposta9", resposta9.getText().toString());
                intent.putExtra("resposta10", resposta10.getText().toString());
                intent.putExtra("resposta11A", resposta11A.getText().toString());
                intent.putExtra("resposta11B", resposta11B.getText().toString());
                intent.putExtra("resposta11C", resposta11C.getText().toString());
                intent.putExtra("resposta11D", resposta11D.getText().toString());
                intent.putExtra("resposta11E", resposta11E.getText().toString());
                intent.putExtra("resposta11F", resposta11F.getText().toString());
                intent.putExtra("resposta11G", resposta11G.getText().toString());
                intent.putExtra("resposta11H", resposta11H.getText().toString());
                intent.putExtra("resposta12", resposta12.getText().toString());
                intent.putExtra("resposta13", resposta13.getText().toString());
                intent.putExtra("resposta14", resposta14.getText().toString());
                intent.putExtra("resposta15", resposta15.getText().toString());
                intent.putExtra("resposta16", resposta16.getText().toString());
                intent.putExtra("resposta17", resposta17.getText().toString());

                startActivity(intent);
            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_excel) {
            Intent intent = new Intent(HomeActivity.this, GerarRelatorioActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_email) {
            Intent intent = new Intent(HomeActivity.this, EnviarEmailActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_memoria) {
            Intent intent = new Intent(HomeActivity.this, DeleteMemoriaActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_banco) {
            Intent intent = new Intent(HomeActivity.this, DeleteBancoActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_sair) {
            auth.getInstance().signOut();
            goLoginScreen();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void goLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
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

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void checkFilePermissions() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            int permissionCheck = this.checkSelfPermission("Manifest.permission.READ_EXTERNAL_STORAGE");
            permissionCheck += this.checkSelfPermission("Manifest.permission.WRITE_EXTERNAL_STORAGE");
            if (permissionCheck != 0) {

                this.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1001); //Any number
            }
        } else {
            Log.d("SDK Permissions", "checkBTPermissions: No need to check permissions. SDK version < LOLLIPOP.");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebase.removeEventListener(mDBListener);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }

}
