package api.model.responses;

import com.google.gson.annotations.SerializedName;

public class Point {

    private String name;
    private Location location;
    @SerializedName("address_details")
    private AddressDetails addressDetails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public AddressDetails getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
    }

}
