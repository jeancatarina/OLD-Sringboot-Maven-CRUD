package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Demo;
import com.example.model.DemoRepository;


@RestController
public class DemoController {

	@Autowired
	private DemoRepository repository;
	
	public DemoController(DemoRepository demoRepository){
		this.repository = demoRepository;
	} 
	
	@RequestMapping("/")
    @ResponseBody
    List<Demo> home() {
		return repository.findAllByOrderByNameAsc();
//		repository.findByName('');
//		return "Hello Jean"; 
	}
	
	@RequestMapping(path = "/", method = RequestMethod.POST )
	@ResponseBody
	Demo create(String name){
		Demo demo = new Demo(name);
		
		repository.save(demo);
		
		return demo;
	}
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	Demo update(@PathVariable Long id, String name){
		Demo demo = repository.findOne(id);
		
		demo.setName(name);
		
		repository.save(demo);
		
		return demo;
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	Long destroy(@PathVariable Long id){
		Demo demo = repository.findOne(id);
		
		repository.delete(demo);
		
		return id;
	}
	
}
