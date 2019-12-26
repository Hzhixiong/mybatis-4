package com.example.mybatis;

import com.example.mybatis.bean.Customer;
import com.example.mybatis.bean.CustomerExample;
import com.example.mybatis.mapper.CustomerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mybatis4ApplicationTests {

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void contextLoads() {

    }
    @Test
    public void test11(){//根据id删除customer
        customerMapper.deleteByPrimaryKey(1);

    }

    @Test
    public void test(){/*查询money大于500的customer*/
        CustomerExample customerExample=new CustomerExample();
        customerExample.createCriteria().andMoneyGreaterThanOrEqualTo(500.0);
        List<Customer> lists=customerMapper.selectByExample(customerExample);
        for (Customer customer:lists){
            System.out.println(customer);
        }
    }

    @Test
    public void test1(){/*查询money大于500的customer或者id=11的customer*/
        CustomerExample customerExample=new CustomerExample();
        customerExample.createCriteria().andMoneyGreaterThanOrEqualTo(500.0);
        customerExample.or().andIdEqualTo(11);
        List<Customer> list=customerMapper.selectByExample(customerExample);
        for(Customer customer:list){
            System.out.println(customer);
        }
    }

    @Test
    public void test2(){/*查询id=1并且money=926的customer*/
        CustomerExample customerExample=new CustomerExample();
        customerExample.createCriteria().andIdEqualTo(1).andMoneyEqualTo(926.0);

        List<Customer>list=customerMapper.selectByExample(customerExample);
        for(Customer customer:list){
            System.out.println(customer);
        }
    }

}
