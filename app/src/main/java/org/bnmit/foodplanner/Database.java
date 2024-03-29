package org.bnmit.foodplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.sql.Timestamp;

public class Database extends SQLiteOpenHelper {
    private static final String DB_NAME = "usersdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "user";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String USERNAME_COL = "username";
    private static final String PASSWORD_COL = "password";
    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + USERNAME_COL + " TEXT,"
                + PASSWORD_COL + " TEXT)";
        db.execSQL(query);
        String query1 = "CREATE TABLE recipe ( recipe_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,serving INTEGER,ingridients TEXT, method TEXT, userid INTEGER, is_public INTEGER,FOREIGN KEY (userid) REFERENCES user(id) ON DELETE CASCADE)";
        db.execSQL(query1);
        String query2 = "CREATE TABLE ingridients (ingridient_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,quantity DECIMAL(5,2), recipeid INTEGER, unit TEXT,FOREIGN KEY (recipeid) REFERENCES recipe(recipe_id) ON DELETE CASCADE)";
        db.execSQL(query2);
        String query3 = "CREATE TABLE calendar (event_id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT,date TEXT, userid INTEGER,FOREIGN KEY (userid) REFERENCES user(id) ON DELETE CASCADE)";
        db.execSQL(query3);
//        addNewUser("Admin","Admin@gmail.com","Admin@123");
//        addNewRecipe("Masala Dosa",20,1,1);
//        addNewIngridient("urad dhal",0.5,1,"cup");
//        addNewIngridient("chana dhal",3,1,"tablespoon");
//        addNewIngridient("Sona Masoori",1.5,1,"cup");
//        addNewIngridient("idli rice",0.5,1,"cup");
//        addNewIngridient("poha",3,1,"tablespoon");
//        addNewIngridient("fenugreek",0.5,1,"teaspoon");
//        addNewIngridient("water",1.75,1,"cup");
    }
    public void addNewUser(String name, String username, String password) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, name);
        values.put(USERNAME_COL, username);
        values.put(PASSWORD_COL, password);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public void addNewRecipe(String name,String ingridients,String method, int serving, int userid,int pub) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("ingridients", ingridients);
        values.put("method", method);
        values.put("serving", serving);
        values.put("userid", userid);
        values.put("is_public", pub);
        db.insert("recipe", null, values);
        db.close();
    }
    public void addNewIngridient(String name, double quantity, int recipeid,String unit) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("quantity", quantity);
        values.put("recipeid", recipeid);
        values.put("unit", unit);
        db.insert("ingridients", null, values);
        db.close();
    }
    public void addNewEvent(String event, String date, int userid) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("event", event);
        values.put("date", date);
        values.put("userid", userid);
        db.insert("calendar", null, values);
        return;
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + "recipe");
        db.execSQL("DROP TABLE IF EXISTS " + "ingridients");
        db.execSQL("DROP TABLE IF EXISTS " + "calendar");
        onCreate(db);
    }
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }
    public String updateData(String tableName, String id, String newValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("password", newValue);
        String selection = "id = ?";
        String[] selectionArgs = {id};
        int rowsUpdated = db.update(tableName, values, selection, selectionArgs);
        if (rowsUpdated > 0) {
            return ("Data updated successfully!");
        } else {
            return ("Failed to update data. Record not found.");
        }
    }
    public String deletePlan(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        String deleteQuery = "date = ?";
        String[] deleteArgs = {date};
        int rowsDeleted = db.delete("calendar", deleteQuery, deleteArgs);
        if (rowsDeleted > 0) {
            return ("Plan was deleted");
        } else {
            return("No plans were deleted");
        }
    }
}
