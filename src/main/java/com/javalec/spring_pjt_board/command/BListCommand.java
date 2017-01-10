// List에서는
// DB에 있는 데이터를 모두 가져와서 화면에 뿌려주기 위해서 즉, JSP 페이지에다가 
// DTO 객체를 넘겨서 JSP 페이지가 DTO 로부터 가져온 데이터를 이쁘게 뿌려주기 위한 작업을 해야함.

package com.javalec.spring_pjt_board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_pjt_board.dao.BDao;
import com.javalec.spring_pjt_board.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {

		BDao dao = new BDao();
		ArrayList<BDto>dtos = dao.list();
		
		model.addAttribute("list", dtos);
		// view에서 받을 때 "list"로 받으면 됨.
		
	}

}
