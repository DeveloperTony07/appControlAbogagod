package com.example.appabogadostn.crontroller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appabogadostn.modelo.Appointment;
import com.example.appabogadostn.modelo.Lawyer;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static SQLiteDatabase db;

    private static final String NOMBRE_DB = "LawyerDatingSQLite";
    private static final int VERSION_DB = 1;

    private final String LAWYER_TABLE ="lawyers"; // table name

    public static final String tbLawyers= "CREATE TABLE IF NOT EXISTS lawyers(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "identification TEXT NOT NULL UNIQUE," +
            "username TEXT NOT NULL," +
            "phone TEXT NOT NULL," +
            "email TEXT NOT NULL," +
            "password TEXT NOT NULL" +
            ");";

    private final String APPOINTMENT_TABLE = "appointments";

    public static final String tbAppointments = "CREATE TABLE IF NOT EXISTS appointments(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "lawyer_identification TEXT NOT NULL," +
            "appointmentType TEXT NOT NULL," +
            "appointmentName TEXT NOT NULL," +
            "clientName TEXT NOT NULL," +
            "clientID TEXT NOT NULL," +
            "clientPhone INTEGER NOT NULL," +
            "FOREIGN KEY(lawyer_identification) REFERENCES lawyers(identification)" +
            ");";

    public Database(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tbLawyers);
        db.execSQL(tbAppointments); // Agrega esta línea para crear la tabla de citas

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    /*------------------------------------------------------------------------*/

    //Open the database
    public void openDatabase(){
        SQLiteDatabase db = this.getWritableDatabase();
    }

    //Add user
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

    //Return user list
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
                lawyer.setPhone(cursor.getString(3));
                lawyer.setEmail(cursor.getString(4));
                lawyer.setPassword(cursor.getString(5));
                listLawyers.add(lawyer);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return  listLawyers;
    }

    /* User login */

    public boolean userLogin(String identification, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"id"};
        String selection = "identification = ? AND password = ?";
        String[] selectionArgs = {identification, password};

        Cursor cursor = db.query(LAWYER_TABLE, columns, selection, selectionArgs, null, null, null);

        boolean successfulLogin = cursor.moveToFirst();
        cursor.close();
        return  successfulLogin;
    }



    public ArrayList<Appointment> getAppointmentsForLawyer(String lawyerIdentification) {
        ArrayList<Appointment> appointments = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM appointments WHERE lawyer_identification = ?";
        String[] selectionArgs = {lawyerIdentification};

        Cursor cursor = db.rawQuery(query, selectionArgs);

        if (cursor.moveToFirst()) {
            do {
                Appointment appointment = new Appointment();
                appointment.setId(cursor.getInt(0));
                appointment.setLawyerId(cursor.getString(1));
                appointment.setAppointmentType(cursor.getString(2));
                appointment.setAppointmentName(cursor.getString(3));
                appointment.setClientName(cursor.getString(4));
                appointment.setClientID(cursor.getString(5));
                appointment.setClientPhone(cursor.getInt(6));
                appointments.add(appointment);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return appointments;
    }

    public Lawyer getLawyerInfo(String identification) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"username"};
        String selection = "identification = ?";
        String[] selectionArgs = {identification};

        Cursor cursor = db.query(LAWYER_TABLE, columns, selection, selectionArgs, null, null, null);

        Lawyer lawyer = null;
        if (cursor.moveToFirst()) {
            lawyer = new Lawyer();
            lawyer.setUsername(cursor.getString(0));
            lawyer.setIdentification(identification);
        }

        cursor.close();
        return lawyer;
    }

}
