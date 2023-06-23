package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    EditText nametext,emailtext, passwordtext, confirmtext;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nametext=findViewById(R.id.editTextName);
        emailtext=findViewById(R.id.editTextEmail);
        passwordtext=findViewById(R.id.editTextPassword);
        confirmtext=findViewById(R.id.editTextPassword1);
        db = new Database(Register.this);
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
    public void signup(View view)
    {
        String email=emailtext.getText().toString();
        String password=passwordtext.getText().toString();
        String confirmPassword = confirmtext.getText().toString();
        String name=nametext.getText().toString();
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(Register.this, "Please enter all the data", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Please enter valid email id", Toast.LENGTH_SHORT).show();
        }
        if (!isvalidpassword(password))
        {
            Toast.makeText(this,"Please enter valid password",Toast.LENGTH_LONG).show();
            return;
        }
        if(!password.equals(confirmPassword)){
            Toast.makeText(this,"Password are not matching",Toast.LENGTH_LONG).show();
        }
        db.addNewUser(name, email, password);
        Intent ref=new Intent(this,Login.class);

        startActivity(ref);
//        finish();
    }

}