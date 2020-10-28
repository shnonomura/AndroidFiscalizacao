package br.com.fiscalizacao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;

import static android.util.Log.*;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference refRaiz = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference osReference;
    private ValueEventListener changeListener;
    private String nextNrOs;
    public Long qttyNodes;
    private ArrayList<String> nrOsList;
    //public String maxOs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // criar os Objetos que serão utilizados
        //OsModel osObject = new OsModel();

        // capturar o número de nós-filhos abaixo
        DatabaseReference osReference = refRaiz.child("os");


        osReference.addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {

               String path =  snapshot.getRef().toString();
               Log.i("resp - path :", path);

               if(snapshot.hasChildren()) {
                   Log.i("resp - Tem nós filhos : ", "sim");
               }else{
                   Log.i("resp - Tem nós filhos : ", "não");
               }

               qttyNodes = snapshot.getChildrenCount();
               Log.i("resp - quantidade de OS : ", String.valueOf(qttyNodes));

               atualizarNodes(qttyNodes);


           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
        });


        /*osReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                OsModel dadosOs = dataSnapshot.getValue(OsModel.class);

                Log.i("Dados da OS - ", "nr. OS :" + dadosOs.getOs().toString() );
                //Log.i("Dados da OS : ", String.valueOf(dataSnapshot.getChildrenCount()));
                //maxOs = dataSnapshot.getChildrenCount(); //  maxOs é pública
                //OsModel OS = dataSnapshot.getValue(OsModel.class);
               // Log.i("Dados da OS : ",
                 //       "Os : " + OS.getOs() +"\n pagar : " + OS.getPagarHashMap() + "\nanalisada : " + OS.getAnalisada());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); */

                //DatabaseReference osPesquisa = osReference.child("os002");

                // captura o quantidade de OS cadastradas
                //Long maxOS = getMaxOs(osReference);

        /*
        osReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("newOs", dataSnapshot.getValue().toString());
                OsModel newOs = dataSnapshot.getValue(OsModel.class);
                Log.i("novoNrOs", dataSnapshot.getKey());
                //novoNrOs = newOs.getOs();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        }); // fim do osReference.addListenerForSingleValueEvent()

        */

                // manualmente, sem uso do OS model  -> ok
        /*
        DatabaseReference osRef = ref1.child("os");
        osRef.setValue("os001");
        osRef.child("os001/fiscalizada").setValue(false);
        osRef.child("os001/analisada").setValue(false);
        osRef.child("os001/pagar/item01").setValue(false);
        osRef.child("os001/pagar/item02").setValue(false);
        osRef.child("os001/pagar/item03").setValue(false);
        osRef.child("os001/quantidade/item01").setValue(1);
        osRef.child("os001/quantidade/item02").setValue(1);
        osRef.child("os001/quantidade/item03").setValue(1);
        osRef.child("os001/contrato/20207421001").setValue(true);
        osRef.child("os001/contrato/20207421002").setValue(false);
        osRef.child("os001/contrato/20207421003").setValue(false);
        */

        // inserir nova Os

        //String newOs = String.valueOf(maxOS + 1);

        /*List<ServicoModel> servicos = new ArrayList<>();

        ServicoModel servico1 = new ServicoModel( "001",  "Pintura esmalte sintetico",  10.0f,  true);
        ServicoModel servico2 = new ServicoModel( "002",  "Pintura esmalte sintetico",  10.0f,    true);
        ServicoModel servico3 = new ServicoModel( "003",  "Pintura esmalte sintetico",  10.0f,  true);
        ServicoModel servico4 = new ServicoModel( "004",  "Pintura esmalte sintetico",  10.0f,    true);
        ServicoModel servico5 = new ServicoModel( "005",  "Pintura esmalte sintetico",  10.0f,   true);

        servicos.addAll(Arrays.asList(servico1,servico2,servico3,servico4,servico5));
        TesteModel teste = new TesteModel( "20207421002","os004", true, true, servicos);

        osReference.push().setValue(teste); */

        /*Map<String, Object> atualizaOs = new HashMap<>();

        atualizaOs.put(newOs+"/fiscalizada", novaOs.getFiscalizada());
        atualizaOs.put(newOs+"/analisada", novaOs.getAnalisada());
        atualizaOs.put(newOs+"/pagar", novaOs.toPagarMap());
        atualizaOs.put(newOs+"/quantidade", novaOs.toQuantidadeMap());
        atualizaOs.put(newOs+"/contrato", novaOs.toNrContratoMao());

        osReference.updateChildren(atualizaOs);*/

        /* OsModel novaOs = new OsModel(newOs);

        Map<String, Object> atualizaOs = new HashMap<>();

        atualizaOs.put(newOs+"/fiscalizada", novaOs.getFiscalizada());
        atualizaOs.put(newOs+"/analisada", novaOs.getAnalisada());
        atualizaOs.put(newOs+"/pagar", novaOs.toPagarMap());
        atualizaOs.put(newOs+"/quantidade", novaOs.toQuantidadeMap());
        atualizaOs.put(newOs+"/contrato", novaOs.toNrContratoMao());

        osReference.updateChildren(atualizaOs);*/
        Log.i("resp - no final do método on create - quantidade de OS : ", String.valueOf(qttyNodes));

    } // fim do método onCreate

    private void atualizarNodes(Long qttyNodes) {

        this.qttyNodes = qttyNodes;
        Log.i("resp - DENTRO DA FUNCAO atualizarNodes - quantidade de OS : ", String.valueOf(qttyNodes));
    }


} // fim do MainActivity