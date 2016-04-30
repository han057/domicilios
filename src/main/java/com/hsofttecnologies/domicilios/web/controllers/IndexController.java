package com.hsofttecnologies.domicilios.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
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
