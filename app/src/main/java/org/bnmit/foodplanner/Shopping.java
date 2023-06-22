package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Shopping extends AppCompatActivity {
    ImageView recipe,schedule,timer,home,profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        recipe=findViewById(R.id.imgrecipe);
        schedule=findViewById(R.id.imgschedule);
        timer=findViewById(R.id.imgtimer);
        home=findViewById(R.id.imghome);
        profile=findViewById(R.id.imguser);
        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rec=new Intent(Shopping.this,Recipe.class);
                startActivity(rec);
                finish();
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sch=new Intent(Shopping.this,Calender.class);
                startActivity(sch);
                finish();
            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ti=new Intent(Shopping.this,TimerActivity.class);
                startActivity(ti);
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h=new Intent(Shopping.this,HomePage.class);
                startActivity(h);
                finish();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pro=new Intent(Shopping.this,Profile.class);
                startActivity(pro);
                finish();
            }
        });
    }
}