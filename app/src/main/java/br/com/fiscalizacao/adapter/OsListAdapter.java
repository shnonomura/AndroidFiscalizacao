package br.com.fiscalizacao.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import br.com.fiscalizacao.R;
import br.com.fiscalizacao.model.OsModel;

public class  OsListAdapter extends RecyclerView.Adapter<OsListAdapter.OsViewHolder>  {

    // este é o Adapter do Recyclerview da OrdensFiscal Activity

    private final List<OsModel> listaOs;
    private int position;
    private OnItemClickListener mListener;



    // construtor
    public OsListAdapter(List<OsModel> lista) {

        this.listaOs = lista;
    }


    @NotNull
    public OsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.cardview_adapter_os, parent,false);

        return new OsViewHolder(cv, mListener);
    }

    public void onBindViewHolder(OsViewHolder holder, final int position) {

        final CardView cardView = holder.cardView;
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

        //Log.i( "Fisc : osListAadapter - número itens", String.valueOf(listaOs.size()));
        return listaOs.size();
    }

    public interface OnItemClickListener{

        void onItemClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;

    }

    public static class OsViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public TextView os;
        public TextView contrato;
        public CheckBox analisada;
        public CheckBox fiscalizada;

        public OsViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            os = itemView.findViewById(R.id.textOs);
            contrato = itemView.findViewById(R.id.textContrato);
            analisada = itemView.findViewById(R.id.checkAnalisada);
            fiscalizada = itemView.findViewById(R.id.checkFiscalizada);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!= null){
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }  // fim do construtor OsViewHolder que tem como parâmetro uma view

    } // fim da class OsViewHolder
}
