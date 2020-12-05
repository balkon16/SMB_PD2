package com.hfad.pracadomowanr2.produkty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.pracadomowanr2.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    private SqliteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        updateProductList();
    }

    @Override
    protected void onResume(){
        super.onResume();
        setContentView(R.layout.activity_product_list);

        updateProductList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDatabase != null) {
            mDatabase.close();
        }
    }

    private void updateProductList(){
        RecyclerView productsView = findViewById(R.id.products_recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        productsView.setLayoutManager(gridLayoutManager);
        productsView.setHasFixedSize(true);

        mDatabase = new SqliteDatabase(this);

        ArrayList<Product> allProducts = mDatabase.listProducts();

        if (allProducts.size() > 0) {
            productsView.setVisibility(View.VISIBLE);
            ProductsAdapter mAdapter = new ProductsAdapter(this, allProducts);
            productsView.setAdapter(mAdapter);

        }
        else {
            Toast.makeText(this, "Lista zakupów jest pusta.", Toast.LENGTH_LONG).show();

        }
    }
}