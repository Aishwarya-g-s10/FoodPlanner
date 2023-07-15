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
            db.addNewRecipe("Masala Dosa","urad dhal, chana dhal, Sona Masoori, idli rice, poha, fenugreek, water","Soak 1 cup of rice (preferably parboiled or idli rice) and 1/4 cup of fenugreek seeds (methi seeds) together in a bowl filled with enough water for about 4-6 hours. Also, soak 1/2 cup of urad dal (split black gram) in a separate bowl with enough water for the same duration. Drain the soaked rice and fenugreek seeds, and transfer them to a blender or wet grinder. Grind them into a smooth batter by gradually adding water. The consistency should be similar to pancake batter. Transfer the batter to a large bowl. Drain the soaked urad dal and add it to the same blender or wet grinder. Grind it into a smooth and fluffy batter, adding water as needed. Combine the urad dal batter with the rice batter in the bowl. Add salt to taste and mix well. Cover the bowl with a lid or a clean cloth and let the batter ferment in a warm place for 8-12 hours or overnight. Fermentation helps in making the dosas light and fluffy. After fermentation, gently mix the batter. The batter will rise and become slightly frothy. Heat a non-stick or cast-iron dosa tawa (griddle) over medium heat. Take a ladleful of batter and pour it onto the center of the tawa. Spread the batter in a circular motion using the back of the ladle to form a thin, round dosa. Drizzle a little oil or ghee around the edges of the dosa and on the surface. Cook the dosa until the bottom turns golden brown and crispy. Flip the dosa using a spatula and cook the other side for a minute or until it is cooked through. Remove the dosa from the tawa and serve hot. Repeat the process with the remaining batter to make more dosas. Serve the dosas hot with coconut chutney, sambar, or any other desired accompaniment.",20,1,1);
            db.addNewRecipe("Aloo Matar","Potatoes, Green peas, Onion, Tomatoes, Oil or ghee (clarified butter), Cumin seeds, Ginger-garlic paste, Turmeric powder, Red chili powder, Coriander powder, Salt, Garam masala powder,Fresh cilantro leaves","Heat oil or ghee in a pan over medium heat. Add cumin seeds and let them splutter. Add finely chopped onions and sauté until they turn golden brown. Add ginger-garlic paste and cook for a minute until the raw smell disappears. Add chopped tomatoes and cook until they become soft and mushy. Add turmeric powder, red chili powder, coriander powder, and salt. Mix well. Add diced potatoes and green peas to the pan. Mix them with the spice mixture. Pour water, cover the pan, and let it simmer on low heat until the potatoes and peas are cooked and tender. Once the vegetables are cooked, mash a few potatoes with the back of a spoon to thicken the gravy. Add garam masala powder and mix well. Cook for an additional minute. Garnish with fresh cilantro leaves. Serve hot with roti, naan, or rice.",4,1,1);
            db.addNewRecipe("Palak Paneer"," spinach, paneer (Indian cottage cheese), onions, tomatoes, ginger, garlic, green chilies, cumin seeds, turmeric powder, garam masala, cream, oil or ghee (clarified butter), and salt.","Blanch spinach, blend into a puree. Sauté onions, ginger, garlic, green chilies. Add tomatoes, spices, and cook. Pour in spinach puree, simmer. Add paneer, cook briefly. Finish with cream. Serve hot with naan or rice.",5,1,1);
            db.addNewRecipe("Naan","All-purpose flour, yogurt, milk, sugar, salt, baking powder, yeast, oil or ghee (clarified butter)","In a mixing bowl, combine 2 cups of all-purpose flour, 1/4 cup of yogurt, 1/4 cup of milk, 1 teaspoon of sugar, 1/2 teaspoon of salt, 1/2 teaspoon of baking powder, and 1/2 teaspoon of yeast.Mix well and knead the dough for about 5-7 minutes until it becomes smooth and elastic. Add a little more flour if the dough is too sticky.Cover the dough with a damp cloth and let it rest in a warm place for about 2 hours, allowing it to rise and double in size.Preheat a non-stick skillet or tawa over medium heat. Take a small portion of the dough, roll it into a round shape, and brush one side with water.Place the naan on the skillet with the wet side down. Cook for about 1-2 minutes until bubbles form on the surface, then flip it over and cook the other side for another 1-2 minutes until it puffs up and gets golden brown spots. Apply a little oil or ghee on both sides while cooking. Repeat the process for the remaining dough.",6,1,1);
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