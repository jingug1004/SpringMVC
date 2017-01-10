package com.javalec.spring_pjt_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_pjt_board.dao.BDao;
import com.javalec.spring_pjt_board.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		// asMap() => model 에서  Map 타입으로 / Map 형식으로 구함!
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		// content는 list에서 가져온 것임! 이름을 "request"라고 약속함!
		
		String bId = request.getParameter("bId");
		
		BDao dao = new BDao();
		BDto dto = dao.contentView(bId);
		
		model.addAttribute("content_view", dto);
		// "content_view"라는 이름으로 content_view.jsp에 데이터를 뿌려줘야함!
		
		
	}

}
