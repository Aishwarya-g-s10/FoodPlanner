package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddNewRecipe extends AppCompatActivity {
    EditText recipe,serving,ingridient,method;
    RadioGroup radioGroup;
    RadioButton yes,no;
    Database db;
    Button add;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);
        db = new Database(AddNewRecipe.this);
        recipe=findViewById(R.id.recipeName);
        serving=findViewById(R.id.serving);
        ingridient=findViewById(R.id.ingridients);
        method=findViewById(R.id.method);
        radioGroup=findViewById(R.id.radio);
        yes=findViewById(R.id.radioYes);
        no=findViewById(R.id.radioNo);
        add=findViewById(R.id.buttonAdd);
        id=getIntent().getIntExtra("id",1);
        final String[] is_public = new String[1];
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Check which radio button is selected
                if (checkedId == R.id.radioYes) {
                    is_public[0] ="1";

                } else if (checkedId == R.id.radioNo) {
                    is_public[0] ="0";
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r=recipe.getText().toString();
                String s=serving.getText().toString();
                String i=ingridient.getText().toString();
                String m=method.getText().toString();
                if (r.isEmpty()||i.isEmpty()||m.isEmpty()||s.isEmpty())
                {
                    Toast.makeText(AddNewRecipe.this, "Please enter all the data", Toast.LENGTH_SHORT).show();
                    return;
                }
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId == -1) {
                    Toast.makeText(AddNewRecipe.this, "Select one of the radio buttons", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    int p=Integer.parseInt(is_public[0]);
                    db.addNewRecipe(r,i,m,Integer.parseInt(s),id,p);
                    Intent re=new Intent(AddNewRecipe.this,Recipe.class);
                    re.putExtra("id",id);
                    startActivity(re);
                    finish();
                }
            }
        });

    }
}