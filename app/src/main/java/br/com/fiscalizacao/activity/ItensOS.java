package br.com.fiscalizacao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    public static final String NUM_OS = "num_os";
    public String os_selecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens);


        mostra_OS_selecionada();

        //Log.i("Fisc - onCreate - antes passar como parâmetro de mostraItens : " , os_selecionada);
        mostraItens(os_selecionada);



        //enviaOsFirebase(os);

    } // fim do método onCreate

/*

    private void enviaOsFirebase(OsModel os) {

        //ref.child("novaos").push().setValue(os);
        ref.child("os").child(os.getOs()).setValue(os);

    } // fim do método enviaOsFirebase
*/


    public void mostra_OS_selecionada(){

        Intent intent = getIntent();
        os_selecionada = intent.getStringExtra(NUM_OS); // número OS
        TextView os = findViewById(R.id.os_number);
        os.setText(os_selecionada);
        //Log.i("Fisc - dentro metodo mostra_OS_selecionada - mostra value de os_selecionada", os_selecionada);
    } // fim do método mostra_OS_selecionada


    public void mostraItens(String os_selecionada){

        Query query1 = ref.child("os").orderByChild("os").equalTo(os_selecionada);

        query1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ArrayList<ItensModel> listItens = new ArrayList<>();
                ItensModel item = new ItensModel();
                OsModel os = new OsModel();


                Log.i(": Fisc - dados snapshot ", snapshot.getValue().toString());

                Iterable<DataSnapshot> it = snapshot.getChildren();

                for (DataSnapshot dados : it){
                    os = dados.getValue(OsModel.class);
                }


                String nr_os = os.getOs();

/*                Log.i(": Fisc - os ", nr_os);
                Log.i(": Fisc - contrato ", os.getContrato());
                Log.i(": Fisc - fiscal ", os.getFiscal());
                Log.i(": Fisc - sit fiscalizada ", String.valueOf(os.getFiscalizada()));
                Log.i(": Fisc - sit analisada ", String.valueOf(os.getAnalisada()));*/

                Log.i(": Fisc - qtde itens " , String.valueOf(os.getItens().size()));

                for( int i=0 ; i < os.getItens().size() ; i++){

                    String codItem = os.getItens().get(i).getCod_item();
                    String descr_item = os.getItens().get(i).getDescr_item();
                    Double qtde_item =  os.getItens().get(i).getQtde_item();
                    String unid_item = os.getItens().get(i).getUnidade_item();
                    Double pr_item = os.getItens().get(i).getPunit_item();

                    item = new ItensModel(codItem, descr_item, qtde_item, unid_item, pr_item);
                    Log.i(": Fisc - item da OS " , item.getCod_item()+item.getDescr_item());
                    listItens.add(item);
                }

                // itens Adapter precisa receber um Arraylist
                ItensAdapter adapter = new ItensAdapter(listItens);

                    RecyclerView recyclerView = findViewById(R.id.osList_recycler);

                    // configurar recyclerview
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
                    recyclerView.setAdapter(adapter);



            } // fim método onDataChange(DataSnapshot snapshot)

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Log.i("Fisc Erro xxx--x-x-x-x-x", error.toException().toString());
                //makeText(this,"Erro ao executar a Intent que direciona o aplicativo para Itens da OS", LENGTH_LONG).show();

            } // fim método onCancelled().

        }); // fim do query1.addListenerForSingleValueEvent

    } // fim do método cria_detalhes_Os

} // fim da class ItensOS