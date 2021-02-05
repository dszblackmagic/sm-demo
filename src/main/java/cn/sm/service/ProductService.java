package cn.sm.service;

import cn.sm.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {


    @Autowired
    ProductDao productDao;

    // 整个执行过程中 发生了错误， 但是呢 id为4的数据仍然被删除了，整个是不符合业务逻辑的
    // 因为我们写再service层一个方法中的内容 应该是一个整体（事务）
    // 那么出现错误别的逻辑不应该执行成功
    // 事务管理中为什么要有readOnly出现呢？
    //   如果 你默认不是readOnly，那么意味着你可能会出现写的操作， 那么只要写的操作都是要有commit
    //   效率 -》commit每次提交是耗费性能的,如果你确定你当前的这个service方法中不需要增删改操作
        //那么你完全可以将这个事务 readOnly设置true， 会提交事务的处理效率
    // noRollbackFor填写的是异常类
    @Transactional(noRollbackFor = ArithmeticException.class) // timeout这个属性 是事务超时时间(秒)
    public void productServiceDemo() {
        // 先删除四号
        productDao.deleteById(4);

        // 再查询3号
        System.out.println(productDao.getById(3));
        // 模拟错误
        int a=10/0;

        // 再删除3号
        productDao.deleteById(3);

    }

}
