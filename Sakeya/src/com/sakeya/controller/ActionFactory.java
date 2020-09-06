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
		}else if (command.equals("product_detail")) {
			action = new ProductDetailAction();
		}else if(command.equals("catagory")) {
			action=new ProductKindAction();
		}
		
		return action;
	}

}
