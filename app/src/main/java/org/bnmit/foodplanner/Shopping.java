package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Shopping extends AppCompatActivity {
    ImageView recipe,schedule,timer,home,profile;
    static ListView listView;
    static ArrayList<String> items;
    static ListViewAdapter adapter;

    EditText input;
    ImageView enter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        recipe=findViewById(R.id.imgrecipe);
        schedule=findViewById(R.id.imgschedule);
        timer=findViewById(R.id.imgtimer);
        home=findViewById(R.id.imghome);
        profile=findViewById(R.id.imguser);
        input=findViewById(R.id.input);
        enter = findViewById(R.id.add);



        listView = findViewById(R.id.list_item);
        items = new ArrayList<>();
        items.add("Apple");
        adapter = new ListViewAdapter(getApplicationContext(), items);
        listView.setAdapter(adapter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                if(text == null || text.length() == 0){
                    Toast.makeText(Shopping.this, "Enter an item", Toast.LENGTH_SHORT).show();
                }else{
                    addItem(text);
                    input.setText("");
                    Toast.makeText(Shopping.this, "Added "+text, Toast.LENGTH_SHORT).show();
                }
            }
        });



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

    public static void addItem(String item){
        items.add(item);
        listView.setAdapter(adapter);
    }

    public static void removeItem(int remove){
        items.remove(remove);
        listView.setAdapter(adapter);
    }
}