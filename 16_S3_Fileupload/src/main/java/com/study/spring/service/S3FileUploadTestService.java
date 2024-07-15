package com.study.spring.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class S3FileUploadTestService {
	
	private final AmazonS3Client amazonS3;
	
	@Value("${cloud.aws.s3.bucket}")
	private String bucketName;
	
	private String dir="/raw";
	private String defaultUrl = "https://hanyong5-s3-file.s3.ap-northeast-2.amazonaws.com";
	
	public String uploadFile(MultipartFile file) throws IOException{
		String bucketDir = bucketName + dir;
		String dirUrl = defaultUrl + dir + "/";
		String fileName = generateFileName(file);
		
		amazonS3.putObject(bucketDir,fileName,file.getInputStream(),getObjectMetadata(file));
		
		return dirUrl + fileName;
	}

	private String generateFileName(MultipartFile file) {
		
		return UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
	}

	private ObjectMetadata getObjectMetadata(MultipartFile file) {
		
		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentType(file.getContentType());
		objectMetadata.setContentLength(file.getSize());
		
		return objectMetadata;
	}
	
	
}
