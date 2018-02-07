package com.dharmendra.redmart.uis.main.list;

import com.dharmendra.redmart.models.pojos.Product;
import com.dharmendra.redmart.uis.base.ViewInteractor;

import java.util.List;

/**
 * Created by dharmendra on 6/1/18.
 */

public interface ProductListViewInteractor extends ViewInteractor {
    void onProductResult(List<Product> products);
}
