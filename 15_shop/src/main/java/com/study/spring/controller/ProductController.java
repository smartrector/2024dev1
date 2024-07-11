package com.study.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.study.spring.dto.ProductDTO;
import com.study.spring.service.ProductService;
import com.study.spring.util.CustomFileUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;
	
	private final CustomFileUtil fileUtil;
	
	@PostMapping("/")
	public Map<String,Long> register(ProductDTO productDTO) {
		log.info("register:" + productDTO);
		
		List<MultipartFile> files = productDTO.getFiles();
		List<String> uploadFileNames = fileUtil.saveFiles(files);
		
		productDTO.setUploadFileNames(uploadFileNames);
		
		log.info(uploadFileNames);
		
		Long pno = productService.register(productDTO);
		
		return Map.of("Result",pno);
	}
	
	@GetMapping("/view/{fileName}")
	public ResponseEntity<Resource> viewFilGet(
			@PathVariable("fileName") String fileName
			){
		
		return fileUtil.getFile(fileName);
	}
}
