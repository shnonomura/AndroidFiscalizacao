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
import br.com.fiscalizacao.adapter.OsListAdapter;
import br.com.fiscalizacao.model.OsDetailsModel;
import br.com.fiscalizacao.model.OsModel;

public class DetailOs extends AppCompatActivity {

    public DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    private ArrayList<OsDetailsModel> mDetailList = new ArrayList<>();

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

        cria_detalhes_Os(os_selecionada);

    } // fim do método onCreate

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
                    OsDetailsModel os = objSnapshot.getValue(OsDetailsModel.class);

                    OsDetailsModel capturaDetalhesOs = new OsDetailsModel();

                    capturaDetalhesOs.setCod_item(os.getCod_item());
                    capturaDetalhesOs.setDescr_item(os.getDescr_item());
                    capturaDetalhesOs.setQtde_item(os.getQtde_item());
                    capturaDetalhesOs.setUnidade_item(os.getUnidade_item());

                    //ArrayList<OsModel> listOs = new ArrayList<OsModel>();
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