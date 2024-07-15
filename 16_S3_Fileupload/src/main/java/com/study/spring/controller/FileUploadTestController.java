package com.study.spring.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.study.spring.service.S3FileUploadTestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FileUploadTestController {

	private final S3FileUploadTestService s3FileUploadTestService;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(
			@RequestPart("file") MultipartFile file
			) throws IOException {
		
		String url = s3FileUploadTestService.uploadFile(file);
		System.out.println(url);
		
		return ResponseEntity.ok(url);
	}
}
