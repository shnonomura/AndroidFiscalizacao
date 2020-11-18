package br.com.fiscalizacao.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.fiscalizacao.R;
import br.com.fiscalizacao.adapter.OsDetailsAdapter;
import br.com.fiscalizacao.model.ItemOsModel;
import br.com.fiscalizacao.model.OsModel;

public class DetailOs extends AppCompatActivity {

    public DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    private ArrayList<ItemOsModel> mDetailList = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private OsDetailsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static final String NUM_OS = "num_os";
    public String os_selecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_os);

        mostra_OS_selecionada();

        //cria_detalhes_Os(os_selecionada);

        //OsModel os = criaOs();
        //enviaOsFirebase(os);

    } // fim do método onCreate


    private OsModel criaOs() {

        OsModel os = new OsModel("0005", "2020742123541", false, false);
        ItemOsModel item1 = new ItemOsModel(
                "001",
                "Mola hidraulica",
                1.0,
                "un",
                120.00
        );

        ItemOsModel item2 = new ItemOsModel(
                "002",
                "Mola hidraulica",
                1.0,
                "un",
                120.00
        );

        List<ItemOsModel> itens = new ArrayList<>();
            itens.add(item1);
            itens.add(item2);
        os.setItensList(itens);

        return os;

    } // fim método criaOs()


    private void enviaOsFirebase(OsModel os) {

        //ref.child("novaos").push().setValue(os);
        ref.child("os").child(os.getOs()).setValue(os);

    } // fim do método enviaOsFirebase

    public void mostra_OS_selecionada(){

        Intent intent = getIntent();
        os_selecionada = intent.getStringExtra(NUM_OS); // nome fiscal
        TextView os = findViewById(R.id.os_number);
        os.setText(os_selecionada);
    } // fim do método mostra_OS_selecionada




    public void cria_detalhes_Os(String os_selecionada){

        Query query1 = ref.child("os").orderByChild("os").equalTo(os_selecionada);

        query1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //listOs.clear();
                for(DataSnapshot objSnapshot:snapshot.getChildren()) {
                    ItemOsModel os = objSnapshot.getValue(ItemOsModel.class);

                    ItemOsModel capturaDetalhesOs = new ItemOsModel();
                    /*String codigo = os.getCod_item();

                    String descricao = os.getDescr_item();
                    String qtde = os.getQtde_item();
                    String unidade = os.getUnidade_item();
                    String preco_unit = os.getPunit_item();*/
                    /*Log.i("Fis código item ; " , "codigo");
                    Log.i("Fis descricao item ; " , descricao);
                    Log.i("Fis qtde item ; " , qtde);
                    Log.i("Fis unidade item ; " , unidade);
                    Log.i("Fis preco_unit item ; " , preco_unit);*/
                    capturaDetalhesOs.setCod_item(os.getCod_item());
                    capturaDetalhesOs.setDescr_item(os.getDescr_item());
                    capturaDetalhesOs.setQtde_item(os.getQtde_item());
                    capturaDetalhesOs.setUnidade_item(os.getUnidade_item());
                    capturaDetalhesOs.setPunit_item(os.getPunit_item());

                    mDetailList.add(capturaDetalhesOs);

                    OsDetailsAdapter adapter = new OsDetailsAdapter(mDetailList);

                    RecyclerView recyclerView = findViewById(R.id.osList_recycler);

                    // configurar recyclerview
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
                    recyclerView.setAdapter(adapter);

                } // fim do for

            } // fim método onDataChange(DataSnapshot snapshot)

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Log.i("Fisc Erro xxx--x-x-x-x-x", error.toException().toString());
                //makeText(this,"Erro ao executar a Intent que direciona o aplicativo para Itens da OS", LENGTH_LONG).show();

            } // fim método onCancelled().

        }); // fim do query1.addListenerForSingleValueEvent

    } // fim do método cria_detalhes_Os

} // fim da class DetailOs