package com.hfad.pracadomowanr2.produkty;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SqliteDatabase extends SQLiteOpenHelper {

    private static final String DB_NAME = "products";
    private static final String PRODUCTS_TABLE = "PRODUCTS";
    private static final int DB_VERSION = 1;

    SqliteDatabase(Context context) { super(context, DB_NAME, null, DB_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateDatabase(db, oldVersion, newVersion);
    }

    private void updateDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE " + PRODUCTS_TABLE + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "PRICE REAL, "
                    + "QUANTITY REAL,"
                    + "UNIT TEXT,"
                    + "BOUGHT BOOLEAN);");
        }
    }

    ArrayList<Product> listProducts(){
        String sql = "SELECT * FROM " + PRODUCTS_TABLE + " WHERE BOUGHT < 1";
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Product> storeProducts = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                Double price = Double.parseDouble(cursor.getString(2));
                Double quantity = Double.parseDouble(cursor.getString(3));
                String unit = cursor.getString(4);
                storeProducts.add(new Product(id, name, price, quantity, unit));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return storeProducts;
    }

    public void addProduct(Product product){
        ContentValues productValues = new ContentValues();
        productValues.put("NAME", product.getName());
        productValues.put("PRICE", product.getPrice());
        productValues.put("QUANTITY", product.getQuantity());
        productValues.put("UNIT", product.getUnit());
        productValues.put("BOUGHT", false);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(PRODUCTS_TABLE, null, productValues);
    }
}
