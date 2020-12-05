package com.hfad.pracadomowanr2.produkty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.pracadomowanr2.R;

public class ProductDetailsActivity extends AppCompatActivity {

    private final SqliteDatabase mDatabase = new SqliteDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent intent = getIntent();

        String productName = intent.getStringExtra("NAME");
        Double productPrice = intent.getDoubleExtra("PRICE", 0.0);
        Double productQuantity = intent.getDoubleExtra("QUANTITY", 0.0);
        String productUnit = intent.getStringExtra("UNIT");

        TextView productNameTextView = (TextView) findViewById(R.id.name_field);
        productNameTextView.setText(productName);
        EditText productPriceEditText = (EditText) findViewById(R.id.new_price_filed);
        productPriceEditText.setText(productPrice.toString());
        EditText productQuantityEditText = (EditText) findViewById(R.id.new_quantity_field);
        productQuantityEditText.setText(productQuantity.toString());
        TextView productUnitInfo = (TextView) findViewById(R.id.unit_info);
        productUnitInfo.setText(productUnit);

    }

    public void onMarkBought(View view){
        TextView productNameTextView = (TextView) findViewById(R.id.name_field);
        String productName = productNameTextView.getText().toString();
        mDatabase.removeProduct(productName);

        Intent intent = new Intent(this, ProductListActivity.class);
        startActivity(intent);
    }

    public void onUpdateProduct(View view){
        TextView productNameTextView = (TextView) findViewById(R.id.name_field);
        String productName = productNameTextView.getText().toString();
        EditText productPriceEditText = (EditText) findViewById(R.id.new_price_filed);
        Double productPrice = Double.parseDouble(productPriceEditText.getText().toString());
        EditText productQuantityEditText = (EditText) findViewById(R.id.new_quantity_field);
        Double productQuantity = Double.parseDouble(productQuantityEditText.getText().toString());

        ContentValues values = new ContentValues();
        values.put("PRICE", productPrice);
        values.put("QUANTITY", productQuantity);
        mDatabase.updateProduct(productName, values);

        Toast toast = Toast.makeText(this, "Zaktualizowano produkt " + productName + ".", Toast.LENGTH_SHORT);
        toast.show();
    }
}