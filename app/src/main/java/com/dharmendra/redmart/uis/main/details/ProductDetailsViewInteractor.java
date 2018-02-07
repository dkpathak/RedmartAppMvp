package com.dharmendra.redmart.uis.main.details;

import com.dharmendra.redmart.models.pojos.ProductDetailsResponse;
import com.dharmendra.redmart.uis.base.ViewInteractor;

/**
 * Created by dharmendra on 6/1/18.
 */

public interface ProductDetailsViewInteractor extends ViewInteractor {

        void onProductDetails(ProductDetailsResponse response);
}
