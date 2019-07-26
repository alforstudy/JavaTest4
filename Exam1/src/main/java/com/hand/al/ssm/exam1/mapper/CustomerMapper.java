package com.hand.al.ssm.exam1.mapper;


import com.hand.al.ssm.exam1.config.MyPage;
import com.hand.al.ssm.exam1.pojo.Customer;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Repository
public interface CustomerMapper extends BaseMapper<Customer> {
    List<Customer> findAll();
    Customer findCustomerByFirstName(String firstName);
    void saveCustomer(Customer customer);
    Long findAddressIdByAddress(String address);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long customerId);
    List<Customer> findAll2(MyPage page);
}
