package com.hfad.pracadomowanr2.produkty;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.hfad.pracadomowanr2.R;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    TextView productName, productPrice, productQuantity, productUnit;
    Button manageButton;

    ProductViewHolder(View view){
        super(view);

//        System.out.println(view);
        productName = view.findViewById(R.id.product_name_text);
//        System.out.println(view);
        productPrice = view.findViewById(R.id.product_price_text);
        productQuantity = view.findViewById(R.id.product_quantity_text);
        productUnit = view.findViewById(R.id.product_unit_text);
        manageButton = view.findViewById(R.id.manage_button);
    }
}
