package com.instanceofcake.domain;

public class Review {
    private int noOfReviews;
    private double overallRating;
    
    public Review() {
      super();
      // TODO Auto-generated constructor stub
    }

    public Review(int noOfReviews, double overallRating) {
      super();
      this.noOfReviews = noOfReviews;
      this.overallRating = overallRating;
    }

    public int getNoOfReviews() {
      return noOfReviews;
    }

    public void setNoOfReviews(int noOfReviews) {
      this.noOfReviews = noOfReviews;
    }

    public double getOverallRating() {
      return overallRating;
    }

    public void setOverallRating(double overallRating) {
      this.overallRating = overallRating;
    }

    @Override
    public String toString() {
      return "Review [noOfReviews=" + noOfReviews + ", overallRating=" + overallRating + "]";
    }
    
    
    
}
