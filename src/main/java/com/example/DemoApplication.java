package com.example;

import com.example.domain.JuheSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableConfigurationProperties({JuheSettings.class})
public class DemoApplication {

	@Autowired
	JuheSettings juheSettings;

	@RequestMapping("/")
	String home(){
		return "Hello World!";
	}

	@RequestMapping(value = "/stock")
	String getAll(){
		return juheSettings.getUrl() + "finance/stock/shall?key="+juheSettings.getUrl()+"&stock=a";
	}


	public static void main(String[] args) {

	    //System.setProperty("","");
	    /*SpringApplication app = new SpringApplication(DemoApplication.class);
	    app.setBannerMode(Banner.Mode.OFF);
	    app.run(args);*/
		SpringApplication.run(DemoApplication.class, args);
	}
}
