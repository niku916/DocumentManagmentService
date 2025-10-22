package com.dms.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dms")
public class DmsUpConroller {
	
	@GetMapping("/ServiceRunning")
	public String getMethodName() {
		return "DMS is Running..........";
	}
	

}
