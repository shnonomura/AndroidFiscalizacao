package br.com.fiscalizacao.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.fiscalizacao.R;
import br.com.fiscalizacao.model.OsModel;

public class OsAdapter extends RecyclerView.Adapter<OsAdapter.OsViewHolder> {

    private List<OsModel> listaOs;

    public OsAdapter(List<OsModel> lista) {

        this.listaOs = lista;

    }


    public OsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.adapter_os, parent,false);

        return new OsViewHolder(itemLista);
    }

    public void onBindViewHolder(OsViewHolder holder, int position) {

        OsModel dadosOs = listaOs.get(position);
        holder.os.setText(dadosOs.getOs());
        holder.contrato.setText(dadosOs.getContrato());
        holder.fiscalizada.setChecked(dadosOs.getFiscalizada());
        holder.analisada.setChecked(dadosOs.getAnalisada());

        /*OsModel dadosOs = listaOs.get(position);
        holder.os.setText("OS 213213246");
        holder.contrato.setText("20201337468");
        holder.fiscalizada.setChecked(true);
        holder.analisada.setChecked(false); */
    }

    public int getItemCount() {

        Log.i( "Fisc : número itens", String.valueOf(listaOs.size()));
        return listaOs.size();
    }

    public class OsViewHolder extends RecyclerView.ViewHolder{

        TextView os;
        TextView contrato;
        CheckBox analisada;
        CheckBox fiscalizada;

        public OsViewHolder(View itemView) {
            super(itemView);
            os = itemView.findViewById(R.id.textOs);
            contrato = itemView.findViewById(R.id.textContrato);
            analisada = itemView.findViewById(R.id.checkAnalisada);
            fiscalizada = itemView.findViewById(R.id.checkFiscalizada);
        }
    }
}
