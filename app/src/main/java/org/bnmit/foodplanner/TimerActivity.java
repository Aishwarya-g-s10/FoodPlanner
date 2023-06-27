package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    int id;
    EditText s,m,hour;
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
        s=findViewById(R.id.second);
        m=findViewById(R.id.minute);
        hour=findViewById(R.id.hour);
        id=getIntent().getIntExtra("id",1);
        h=new Handler();
        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rec=new Intent(TimerActivity.this,Recipe.class);
                rec.putExtra("id",id);
                startActivity(rec);
                finish();
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sch=new Intent(TimerActivity.this,Calender.class);
                sch.putExtra("id",id);
                startActivity(sch);
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h=new Intent(TimerActivity.this,HomePage.class);
                h.putExtra("id",id);
                startActivity(h);
                finish();
            }
        });
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shop=new Intent(TimerActivity.this,Shopping.class);
                shop.putExtra("id",id);
                startActivity(shop);
                finish();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pro=new Intent(TimerActivity.this,Profile.class);
                pro.putExtra("id",id);
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
                stopTimer();
                seconds=300;
                startTimer();

            }
        });
        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopTimer();
                seconds=180;
                startTimer();
            }
        });

    }
    private void startTimer() {
        int se=0,min=0,ho=0;
        if (seconds==0)
        {
            if ((s.getText().toString()).isEmpty())
                se=0;
            else
            {
                se=Integer.parseInt(s.getText().toString());
                if (se>59)
                {
                    se=59;
                    s.setText("59");
                }
            }
            if ((m.getText().toString()).isEmpty())
                min=0;
            else
            {
                min=Integer.parseInt(m.getText().toString());
                if (min>59)
                {
                    min=59;
                    m.setText("59");
                }
            }
            if ((hour.getText().toString()).isEmpty())
                ho=0;
            else {
                ho = Integer.parseInt(hour.getText().toString());
            }
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
            if (seconds<=0)
                resetTimer();
            seconds--;
        }
    };

}
