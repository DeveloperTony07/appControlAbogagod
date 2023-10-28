package com.example.appabogadostn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appabogadostn.crontroller.Database;
import com.google.android.material.textfield.TextInputLayout;

public class act_Login extends AppCompatActivity {

    private Button btnBack, btnLogin;
    private TextInputLayout id, password;

    private Database db;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_login);

        db = new Database(this);

        btnBack = findViewById(R.id.btnBack);
        btnLogin = findViewById(R.id.btnLoginLogin);

        id = findViewById(R.id.txtIDLogin);
        password = findViewById(R.id.txtPasswordLogin);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act_Login.this, act_Welcome.class);
                startActivity(intent);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = id.getEditText().getText().toString();
                String userPassword = password.getEditText().getText().toString();

                boolean successfulLogin = db.userLogin(userId, userPassword);

                if(successfulLogin){

                    Intent intent = new Intent(act_Login.this, act_Start.class);
                    startActivity(intent);
                    finish();
                }else{
                    showMessage("Error al iniciar secion");
                }
            }
        });

    }// End onCreate

    private void showMessage(String mensaje) {
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
    }

}