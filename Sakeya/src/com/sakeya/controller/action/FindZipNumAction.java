package com.sakeya.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sakeya.dao.AddressDAO;
import com.sakeya.dto.AddressVO;

public class FindZipNumAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url ="findZipNum.jsp";
		
		String dong = request.getParameter("dong");
		
		 if(dong!=null && dong.trim().equals("")==false){
			 AddressDAO addressDAO=AddressDAO.getInstance();
			 ArrayList<AddressVO> addressList =
			addressDAO.selectAddressByDong(dong.trim());
			 request.setAttribute("addressList", addressList);
			 }
			 RequestDispatcher dispatcher=request.getRequestDispatcher(url);
			 dispatcher.forward(request, response); 
	}

}
