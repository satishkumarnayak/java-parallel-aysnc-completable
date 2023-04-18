package com.instanceofcake.service;

import com.instanceofcake.domain.Product;
import com.instanceofcake.domain.ProductInfo;
import com.instanceofcake.domain.Review;
import static com.instanceofcake.util.CommonUtil.stopWatch;
import static com.instanceofcake.util.LoggerUtil.log;

public class ProductServiceWithThread {
  private ProductInfoService productInfoService;
  private ReviewService reviewService;

  public ProductServiceWithThread(ProductInfoService productInfoService,
      ReviewService reviewService) {
    this.productInfoService = productInfoService;
    this.reviewService = reviewService;
  }

  public Product retrieveProductDetails(String productId) throws InterruptedException {
    stopWatch.start();

    ProductInfoRunnable productInfoRunnable = new ProductInfoRunnable(productId);
    Thread productInfoThread = new Thread(productInfoRunnable);

    ReviewRunnable reviewRunnable = new ReviewRunnable(productId);
    Thread reviewThread = new Thread(reviewRunnable);

    productInfoThread.start();
    reviewThread.start();

    reviewThread.join();
    productInfoThread.join();
   


    ProductInfo productInfo = productInfoRunnable.getProductInfo();
    Review review = reviewRunnable.getReview();

    // ProductInfo productInfo = productInfoService.retrieveProductInfo(productId); // blocking call
    // Review review = reviewService.retrieveReviews(productId); // blocking call

    stopWatch.stop();
    log("Total Time Taken : " + stopWatch.getTime());
    return new Product(productId, productInfo, review);
  }

  public static void main(String[] args) throws InterruptedException {

    ProductInfoService productInfoService = new ProductInfoService();
    ReviewService reviewService = new ReviewService();
    ProductServiceWithThread productService =
        new ProductServiceWithThread(productInfoService, reviewService);
    String productId = "ABC123";
    Product product = productService.retrieveProductDetails(productId);
    log("Product is " + product);
   
  }

  private class ProductInfoRunnable implements Runnable {


    private String productId;
    private ProductInfo productInfo;

    public ProductInfoRunnable(String productId) {
      this.productId = productId;
    }



    public ProductInfo getProductInfo() {
      return productInfo;
    }



    @Override
    public void run() {
      productInfo = productInfoService.retrieveProductInfo(productId);

    }

  }


  class ReviewRunnable implements Runnable {


    private String productId;
    private Review review;

    public ReviewRunnable(String productId) {
      this.productId = productId;
    }



    public Review getReview() {
      return review;
    }



    @Override
    public void run() {
      review = reviewService.retrieveReviews(productId);

    }

  }
}


