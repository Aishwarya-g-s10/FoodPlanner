package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText emailtext,passwordtext;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailtext=findViewById(R.id.editTextEmail);
        passwordtext=findViewById(R.id.editTextPassword);
        }
        @SuppressLint("Range")
        public void login(View view)
        {
            String email=emailtext.getText().toString();
            String password=passwordtext.getText().toString();

            Database database=new Database(this);
            SQLiteDatabase db = database.getReadableDatabase();
            String query = "SELECT * FROM user WHERE username = ?";
            Cursor cursor = db.rawQuery(query, new String[]{email});
            if (!cursor.moveToFirst())
            {
                Toast.makeText(this,"Please enter registered email id",Toast.LENGTH_LONG).show();
                return;
            }
            cursor.close();
            String query1 = "SELECT * FROM user WHERE username=? and password = ? ";
            Cursor cursor1 = db.rawQuery(query1, new String[]{email,password});
            if (cursor1.moveToFirst()) {
                id = cursor1.getInt(cursor1.getColumnIndex("id"));
                Intent ref=new Intent(this,HomePage.class);
                ref.putExtra("id",id);
                startActivity(ref);
                finish();
            }
            else
            {
                Toast.makeText(this,"Please enter correct password",Toast.LENGTH_LONG).show();
                return;
            }
            cursor.close();


        }
        public void register(View view)
        {
            Intent reg=new Intent(this, Register.class);
            startActivity(reg);
            finish();
        }
}