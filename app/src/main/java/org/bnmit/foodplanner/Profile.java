package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Profile extends AppCompatActivity {
    ImageView recipe,schedule,timer,shopping,home;
    int id;
    TextView logout, chpassword, name, email;
    EditText newp,confirmp;
    Button pchange;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        recipe=findViewById(R.id.imgrecipe);
        schedule=findViewById(R.id.imgschedule);
        timer=findViewById(R.id.imgtimer);
        shopping=findViewById(R.id.imgshopping);
        home=findViewById(R.id.imghome);
        logout=findViewById(R.id.logout);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        pchange=findViewById(R.id.passwordch);
        newp=findViewById(R.id.newpassword);
        confirmp=findViewById(R.id.confirmpassword);
        pchange.setVisibility(View.GONE);
        newp.setVisibility(View.GONE);
        confirmp.setVisibility(View.GONE);
        chpassword=findViewById(R.id.changepassword);
        id=getIntent().getIntExtra("id",1);
        database=new Database(this);
        SQLiteDatabase db = database.getReadableDatabase();
        String query = "SELECT * FROM user WHERE id = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id)});
        String n= cursor.getString(cursor.getColumnIndexOrThrow("name"));
        name.setText("Hello, "+n);
        String e=cursor.getString(cursor.getColumnIndexOrThrow("username"));
        email.setText("Email: "+e);
        chpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pchange.setVisibility(View.VISIBLE);
                newp.setVisibility(View.VISIBLE);
                confirmp.setVisibility(View.VISIBLE);
            }
        });
        pchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pnew=newp.getText().toString();
                String pconf=confirmp.getText().toString();
                if (pnew.isEmpty() || pconf.isEmpty())
                {
                    Toast.makeText(Profile.this,"Enter new password and confirm password",Toast.LENGTH_LONG).show();
                    return;
                }
                else if (!pnew.equals(pconf))
                {
                    Toast.makeText(Profile.this,"New password and confirm password does not match",Toast.LENGTH_LONG).show();
                    return;
                }
                else if (!isvalidpassword(pnew))
                {
                    Toast.makeText(Profile.this,"Invalid Password",Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    String r=database.updateData("user",String.valueOf(id),pnew);
                    Toast.makeText(Profile.this,r,Toast.LENGTH_LONG).show();
                }
                pchange.setVisibility(View.GONE);
                newp.setVisibility(View.GONE);
                confirmp.setVisibility(View.GONE);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m=new Intent(Profile.this,MainActivity.class);
                startActivity(m);
                finish();
            }
        });
        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rec=new Intent(Profile.this,Recipe.class);
                rec.putExtra("id",id);
                startActivity(rec);
                finish();
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sch=new Intent(Profile.this,Calender.class);
                sch.putExtra("id",id);
                startActivity(sch);
                finish();
            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ti=new Intent(Profile.this,TimerActivity.class);
                ti.putExtra("id",id);
                startActivity(ti);
                finish();
            }
        });
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shop=new Intent(Profile.this,Shopping.class);
                shop.putExtra("id",id);
                startActivity(shop);
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h=new Intent(Profile.this,HomePage.class);
                h.putExtra("id",id);
                startActivity(h);
                finish();
            }
        });
    }
    Pattern lowercase=Pattern.compile("^.*[a-z].*$");
    Pattern uppercase=Pattern.compile("^.*[A-Z].*$");
    Pattern numchar=Pattern.compile("^.*[0-9].*$");
    Pattern spchar=Pattern.compile("^.*[^a-zA-Z0-9].*$");
    Pattern em=Pattern.compile("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$");
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