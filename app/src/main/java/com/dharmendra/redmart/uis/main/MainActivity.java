package com.dharmendra.redmart.uis.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;

import com.dharmendra.redmart.R;
import com.dharmendra.redmart.models.pojos.Product;
import com.dharmendra.redmart.uis.base.BaseActivity;
import com.dharmendra.redmart.uis.main.details.ProductDetailsFragment;
import com.dharmendra.redmart.uis.main.list.ProductListFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements
        MainViewInteractor,ProductListFragment.FragmentInteractionListener{

    ProductListFragment listFragment;


    //For unit Test
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUnBinder(ButterKnife.bind(this));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listFragment = ProductListFragment.getNewInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.container,listFragment,"list").commit();
    }

    @Override
    public void onOpenDetailsFragment(int productId) {
        ProductDetailsFragment fragment = ProductDetailsFragment.newInstance(productId);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,fragment).addToBackStack("details").commit();

    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()>0)
            getSupportFragmentManager().popBackStack();
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to exit app ?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.show();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
