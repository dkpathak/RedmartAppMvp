
package com.dharmendra.redmart.models.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Discounts {

    @SerializedName("promo")
    @Expose
    private Promo promo;
    @SerializedName("live_up")
    @Expose
    private LiveUp liveUp;

    public Promo getPromo() {
        return promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    public LiveUp getLiveUp() {
        return liveUp;
    }

    public void setLiveUp(LiveUp liveUp) {
        this.liveUp = liveUp;
    }

}
