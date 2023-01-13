package com.example.cursodadospassandoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campEmail, campName, campAddress, campPhone, campSex;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campEmail = findViewById(R.id.editEmailDados);
        campName = findViewById(R.id.editNomeDados);
        campAddress = findViewById(R.id.editAddressDados);
        campPhone = findViewById(R.id.editPhoneDados);
        campSex = findViewById(R.id.editSexDados);
        btnRegister = findViewById(R.id.btnCadastrar);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = campEmail.getText().toString();
                String name = campName.getText().toString();
                String address = campAddress.getText().toString();
                String phone = campPhone.getText().toString();
                String sex = campSex.getText().toString();

                if (!email.isEmpty()){
                    if (!name.isEmpty()){
                        if (!address.isEmpty()){
                            if (!phone.isEmpty()){
                                if (!sex.isEmpty()){
                                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                                    i.putExtra("email", email);
                                    i.putExtra("name", name);
                                    i.putExtra("address", address);
                                    i.putExtra("phone", phone);
                                    i.putExtra("sex", sex);
                                    startActivity(i);
                                }else{
                                    Toast.makeText(getApplicationContext(), "Preencha o sexo", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(getApplicationContext(), "Preencha o telefone", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(getApplicationContext(), "Preencha o endereço", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Preencha o nome", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Preencha o e-mail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}