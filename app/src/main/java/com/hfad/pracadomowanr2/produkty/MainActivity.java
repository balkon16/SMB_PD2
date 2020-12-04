package com.hfad.pracadomowanr2.produkty;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.hfad.pracadomowanr2.R;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupDatabase();
    }

    private void setupDatabase(){
        SQLiteOpenHelper dbHelper = new DatabaseHelper(this);
        try{
            db = dbHelper.getReadableDatabase();

        } catch(SQLiteException e){
            Toast toast = Toast.makeText(this, "Baza niedostępna.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onAddProduct(View view){
        EditText productNameText = (EditText) findViewById(R.id.edit_product_name);
        String productName = productNameText.getText().toString();

        EditText productPriceText = (EditText) findViewById(R.id.edit_price);
        Double productPrice = Double.parseDouble(productPriceText.getText().toString());

        EditText productQuantityText = (EditText) findViewById(R.id.edit_quantity);
        Double productQuantity = Double.parseDouble(productQuantityText.getText().toString());

        Spinner unitSpinner = (Spinner) findViewById(R.id.unit_spinner);
        String productUnit = String.valueOf(unitSpinner.getSelectedItem());

        // debug
        Toast toast = Toast.makeText(this, "Wartości: " + productName + productPrice + productUnit, Toast.LENGTH_SHORT);
        toast.show();
        // TODO:
        DatabaseHelper.insertProduct(db, productName, productPrice, productQuantity, productUnit, false);
    }
}