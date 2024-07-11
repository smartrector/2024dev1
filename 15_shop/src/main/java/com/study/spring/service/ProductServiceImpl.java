package com.study.spring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.spring.dto.PageRequestDTO;
import com.study.spring.dto.PageResponseDTO;
import com.study.spring.dto.ProductDTO;
import com.study.spring.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	
	
	@Override
	public PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = PageRequest.of(pageRequestDTO.getPage()-1,
				pageRequestDTO.getSize(),
				Sort.by("pno").descending());
		
		Page<Object[]> result = productRepository.selectList(pageable);
		
		//object[] -> 0 p 1 pimage
		//object[] -> 1 p 1 pimage
		
		return null;
	}

}
