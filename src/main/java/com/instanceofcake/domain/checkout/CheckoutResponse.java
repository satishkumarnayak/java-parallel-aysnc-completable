package com.instanceofcake.domain.checkout;

import java.util.ArrayList;
import java.util.List;

public class CheckoutResponse {

    CheckoutStatus checkoutStatus;
    List<CartItem> errorList = new ArrayList<>();
    double finalRate;

    public CheckoutResponse(CheckoutStatus checkoutStatus) {
        this.checkoutStatus = checkoutStatus;
    }

    public CheckoutResponse(CheckoutStatus checkoutStatus, List<CartItem> errorList) {
        this.checkoutStatus = checkoutStatus;
        this.errorList = errorList;
    }

    public CheckoutResponse(CheckoutStatus checkoutStatus, double finalRate) {
        this.checkoutStatus = checkoutStatus;
        this.finalRate = finalRate;
    }

    public CheckoutStatus getCheckoutStatus() {
      return checkoutStatus;
    }

    public void setCheckoutStatus(CheckoutStatus checkoutStatus) {
      this.checkoutStatus = checkoutStatus;
    }

    public List<CartItem> getErrorList() {
      return errorList;
    }

    public void setErrorList(List<CartItem> errorList) {
      this.errorList = errorList;
    }

    public double getFinalRate() {
      return finalRate;
    }

    public void setFinalRate(double finalRate) {
      this.finalRate = finalRate;
    }
    
    
    
}
