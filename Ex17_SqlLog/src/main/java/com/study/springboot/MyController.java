package com.study.springboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.ISimpleBbsDao;

@Controller
public class MyController {
	
	//자동주입을 지정
	@Autowired
	//인터에시스 타입의 변수로 dao객체변수를 만듬
	ISimpleBbsDao dao;
	
	@RequestMapping("/")
	public String root() throws Exception{
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String userlistPage(Model model) {
		//게시판의 리스트를 출력하기 위해 dao의 listDao() 메소드를 호출하여 리턴값을 model 변수에 담는다.
		model.addAttribute("list",dao.listDao());
		return "list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request,Model model) {
		String sId = request.getParameter("id");
		
		//Model을 매개변수로 전달받고 있다. 매개변수로 전달받은 model.addAttribute("key", "value"); 
		//메소드를 이용하여 view 전달할 데이터를 key, value쌍으로하여 전달할 수 있다.
		//개별 게시글을 보기 위해 dao의 viewDao메소드를 호출하여 리턴값을 model변수에 담는다.
		model.addAttribute("dto",dao.viewDao(sId));
		return "view";
		
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		
		//입력 폼을 가진 JSP파일을 호출한다
		return "writeForm";

	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request,Model model) {
		
		//폼의 입력값을 파라미터로 받아 dao의 writeDao메소드를 호출해 데이터베이스에 insert한다.
		dao.writeDao(request.getParameter("writer"),
					 request.getParameter("title"),
					 request.getParameter("content"));
			
		return "redirect:list";
	
	}
	
	@RequestMapping("/delete")	
	public String delete(HttpServletRequest request,Model model) {
		
		//파라미터로 넘어온 값을 이용해 dao의 deleteDao 메소드를 호출해 데이터베이스에서 게시글을 delete한다.
		dao.deleteDao(request.getParameter("id"));
		return "redirect:list";
		
	}
		
	}
	










