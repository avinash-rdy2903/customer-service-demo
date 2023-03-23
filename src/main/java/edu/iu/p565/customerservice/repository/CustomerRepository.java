package edu.iu.p565.customerservice.repository;

import java.util.List;
import java.util.ArrayList;
import edu.iu.p565.customerservice.model.Customer;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();
    public List<Customer> findAll(){
        return customers;
    }

    public int create(Customer customer){
        int id = customers.size()+1;
        customer.setId(id);
        customers.add(customer);
        return id;
    }
    public void update(Customer customer, int id){
        Customer temp = this.getCustomerById(id);
        if(temp!=null){
            temp.setName(customer.getName());
            temp.setEmail(customer.getEmail());
        }else{
            throw new IllegalStateException("Customer with the given ID: {"+id+"} not found.");
        }
    }
    public void delete(int id){
        Customer temp = this.getCustomerById(id);
        if(temp!=null){
            this.customers.remove(temp);
        }else{
            throw new IllegalStateException("Customer with the given ID: {"+id+"} not found.");
        }
    }
    private Customer getCustomerById(int id){
        return customers.stream().filter(x->x.getId()==id).findAny().orElse(null);
    }
}
