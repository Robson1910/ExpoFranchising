package com.gerielcastro.expofranchising.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gerielcastro.expofranchising.R;

import java.util.ArrayList;

public class ListaAdapter extends ArrayAdapter<Pesquisa> {
    private ArrayList<Pesquisa> empresas;
    private Context context;

    public ListaAdapter(Context c, ArrayList<Pesquisa> objects) {
        super(c, 0, objects);
        this.context = c;
        this.empresas = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if (empresas != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_empresa, parent, false);

            TextView inicial = (TextView) view.findViewById(R.id.responsave_text_data);
            TextView ID = (TextView) view.findViewById(R.id.userId_text);
            TextView nome_empresa = (TextView) view.findViewById(R.id.nome_empresa_text);
            TextView responsavel = (TextView) view.findViewById(R.id.responsave_text);
            TextView cargo = (TextView) view.findViewById(R.id.cargo_text);
            TextView cidade = (TextView) view.findViewById(R.id.cidade_text);
            TextView empresa_expositora = (TextView) view.findViewById(R.id.empresa_expositora_text);
            TextView data = (TextView) view.findViewById(R.id.nome_data_text);
            TextView key = (TextView) view.findViewById(R.id.key_text);

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

            Pesquisa empresa2 = empresas.get(position);

            inicial.setText(empresa2.getData()+" - "+empresa2.getResponsavel());

            ID.setText(empresa2.getUserId());
            nome_empresa.setText(empresa2.getNomeEmpresa());
            responsavel.setText(empresa2.getResponsavel());
            cargo.setText(empresa2.getCargo());
            cidade.setText(empresa2.getCidade());
            data.setText(empresa2.getData());
            empresa_expositora.setText(empresa2.getEmpresaExpositora());
            key.setText(empresa2.getmKey());

            resposta1.setText(empresa2.getResposta1());
            resposta2.setText(empresa2.getResposta2());
            resposta3.setText(empresa2.getResposta3());
            resposta4.setText(empresa2.getResposta4());
            resposta5.setText(empresa2.getResposta5());
            resposta6.setText(empresa2.getResposta6());
            resposta7A.setText(empresa2.getResposta7A());
            resposta7B.setText(empresa2.getResposta7B());
            resposta8.setText(empresa2.getResposta8());
            resposta9.setText(empresa2.getResposta9());
            resposta10.setText(empresa2.getResposta10());
            resposta11A.setText(empresa2.getResposta11A());
            resposta11B.setText(empresa2.getResposta11B());
            resposta11C.setText(empresa2.getResposta11C());
            resposta11D.setText(empresa2.getResposta11D());
            resposta11E.setText(empresa2.getResposta11E());
            resposta11F.setText(empresa2.getResposta11F());
            resposta11G.setText(empresa2.getResposta11G());
            resposta11H.setText(empresa2.getResposta11H());
            resposta12.setText(empresa2.getResposta12());
            resposta13.setText(empresa2.getResposta13());
            resposta14.setText(empresa2.getResposta14());
            resposta15.setText(empresa2.getResposta15());
            resposta16.setText(empresa2.getResposta16());
            resposta17.setText(empresa2.getResposta17());

        }
        return view;
    }
}
