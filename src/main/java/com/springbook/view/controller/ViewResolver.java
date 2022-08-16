package com.springbook.view.controller;

import lombok.Data;

@Data
public class ViewResolver {
	
	public String prefix;
	public String suffix;
	
	public String getView(String viewName) {
		
		return prefix + viewName + suffix;
	}
}
