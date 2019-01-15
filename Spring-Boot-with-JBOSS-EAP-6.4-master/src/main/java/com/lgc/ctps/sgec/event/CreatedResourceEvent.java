package com.lgc.ctps.sgec.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class CreatedResourceEvent extends ApplicationEvent { 
	
	private static final long serialVersionUID = -1893987187803722358L;
	
	private transient HttpServletResponse httpServletResponse; // Talvez o transient de problema
	private Long id;
	
	public CreatedResourceEvent(Object source, HttpServletResponse httpServletResponse, Long id) {
		super(source);
		this.httpServletResponse = httpServletResponse;
		this.id = id;
	} 
}
