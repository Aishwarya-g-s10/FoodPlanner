package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Recipe extends AppCompatActivity {
    ImageView home,schedule,timer,shopping,profile;
    static ListView listView;
    static ListRecipe adapter;
    static ArrayList<String> items;
    static Context context;
    int id;
    FloatingActionButton add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        home=findViewById(R.id.imghome);
        schedule=findViewById(R.id.imgschedule);
        timer=findViewById(R.id.imgtimer);
        shopping=findViewById(R.id.imgshopping);
        profile=findViewById(R.id.imguser);
        listView = findViewById(R.id.list);
        context = getApplicationContext();
        add=findViewById(R.id.addnew);
        id=getIntent().getIntExtra("id",1);
        items = new ArrayList<>();
        Database database=new Database(this);
        SQLiteDatabase db = database.getReadableDatabase();
        String query = "SELECT * FROM recipe WHERE userid in (?,?) union SELECT * FROM recipe WHERE is_public=1";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id),String.valueOf(1)});
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                items.add(name);
            } while (cursor.moveToNext());
        }
        adapter = new ListRecipe(this, items);
        listView.setAdapter(adapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(Recipe.this,AddNewRecipe.class);
                a.putExtra("id",id);
                startActivity(a);
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h=new Intent(Recipe.this,HomePage.class);
                h.putExtra("id",id);
                startActivity(h);
                finish();
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sch=new Intent(Recipe.this,Calender.class);
                sch.putExtra("id",id);
                startActivity(sch);
                finish();
            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ti=new Intent(Recipe.this,TimerActivity.class);
                ti.putExtra("id",id);
                startActivity(ti);
                finish();
            }
        });
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shop=new Intent(Recipe.this,Shopping.class);
                shop.putExtra("id",id);
                startActivity(shop);
                finish();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pro=new Intent(Recipe.this,Profile.class);
                pro.putExtra("id",id);
                startActivity(pro);
                finish();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedText = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(Recipe.this, ViewRecipe.class);
                intent.putExtra("name",clickedText);
                startActivity(intent);
            }
        });
    }
}