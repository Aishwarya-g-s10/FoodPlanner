package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {
    ImageView recipe,schedule,home,shopping,profile;
    TextView egg,milk,count;
    Button start, reset, stop;
    Handler h;
    boolean isTimerRunning;
    int seconds=0;
    NumberPicker s,m,hour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        recipe=findViewById(R.id.imgrecipe);
        schedule=findViewById(R.id.imgschedule);
        home=findViewById(R.id.imghome);
        shopping=findViewById(R.id.imgshopping);
        profile=findViewById(R.id.imguser);
        egg=findViewById(R.id.textegg);
        milk=findViewById(R.id.textmilk);
        start=findViewById(R.id.start);
        reset=findViewById(R.id.reset);
        stop=findViewById(R.id.stop);
        stop.setVisibility(View.GONE);
        reset.setVisibility(View.GONE);
        count=findViewById(R.id.textcount);
        s=findViewById(R.id.secondsPicker);
        m=findViewById(R.id.minutesPicker);
        hour=findViewById(R.id.hourPicker);
        h=new Handler();
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
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seconds=300;
                h.postDelayed(t,0);

            }
        });
        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seconds=180;
            }
        });

    }
    private void startTimer() {
        if (seconds==0)
        {
            int se=s.getValue();
            int min=m.getValue();
            int ho=hour.getValue();
            seconds=ho*3600+min*60+se;
        }
        isTimerRunning = true;
        h.postDelayed(t,0);
        start.setVisibility(View.GONE);
        stop.setVisibility(View.VISIBLE);
        reset.setVisibility(View.VISIBLE);
    }
    private void stopTimer() {
        isTimerRunning = false;
        h.removeCallbacks(t);
        start.setVisibility(View.VISIBLE);
        stop.setVisibility(View.GONE);
    }
    private void resetTimer() {
        stopTimer();
        seconds=0;
        count.setText("00:00:00");
        reset.setVisibility(View.GONE);
    }
    public Runnable t=new Runnable() {
        @Override
        public void run() {
            int hours=seconds/3600;
            int minutes = seconds % 3600/60;
            int remainingSeconds = seconds % 60;
            String time = String.format("%02d:%02d:%02d", hours,minutes, remainingSeconds);
            count.setText(time);
            h.postDelayed(this,1000);
            seconds--;
        }
    };

}
