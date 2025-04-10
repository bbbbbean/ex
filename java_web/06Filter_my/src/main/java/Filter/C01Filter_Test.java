package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// /index.do 안에서만 필터 처리 - 메인에서는 동작 x
//@WebFilter("/*.do")
public class C01Filter_Test implements Filter{

	// req와 resp 사이에서 쓰일 것
	// 필터는 체인으로 연결해서 사용할 수 있음 == 여러개의 필터를 사용할 수 있다
	// 중간에 필터 끼워넣기도 가능
	// 작업하는 순서대로 연결
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// request가 만들어지기 전처리 코드
		System.out.println("[Filter] Index Filter - start");
		
		// req와 resp 연결 - 기준
		chain.doFilter(req, resp);
		
		// reaponse가 완성되고 나갈 때 후처리 코드
		System.out.println("[Filter] Index Filter - end");
	}

}
