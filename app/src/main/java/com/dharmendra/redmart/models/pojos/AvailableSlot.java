
package com.dharmendra.redmart.models.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvailableSlot {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("available")
    @Expose
    private String available;
    @SerializedName("slots")
    @Expose
    private List<Slot> slots = null;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

}
