package com.hfad.pracadomowanr2.produkty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    private SqliteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupDatabase();
    }

    private void setupDatabase(){

        try{
            db = new SqliteDatabase(this);
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
        // TODO: tutaj ma być rozgłaszana intencja, że produkt został dodany do bazy danych
        db.addProduct(new Product(productName, productPrice, productQuantity, productUnit));

        Intent intent = new Intent();
        intent.setAction("com.hfad.pracadomowanr2.produkty.NEW_PRODUCT_ADDED");
        intent.putExtra("NAME", productName);
        intent.putExtra("PRICE", productPrice);
        intent.putExtra("QUANTITY", productQuantity);
        intent.putExtra("UNIT", productUnit);
        sendBroadcast(intent);
    }

    public void onClickShoppingList(View view){
        Intent intent = new Intent(getApplicationContext(), ProductListActivity.class);
        startActivity(intent);
    }
}