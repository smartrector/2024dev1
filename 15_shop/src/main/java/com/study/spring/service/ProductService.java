package com.study.spring.service;

import com.study.spring.dto.PageRequestDTO;
import com.study.spring.dto.PageResponseDTO;
import com.study.spring.dto.ProductDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface ProductService {
	PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);
	
	Long register(ProductDTO producDTO);
}
