package onlineShop.service;

import onlineShop.dao.CustomerDao;
import onlineShop.model.Cart;
import onlineShop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;
    // here we can add the cache and speed up the response
    // add other limit in the service
    public void addCustomer(Customer customer) {
        Cart cart = new Cart();
        customer.setCart(cart);  //cannot get form the register form
        customer.getUser().setEnabled(true);
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerByUserName(String email) {
        return customerDao.getCustomerByUserName(email);
    }


}
