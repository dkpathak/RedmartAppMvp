
package com.dharmendra.redmart.models.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product implements Parcelable {

    @SerializedName("categories")
    @Expose
    private List<Integer> categories = null;
    @SerializedName("category_tags")
    @Expose
    private List<String> categoryTags = null;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("details")
    @Expose
    private Details details;
    @SerializedName("filters")
    @Expose
    private ProdcutFilters filters;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("img")
    @Expose
    private Img img;
    @SerializedName("measure")
    @Expose
    private Measure measure;
    @SerializedName("pricing")
    @Expose
    private Pricing pricing;
    @SerializedName("product_life")
    @Expose
    private ProductLife productLife;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("types")
    @Expose
    private List<Integer> types = null;
    @SerializedName("warehouse")
    @Expose
    private Warehouse warehouse;
    @SerializedName("description_fields")
    @Expose
    private DescriptionFields descriptionFields;
    @SerializedName("max_days_on_shelf")
    @Expose
    private Integer maxDaysOnShelf;
    @SerializedName("promotions")
    @Expose
    private List<Promotion> promotions = null;
    @SerializedName("inventory")
    @Expose
    private Inventory inventory;
    @SerializedName("pr")
    @Expose
    private Integer pr;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;

    protected Product(Parcel in) {
        categoryTags = in.createStringArrayList();
        desc = in.readString();
        sku = in.readString();
        title = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public List<String> getCategoryTags() {
        return categoryTags;
    }

    public void setCategoryTags(List<String> categoryTags) {
        this.categoryTags = categoryTags;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public ProdcutFilters getFilters() {
        return filters;
    }

    public void setFilters(ProdcutFilters filters) {
        this.filters = filters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Img getImg() {
        return img;
    }

    public void setImg(Img img) {
        this.img = img;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public ProductLife getProductLife() {
        return productLife;
    }

    public void setProductLife(ProductLife productLife) {
        this.productLife = productLife;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getTypes() {
        return types;
    }

    public void setTypes(List<Integer> types) {
        this.types = types;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public DescriptionFields getDescriptionFields() {
        return descriptionFields;
    }

    public void setDescriptionFields(DescriptionFields descriptionFields) {
        this.descriptionFields = descriptionFields;
    }

    public Integer getMaxDaysOnShelf() {
        return maxDaysOnShelf;
    }

    public void setMaxDaysOnShelf(Integer maxDaysOnShelf) {
        this.maxDaysOnShelf = maxDaysOnShelf;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Integer getPr() {
        return pr;
    }

    public void setPr(Integer pr) {
        this.pr = pr;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(categoryTags);
        dest.writeString(desc);
        dest.writeString(sku);
        dest.writeString(title);
    }
}
