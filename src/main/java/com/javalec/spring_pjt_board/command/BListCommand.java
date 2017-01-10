// List������
// DB�� �ִ� �����͸� ��� �����ͼ� ȭ�鿡 �ѷ��ֱ� ���ؼ� ��, JSP ���������ٰ� 
// DTO ��ü�� �Ѱܼ� JSP �������� DTO �κ��� ������ �����͸� �̻ڰ� �ѷ��ֱ� ���� �۾��� �ؾ���.

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
		// view���� ���� �� "list"�� ������ ��.
		
	}

}
