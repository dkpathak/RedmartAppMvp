
package com.dharmendra.redmart.models.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PromoProduct {

    @SerializedName("images")
    @Expose
    private List<PromoProdImage> images = null;
    @SerializedName("group_id")
    @Expose
    private Integer groupId;
    @SerializedName("min_qty")
    @Expose
    private Integer minQty;

    public List<PromoProdImage> getImages() {
        return images;
    }

    public void setImages(List<PromoProdImage> images) {
        this.images = images;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getMinQty() {
        return minQty;
    }

    public void setMinQty(Integer minQty) {
        this.minQty = minQty;
    }

}
