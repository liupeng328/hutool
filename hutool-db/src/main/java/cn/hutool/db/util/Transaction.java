package cn.hutool.db.util;

/**
 * 事务接口，封装一段java代码，用于处理事务操作
 * Java8以上版本特有Lamdba表达式
 * 封装事务操作的一段Java代码
 */
@FunctionalInterface
public interface Transaction {
     void test();
}
