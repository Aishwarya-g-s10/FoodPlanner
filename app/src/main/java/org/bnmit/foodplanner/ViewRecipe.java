package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class ViewRecipe extends AppCompatActivity {
    TextView r,i,m;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        r=findViewById(R.id.recipename);
        i=findViewById(R.id.in);
        m=findViewById(R.id.me);
        name=getIntent().getStringExtra("name");
        Database database=new Database(this);
        SQLiteDatabase db = database.getReadableDatabase();
        String query = "SELECT * FROM recipe WHERE name = ?";
        Cursor cursor = db.rawQuery(query, new String[]{name});
        if (cursor.moveToFirst())
        {
            String ing = cursor.getString(cursor.getColumnIndexOrThrow("ingridients"));
            String met = cursor.getString(cursor.getColumnIndexOrThrow("method"));
            r.setText(name);
            i.setText(ing);
            m.setText(met);
        }
    }
}