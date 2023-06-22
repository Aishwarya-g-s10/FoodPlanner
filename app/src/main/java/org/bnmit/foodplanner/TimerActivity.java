package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TimerActivity extends AppCompatActivity {
    ImageView recipe,schedule,home,shopping,profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        recipe=findViewById(R.id.imgrecipe);
        schedule=findViewById(R.id.imgschedule);
        home=findViewById(R.id.imghome);
        shopping=findViewById(R.id.imgshopping);
        profile=findViewById(R.id.imguser);
        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rec=new Intent(TimerActivity.this,Recipe.class);
                startActivity(rec);
                finish();
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sch=new Intent(TimerActivity.this,Calender.class);
                startActivity(sch);
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h=new Intent(TimerActivity.this,HomePage.class);
                startActivity(h);
                finish();
            }
        });
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shop=new Intent(TimerActivity.this,Shopping.class);
                startActivity(shop);
                finish();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pro=new Intent(TimerActivity.this,Profile.class);
                startActivity(pro);
                finish();
            }
        });
    }
}