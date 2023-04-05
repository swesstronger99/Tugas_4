package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Mahasiswa> ArrMhs;
    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private Button Register;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = (EditText) findViewById(R.id.IdUsername);
        Password = (EditText) findViewById(R.id.IdPasswd);
        Register = (Button) findViewById(R.id.idRegister);
        Login = (Button) findViewById(R.id.idLogin);
        Intent intent =getIntent();
        ArrMhs = intent.getParcelableArrayListExtra("myData");
        Login.setOnClickListener(this);
        Register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idLogin){
            validate(Username.getText().toString(), Password.getText().toString());
        }

        if (v.getId() == R.id.idRegister){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }
    private void validate(String valUsername, String valPassword) {
        for (int idx = 0; idx < ArrMhs.size();idx++){
            String UserPassword = ArrMhs.get(idx).getPassword();
            String UserName = ArrMhs.get(idx).getUsername();
            if (valUsername.equals(UserName) && valPassword.equals(UserPassword)) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            } else {
                counter--;
                Info.setText("Toleransi Jumlah Kesalahan :" + String.valueOf(counter));

                if (counter == 0) {
                    Login.setEnabled(false);

                }
            }
        }
    }


}


