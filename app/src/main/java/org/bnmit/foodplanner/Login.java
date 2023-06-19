package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText emailtext,passwordtext;
    String remail, rpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailtext=findViewById(R.id.editTextEmail);
        passwordtext=findViewById(R.id.editTextPassword);
        remail=getIntent().getStringExtra("email");
        rpassword=getIntent().getStringExtra("password");

        }
        public void login(View view)
        {
            String email=emailtext.getText().toString();
            String password=passwordtext.getText().toString();
            if (!((email.equals(remail)) && (password.equals(rpassword))))
            {
                Toast.makeText(this,"Password or email is mismatched",Toast.LENGTH_LONG).show();
                return;
            }
            //Intent ref=new Intent(this,HomePage.class);
            //startActivity(ref);
        }
        public void register(View view)
        {
            Intent reg=new Intent(this, Register.class);
            startActivity(reg);
            finish();
        }
}