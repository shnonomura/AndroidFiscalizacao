
package br.com.fiscalizacao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import br.com.fiscalizacao.R;
import br.com.fiscalizacao.adapter.ItensAdapter;
import br.com.fiscalizacao.model.ItensModel;
import br.com.fiscalizacao.model.OsModel;

public class ItensOS extends AppCompatActivity {

    public DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    private RecyclerView mRecyclerView;
    private ItensAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<ItensModel> listItens = new ArrayList<>();

    private Button buttonConforme;

    public static final String NUM_OS = "num_os";
    public String os_selecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens);

        mostra_OS_selecionada();
        mostraItens(os_selecionada);

    } // fim do método onCreate


    public void mostra_OS_selecionada(){

        Intent intent = getIntent();
        os_selecionada = intent.getStringExtra(NUM_OS); // número OS
        TextView os = findViewById(R.id.os_number);
        os.setText("Ordem de Serviço " + os_selecionada);

    } // fim do método mostra_OS_selecionada


    public void mostraItens(String os_selecionada){


        Query query1 = ref.child("os").orderByChild("os").equalTo(os_selecionada);
        query1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ItensModel item = new ItensModel();
                OsModel os = new OsModel();
                Double total_OS = 0.0;

                //Log.i(": Fisc - dados snapshot ", snapshot.getValue().toString());
                // Iterador para buscar a OS com os respectivos itens
                Iterable<DataSnapshot> it = snapshot.getChildren();

                for (DataSnapshot dados : it){
                    os = dados.getValue(OsModel.class);
                }

                String nr_os = os.getOs();

                Log.i(": Fisc - qtde itens " , String.valueOf(os.getItens().size()));

                for( int i=0 ; i < os.getItens().size() ; i++){

                    String codItem = os.getItens().get(i).getCod_item();
                    String descr_item = os.getItens().get(i).getDescr_item();
                    Double qtde_item =  os.getItens().get(i).getQtde_item();
                    String unid_item = os.getItens().get(i).getUnidade_item();
                    Double pr_item = os.getItens().get(i).getPunit_item();
                    Double pr_totItem = (qtde_item * pr_item);

                    //total_OS = total_OS + pr_totItem;

                    item = new ItensModel(codItem, descr_item, qtde_item, unid_item, pr_item, pr_totItem);
                    Log.i(": Fisc - item da OS " , item.getCod_item()+"   "+item.getDescr_item());
                    listItens.add(item);
                }

                // Mostrar o total da OS
                //TextView total = findViewById(R.id.os_total);
                //total.setText("R$ " + total_OS);

                // itens Adapter precisa receber um Arraylist
                ItensAdapter mAdapter = new ItensAdapter(listItens);

                RecyclerView recyclerView = findViewById(R.id.osList_recycler);

                // configurar recyclerview
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
                recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
                recyclerView.setAdapter(mAdapter);

                mAdapter.setOnItemClickListener(new ItensAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(int position) {

                    }

                    @Override
                    public void onSaveClick(int position, double qtde) {
                        grava_firebase(nr_os, position, qtde);
                        listItens.get(position).changeQtde(qtde);
                        mAdapter.notifyItemChanged(position);

                    }
                }) ;



            } // fim método onDataChange(DataSnapshot snapshot)

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            } // fim método onCancelled().

        }); // fim do query1.addListenerForSingleValueEvent

    } // fim do método cria_detalhes_Os

    private void grava_firebase(String os, int position, double qtde){


    }

} // fim da class ItensOS