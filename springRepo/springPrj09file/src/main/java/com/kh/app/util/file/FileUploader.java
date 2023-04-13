package com.kh.app.util.file;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileUploader {
	
	public static String saveFile(boolean isEmpty , String path, MultipartFile f) throws Exception {
		//파일 있는지 체크
		if(isEmpty) {throw new Exception();}
		
		//파일이름준비
		String changeName = generateName(f.getOriginalFilename());
		
		//타겟파일
		File target = new File(path + changeName);
		
		//바이너리 데이터 저장하기
		f.transferTo(target);
		
		return changeName;
	}
	
	//서버에 저장할 파일이름 생성 (현재시간 + 랜덤숫자5개)
	public static String generateName(String originName) {
		String ext = originName.substring(originName.lastIndexOf("."));
		long currentTime = System.currentTimeMillis();
		int random = (int) (Math.random() * 90000 + 10000);
		String changeName = currentTime + "_" + random + ext;
		return changeName;
	}

}











