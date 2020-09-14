package com.sakeya.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sakeya.dto.MemberVO;

public class QnaWriteFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "qnaWrite.jsp";
		
		HttpSession session = request.getSession();
		 MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		 if (loginUser == null) {
		 url = "SakeyaServlet?command=login_form";
		 }

		 request.getRequestDispatcher(url).forward(request, response);
	}

}
