package com.dharmendra.redmart.models;

import android.content.Context;

import com.dharmendra.redmart.dependency.ApplicationContext;
import com.dharmendra.redmart.models.apidata.ApiHelper;
import com.dharmendra.redmart.models.pojos.ProductResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;

/**
 * Created by dharmendra on 6/1/18.
 */


/**
 * This class is responsible for providing data from different data sources.
 * It could be either local, like Database or SharedPreferences or Network through HTTP req/res
 */


//Not using this class wrapper.
@Singleton
public class AppDataManager {


    private Context mContext;
    private ApiHelper mApiHelper;


    /**
     * Pass context and other dataHelper interface like shardPrefHelper and dbHelper
      * @param context
     * @param apiHelper apiHelper interface
     */
    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          ApiHelper apiHelper) {
        mContext = context;
    }
//    @Override
//    public Call<ProductResponse> getProducts(int page, int size) {
//        return null;
//    }
}
