package com.antra.demo.customer.repository;

import com.antra.demo.customer.exception.UserNotFoundException;
import com.antra.demo.customer.pojo.Customer;
import com.antra.demo.customer.response.PageResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CustomerRepository {
    List<Customer> customers = new ArrayList<>();
    public CustomerRepository(){
        customers.add(new Customer("c-001","Test1","TestLast1",25));
        customers.add(new Customer("c-002","Test2","TestLast2",26));
        customers.add(new Customer("c-003","Test3","TestLast3",27));
        customers.add(new Customer("c-004","Test4","TestLast4",35));
        customers.add(new Customer("c-005","Test5","TestLast5",55));
        customers.add(new Customer("c-006","Test6","TestLast6",45));
        customers.add(new Customer("c-007","Test7","TestLast7",15));
        customers.add(new Customer("c-008","Test8","TestLast8",29));
        customers.add(new Customer("c-009","Test9","TestLast9",25));
        customers.add(new Customer("c-010","Test10","TestLast10",46));
        customers.add(new Customer("c-011","Test11","TestLast11",19));
        customers.add(new Customer("c-012","Test12","TestLast12",20));
        customers.add(new Customer("c-013","Test13","TestLast13",67));
    }

    public Customer getCustomerById(String id){
        return this.customers.stream().filter(c->c.getId().equals(id)).findFirst().orElseThrow(UserNotFoundException::new);
    }

    public Customer addCustomer(Customer customer) {
        customer.setId(UUID.randomUUID().toString());
        this.customers.add(customer);
        return customer;
    }

    public List<Customer> getAllCustomer() {
        return this.customers;
    }

    public PageResponse getCustomerByPage(int page, int rowsPerPage, String order) {
        List<Customer> customer = customers.stream().sorted(((o1, o2) -> {
            if(order.equals("name")){
                return o1.getFirstName().compareTo(o2.getFirstName());
            } else if (order.equals("age")){
                return o1.getAge() - o2.getAge();
            } return 0;
        })).skip(rowsPerPage * (page - 1)).limit(rowsPerPage).collect(Collectors.toList());
        PageResponse response = new PageResponse();
        response.setData(customer);
        response.setTotalRows(this.customers.size());
        response.setPage(page);
        return response;
    }
}
