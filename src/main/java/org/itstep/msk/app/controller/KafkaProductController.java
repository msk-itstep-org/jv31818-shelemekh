package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaProductController {
	
	private KafkaTemplate<String,Product> kafkatemplate;
	
	
	@Autowired
	public KafkaProductController(KafkaTemplate<String,Product> kafkatemplate) {
		this.kafkatemplate = kafkatemplate
	}
	
	
	
	@PostMapping
	public void post(@RequestBody Product product) {
		kafkatemplate.send("product will be ordered", product);
		
		
	}

}
