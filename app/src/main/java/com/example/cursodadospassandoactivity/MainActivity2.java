package com.example.cursodadospassandoactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    private TextView personalData, conficData;
    Intent i;
    private String email, name, address, phone, sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        personalData = findViewById(R.id.textDados);
        conficData = findViewById(R.id.textEditar);

        i = getIntent();

        email = i.getExtras().getString("email");
        name = i.getExtras().getString("name");
        address = i.getExtras().getString("address");
        phone = i.getExtras().getString("phone");
        sex = i.getExtras().getString("sex");

        personalData.setText("Olá, " + name + " seu e-mail é " + email + ", endereço " + address +
                ", telefone " + phone + " e você é do sexo " + sex);

        conficData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(MainActivity2.this, MainActivity3.class);
                i.putExtra("email", email);
                i.putExtra("name", name);
                i.putExtra("address", address);
                i.putExtra("phone", phone);
                i.putExtra("sex", sex);
                startActivityForResult(i, 1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == 1 && data != null){

            email = data.getExtras().getString("email");
            name = data.getExtras().getString("name");
            address = data.getExtras().getString("address");
            phone = data.getExtras().getString("phone");
            sex = data.getExtras().getString("sex");

            personalData.setText("Olá, " + name + " seu e-mail é " + email + ", endereço " + address +
                    ", telefone " + phone + " e você é do sexo " + sex);

        }
    }
}