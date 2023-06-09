package com.kh.app;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.common.annotation.KhComponent;
import com.kh.app.common.annotation.KhController;
import com.kh.app.common.annotation.KhRepository;
import com.kh.app.common.annotation.KhService;

@WebServlet("/*")
public class MyServlet extends HttpServlet {
	
	private final List<Class> classList = new ArrayList<>();
	private final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	private final Map<String , Object> beanMap = new HashMap<>();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//요청 정보들 얻기	(이 정보들을 바탕으로 어느 메소드를 호출할지 결정)
			String method = req.getMethod();					//	GET , POST ...
			String uri = req.getRequestURI();					//	/app/board/list  ...
			String root = getServletContext().getContextPath();	//	/app
			uri = uri.replace(root, "");		// /app/board/list   ==>   /board/list
			
			//base package 의 모든 클래스를 읽어온 후, map 에 객체들을 등록
			setClassList("com/kh/app");	// com/kh/app 하위의 모든 클래스들을 classList 에 담음
			initBean();					//classList 중 Bean 에 해당하는 것들을 beanMap 에 등록
			
			//메소드 호출
			//argumentResolver
			//viewResolver
			
			if("리턴값".startsWith("redirect:")) {
				resp.sendRedirect("~~~");
			}else {
				req.setAttribute("model", "모델객체");
				req.getRequestDispatcher("~").forward(req, resp);
			}
			
			//req.getRequestDispatcher("pagezzz").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * class 정보들을 바탕으로 객체를 생성하여 beanMap 에 등록한다.
	 * 
	 * "@Autowired" 를 통한 연결관계 또한 신경써서 객체를 생성해야지만, 여기서는 생략
	 * 
	 * @throws Exception
	 */
	private void initBean() throws Exception {
		
		for (Class<?> clazz : classList) {
			System.out.println("현재 클래스 : " + clazz);
			boolean isBean = false;
			Annotation[] anoArr = clazz.getDeclaredAnnotations();
			
			//bean 맞는지 검사
			for (Annotation annotation : anoArr) {
				System.out.println("annotation : " + annotation);
				if(
						annotation.annotationType().equals(KhController.class)
						|| annotation.annotationType().equals(KhService.class)
						|| annotation.annotationType().equals(KhRepository.class)
						|| annotation.annotationType().equals(KhComponent.class)
						) 
				{
					System.out.println("if통과");
					isBean = true;
					break;
				}
			}
			
			//bean 아니면 작업 ㄴㄴ
			if(!isBean) {continue;}
			Object obj = clazz.getConstructor().newInstance();
			String objName = clazz.getSimpleName();
			beanMap.put(objName, obj);
		}
		
		
	}

	/**
	 * com.kh.app 하위의 모든 클래스파일들 가져오기
	 * 
	 * @param base-package 에 해당하는 경로 (이 아래 내용을 스캔할예정)
	 * @throws Exception (예외 걍 다 던짐)
	 */
	private void setClassList(String packageName) throws Exception {
		URL fileUrl = classLoader.getResource(packageName);	//	file:/D:/dev/mybatisRepo/test2/src/main/webapp/WEB-INF/classes/com/kh/app/
		File dir = new File(fileUrl.toURI());	//파일(디렉토리) 가져오기	//.txt , .jpg 뿐만아니라 디렉토리도 파일임.
		
		//경로 (com.kh.app 에 대하여) 정상인지 체크
		if(!dir.exists()) {new Exception("그런 파일 없음");}
		if(!dir.isDirectory()) {new Exception("이건 디렉토리가 아님");}
		
		// 2. com.kh.app 디렉토리 아래의 파일들 중 class 파일들 가져오기
		File[] fileList = dir.listFiles();	// 디렉토리(com.kh.app) 하위 파일리스트 가져오기
		for (File file: fileList) {	//file 은 com.kh.app 의 자식 파일(디렉토리포함)들을 가져온다.
			
			//디렉토리면 재귀호출
			if(file.isDirectory()) {
				setClassList(packageName + "/" + file.getName());
				continue;
			}
			
			String fileName = file.getName();
			if(fileName.endsWith("class")) {	//class 맞으면 list에 담기
				String className = packageName + "." + fileName.substring(0 , fileName.length() - 6);
				Class<?> clazz = Class.forName(className.replaceAll("/", "."));
				classList.add(clazz);
			}
		}
		
		
	}

}//class































