package api.model.responses;

import com.google.gson.annotations.SerializedName;

public class AddressDetails {

    @SerializedName("post_code")
    private String postCode;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

}
