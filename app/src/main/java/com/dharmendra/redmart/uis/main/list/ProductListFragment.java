package com.dharmendra.redmart.uis.main.list;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.dharmendra.redmart.R;
import com.dharmendra.redmart.dependency.component.ActivityComponent;
import com.dharmendra.redmart.models.pojos.Product;
import com.dharmendra.redmart.uis.base.BaseFragment;
import com.dharmendra.redmart.uis.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dharmendra on 6/1/18.
 */

public class ProductListFragment extends BaseFragment implements ProductListViewInteractor,
        ProductListAdapter.OnProductClickListener {

    @Inject
    ProductFragmentPresenter<ProductListViewInteractor> productFragmentPresenter;

    @Inject
    ProductListAdapter productListAdapter;

    @Inject
    GridLayoutManager layoutManager;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;


    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    private FragmentInteractionListener interactionListener;

    private List<Product> products = new ArrayList<>();

    public static ProductListFragment getNewInstance() {
        return new ProductListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            interactionListener = (FragmentInteractionListener) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            productFragmentPresenter.onAttach(this);
            productListAdapter.setProductClickListener(this);
            if (products.isEmpty()) {
                progressBar.setVisibility(View.VISIBLE);
                productFragmentPresenter.fetchProductData(0, 20);
            }
            else{
                productListAdapter.addProducts(products);
            }
        }

        return view;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        if(savedInstanceState!=null) {
            products = savedInstanceState.getParcelableArrayList("PRODUCT");
        }
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("PRODUCT",(ArrayList<? extends Parcelable>) products);
        super.onSaveInstanceState(outState);
    }

    public void onRefresh() {
        productFragmentPresenter.fetchProductData(0, 20);
        productListAdapter.clear();
    }

    @Override
    protected void setUp(View view) {
        recyclerView.setHasFixedSize(true);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(productListAdapter);

    }

    @Override
    public void onProductResult(List<Product> products) {
        this.products.addAll(products);
        productListAdapter.addProducts(products);
    }

    @Override
    public void onProductClick(int id) {
        interactionListener.onOpenDetailsFragment(id);
    }

    @Override
    public void loadMore(int currentSize) {
        productFragmentPresenter.fetchProductData(currentSize, 20);
    }

    public interface FragmentInteractionListener extends Callback {
        void onOpenDetailsFragment(int productId);
    }
}
