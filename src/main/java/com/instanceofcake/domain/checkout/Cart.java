package com.instanceofcake.domain.checkout;



import java.util.List;


public class Cart {

    private Integer cardId;
    private List<CartItem> cartItemList;
    
    public Cart() {
      super();
      // TODO Auto-generated constructor stub
    }

    public Cart(Integer cardId, List<CartItem> cartItemList) {
      super();
      this.cardId = cardId;
      this.cartItemList = cartItemList;
    }

    public Integer getCardId() {
      return cardId;
    }

    public void setCardId(Integer cardId) {
      this.cardId = cardId;
    }

    public List<CartItem> getCartItemList() {
      return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
      this.cartItemList = cartItemList;
    }
    

}
