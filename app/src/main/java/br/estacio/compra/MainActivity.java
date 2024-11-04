package br.estacio.compra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rbgAlimentos;
    EditText txtQtde;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtQtde = findViewById(R.id.txtQtde);
        rbgAlimentos = findViewById(R.id.rbgAlimentos);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setTitle("Fechar conta?");
                msg.setMessage("Deseja realmente finalizar seu pedido?");
                msg.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finalizarPedido();
                    }
                });
                msg.setNegativeButton("NÃO", null);
                msg.show();
            }
        });


    }
    private void finalizarPedido()
    {
        int rbtSelecionado = rbgAlimentos.getCheckedRadioButtonId();
        if(rbtSelecionado == -1)
        {
            Toast.makeText(getApplicationContext(), "Selecione o Alimento!", Toast.LENGTH_LONG).show();
        }
        else if(txtQtde.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Digite a quantidade!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent it = new Intent(this, Resultado.class);
            it.putExtra("alimento", retornarAlimento());
            it.putExtra("qtde", txtQtde.getText().toString());
            startActivity(it);
        }
    }


    public String retornarAlimento()
    {

        int rbtSelecionado = rbgAlimentos.getCheckedRadioButtonId();
        RadioButton rbtAux = findViewById(rbtSelecionado);
        return rbtAux.getText().toString();
    }

}