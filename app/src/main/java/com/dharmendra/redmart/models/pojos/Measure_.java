
package com.dharmendra.redmart.models.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Measure_ {

    @SerializedName("vol")
    @Expose
    private Double vol;
    @SerializedName("vol_metric")
    @Expose
    private String volMetric;
    @SerializedName("wt_metric")
    @Expose
    private String wtMetric;
    @SerializedName("l")
    @Expose
    private Double l;
    @SerializedName("w")
    @Expose
    private Double w;
    @SerializedName("h")
    @Expose
    private Double h;

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
    }

    public String getVolMetric() {
        return volMetric;
    }

    public void setVolMetric(String volMetric) {
        this.volMetric = volMetric;
    }

    public String getWtMetric() {
        return wtMetric;
    }

    public void setWtMetric(String wtMetric) {
        this.wtMetric = wtMetric;
    }

    public Double getL() {
        return l;
    }

    public void setL(Double l) {
        this.l = l;
    }

    public Double getW() {
        return w;
    }

    public void setW(Double w) {
        this.w = w;
    }

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }

}
