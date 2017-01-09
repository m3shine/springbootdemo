package com.example;

import com.example.domain.utils.Juhe;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;


@RestController
@SpringBootApplication
public class DemoApplication {

	//@Autowired
	//Environment ev;

	@Autowired
	Juhe juhe;

	@RequestMapping("/")
	String home(){
		return "Hello World!";
	}

	public static void main(String[] args) {

	    //System.setProperty("","");
	    /*SpringApplication app = new SpringApplication(DemoApplication.class);
	    app.setBannerMode(Banner.Mode.OFF);
	    app.run(args);*/
		SpringApplication.run(DemoApplication.class, args);
	}
}
