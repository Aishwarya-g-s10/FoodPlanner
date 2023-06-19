package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    EditText emailtext, passwordtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailtext=findViewById(R.id.editTextEmail);
        passwordtext=findViewById(R.id.editTextPassword);
    }
    public void signup(View view)
    {
        String email=emailtext.getText().toString();
        String password=passwordtext.getText().toString();
        if (!isvalidpassword(password))
        {
            Toast.makeText(this,"The password is invalid",Toast.LENGTH_LONG).show();
            return;
        }
        //Intent ref=new Intent(this,HomePage.class);
        //ref.putExtra("email",email);
        //ref.putExtra("password",password);
        //startActivity(ref);
    }
    Pattern lowercase=Pattern.compile("^.*[a-z].*$");
    Pattern uppercase=Pattern.compile("^.*[A-Z].*$");
    Pattern numchar=Pattern.compile("^.*[0-9].*$");
    Pattern spchar=Pattern.compile("^.*[^a-zA-Z0-9].*$");
    public boolean isvalidpassword(String password)
    {
        if (password.length()<8)
        {
            return false;
        }
        if (!lowercase.matcher(password).matches())
        {
            return false;
        }
        if (!uppercase.matcher(password).matches())
        {
            return false;
        }
        if (!numchar.matcher(password).matches())
        {
            return false;
        }
        if (!spchar.matcher(password).matches())
        {
            return false;
        }
        return true;

    }
}