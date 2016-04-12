package com.hsofttecnologies.domicilios.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("/api")
	@ResponseBody
	public Object api(int id) {
		class X {
			private String s = "Nombre";

			public String getS() {
				return s;
			}

			public void setS(String s) {
				this.s = s;
			}
		}
		return new X();
	}
}
