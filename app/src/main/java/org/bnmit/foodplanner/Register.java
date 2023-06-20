package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    EditText nametext,emailtext, passwordtext;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nametext=findViewById(R.id.editTextName);
        emailtext=findViewById(R.id.editTextEmail);
        passwordtext=findViewById(R.id.editTextPassword);
        db = new Database(Register.this);
    }
    public void signup(View view)
    {
        String email=emailtext.getText().toString();
        String password=passwordtext.getText().toString();
        String name=nametext.getText().toString();
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(Register.this, "Please enter all the data", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!isvalidpassword(password))
        {
            Toast.makeText(this,"The password is invalid",Toast.LENGTH_LONG).show();
            return;
        }
        db.addNewUser(name, email, password);
        Intent ref=new Intent(this,HomePage.class);
        //ref.putExtra("email",email);
        //ref.putExtra("password",password);
        startActivity(ref);
        finish();
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