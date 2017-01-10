package com.javalec.spring_pjt_board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_pjt_board.command.BCommand;
import com.javalec.spring_pjt_board.command.BContentCommand;
import com.javalec.spring_pjt_board.command.BDeleteCommand;
import com.javalec.spring_pjt_board.command.BListCommand;
import com.javalec.spring_pjt_board.command.BModifyCommand;
import com.javalec.spring_pjt_board.command.BReplyCommand;
import com.javalec.spring_pjt_board.command.BReplyViewCommand;
import com.javalec.spring_pjt_board.command.BWriteCommand;
import com.javalec.spring_pjt_board.util.Constant;

// BController가 Controller의 역할을 하려면 오토스캔에 걸려야 한다. 걸리게 하기 위해서 어노테이션 설정!
@Controller
public class BController {
	
	
	BCommand command = null;

	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	

	
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		System.out.println("list");
		
		command = new BListCommand();
		command.execute(model);		
		
		return "list";
	}

	@RequestMapping("/write_view")
	public String wirte_view(Model model) {
		
		System.out.println("write_view");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
	// HttpServletRequest를 왜 받냐면 위에서 작성한 write_view를 폼에서 받아야 하기 때문!
		
		System.out.println("write()");

		model.addAttribute("request", request);
		// request 속성을 정해서 "request"에 담아버림. 어차 컨트롤러에서 작업을 안 하고 서비스와 DAO에서 작업하기 때문
		// 같이 model에 통째로 넣어버림.
		
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
		
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		
		command = new BModifyCommand();
		command.execute(model);
				
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");

		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.equals(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);		
		
		return "redirect:list";
	}

	@RequestMapping("/dbtest")
	public String dbtest() {
		System.out.println("dbtest()");
				
		return "DBConnectTest";
	}

	@RequestMapping("/dbcptest")
	public String dbcptest() {
		System.out.println("dbcptest()");
		
		return "DBCPConnectTest";
	}
	
	
}
