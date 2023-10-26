package com.example.appabogadostn.crontroller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appabogadostn.modelo.Lawyer;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static SQLiteDatabase db;

    private static final String NOMBRE_DB = "LawyerDatingSQLite";
    private static final int VERSION_DB = 1;

    private final String LAWYER_TABLE ="lawyers";
    public static final String tbLawyers= "CREATE TABLE IF NOT EXISTS lawyers(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "identification TEXT NOT NULL UNIQUE," +
            "username TEXT NOT NULL," +
            "phone TEXT NOT NULL," +
            "email TEXT NOT NULL," +
            "password TEXT NOT NULL" +
            ");";

    public Database(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tbLawyers);
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    /*------------------------------------------------------------------------*/

    public void openDatabase(){
        SQLiteDatabase db = this.getWritableDatabase();
    }

    public boolean addLawyer(String identification, String username, String phone, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("identification", identification);
        values.put("username", username);
        values.put("phone", phone);
        values.put("email", email);
        values.put("password",password);

        long result = db.insert("lawyers", null,values);
        return result != -1;
    }

    public ArrayList<Lawyer> getLawyers(){
        ArrayList<Lawyer> listLawyers = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + LAWYER_TABLE, null);

        if (cursor.moveToFirst()) {
            do {
                Lawyer lawyer = new Lawyer();
                lawyer.setId(cursor.getInt(0));
                lawyer.setIdentification(cursor.getString(1));
                lawyer.setUsername(cursor.getString(2));
                lawyer.setPassword(cursor.getString(3));
                lawyer.setEmail(cursor.getString(4));
                listLawyers.add(lawyer);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return  listLawyers;
    }


}
