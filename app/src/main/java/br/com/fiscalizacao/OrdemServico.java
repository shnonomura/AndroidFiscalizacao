package br.com.fiscalizacao;

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

import br.com.fiscalizacao.adapter.OsAdapter;
import br.com.fiscalizacao.model.OsModel;

public class OrdemServico extends AppCompatActivity {

    public DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    public static final String FISCALID = "fiscalID";
    public static final String NOMEFISCAL = "nome";
    public List<OsModel> listOs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordem_servico);

        TextView nomeFiscal = findViewById(R.id.nomefiscal);

        Intent intent = getIntent();
        int fiscalId = (Integer)getIntent().getExtras().get(FISCALID); // índice da lv_fiscais
        String nome = intent.getStringExtra(NOMEFISCAL); // nome fiscal

        //Log.i("Fiscal ID : ", String.valueOf(fiscalId));
        //Log.i("Nome Fiscal", nome.toString());
        nomeFiscal.setText(nome);

        this.criaListaOs();



    } // fim do método onCreate


    public void criaListaOs(){

        Query query1 = ref.child("os").orderByChild("fiscal");

        query1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //listOs.clear();
                for(DataSnapshot objSnapshot:snapshot.getChildren()) {
                    OsModel os = objSnapshot.getValue(OsModel.class);
                    //Log.i("Fisc ", "OS : " + os.getOs() + " Contrato : " + os.getContrato());

                    OsModel capturaOs = new OsModel();
                    capturaOs.setOs(os.getOs());
                    capturaOs.setContrato(os.getContrato());
                    capturaOs.setAnalisada(os.getAnalisada());
                    capturaOs.setFiscalizada(os.getFiscalizada());

                    //ArrayList<OsModel> listOs = new ArrayList<OsModel>();
                    listOs.add(capturaOs);

                    OsAdapter adapter = new OsAdapter(listOs);
                    //Log.i("Fisc lista1", "nr OS : " + listOs.get(0).getOs() + "\nnr contrato : " + listOs.get(0).getContrato());

                    RecyclerView recyclerView = findViewById(R.id.os_recycler);
                    // configurar recyclerview
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
                    recyclerView.setAdapter(adapter);
                }

            } // fim método onDataChange()

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            } // fim método onCancelled().
        });
    } // fim do método criaListaOs

} // fim da classe OrdemServico