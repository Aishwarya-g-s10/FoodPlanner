package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button register,login;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register=findViewById(R.id.button1);
        login=findViewById(R.id.button2);
        db=new Database(this);
        SQLiteDatabase database = db.getReadableDatabase();
        String query = "SELECT * FROM user WHERE username = ?";
        String[] admin = {"Admin@gmail.com"};
        Cursor cursor = database.rawQuery(query,admin);
        if (!cursor.moveToFirst())
        {
            db.addNewUser("Admin","Admin@gmail.com","Admin@123");
            db.addNewRecipe("Masala Dosa",20,1,1);
            db.addNewRecipe("Aloo Matar",4,1,1);
            db.addNewRecipe("Palak Panner",5,1,1);
            db.addNewRecipe("Naan",6,1,1);
            db.addNewIngridient("urad dhal",0.5,1,"cup");
            db.addNewIngridient("chana dhal",3,1,"tablespoon");
            db.addNewIngridient("Sona Masoori",1.5,1,"cup");
            db.addNewIngridient("idli rice",0.5,1,"cup");
            db.addNewIngridient("poha",3,1,"tablespoon");
            db.addNewIngridient("fenugreek",0.5,1,"teaspoon");
            db.addNewIngridient("water",1.75,1,"cup");
        }
    }
    public void register(View view){
        Intent ref = new Intent(this, Register.class);
        startActivity(ref);
    }
    public void login(View view){
        Intent ref = new Intent(this, Login.class);
        startActivity(ref);
    }

}