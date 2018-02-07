
package com.dharmendra.redmart.models.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WHMeasure {

    @SerializedName("vol_metric_alt")
    @Expose
    private String volMetricAlt;
    @SerializedName("wt_metric")
    @Expose
    private String wtMetric;
    @SerializedName("vol_metric")
    @Expose
    private String volMetric;
    @SerializedName("wt")
    @Expose
    private Double wt;
    @SerializedName("w")
    @Expose
    private Double w;
    @SerializedName("l")
    @Expose
    private Double l;
    @SerializedName("h")
    @Expose
    private Double h;
    @SerializedName("vol")
    @Expose
    private Double vol;

    public String getVolMetricAlt() {
        return volMetricAlt;
    }

    public void setVolMetricAlt(String volMetricAlt) {
        this.volMetricAlt = volMetricAlt;
    }

    public String getWtMetric() {
        return wtMetric;
    }

    public void setWtMetric(String wtMetric) {
        this.wtMetric = wtMetric;
    }

    public String getVolMetric() {
        return volMetric;
    }

    public void setVolMetric(String volMetric) {
        this.volMetric = volMetric;
    }

    public Double getWt() {
        return wt;
    }

    public void setWt(Double wt) {
        this.wt = wt;
    }

    public Double getW() {
        return w;
    }

    public void setW(Double w) {
        this.w = w;
    }

    public Double getL() {
        return l;
    }

    public void setL(Double l) {
        this.l = l;
    }

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
    }

}
