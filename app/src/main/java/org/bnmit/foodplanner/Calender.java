package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Calender extends AppCompatActivity {
    ImageView recipe,home,timer,shopping,profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        recipe=findViewById(R.id.imgrecipe);
        home=findViewById(R.id.imghome);
        timer=findViewById(R.id.imgtimer);
        shopping=findViewById(R.id.imgshopping);
        profile=findViewById(R.id.imguser);
        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rec=new Intent(Calender.this,Recipe.class);
                startActivity(rec);
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h=new Intent(Calender.this,HomePage.class);
                startActivity(h);
                finish();
            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ti=new Intent(Calender.this,TimerActivity.class);
                startActivity(ti);
                finish();
            }
        });
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shop=new Intent(Calender.this,Shopping.class);
                startActivity(shop);
                finish();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pro=new Intent(Calender.this,Profile.class);
                startActivity(pro);
                finish();
            }
        });

    }
}