package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Recipe extends AppCompatActivity {
    ImageView home,schedule,timer,shopping,profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        home=findViewById(R.id.imghome);
        schedule=findViewById(R.id.imgschedule);
        timer=findViewById(R.id.imgtimer);
        shopping=findViewById(R.id.imgshopping);
        profile=findViewById(R.id.imguser);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h=new Intent(Recipe.this,HomePage.class);
                startActivity(h);
                finish();
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sch=new Intent(Recipe.this,Calender.class);
                startActivity(sch);
                finish();
            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ti=new Intent(Recipe.this,TimerActivity.class);
                startActivity(ti);
                finish();
            }
        });
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shop=new Intent(Recipe.this,Shopping.class);
                startActivity(shop);
                finish();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pro=new Intent(Recipe.this,Profile.class);
                startActivity(pro);
                finish();
            }
        });
    }
}