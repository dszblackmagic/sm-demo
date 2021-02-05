package cn.sm.dao;

import cn.sm.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
// SpringJUnit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class ProductDaoImplTest {

    @Autowired
    ProductDao dao;

    @Test
    public void getById() {
        Product product = dao.getById(3);
        System.out.println(product);
    }
}