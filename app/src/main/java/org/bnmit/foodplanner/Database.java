package org.bnmit.foodplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }
}
