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
		// asMap() => model ����  Map Ÿ������ / Map �������� ����!
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		// content�� list���� ������ ����! �̸��� "request"��� �����!
		
		String bId = request.getParameter("bId");
		
		BDao dao = new BDao();
		BDto dto = dao.contentView(bId);
		
		model.addAttribute("content_view", dto);
		// "content_view"��� �̸����� content_view.jsp�� �����͸� �ѷ������!
		
		
	}

}
