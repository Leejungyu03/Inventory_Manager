package com.manager.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {
	
	public final static String FILE_UPLOAD_PATH = "C:\\Users\\l1j1g\\Desktop\\이준규\\대학교\\OJT\\02_자바프로그래밍 활용 실무\\과제\\TermProject\\workspace\\images/";
	
	public String saveFile(String loginId, MultipartFile imageFile) throws IOException {
		// 파일명이 겹치지 않게 하기 위해 현재시간을 경로에 붙여준다.
		
		String directoryName = loginId + "_" + System.currentTimeMillis() + "/";
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			return null;
		}
		
		// 파일 업로드 : byte 단위로 업로드 한다.
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(filePath + imageFile.getOriginalFilename());
		Files.write(path, bytes);
		
		return "/images/" + directoryName + imageFile.getOriginalFilename();
	}
	
	// 파일 삭제
	// input : imagePath
	// output : x
	public void deleteFile(String imagePath) throws IOException {
		Path path = Paths.get(FILE_UPLOAD_PATH + imagePath.replace("/images", ""));
	
		if (Files.exists(path)) {
			Files.delete(path);
		}
		
		path = path.getParent();
		if (Files.exists(path)) {
			Files.delete(path);
		}
	}
}
