package com.sakeya.controller;

import com.sakeya.controller.action.*;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	public ActionFactory() {
		super();
	}
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action =null;
		System.out.println("ActionFactory :" + command);
		
		if(command.equals("index")) {
			action = new IndexAction();
		}else if (command.equals("product_detail")) {
			action = new ProductDetailAction();
		}else if(command.equals("catagory")) {
			action=new ProductKindAction();
		}else if(command.equals("contract")) {
			action=new ContractAction();
		}else if(command.equals("join_form")) {
			action = new JoinFormAction();
		}else if(command.equals("id_check_form")) {
			action = new idCheckFormAction();
		}else if (command.equals("find_zip_num")) {
			 action = new FindZipNumAction();
		} else if(command.equals("join")) {
			action = new JoinAction();
		} else if(command.equals("login_form")) {
			action = new LoginFormAction();
		}else if (command.equals("login")) {
			 action = new LoginAction();
		}else if(command.equals("logout")) {
			action = new LogoutAction();
		}
		else if (command.equals("cart_insert")) {
			 action = new CartInsertAction();
		}
		else if (command.equals("cart_list")) {
			 action = new CartListAction();
		}else if(command.equals("cart_delete")) {
			action = new CartDeleteAction();
		}else if(command.equals("order_list")) {
			action = new OrderInsertAction();
		}else if (command.equals("order_list")) {
			 action = new OrderListAction();
		 }
		
		return action;
	}

}
