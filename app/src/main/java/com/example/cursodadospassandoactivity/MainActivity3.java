package com.example.cursodadospassandoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity3 extends AppCompatActivity {

    private TextInputEditText campEmail, campName, campAddress, campPhone, campSex;
    private Button register;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        campEmail = findViewById(R.id.editEmailEdit);
        campName = findViewById(R.id.editNomeEdit);
        campAddress = findViewById(R.id.editAddressEdit);
        campPhone = findViewById(R.id.editPhoneEdit);
        campSex = findViewById(R.id.editSexEdit);
        register = findViewById(R.id.btnEnviar);

        i = getIntent();
        campEmail.setText(i.getExtras().getString("email"));
        campName.setText(i.getExtras().getString("name"));
        campAddress.setText(i.getExtras().getString("address"));
        campPhone.setText(i.getExtras().getString("phone"));
        campSex.setText(i.getExtras().getString("sex"));

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("email", campEmail.getText().toString());
                i.putExtra("name", campName.getText().toString());
                i.putExtra("address", campAddress.getText().toString());
                i.putExtra("phone", campPhone.getText().toString());
                i.putExtra("sex", campSex.getText().toString());
                setResult(1, i);
                finish();
            }
        });
    }
}