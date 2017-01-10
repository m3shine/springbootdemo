package com.example;

import com.example.domain.utils.Juhe;


import com.example.service.HolidayService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class DemoApplication {

	//@Autowired
	//Environment ev;

	@Autowired
	Juhe juhe;

	@Autowired
	HolidayService holidayService;

	@RequestMapping("/")
	JSONObject home(){
		JSONObject res = juhe.call("finance/stock/shall","&stock=a");
		return res;
	}

	@RequestMapping("/init")
	void initHoliday(){
		holidayService.init();
	}
	public static void main(String[] args) {

	    //System.setProperty("","");
	    /*SpringApplication app = new SpringApplication(DemoApplication.class);
	    app.setBannerMode(Banner.Mode.OFF);
	    app.run(args);*/
		SpringApplication.run(DemoApplication.class, args);
	}
}
