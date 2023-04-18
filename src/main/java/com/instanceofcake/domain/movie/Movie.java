package com.instanceofcake.domain.movie;




import java.util.List;


public class Movie {

    private MovieInfo movieInfo;
    private List<Review> reviewList;
    
    public Movie() {
      super();
      // TODO Auto-generated constructor stub
    }
    public Movie(MovieInfo movieInfo, List<Review> reviewList) {
      super();
      this.movieInfo = movieInfo;
      this.reviewList = reviewList;
    }
    public MovieInfo getMovieInfo() {
      return movieInfo;
    }
    public void setMovieInfo(MovieInfo movieInfo) {
      this.movieInfo = movieInfo;
    }
    public List<Review> getReviewList() {
      return reviewList;
    }
    public void setReviewList(List<Review> reviewList) {
      this.reviewList = reviewList;
    }
    
    
    
    
}
