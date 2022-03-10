package com.antra.demo.customer.controller;

import com.antra.demo.customer.exception.UserNotFoundException;
import com.antra.demo.customer.pojo.Customer;
import com.antra.demo.customer.repository.CustomerRepository;
import com.antra.demo.customer.response.ErrorResponse;
import com.antra.demo.customer.response.PageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity<PageResponse> getCustomerAll(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                       @RequestParam(value = "rows", required = false, defaultValue = "5") int rowsPerPage,
                                                       @RequestParam(value = "orderby", required = false, defaultValue = "name") String order){
        log.debug("Page {}, rows {}, order {}", page, rowsPerPage, order);
        PageResponse response = customerRepository.getCustomerByPage(page, rowsPerPage, order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createNewCustomer(@RequestBody @Valid Customer customer){
        Customer savedCustomer = customerRepository.addCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping(value="/{cid}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("cid") String id){
        Customer c = customerRepository.getCustomerById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity exceptionHandler(Exception e){
        return new ResponseEntity<>(new ErrorResponse("The user cannot be found","404"), HttpStatus.NOT_FOUND);
    }

}
