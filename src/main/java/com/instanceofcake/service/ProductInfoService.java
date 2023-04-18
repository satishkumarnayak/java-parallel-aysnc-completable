package com.instanceofcake.service;

import com.instanceofcake.domain.ProductInfo;
import com.instanceofcake.domain.ProductOption;
import java.util.ArrayList;
import java.util.List;

import static com.instanceofcake.util.CommonUtil.delay;

public class ProductInfoService {

  public ProductInfo retrieveProductInfo(String productId) {
    delay(1000);
    List<ProductOption> productOptions = new ArrayList();
    ProductOption p1 = new ProductOption(1, "64GB", "Black", 699.99);
    ProductOption p2 = new ProductOption(2, "128GB", "Black", 749.99);

    productOptions.add(p1);
    productOptions.add(p2);
    return new ProductInfo(productId, productOptions);

  }
}
