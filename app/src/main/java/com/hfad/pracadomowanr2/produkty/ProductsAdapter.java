package com.hfad.pracadomowanr2.produkty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.hfad.pracadomowanr2.R;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private Context context;
    private ArrayList<Product> productsList;
    private SqliteDatabase mDatabase;

    ProductsAdapter(Context context, ArrayList<Product> productsList){
        this.context = context;
        this.productsList = productsList;
        mDatabase = new SqliteDatabase(context);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position){
        final Product product = productsList.get(position);

        holder.productName.setText(product.getName());
        holder.productPrice.setText(product.getPrice().toString());
        holder.productQuantity.setText(product.getQuantity().toString());
        holder.productUnit.setText(product.getUnit());

        holder.manageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProductDetailsActivity.class);
                intent.putExtra("NAME", product.getName());
                intent.putExtra("PRICE", product.getPrice());
                intent.putExtra("QUANTITY", product.getQuantity());
                intent.putExtra("UNIT", product.getUnit());
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

}
