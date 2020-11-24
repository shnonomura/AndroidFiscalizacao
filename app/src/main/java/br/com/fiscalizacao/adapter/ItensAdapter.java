package br.com.fiscalizacao.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.fiscalizacao.R;
import br.com.fiscalizacao.model.ItensModel;

public class ItensAdapter extends RecyclerView.Adapter<ItensAdapter.OsDetailViewHolder> {

    private final List<ItensModel> mItensList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onClick(int position);
        void onSaveClick(int position, double qtde_item);

    }

    public void setOnItemClickListener(ItensAdapter.OnItemClickListener listener){
        mListener = listener;

    }

    // construtor do Adapter
    public ItensAdapter(List<ItensModel>detailsList){
        mItensList = detailsList;
    }


    public static class OsDetailViewHolder extends RecyclerView.ViewHolder{

    public TextView mcod_item;
    public TextView mdescr_item;
    public EditText mqtde_item;
    public TextView munidade;
    public TextView mpunit_item;
    public TextView mptot_item;
    public ImageView msave_item;

        // construtor OsDetailViewHolder
        public OsDetailViewHolder(View itemView, final OnItemClickListener listener){
            super(itemView);

            mcod_item = itemView.findViewById(R.id.cod_item);
            mdescr_item = itemView.findViewById(R.id.descr_item);
            mqtde_item = itemView.findViewById(R.id.qtde_item);
            munidade = itemView.findViewById(R.id.unidade_item);
            mpunit_item = itemView.findViewById(R.id.punit_item);
            mptot_item = itemView.findViewById(R.id.ptotal_item);
            msave_item = itemView.findViewById(R.id.image_save);

            msave_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){

                        double qtde_item = Double.parseDouble(mqtde_item.getText().toString());
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onSaveClick(position, qtde_item);
                        }
                    }
                }
            });

        } // fim do construtor da classe OsDetailViewHolder


    } // fim da class OsDetailViewHolder


    @NonNull
    @Override
    public OsDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_adapter_itens,parent,false);
        OsDetailViewHolder detailViewHolder = new OsDetailViewHolder(v, mListener);
        return detailViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull OsDetailViewHolder holder, int position) {
        ItensModel currentItem = mItensList.get(position);

        holder.mcod_item.setText(currentItem.getCod_item());
        holder.mdescr_item.setText(currentItem.getDescr_item());
        holder.mqtde_item.setText(String.valueOf(currentItem.getQtde_item()));
        holder.munidade.setText(currentItem.getUnidade_item());
        holder.mpunit_item.setText(String.valueOf(currentItem.getPunit_item()));
        holder.mptot_item.setText(String.valueOf(currentItem.getPtotal_item()));

    }

    @Override
    public int getItemCount() {
        return mItensList.size();
    }



} // fim da class ItensAdapter
