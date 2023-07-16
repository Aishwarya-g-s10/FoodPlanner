package org.bnmit.foodplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class Calender extends AppCompatActivity {
    ImageView recipe,home,timer,shopping,profile,check,removeplan;
    CalendarView calendar;
    FloatingActionButton floatbtn;
    EditText plan;
    TextView display;
    Database database;
    Calendar selDate;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        recipe=findViewById(R.id.imgrecipe);
        home=findViewById(R.id.imghome);
        timer=findViewById(R.id.imgtimer);
        shopping=findViewById(R.id.imgshopping);
        profile=findViewById(R.id.imguser);
        floatbtn=findViewById(R.id.floatbtn);
        calendar = findViewById(R.id.calendarView);
        check=findViewById(R.id.imgcheck);
        check.setVisibility(View.GONE);
        plan=findViewById(R.id.editplan);
        plan.setVisibility(View.GONE);
        display=findViewById(R.id.textdisplay);
        display.setVisibility(View.GONE);
        removeplan=findViewById(R.id.removeplan);
        removeplan.setVisibility(View.GONE);
        id=getIntent().getIntExtra("id",1);
        database = new Database(Calender.this);
        SQLiteDatabase db = database.getReadableDatabase();
        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rec=new Intent(Calender.this,Recipe.class);
                rec.putExtra("id",id);
                startActivity(rec);
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h=new Intent(Calender.this,HomePage.class);
                h.putExtra("id",id);
                startActivity(h);
                finish();
            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ti=new Intent(Calender.this,TimerActivity.class);
                ti.putExtra("id",id);
                startActivity(ti);
                finish();
            }
        });
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shop=new Intent(Calender.this,Shopping.class);
                shop.putExtra("id",id);
                startActivity(shop);
                finish();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pro=new Intent(Calender.this,Profile.class);
                pro.putExtra("id",id);
                startActivity(pro);
                finish();
            }
        });
        floatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plan.setVisibility(View.VISIBLE);
                check.setVisibility(View.VISIBLE);
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p=plan.getText().toString();
                if (p.isEmpty())
                {
                    Toast.makeText(Calender.this,"Please enter plan", Toast.LENGTH_LONG).show();
                    return;
                }
                if (selDate!=null)
                {
                    Date d=selDate.getTime();
                    database.addNewEvent(p, String.valueOf(d), id);
                    plan.setVisibility(View.GONE);
                    check.setVisibility(View.GONE);
                    display.setVisibility(View.VISIBLE);
                    display.setText(""+p);
                    removeplan.setVisibility(View.VISIBLE);
                    floatbtn.setVisibility(View.GONE);
                }
                else
                {
                    Toast.makeText(Calender.this,"Please select the date", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                display.setVisibility(View.GONE);
                plan.setVisibility(View.GONE);
                check.setVisibility(View.GONE);
                removeplan.setVisibility(View.GONE);
                floatbtn.setVisibility(View.VISIBLE);
                selDate=Calendar.getInstance();
                selDate.set(i,i1,i2,0,0,0);
                Date d=selDate.getTime();
                String query = "SELECT event FROM calendar WHERE date = ? and userid=?";
                String[] args = {String.valueOf(d), String.valueOf(id)};
                Cursor cursor = db.rawQuery(query, args);
                if (cursor.moveToFirst()) {
                     String pl= cursor.getString(cursor.getColumnIndexOrThrow("event"));
                     display.setVisibility(View.VISIBLE);
                     display.setText(""+pl);
                     removeplan.setVisibility(View.VISIBLE);
                     floatbtn.setVisibility(View.GONE);
                }
                cursor.close();
            }
        });
        removeplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date d=selDate.getTime();
                String msg=database.deletePlan(String.valueOf(d));
                Toast.makeText(Calender.this,msg, Toast.LENGTH_LONG).show();
                display.setVisibility(View.GONE);
                removeplan.setVisibility(View.GONE);
                floatbtn.setVisibility(View.VISIBLE);
            }
        });
    }
}