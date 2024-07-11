package com.study.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.spring.domain.Product;
import com.study.spring.domain.ProductImage;
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


	@Override
	public Long register(ProductDTO productDTO) {
		Product product = dtoToEntity(productDTO);
		
		log.info("#########################");
		log.info(product);
		log.info(product.getImageList());
		
		
		Long pno = productRepository.save(product).getPno();
		
		return pno;
	}


	private Product dtoToEntity(ProductDTO productDTO) {
		Product product = Product.builder()
				.pno(productDTO.getPno())
				.pname(productDTO.getPname())
				.pdesc(productDTO.getPdesc())
				.price(productDTO.getPrice())
				.build();
		
		List<String> upLoadFileNames = productDTO.getUploadFileNames();
		
		if(upLoadFileNames == null || upLoadFileNames.isEmpty()) {
			return product;
		}
		
		upLoadFileNames.forEach(fileName -> {
			product.addImageString(fileName);
		});
		
		return product;
	}

}
