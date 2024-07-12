package com.study.spring.service;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.dto.ProductDTO;

@SpringBootTest
public class ProductServiceTests {

	@Autowired
	private ProductService productService;

	@Test
	public void testRegister() {

		for (int i = 0; i < 10; i++) {
			ProductDTO productDTO = ProductDTO.builder()
					.pname("새로운상품"+i).pdesc("새상품설명"+i).price(5000).build();

			productDTO.setUploadFileNames(
					java.util.List.of(UUID.randomUUID() + "_" + "test1.jpg", UUID.randomUUID() + "_" + "test2.jpg"));

			productService.register(productDTO);
		}
	}
}
