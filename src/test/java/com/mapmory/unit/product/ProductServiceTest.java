package com.mapmory.unit.product;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mapmory.common.domain.Search;
import com.mapmory.common.util.ImageFileUtil;
import com.mapmory.services.product.domain.Product;
import com.mapmory.services.product.domain.ProductImage;
import com.mapmory.services.product.service.ProductService;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    //@Test
    public void testAddProduct() throws Exception {
        // Given
    	
    	LocalDateTime now = LocalDateTime.now();
    	Date sqlDate = Date.valueOf(now.toLocalDate());
    	
        Product product = new Product();
        product.setProductTitle("Test Product");
        product.setPrice(10000);
        product.setProductRegDate(sqlDate);
        product.setPeriod(1);
        product.setUserId("admin");

        List<String> imageFiles = new ArrayList<>();
        imageFiles.add("test_image12.jpg");
        imageFiles.add("test_image13.jpg");
        
        List<String> imageTag = new ArrayList<>();
        
        imageTag.add("/안녕/");
        imageTag.add("/잘가/");

        // When
        productService.addProduct(product, imageFiles, imageFiles,imageTag);

        // Then
    }
    
    @Test
    public void testGetProductList() throws Exception {
    	
    	Search search = new Search();
    	search.setCurrentPage(1);
    	search.setPageSize(18);
    	
    	Map<String,Object> map = productService.getProductList(search);
    	List<Product> list = (List<Product>)map.get("productList");
    	
    	System.out.println("리스트 확인 하세요 " +list);
    	
    	Assert.assertEquals(18, list.size());
		
		Integer totalCount = (Integer)map.get("productTotalCount");
	 	System.out.println(totalCount);
		
	 	System.out.println("=======================================");
	 	System.out.println("=======================================");
    	
    }
    
    //@Test
    public void testUpdateProduct() throws Exception {
        // Given
        LocalDateTime now = LocalDateTime.now();
        Date sqlDate = Date.valueOf(now.toLocalDate());

        Product product = new Product();
        product.setProductNo(17); // 업데이트할 제품 번호 설정
        product.setProductTitle("Updated Test Product");
        product.setPrice(15000);
        product.setProductRegDate(sqlDate);
        product.setPeriod(2);
        product.setUserId("admin");

        List<String> uuidFileNames = new ArrayList<>();
        uuidFileNames.add("updated_test_image_uuid.jpg");
        uuidFileNames.add("test_update_image_uuid.jpg");

        List<String> originalFileNames = new ArrayList<>();
        originalFileNames.add("updated_test_image.jpg");
        originalFileNames.add("test_update_image.jpg");

        // When
        productService.updateProduct(product, uuidFileNames, originalFileNames);

        // Then
        Product updatedProduct = productService.getDetailProduct(17);
        assertEquals("Updated Test Product", updatedProduct.getProductTitle());
        assertEquals(15000, updatedProduct.getPrice());
        assertEquals(2, updatedProduct.getPeriod());
        assertEquals("admin", updatedProduct.getUserId());

        List<String> updatedImageUuids = updatedProduct.getUuid();
        assertTrue(updatedImageUuids.contains("updated_test_image_uuid.jpg"));
        assertTrue(updatedImageUuids.contains("test_update_image_uuid.jpg"));
    }
    
    //@Test
    public void testDeleteImage() throws Exception {
    	
    	productService.deleteImage("c2e31b5692784d50ba294a81fb535b51.jpg","/");
    	System.out.println("=======================================");
    	
    }
    
    //@Test
    public void testDeleteProduct() throws Exception {
    	productService.deleteProduct(25,"/");
    }
    
    //@Test
    public void testGetDetailProduct() throws Exception {
    	
    	Product product = new Product();
    	
    	product = productService.getDetailProduct(26);
    	
    	System.out.println("여길 보시오 ~~ :::: " + product);
    }
}
