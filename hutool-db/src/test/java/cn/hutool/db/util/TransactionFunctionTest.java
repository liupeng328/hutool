package cn.hutool.db.util;import org.junit.Test;/** * 函数式编程 lamdba 测试 */class TransactionFunctionTest {    public static void main(String[] args) {        TransactionFunction ts = ()-> System.out.println("函数式编程！");        ts.call();        TransactionFunction ts2 = new TransactionFunction() {            @Override            public void call() {                System.out.println("函数式编程的语法解释");            }        };        ts2.call();    }}