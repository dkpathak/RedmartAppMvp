
package com.dharmendra.redmart.models.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Promotion {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("savings_text")
    @Expose
    private String savingsText;
    @SerializedName("live_up_savings_text")
    @Expose
    private String liveUpSavingsText;
    @SerializedName("promo_label")
    @Expose
    private String promoLabel;
    @SerializedName("current_product_group_id")
    @Expose
    private Integer currentProductGroupId;
    @SerializedName("products")
    @Expose
    private List<PromoProduct> products = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSavingsText() {
        return savingsText;
    }

    public void setSavingsText(String savingsText) {
        this.savingsText = savingsText;
    }

    public String getLiveUpSavingsText() {
        return liveUpSavingsText;
    }

    public void setLiveUpSavingsText(String liveUpSavingsText) {
        this.liveUpSavingsText = liveUpSavingsText;
    }

    public String getPromoLabel() {
        return promoLabel;
    }

    public void setPromoLabel(String promoLabel) {
        this.promoLabel = promoLabel;
    }

    public Integer getCurrentProductGroupId() {
        return currentProductGroupId;
    }

    public void setCurrentProductGroupId(Integer currentProductGroupId) {
        this.currentProductGroupId = currentProductGroupId;
    }

    public List<PromoProduct> getProducts() {
        return products;
    }

    public void setProducts(List<PromoProduct> products) {
        this.products = products;
    }

}
