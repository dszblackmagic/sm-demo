//package cn.sm.dao;
//
//import cn.sm.entity.Product;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//// 后期肯定不用这种方式， 肯定是mybatis的动态代理
//@Repository // @Controller @Service
//public class ProductDaoImpl implements ProductDao {
//    // 实现类想要去操作我们Mybatis，必要的东西就是sqlSessionFactory
//    //1. 我们有了spring， 那么意味着很多对象并不需要我们去手动的创建
//    // 可以通过注入的方式将我们的内容进行
////    @Autowired
////    SqlSessionFactory sqlSessionFactory;
//
//    //如果你想要通过配置文件来注入内容， 那么一定要有set方法
////    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
////        this.sqlSessionFactory = sqlSessionFactory;
////    }
//
//    // 如果你可以有一个 sqlSession直接交给我 是最好的
//    // sqlSession 是多例
//    @Autowired
//    SqlSession sqlSession;
//
//    public void setSqlSession(SqlSession sqlSession) {
//        this.sqlSession = sqlSession;
//    }
//
//    @Override
//    public Product getById(Integer id) {
//        // 工厂生成sqlSession会话
//        Product product = sqlSession.selectOne("product.getById", id);
//        return product;
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        sqlSession.delete("product.deleteById",id);
//        // 查询呢是不需要提交的， 但是如果是增删改这三个操作，属于写的操作
//        // 那么和写入相关的操作都要进行commit提交才能够生效
//        sqlSession.commit();
//    }
//}
