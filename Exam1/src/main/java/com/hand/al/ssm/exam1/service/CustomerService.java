package com.hand.al.ssm.exam1.service;

import com.hand.al.ssm.exam1.config.MyPage;
import com.hand.al.ssm.exam1.mapper.CustomerMapper;
import com.hand.al.ssm.exam1.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    public List<Customer> findAll(){
        return customerMapper.findAll();
    }

    @Transactional
    public Customer saveCustomer(Customer customer) {
        String address = customer.getAddress();
        Long addressId = customerMapper.findAddressIdByAddress(address);
        if (addressId != null) {
            customer.setAddressId(addressId);
            customer.setStoreId(2L);
            customer.setActive(1L);
            customer.setCreateDate(new Date());
            customer.setLastUpdate(new Date());
            customerMapper.saveCustomer(customer);
        } else {
            throw new RuntimeException("address不存在");
        }
        return customer;
    }

    @Transactional
    public Customer updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
        return customer;
    }

    @Transactional
    public void deleteCustomer(Long customerId) {
        customerMapper.deleteCustomerById(customerId);
    }

    public List<Customer> findAll2(MyPage page) {
        return customerMapper.findAll2(page);
    }
}
