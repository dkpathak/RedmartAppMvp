
package com.dharmendra.redmart.models.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Warehouse {

    @SerializedName("measure")
    @Expose
    private WHMeasure measure;

    public WHMeasure getMeasure() {
        return measure;
    }

    public void setMeasure(WHMeasure measure) {
        this.measure = measure;
    }

}
