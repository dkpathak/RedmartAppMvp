package com.dharmendra.redmart.uis.main.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dharmendra.redmart.R;
import com.dharmendra.redmart.dependency.component.ActivityComponent;
import com.dharmendra.redmart.uis.base.BaseFragment;
import com.dharmendra.redmart.utility.AppConstants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dharmendra on 7/1/18.
 */

public class ImageFragment extends BaseFragment {

    @BindView(R.id.detailsImage)
    ImageView productImageView;

    private static final String URL  ="url";

    public static ImageFragment newInstance(String url){

        Bundle bundle = new Bundle();
        bundle.putString(URL,url);
        ImageFragment fragment = new ImageFragment();
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
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        setUnBinder(ButterKnife.bind(this, view));

        return view;
    }

    @Override
    protected void setUp(View view) {
        Picasso.with(getContext()).load(AppConstants.IMG_BASE_URL+getArguments().getString(URL)).into(productImageView);
    }
}
