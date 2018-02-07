package com.dharmendra.redmart.uis.main.list;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dharmendra.redmart.R;
import com.dharmendra.redmart.models.pojos.Product;
import com.dharmendra.redmart.utility.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dharmendra on 6/1/18.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductHolder> {

    private OnProductClickListener productClickListener;
    private List<Product> products = new ArrayList<>();
    private String TAG = "ProductListAdapter";
    private boolean isLoading =false;

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
        notifyDataSetChanged();
        isLoading = false;
    }

    public void clear(){
        products.clear();
    }

    public void setProductClickListener(OnProductClickListener productClickListener) {
        this.productClickListener = productClickListener;
    }

    @Override
    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ProductHolder holder, int position) {
        Product product = products.get(position);

        if (product.getPricing().getPromoPrice() > 0) {

            holder.priceView.setVisibility(View.VISIBLE);
            holder.priceView.setText("\u0024" + String.format("%.2f", product.getPricing().getPrice()));
            holder.priceView.setPaintFlags(holder.priceView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            holder.pricePromoView.setText("\u0024" + String.format("%.2f", product.getPricing().getPromoPrice()));

        }else{
            holder.priceView.setVisibility(View.GONE);
            holder.pricePromoView.setText("\u0024" + String.format("%.2f", product.getPricing().getPrice()));
        }

        holder.productNameView.setText(product.getTitle());

        Picasso.with(holder.imageView.getContext())
                .load(AppConstants.IMG_BASE_URL + product.getImg().getName())
                .placeholder(R.drawable.redmart)
                .into(holder.imageView);


        if(!isLoading && position>=getItemCount()*.80){
            isLoading = true;
            productClickListener.loadMore(getItemCount());

        }
    }


    @Override
    public int getItemCount() {
        return this.products.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView priceView;
        public TextView pricePromoView;
        public TextView productNameView;

        public ProductHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.row_image);
            productNameView = itemView.findViewById(R.id.productName);
            priceView = itemView.findViewById(R.id.productPrice);
            pricePromoView = itemView.findViewById(R.id.productPromoPrice);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productClickListener.onProductClick(products.get(getAdapterPosition()).getId());
                }
            });
        }
    }


    public interface OnProductClickListener {
        void onProductClick(int id);
        void loadMore(int size);
    }
}
