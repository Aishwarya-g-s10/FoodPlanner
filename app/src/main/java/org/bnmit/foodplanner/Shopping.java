package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Shopping extends AppCompatActivity {
    ImageView recipe,schedule,timer,home,profile;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        recipe=findViewById(R.id.imgrecipe);
        schedule=findViewById(R.id.imgschedule);
        timer=findViewById(R.id.imgtimer);
        home=findViewById(R.id.imghome);
        profile=findViewById(R.id.imguser);
        id=getIntent().getIntExtra("id",1);
        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rec=new Intent(Shopping.this,Recipe.class);
                rec.putExtra("id",id);
                startActivity(rec);
                finish();
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sch=new Intent(Shopping.this,Calender.class);
                sch.putExtra("id",id);
                startActivity(sch);
                finish();
            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ti=new Intent(Shopping.this,TimerActivity.class);
                ti.putExtra("id",id);
                startActivity(ti);
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h=new Intent(Shopping.this,HomePage.class);
                h.putExtra("id",id);
                startActivity(h);
                finish();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pro=new Intent(Shopping.this,Profile.class);
                pro.putExtra("id",id);
                startActivity(pro);
                finish();
            }
        });
    }
}