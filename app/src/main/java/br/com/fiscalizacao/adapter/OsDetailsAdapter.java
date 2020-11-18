package br.com.fiscalizacao.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.fiscalizacao.R;
import br.com.fiscalizacao.model.ItemOsModel;

public class OsDetailsAdapter extends RecyclerView.Adapter<OsDetailsAdapter.OsDetailViewHolder> {

    private ArrayList<ItemOsModel> mOsDetailsList;
    private OnItemClickListener mListener;

    public static class OsDetailViewHolder extends RecyclerView.ViewHolder{

    public TextView mcod_item;
    public TextView mdescr_item;
    public EditText mqtde_item;
    public TextView munidade;
    public TextView mpunit_item;

        // construtor OsDetailViewHolder
        public OsDetailViewHolder(View itemView){
            super(itemView);

            mcod_item = itemView.findViewById(R.id.cod_item);
            mdescr_item = itemView.findViewById(R.id.descr_item);
            mqtde_item = itemView.findViewById(R.id.qtde_item);
            munidade = itemView.findViewById(R.id.unidade_item);
            mpunit_item = itemView.findViewById(R.id.punit_item);

        } // fim do construtor da classe OsDetailViewHolder


    } // fim da class OsDetailViewHolder

    // construtor do Adapter
    public OsDetailsAdapter(ArrayList<ItemOsModel> detailsList){
        mOsDetailsList = detailsList;
    }

    @NonNull
    @Override
    public OsDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_adapter_os_details,parent,false);
        OsDetailViewHolder detailViewHolder = new OsDetailViewHolder(v);
        return detailViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull OsDetailViewHolder holder, int position) {
        ItemOsModel currentItem = mOsDetailsList.get(position);

        holder.mcod_item.setText(currentItem.getCod_item());
        holder.mdescr_item.setText(currentItem.getDescr_item());
        holder.mqtde_item.setText(String.valueOf(currentItem.getQtde_item()));
        holder.munidade.setText(currentItem.getUnidade_item());
        holder.mpunit_item.setText(String.valueOf(currentItem.getPunit_item()));

    }

    @Override
    public int getItemCount() {
        return mOsDetailsList.size();
    }

    public interface OnItemClickListener{

        void onItemClick(int position);

    }

    public void setOnItemClickListener(OsDetailsAdapter.OnItemClickListener listener){
        mListener = listener;

    }


} // fim da class OsDetailsAdapter
