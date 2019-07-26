package com.hand.al.ssm.exam1.controller.v1;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.al.ssm.exam1.config.MyPage;
import com.hand.al.ssm.exam1.config.Page;
import com.hand.al.ssm.exam1.mapper.CustomerMapper;
import com.hand.al.ssm.exam1.pojo.Customer;
import com.hand.al.ssm.exam1.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("v1/customers")
public class CustomerController {
    private static Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/login")
    public HashMap<String,Object> login(String name,String password){
        HashMap<String, Object> map = new HashMap<>();
        map.put("success",false);
        map.put("code",1);

        Customer customer = customerMapper.findCustomerByFirstName(name);
        if(customer.getLastName().equals(password)){
            map.put("success",true);
            map.put("code",0);
            log.info("用户{},登录成功",customer.getFirstName()+customer.getLastName());

        }else {
            log.info("用户{},登录失败",customer.getFirstName()+customer.getLastName());
        }

        return map;
    }

    @GetMapping("/")
    public PageInfo<Customer>  listByPageHelper(Integer page, Integer pageSize){
        log.info("查询所有");
        PageHelper.startPage(page,pageSize);
        List<Customer> items = customerService.findAll();
        PageInfo<Customer> itemsPageInfo = new PageInfo<>(items);
        return itemsPageInfo;
    }

    @GetMapping("/BySelfPage")
    public List<Customer>  listByPageHelper(@Page MyPage page){
        log.info("查询所有2---自定义分页");
        List<Customer> items = customerService.findAll2(page);
        return items;
    }


    @PostMapping("/")
    public Long create(@RequestBody Customer customer){
        log.info("创建用户");
        customerService.saveCustomer(customer);
        return customer.getCustomerId();
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable("id") Long id, @RequestBody Customer customer){
        log.info("更新用户");
        customer.setCustomerId(id);
        customerService.updateCustomer(customer);
        return  customer;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        log.info("删除用户");
        customerService.deleteCustomer(id);
    }

}
