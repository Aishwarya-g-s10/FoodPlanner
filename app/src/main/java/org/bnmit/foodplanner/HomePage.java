package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity {
    ImageView recipe,schedule,timer,shopping,profile;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        recipe=findViewById(R.id.imgrecipe);
        schedule=findViewById(R.id.imgschedule);
        timer=findViewById(R.id.imgtimer);
        shopping=findViewById(R.id.imgshopping);
        profile=findViewById(R.id.imguser);
        id=getIntent().getIntExtra("id",1);
        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rec=new Intent(HomePage.this,Recipe.class);
                rec.putExtra("id",id);
                startActivity(rec);
                finish();
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sch=new Intent(HomePage.this,Calender.class);
                sch.putExtra("id",id);
                startActivity(sch);
                finish();
            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ti=new Intent(HomePage.this,TimerActivity.class);
                ti.putExtra("id",id);
                startActivity(ti);
                finish();
            }
        });
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shop=new Intent(HomePage.this,Shopping.class);
                shop.putExtra("id",id);
                startActivity(shop);
                finish();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pro=new Intent(HomePage.this,Profile.class);
                pro.putExtra("id",id);
                startActivity(pro);
                finish();
            }
        });

    }
}