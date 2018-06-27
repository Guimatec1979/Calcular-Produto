package com.guimatec.descontodeproduto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editvalorProduto, editporcentagemDesconto;
    TextView txtValorDesconto, txtValorProdutoComDesconto;
    Button btnCalcular, btnLimpar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editvalorProduto = findViewById(R.id.editValorProduto);
        editporcentagemDesconto = findViewById(R.id.editporcentagemDesconto);
        txtValorDesconto = findViewById(R.id.txtValorDesconto);
        txtValorProdutoComDesconto = findViewById(R.id.txtValorProdutoComDesconto);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String s;
                    float valorProduto, valorDesconto, valorProdutoComDesconto;
                    int porcentagemDesconto;

                    valorProduto = Float.parseFloat(editvalorProduto.getText().toString());
                    porcentagemDesconto = Integer.parseInt(editporcentagemDesconto.getText().toString());

                    valorDesconto = valorProduto * porcentagemDesconto / 100;
                    valorProdutoComDesconto = valorProduto - valorDesconto;

                    txtValorDesconto.setText("R$ " + valorDesconto);
                    txtValorProdutoComDesconto.setText("R$ " + valorProdutoComDesconto);

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Houve erro na conversão, digite apenas caracteres numéricos"+e.getMessage(), Toast.LENGTH_LONG).show();
                }


            }
        });

        btnLimpar = findViewById(R.id.btnLimpar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editvalorProduto.setText("");
                editporcentagemDesconto.setText("");
                txtValorProdutoComDesconto.setText("");
                txtValorDesconto.setText("");
            }
        });


    }
}
