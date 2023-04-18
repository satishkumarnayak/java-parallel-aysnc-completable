package com.instanceofcake.domain;




public class Inventory {
    private int count;

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }

    public Inventory(int count) {
      super();
      this.count = count;
    }

    public Inventory() {
      super();
      // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
      return "Inventory [count=" + count + "]";
    }
    
    
} 
