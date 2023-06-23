package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Profile extends AppCompatActivity {
    ImageView recipe,schedule,timer,shopping,home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        recipe=findViewById(R.id.imgrecipe);
        schedule=findViewById(R.id.imgschedule);
        timer=findViewById(R.id.imgtimer);
        shopping=findViewById(R.id.imgshopping);
        home=findViewById(R.id.imghome);
        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rec=new Intent(Profile.this,Recipe.class);
                startActivity(rec);
                finish();
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sch=new Intent(Profile.this,Calender.class);
                startActivity(sch);
                finish();
            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ti=new Intent(Profile.this,TimerActivity.class);
                startActivity(ti);
                finish();
            }
        });
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shop=new Intent(Profile.this,Shopping.class);
                startActivity(shop);
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h=new Intent(Profile.this,HomePage.class);
                startActivity(h);
                finish();
            }
        });
    }
}