package com.example.bean.injection;

import lombok.Getter;

// This class represents a Helm
public class Helm {
    // This field holds the brand of the helm (default value is "HelmBrand")
    private String brandOfHelm = "HelmBrand";

    public String getBrandOfHelm() {
        return brandOfHelm;
    }

    // This method is a setter for the brandOfHelm field
    public void setBrandOfHelm(String brandOfHelm) {
        // Set the brandOfHelm field with the provided value
        this.brandOfHelm = brandOfHelm;
    }
}
