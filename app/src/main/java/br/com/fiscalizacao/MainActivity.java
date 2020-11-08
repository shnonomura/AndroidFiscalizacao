package br.com.fiscalizacao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.fiscalizacao.model.FiscalModel;

public class MainActivity<Fiscal> extends AppCompatActivity {


    private DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    private List<String> listFiscal = new ArrayList<String>();
    private ArrayAdapter<String> arrayAdapterfiscal;
    private ListView lv_fiscais;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_fiscais = findViewById(R.id.lv_fiscais);

        eventoDatabase();


    } // fim do método onCreate

    private void eventoDatabase() {
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
    } // fim do método eventoDatabase()

    private void addChildEventListener(){

        ChildEventListener childListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        };


    } // fim do método addChildEventListener


} // fim do MainActivity