package cn.sm.dao;

import cn.sm.entity.Product;

public interface ProductDao {
    /**
     * 通过产品ID查询
     */
    Product getById(Integer id);

    /**
     * 通过产品ID删除
     */
    void deleteById(Integer id);
}
