package another.way;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pojo.Pojo;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase {

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    private ArrayList<String> districtList;

    public MyDatabase(Context context) {
        databaseHelper = new DatabaseHelper(context, "Test.db");
        database = databaseHelper.getReadableDatabase();
    }

    public void open() {
        this.database = databaseHelper.getWritableDatabase();
    }


    /*
    //Example of getting a list from database
    public ArrayList<String> getDistrictList() {
        districtList = new ArrayList<>();

        String query = "SELECT * FROM districtName ";
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                districtList.add(cursor.getString(cursor.getColumnIndex("name")));
            } while (cursor.moveToNext());
        }
        return districtList;
    }
     */

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

