package br.com.fiscalizacao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.fiscalizacao.R;
import br.com.fiscalizacao.model.FiscalModel;

public class MainActivity<Fiscal> extends AppCompatActivity {

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference ref = database.getReference();
    private final List<String> listFiscal = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapterfiscal;
    private ListView lv_fiscais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_fiscais = findViewById(R.id.lv_fiscais);

        //criaFiscais();

        // método onStart() carrega o ListView dos fiscais
        // cria um addListenerForSingleValueEvent
        aguardaClickListView();



    } // fim do método onCreate
/*
     public void criaFiscais(){

        ArrayList<FiscalModel> listaFiscais = new ArrayList<>();
        FiscalModel f1 = new FiscalModel("Margareth", "111111", "202074201111");
        FiscalModel f2 = new FiscalModel("Jessica", "222222", "202074202222");
        FiscalModel f3 = new FiscalModel("Beth", "333333", "202074203333");
        listaFiscais.add(f1);
        listaFiscais.add(f2);
        listaFiscais.add(f3);
        FiscalModel item = listaFiscais.get(0);
        Log.i("xxx Lista de Fiscais : " , item.toString());
        Log.i("xxx Lista de Fiscais : " , listaFiscais.get(1).toString());

        ref.child("fiscal").push().setValue(f1);
        ref.child("fiscal").push().setValue(f2);
        ref.child("fiscal").push().setValue(f3);

    } // fim do método criaFiscais

*/
    @Override
    protected void onStart(){
        super.onStart();

        // captura fiscais para apresentar na tela inicial
        ref.child("fiscal").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listFiscal.clear();
                for(DataSnapshot objSnapshot:snapshot.getChildren()){
                    FiscalModel f = objSnapshot.getValue(FiscalModel.class);
                    listFiscal.add(f.getNome());
                }
                arrayAdapterfiscal = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_single_choice,listFiscal);
                lv_fiscais.setAdapter(arrayAdapterfiscal);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }



    public void aguardaClickListView(){

        //cria um OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lv_fiscais, View itemView, int position, long id) {
                Intent intent = new Intent(MainActivity.this, OrdensFiscal.class);

                String nomeFiscal = lv_fiscais.getItemAtPosition(position).toString();
                intent.putExtra(OrdensFiscal.NOMEFISCAL,nomeFiscal );
                startActivity(intent);

            }
        };


        ListView lv_fiscais = findViewById(R.id.lv_fiscais);
        lv_fiscais.setOnItemClickListener(itemClickListener);

    }// fim do método apresentaListView



} // fim do MainActivity