package com.study.spring.service;

import java.util.List;
import java.util.Optional;

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

import jakarta.transaction.Transactional;
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
		
		//object[] -> 0 p 0 pimage
		//object[] -> 1 p 0 pimage
		
//		List<ProductDTO> dtoList = result.get().map(null).toList();
		List<ProductDTO> dtoList = result.get().map(
				arr -> {
					ProductDTO productDTO = null;
					Product product = (Product) arr[0];
					ProductImage productImage = (ProductImage) arr[1];
					
					productDTO = ProductDTO.builder()
							.pno(product.getPno())
							.pname(product.getPname())
							.pdesc(product.getPdesc())
							.price(product.getPrice())
							.build();
					
					String imageStr = productImage.getFileName();
					productDTO.setUploadFileNames(List.of(imageStr));
					
					return productDTO;
					
				})
				.toList();
		
		long totalCount = result.getTotalElements();
		
		return PageResponseDTO.<ProductDTO>withAll()
				.dtoList(dtoList)
				.totalCount(totalCount)
				.pageRequestDTO(pageRequestDTO)
				.build();
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


	@Override
	public ProductDTO get(Long pno) {
		Optional<Product> result = productRepository.findById(pno);
		Product product = result.orElseThrow();
		
		ProductDTO productDTO = entityToDto(product);
		
		return productDTO;
	}


	private ProductDTO entityToDto(Product product) {
		
		ProductDTO productDTO = ProductDTO.builder()
				.pno(product.getPno())
				.pname(product.getPname())
				.pdesc(product.getPdesc())
				.price(product.getPrice())
				.delFlag(product.isDelFlag())
				.build();
		
		List<ProductImage> imageList = product.getImageList();
		
		if(imageList == null || imageList.size()==0) {
			return productDTO;
		}
		
		List<String> fileNameList = imageList.stream()
				.map(productImage -> productImage.getFileName())
				.toList();
		
		productDTO.setUploadFileNames(fileNameList);
		
		return productDTO;
	}


	@Override
	public void modify(ProductDTO productDTO) {
		
		//#1 pno read
		Optional<Product> result = productRepository.findById(productDTO.getPno());
		Product product = result.orElseThrow();
		
		//#2 change
		product.changePname(productDTO.getPname());
		product.changePrice(productDTO.getPrice());
		product.changePdesc(productDTO.getPdesc());
		
		//#3 upload file clear
		product.clearList();
 		
		List<String> uploadFileNames = productDTO.getUploadFileNames();
		
		if(uploadFileNames != null && uploadFileNames.size() > 0) {
			uploadFileNames.stream().forEach(
					uploadName -> {
						product.addImageString(uploadName);
					});
		}
		
		//last
		productRepository.save(product);
		
		
	}


	@Override
	@Transactional
	public void remove(Long pno) {
		productRepository.updateToDelete(pno,true);
		
	}
	
	

	
	
	
	
	
	
}
