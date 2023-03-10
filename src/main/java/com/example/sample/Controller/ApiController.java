package com.example.sample.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.Repository.EmployeeRepo;
import com.example.sample.Table.Employee;

@RestController
public class ApiController {
	@Autowired
	private EmployeeRepo r;
	@PostMapping("/add")
	public Employee addDetails(@RequestBody Employee e) {
		return r.save(e);
	}
	@GetMapping("/show")
	public List<Employee> getDetails(){
		return r.findAll();
	}
	@GetMapping("/sort/{field}")
	public List<Employee> sort(String field){
		return r.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	@GetMapping("/pagi/{offset}/{pageSize}")
	public List<Employee> pagination(@PathVariable int offset,@PathVariable int pageSize){
		Page<Employee> page = r.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
}
