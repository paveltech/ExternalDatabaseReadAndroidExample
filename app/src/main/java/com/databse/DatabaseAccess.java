package com.databse;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pojo.Pojo;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess  {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public List<Pojo> getCompany(){
        Pojo product = null;
        open();
        List<Pojo> productList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM company" , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            //product = new Pojo(cursor.getInt(0) , cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            product = new Pojo(cursor.getInt(0) , cursor.getString(1));
            productList.add(product);
            cursor.moveToNext();
        }
        cursor.close();
        return productList;
    }

    public List<Pojo> getEmploye(){
        Pojo product = null;
        open();
        List<Pojo> productList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM employe" , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            //product = new Pojo(cursor.getInt(0) , cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            product = new Pojo(cursor.getInt(0) , cursor.getString(1));
            productList.add(product);
            cursor.moveToNext();
        }
        cursor.close();

        return productList;
    }
}
