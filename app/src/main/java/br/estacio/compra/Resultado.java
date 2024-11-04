package br.estacio.compra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    TextView txtAlimento, txtValorTotal, txtQtdeConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        txtAlimento = findViewById(R.id.txtAlimento);
        txtValorTotal = findViewById(R.id.txtValorTotal);
        txtQtdeConta = findViewById(R.id.txtQtdeConta);

        Intent it = getIntent();
        String alimento = it.getStringExtra("alimento");
        String qtde = it.getStringExtra("qtde");
        double vlrUnitario = 0, vlrTotal = 0;


    }
}