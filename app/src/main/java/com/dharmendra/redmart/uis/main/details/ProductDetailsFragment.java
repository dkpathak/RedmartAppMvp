package com.dharmendra.redmart.uis.main.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dharmendra.redmart.R;
import com.dharmendra.redmart.dependency.component.ActivityComponent;
import com.dharmendra.redmart.models.pojos.Product;
import com.dharmendra.redmart.models.pojos.ProductDetailsResponse;
import com.dharmendra.redmart.uis.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dharmendra on 6/1/18.
 */

public class ProductDetailsFragment extends BaseFragment implements ProductDetailsViewInteractor {

    @Inject
    ProductDetailsFragmentPresenter<ProductDetailsViewInteractor> presenter;

    @BindView(R.id.imageViewPager)
    ViewPager imageViewPager;

    @BindView(R.id.productName)
    TextView productNameView;

    @BindView(R.id.productPrice)
    TextView productPrice;

    @BindView(R.id.productWeight)
    TextView productWeight;

    @BindView(R.id.productdesc)
    TextView productDesc;

    @BindView(R.id.detailsContainer)
    LinearLayout containerLayout;


    private static final String PRODUCT_ID = "PRODUCT_ID";

    public static ProductDetailsFragment newInstance(int id){
        Bundle bundle = new Bundle();
        bundle.putInt(PRODUCT_ID,id);
        ProductDetailsFragment fragment = new ProductDetailsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments_product_details,container,false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            presenter.onAttach(this);
            presenter.getProductDetails(getArguments().getInt(PRODUCT_ID));
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        showLoader();
    }

    @Override
    public void onProductDetails(ProductDetailsResponse response) {
        containerLayout.setVisibility(View.VISIBLE);
        FragmentStatePagerAdapter pagerAdapter = new ImagePagerAdapter(getFragmentManager(),response.getProduct().getImages());
        imageViewPager.setAdapter(pagerAdapter);
        imageViewPager.getAdapter().notifyDataSetChanged();
        Product product = response.getProduct();
        productNameView.setText(response.getProduct().getTitle());
        Double price = product.getPricing().getPromoPrice()==0?product.getPricing().getPromoPrice():product.getPricing().getPrice();
        productPrice.setText("\u0024"+price);
        productWeight.setText(product.getMeasure().getWtOrVol());
        productDesc.setText(product.getDesc());
    }
}
