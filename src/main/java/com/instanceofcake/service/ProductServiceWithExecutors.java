package com.instanceofcake.service;

import com.instanceofcake.domain.Product;
import com.instanceofcake.domain.ProductInfo;
import com.instanceofcake.domain.Review;
import static com.instanceofcake.util.CommonUtil.stopWatch;
import static com.instanceofcake.util.LoggerUtil.log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProductServiceWithExecutors {
  
    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); 
    private ProductInfoService productInfoService;
    private ReviewService reviewService;
    

    public ProductServiceWithExecutors(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }

    public Product retrieveProductDetails(String productId) throws InterruptedException, ExecutionException {
        stopWatch.start();
       
         Future<ProductInfo> productInfoFuture = executorService.submit(() -> productInfoService.retrieveProductInfo(productId));
         Future<Review> reviewServiceFuture = executorService.submit(()-> reviewService.retrieveReviews(productId));

         ProductInfo productInfo  = productInfoFuture.get();
         Review review = reviewServiceFuture.get();
        stopWatch.stop();
        log("Total Time Taken : "+ stopWatch.getTime());
        executorService.shutdown();
        return new Product(productId, productInfo, review);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ProductInfoService productInfoService = new ProductInfoService();
        ReviewService reviewService = new ReviewService();
        ProductServiceWithExecutors productService = new ProductServiceWithExecutors(productInfoService, reviewService);
        String productId = "ABC123";
        Product product = productService.retrieveProductDetails(productId);
        log("Product is " + product);
        

    }
}
