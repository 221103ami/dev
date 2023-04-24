package com.kh.app.common.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileUploader {

	
	/**
	 * 서버에 파일을 저장한다.
	 * 저장한 파일명을 리턴해준다.
	 * 
	 * @param 파일객체
	 * @param 파일을 저장할경로
	 * @return 서버에 저장된 파일명
	 */
	public static String upload(MultipartFile f, String path) {
		//파일이 있는지
		if (f == null || f.isEmpty()) {return null;}
		
		//changeName 만들기
		String changeName = generateChangeName(f);
		
		//서버에 저장
		File target = new File(path + changeName);
		try {
			f.transferTo(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return changeName;
	}
	
	/**
	 * 현재 날짜 및 전달받은 파일 객체의 확장자 를 이용하여 문자열을 만들어낸다.
	 * 
	 * @param 파일객체
	 * @return 랜덤한파일명
	 */
	private static String generateChangeName(MultipartFile f) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentTime = sdf.format(new Date());
		int randomNum = (int)(Math.random() * 90000 + 10000);
		String originName = f.getOriginalFilename();
		String ext = originName.substring(originName.lastIndexOf("."));
		String changeName = currentTime + "_" + randomNum + ext;
		
		return changeName;
	}
	
	
	
}









