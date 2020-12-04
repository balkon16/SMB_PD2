package com.hfad.pracadomowanr2.produkty;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "products";
    private static final int DB_VERSION = 1;

    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateDatabase(db, oldVersion, newVersion);
    }

    public static void insertProduct(SQLiteDatabase db, String name, Double price
                                        , Double quantity, String unit, boolean bought) {
        ContentValues productValues = new ContentValues();
        productValues.put("NAME", name);
        productValues.put("PRICE", price);
        productValues.put("QUANTITY", quantity);
        productValues.put("UNIT", unit);
        productValues.put("BOUGHT", bought);
        db.insert("PRODUCTS", null, productValues);
    }

    private void updateDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE PRODUCTS (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "PRICE REAL, "
                    + "QUANTITY REAL,"
                    + "UNIT TEXT,"
                    + "BOUGHT BOOLEAN);");
        }
    }

}
