package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button register,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register=findViewById(R.id.button1);
        login=findViewById(R.id.button2);
    }
    public void register(View view){
        Intent ref = new Intent(this, Register.class);
        startActivity(ref);
    }
    public void login(View view){
        Intent ref = new Intent(this, Login.class);
        startActivity(ref);
    }

}