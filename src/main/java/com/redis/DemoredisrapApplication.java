package com.redis;

import com.redis.entity.Product;
import com.redis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/raka")
public class DemoredisrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoredisrapApplication.class, args);
	}

}
