
package com.dharmendra.redmart.models.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProdcutFilters {

    @SerializedName("frequency")
    @Expose
    private Integer frequency;
    @SerializedName("is_organic")
    @Expose
    private Integer isOrganic;
    @SerializedName("mfr_name")
    @Expose
    private String mfrName;
    @SerializedName("vendor_name")
    @Expose
    private String vendorName;
    @SerializedName("country_of_origin")
    @Expose
    private String countryOfOrigin;
    @SerializedName("trending_frequency")
    @Expose
    private Integer trendingFrequency;
    @SerializedName("brand_uri")
    @Expose
    private String brandUri;
    @SerializedName("brand_name")
    @Expose
    private String brandName;
    @SerializedName("festive_bbq")
    @Expose
    private String festiveBbq;
    @SerializedName("potluck")
    @Expose
    private String potluck;
    @SerializedName("natural")
    @Expose
    private Integer natural;
    @SerializedName("vegan")
    @Expose
    private Integer vegan;
    @SerializedName("holiday_brunch")
    @Expose
    private String holidayBrunch;
    @SerializedName("fsc")
    @Expose
    private Integer fsc;

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getIsOrganic() {
        return isOrganic;
    }

    public void setIsOrganic(Integer isOrganic) {
        this.isOrganic = isOrganic;
    }

    public String getMfrName() {
        return mfrName;
    }

    public void setMfrName(String mfrName) {
        this.mfrName = mfrName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public Integer getTrendingFrequency() {
        return trendingFrequency;
    }

    public void setTrendingFrequency(Integer trendingFrequency) {
        this.trendingFrequency = trendingFrequency;
    }

    public String getBrandUri() {
        return brandUri;
    }

    public void setBrandUri(String brandUri) {
        this.brandUri = brandUri;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getFestiveBbq() {
        return festiveBbq;
    }

    public void setFestiveBbq(String festiveBbq) {
        this.festiveBbq = festiveBbq;
    }

    public String getPotluck() {
        return potluck;
    }

    public void setPotluck(String potluck) {
        this.potluck = potluck;
    }

    public Integer getNatural() {
        return natural;
    }

    public void setNatural(Integer natural) {
        this.natural = natural;
    }

    public Integer getVegan() {
        return vegan;
    }

    public void setVegan(Integer vegan) {
        this.vegan = vegan;
    }

    public String getHolidayBrunch() {
        return holidayBrunch;
    }

    public void setHolidayBrunch(String holidayBrunch) {
        this.holidayBrunch = holidayBrunch;
    }

    public Integer getFsc() {
        return fsc;
    }

    public void setFsc(Integer fsc) {
        this.fsc = fsc;
    }

}
