package Ch17;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class C08PropertiesMain {
	public static void main(String[] args) throws Exception {
		
		// 경로 정보 : 직접 넣으면 피곤해짐 -> 전역화, 위치정보를 받아놓는 과정을 거쳐야함, 언제든 변할 수 있는 값이라서.. 절대 안변한다!하면 고정값 O
		// class 경로 정보들 확인
		String classPath = System.getProperty("java.class.path");
		System.out.println("classPath : "+classPath);
		// dir 경로 정보들 확인
		String dirPath = System.getProperty("user.dir");
		System.out.println("dirPath : "+dirPath);
		// package 경로 정보들 확인
		String packagePath = C08PropertiesMain.class.getPackageName();
		System.out.println("packagePath : "+packagePath);
		
		// File.separator : 환경마다 키가 다름 - 
		String filePath = dirPath+File.separator+"src"+File.separator+packagePath+File.separator+"application.properties";
		FileInputStream fin = new FileInputStream(filePath);
		// 여기까지 properties 위치 찾은 거------------------------------------------------------------------------
		//----------------------------------------------------------------------------------------------------
		
		Properties properties = new Properties();
		properties.load(fin);
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		System.out.printf("%s %s %s\n",url,username,password);
		
		
	}
}
