//package cn.hutool.db.util;
//
//import cn.hutool.db.Entity;
//import cn.hutool.db.Page;
//import org.junit.jupiter.api.Test;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.List;
//import java.util.function.Consumer;
//import java.util.function.Predicate;
//import java.util.function.Supplier;
//
//public class DB implements DBInterface {
//
//    @Override
//    public Boolean insert(Entity entity) {
//        return null;
//    }
//
//    @Override
//    public Entity insertPrimaryKey(Entity entity) {
//        return null;
//    }
//
//    @Override
//    public Boolean insertBatch(Collection<Entity> collection) {
//        return null;
//    }
//
//    @Override
//    public Collection<Entity> insertBatchPrimaryKey(Collection<Entity> collection) {
//        return null;
//    }
//
//    @Override
//    public Boolean insertOrUpdate(Entity entity) {
//        return null;
//    }
//
//    @Override
//    public Boolean insertOrUpdatePrimaryKey(Entity entity) {
//        return null;
//    }
//
//    @Override
//    public Boolean insertOrUpdateBatch(Collection<Entity> collection) {
//        return null;
//    }
//
//    @Override
//    public Boolean insertOrUpdateBatchPrimaryKey(Collection<Entity> collection) {
//        return null;
//    }
//
//    @Override
//    public Boolean update(Entity entity) {
//        return null;
//    }
//
//    @Override
//    public Boolean updateAllField(Entity entity) {
//        return null;
//    }
//
//    @Override
//    public Boolean updateBatch(Collection<Entity> collection) {
//        return null;
//    }
//
//    @Override
//    public Boolean updateAllFieldBatch(Collection<Entity> collection) {
//        return null;
//    }
//
//    @Override
//    public Boolean deleteById(Serializable id) {
//        return null;
//    }
//
//    @Override
//    public Boolean deleteByIdLogic(Serializable id) {
//        return null;
//    }
//
//    @Override
//    public Boolean deleteByIdBatch(Collection<Serializable> ids) {
//        return null;
//    }
//
//    @Override
//    public Boolean deleteByIdBatchLogic(Collection<Serializable> ids) {
//        return null;
//    }
//
//    @Override
//    public Entity selectById(Serializable id) {
//        return null;
//    }
//
//    @Override
//    public Entity selectByIds(Collection<Serializable> ids) {
//        return null;
//    }
//
//    @Override
//    public List<Entity> selectOne(String sql) {
//        return null;
//    }
//
//    @Override
//    public List<Entity> selectOne(String sql, Entity entity) {
//        return null;
//    }
//
//    @Override
//    public Integer selectCount(String sql) {
//        return null;
//    }
//
//    @Override
//    public Integer selectCount(String sql, Entity entity) {
//        return null;
//    }
//
//    @Override
//    public List<Entity> select(String sql) {
//        return null;
//    }
//
//    @Override
//    public List<Entity> select(String sql, Entity entity) {
//        return null;
//    }
//
//    @Override
//    public List<Entity> selectAll(String tableName) {
//        return null;
//    }
//
//    @Override
//    public List<Entity> selectPage(Page page, String sql) {
//        return null;
//    }
//
//    @Override
//    public List<Entity> selectPage(Page page, String sql, Entity entity) {
//        return null;
//    }
//
//    @Override
//    public void transaction(Consumer consumer) {
//
//    }
//
//    @Test
//    public  void aa() {
//        transaction(
//                (1)->{
//                    System.out.println("aaa");
//                    System.out.println("bbb");
//        }
//        );
//    }
//
//    public static void main(String[] args) {
//       new DB(). transaction(
//               (1)->{
//                   System.out.println("aaa");
//                   System.out.println("bbb");
//               }
//       );
//    }
//
//}
