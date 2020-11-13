package br.com.fiscalizacao.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import br.com.fiscalizacao.R;

public class ItensOrdemServico extends AppCompatActivity {

    public static final String NUM_OS = "nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens_ordem_servico);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        TextView nr_os = findViewById(R.id.nr_os);

        /*Intent intent = getIntent();
        int osId = (Integer)getIntent().getExtras().get(NUM_OS); // índice da Os Selecionada
        //String fiscal = intent.getStringExtra(NOMEFISCAL); // nome fiscal

        Log.i("Fisc  Os_ID : ", String.valueOf(osId));
        //Log.i("Nome Fiscal", fiscal);
        nr_os.setText(osId);*/

    } // fim do método onCreate()

    public void capturaDadosOs(){


    } // fim do método capturaDadosOs


} // fim da class ItemsOrdemServico

