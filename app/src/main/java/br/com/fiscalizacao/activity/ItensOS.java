
package br.com.fiscalizacao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.com.fiscalizacao.R;
import br.com.fiscalizacao.adapter.ItensAdapter;
import br.com.fiscalizacao.model.ItensModel;
import br.com.fiscalizacao.model.OsModel;

import static android.widget.Toast.LENGTH_SHORT;

public class ItensOS extends AppCompatActivity {

    public DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    private RecyclerView mRecyclerView;
    private ItensAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    List<ItensModel> listItens = new ArrayList<>();

    private Button buttonConforme;

    public static final String NUM_OS = "num_os";
    public static final String KEY = "key";
    public String os_selecionada, chaveKey;
    public String fiscal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens);

        mostra_OS_selecionada();
        mostraItens(os_selecionada);
        mostraButtonConforme();


    } // fim do método onCreate

    public void mostraButtonConforme(){

        buttonConforme = findViewById(R.id.button_conforme);

        buttonConforme.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                grava_firebase(os_selecionada, listItens);
                //Log.i(": Fisc - estou dentro de mostraButtonConforme e passando pelo intent o NOMEFISCAL como ", fiscal);
                Intent intent = new Intent(ItensOS.this, OrdensFiscal.class);
                intent.putExtra("nome", fiscal);
                startActivity(intent);

            }
        });



    } // fim do método mostraButtonConforme


    public void grava_firebase(String os, List<ItensModel> list){

        int i=0;
        DatabaseReference refItens = ref.child("os").child(chaveKey);

        Iterator<ItensModel> it = list.iterator();
        while (it.hasNext()){

            //item = new ItensModel(codItem, descr_item, qtde_item, unid_item, pr_item, pr_totItem);
            ItensModel obj = new ItensModel();
            obj = it.next();

            Map<String, Object> childUpdates = new HashMap<>();

            childUpdates.put("analisada", true);
            childUpdates.put( "itens/" + i + "/qtde_item", obj.getQtde_item());

            refItens.updateChildren(childUpdates);

            i = i + 1;
        }


    }
    public void mostra_OS_selecionada(){

        Intent intent = getIntent();
        fiscal = intent.getStringExtra("nome");
        os_selecionada = intent.getStringExtra(NUM_OS); // número OS
        chaveKey = intent.getStringExtra(KEY);
        Log.i(": Fisc - nome do fiscal recebido em mostra_OS_selecionada é  ", fiscal);
        Log.i(": Fisc - chave key ", chaveKey);
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

                Log.i(": Fisc - dados snapshot ", snapshot.getValue().toString());
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
                    Double pr_totItem = qtde_item * pr_item;
                    //Double pr_totItem = (qtde_item * pr_item);

                    //total_OS = total_OS + pr_totItem;

                    item = new ItensModel(codItem, descr_item, qtde_item, unid_item, pr_item, pr_totItem);
                    //Log.i(": Fisc - item da OS " , item.getCod_item()+"   "+item.getDescr_item());
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
                        CharSequence msg = "Alteração realizada.";

                        listItens.get(position).changeQtde(qtde);
                        mAdapter.notifyItemChanged(position);
                        Toast toast = Toast.makeText(getBaseContext(),msg,LENGTH_SHORT);
                        toast.show();

                    }
                }) ;



            } // fim método onDataChange(DataSnapshot snapshot)

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            } // fim método onCancelled().

        }); // fim do query1.addListenerForSingleValueEvent

    } // fim do método cria_detalhes_Os


} // fim da class ItensOS