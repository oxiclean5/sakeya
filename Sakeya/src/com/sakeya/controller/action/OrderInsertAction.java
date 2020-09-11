package com.sakeya.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sakeya.dao.CartDAO;
import com.sakeya.dao.OrderDAO;
import com.sakeya.dto.CartVO;
import com.sakeya.dto.MemberVO;

public class OrderInsertAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url ="SakeyaServlet?command = order_list";
		
		HttpSession session = request.getSession();
		 MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		 if (loginUser == null) {
		 url = "SakeyaServlet?command=login_form";
		 } else {
		 CartDAO cartDAO = CartDAO.getInstance();
		 ArrayList<CartVO> cartList = cartDAO.listCart(loginUser.getId());

		 OrderDAO orderDAO = OrderDAO.getInstance();

		 int maxOseq=orderDAO.insertOrder(cartList, loginUser.getId());
		 url = "SakeyaServlet?command=order_list&oseq="+maxOseq;
		 }
		 response.sendRedirect(url);
	}
	

}
