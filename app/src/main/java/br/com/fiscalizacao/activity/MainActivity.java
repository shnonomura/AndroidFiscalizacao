package br.com.fiscalizacao.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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


    private DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    private List<String> listFiscal = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapterfiscal;
    private ListView lv_fiscais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_fiscais = findViewById(R.id.lv_fiscais);

        capturaFiscais();

        //cria um OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lv_fiscais, View itemView, int position, long id) {
                Intent intent = new Intent(MainActivity.this, OrdensFiscal.class);

                String nomeFiscal = lv_fiscais.getItemAtPosition(position).toString();
                intent.putExtra(OrdensFiscal.FISCALID, (int)id);
                intent.putExtra(OrdensFiscal.NOMEFISCAL,nomeFiscal );
                startActivity(intent);

            }
        };

        ListView lv_fiscais = findViewById(R.id.lv_fiscais);
        lv_fiscais.setOnItemClickListener(itemClickListener);

    } // fim do método onCreate

    private void capturaFiscais() {

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
    } // fim do método capturaFiscais()


} // fim do MainActivity