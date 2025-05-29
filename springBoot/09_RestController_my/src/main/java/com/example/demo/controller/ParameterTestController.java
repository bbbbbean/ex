package com.example.demo.controller;

import com.example.demo.domain.dto.PersonDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// 파라미터 받기
@Controller
@Slf4j
@RequestMapping("/param")
public class ParameterTestController {

	@RequestMapping(value="/p01",method=RequestMethod.GET)
	public void p01(@RequestParam(value="name",required = true) String name) {
		log.info("GET /param/p01 : "+name);
	}
	

	@GetMapping("/p02")
	public void p02(@RequestParam(value="name",required = true) String name) {
		log.info("GET /param/p02 : "+name);
	}

	@PostMapping(value="/p03")
	public void p03(@RequestParam(value="name",required = true) String name) {
		log.info("POST /param/p03 : "+name);
	}

	@PostMapping(value="/p04")
	public void p04(@RequestBody String name) {
		log.info("POST /param/p04 : "+name);
	}

	// 인자 전달 X시 기본으로 설정한 인자 전달
	@RequestMapping(value="/p05",method=RequestMethod.GET)
	public void p05(@RequestParam(value="name",defaultValue="홍씨") String name) {
		log.info("GET /param/p05 : "+name);
	}

	// 여러개 전달 가능
	@RequestMapping(value="/p06",method=RequestMethod.GET)
	public void p06(@RequestParam(value="name") String name,
					@RequestParam(value="age") int age,
					@RequestParam(value="addr") String addr) {
		log.info("GET /param/p06 : "+name+", "+age+", "+addr);
	}
	// 여러개 전달 때 쓰기 귀찮 -> class단위 DTO로 전달 가능
	// 여러개 속성을 DTO랑 비교, 맞는 속성에 끼워 넣음
	@RequestMapping(value="/p07",method=RequestMethod.GET)
	public void p07(@ModelAttribute PersonDto dto) {
		log.info("GET /param/p07 : "+dto);
	}

	@RequestMapping(value="/p08/{username}/{age}/{addr}",method=RequestMethod.GET)
	public void p08(@PathVariable("username") String name,
					@PathVariable int age,
					@PathVariable String addr) {
		log.info("GET /param/p08 : "+name+", "+age+", "+addr);
	}
	// DTO에 넣기 가능
	@RequestMapping(value="/p09/{username}/{age}/{addr}",method=RequestMethod.GET)
	public void p09(@ModelAttribute PersonDto dto) {
		log.info("GET /param/p09 : "+dto);
	}
	// @ModelAttribute는 생략 가능
	@RequestMapping(value="/p09_1/{username}/{age}/{addr}",method=RequestMethod.GET)
	public void p09_1(PersonDto dto) {
		log.info("GET /param/p09_1 : "+dto);
	}


	@GetMapping("/page01")
	public void page01(PersonDto dto, Model model) {
		log.info("GET /param/page01"+dto);
		model.addAttribute("dto",dto);
		model.addAttribute("test","test1value");
	}
	
	@GetMapping("/page02")
	public String page02(PersonDto dto, Model model) {
		log.info("GET /param/page02"+dto);

		model.addAttribute("dto",dto);
		model.addAttribute("test","test2value");

		return "param/page01";
	}
	
	@GetMapping("/page03/{username}/{age}/{addr}")
	public String page03(PersonDto dto, Model model) {
		log.info("GET /param/page03"+dto);

		model.addAttribute("dto",dto);
		model.addAttribute("test","test3value");

		return "param/page01";
	}

	@GetMapping("/page04/{username}/{age}/{addr}")
	public void page04(PersonDto dto) {
		log.info("GET /param/page04"+dto);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto",dto);
		modelAndView.setViewName("param/page01");	// 이동할 페이지 지정
	}
	
	@GetMapping("/page04_1/{username}/{age}/{addr}")
	public ModelAndView page04_1(PersonDto dto) {
		log.info("GET /param/page04_1"+dto);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto",dto);
		modelAndView.setViewName("param/page01");	// 이동할 페이지 지정
		return modelAndView;
	}
	// SERVLET 방식
	@GetMapping("/page05")
	public String page05(HttpServletRequest req, HttpServletResponse resp) {
		log.info("GET /param/page05");
		// 파라미터 받기
		String name = req.getParameter("username");
		int age = Integer.parseInt(req.getParameter("age"));
		String addr = req.getParameter("addr");
		
		log.info(name+", "+age+", "+addr);
		PersonDto dto = new PersonDto(name,age,addr);
		// 내용 담기
		req.setAttribute("dto", dto);
		
		HttpSession session = req.getSession();
		log.info("session : "+session);
		
		return "param/page01";
	}
	
	// forwarding 처리를 위한 함수등
	// forward: << 사용하면 dispatcher.forward()랑 같은 동작
	@GetMapping("/forward1")
	public String f1(Model model) {
		log.info("/param/forward1");
		model.addAttribute("f1","f1Value");
		return "forward:/param/forward2";
	}
	@GetMapping("/forward2")
	public String f2(Model model) {
		log.info("/param/forward2");
		model.addAttribute("f2","f2Value");
		return "forward:/param/forward3";
	}
	@GetMapping("/forward3")
	public String f3(Model model) {
		log.info("/param/forward3");
		model.addAttribute("f3","f3Value");
		return "/param/forward_result";
	}
	
	// redirect
	// redirect 속성값 전달 : RedirectAttributes
	@GetMapping("/redirect1")
	public String r1(Model model, RedirectAttributes redirectAttributes) {
		log.info("/param/redirect1");
		model.addAttribute("r1","r1Value");
		// 쿼리 스트림으로 전달
		// : 
		redirectAttributes.addAttribute("r11","r1reAt");
		return "redirect:/param/redirect2";
	}
	// @RequestParam("r11") String r11 으로 받아야함
	@GetMapping("/redirect2")
	public String r2(Model model, @RequestParam("r11") String r11, RedirectAttributes redirectAttributes) {
		log.info("/param/redirect2");
		model.addAttribute("r2","r3Value");
		redirectAttributes.addAttribute("r11",r11);
		redirectAttributes.addAttribute("r22","r2reAt");
		return "redirect:/param/redirect_result";
	}
	@GetMapping("/redirect_result")
	public void r3(Model model, @RequestParam("r11") String r11, @RequestParam("r22") String r22) {
		log.info("/param/redirect3");
		model.addAttribute("r11",r11);
		model.addAttribute("r22",r22);
		model.addAttribute("r3","r3Value");
	}
}
