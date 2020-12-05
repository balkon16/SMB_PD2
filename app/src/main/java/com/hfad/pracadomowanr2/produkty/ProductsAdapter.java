package com.hfad.pracadomowanr2.produkty;

import android.content.Context;
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
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }


    // TODO: jak coś nie będzie działać to zajrzyj tutaj i zrób dokładnie tak samo jak w przykładzie


    // TODO: onBindViewHolder

}
