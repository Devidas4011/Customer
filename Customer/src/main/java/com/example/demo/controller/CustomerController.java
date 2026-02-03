package com.example.demo.controller;

import java.util.List;
import com.example.demo.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.CustomerApplication;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;

    private final CustomerApplication customerApplication;
	
	@Autowired
	private CustomerService cs;

    CustomerController(CustomerApplication customerApplication, CustomerServiceImpl customerServiceImpl) {
        this.customerApplication = customerApplication;
        this.customerServiceImpl = customerServiceImpl;
    }
	
	@PostMapping("add")
	public void add(@RequestBody Customer c) {
		
		cs.add(c);
	}
	
	@GetMapping("display")
	public List<Customer> display(){
		
		return cs.display();
	}
	
   
	@PostMapping("add All")
	public void addAll(@RequestBody List<Customer> list) {
		
		cs.addAll(list);
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?>  delete(@PathVariable Integer id) {
		
		Customer temp=cs.delete(id);
		
		if(temp==null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Founds !!");
			
		}
		
		return ResponseEntity.ok(temp);
		
	}
	
	@PostMapping("search/{id}")
	public ResponseEntity<?> search(@PathVariable Integer id) {
		
		Customer temp=cs.search(id);
		if(temp==null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found !!");
			
		}
		
		return ResponseEntity.ok(temp);
		
		
	}
	
	@PostMapping("search/mob/{mob}")
	public Customer searchMob(@PathVariable String mob) {
		
		return cs.findByMob(mob);	 
	}
	
	
	@PostMapping("search/name/{name}")
	public List<Customer> FindByName(@PathVariable String name){
		
		return cs.findByName(name);
	}
	
	@PostMapping("search/total/{total}")
	public List<Customer> findByTotal(@PathVariable float total){
		
		return cs.findByTotal(total);
	}
	
	@PostMapping("search/address/{address}")
	public List<Customer> findByAddress(@PathVariable String address){
		
	    return cs.findByAddress(address);
	}

}
