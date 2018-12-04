package cn.hutool.db.util;

import cn.hutool.db.Entity;
import cn.hutool.db.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 关系型数据库操作工具类
 * 封装数据库操作，提供一种便捷的操作关系型数据库的方式
 * <pre>
 *     设计思想：以sql为中心，提供操作数据库便捷的方式
 *     设计目标：
 *     1.支持orm（对象关系映射，把关系型数据库的一条记录映射为一个JavaBean对象）,Java是面向对象的语言orm是必须提供的
 *     2.支持ActiveRecord（领域模型，把关系型数据库的一条记录映射为一个“活动记录”，可以理解为HashMap<String,Object>类型），
 *       提供类似脚本语言（python，php等）操作数据库的便捷方式,但是该方式有致命缺陷，数据库表字段更改后，代码中所有Map的key
 *       都要改一次，项目大了，这个样改要累死，还是推荐JavaBean方式。
 *     3.速度要够快，要比Mybatis、Hibernate快，原因很简单，该工具类无Java反射操作，效率会很高
 *     4.以工具类的形式出现，可以兼容任何框架，再任何地方、任何一个代码行调用
 *     5.做成工具类，简单易用
 *     具体实现：
 *     1.以sql为中心，所有的数据库操作都转换为sql，则该工具本质上是一个sql拼接/转换工具
 *     2.单表操作在开发中占比例最大，提供常用的操作方法
 *     3.只在hutool基础上添加代码，不删除/修改任何代码，保证向前兼容性。
 * </pre>
 *
 * @author 刘鹏
 * @date 2018-12-04
 */
interface DBInterface {

    //--------------ActiveRecord 领域模型 开始----------------------------------

    ////------插入操作

    /**
     * 执行insert sql语句
     *
     * @param sql sql语句
     * @return 成功true，失败false
     */
    Boolean insert(String sql);

    /**
     * 执行insert sql语句
     *
     * @param entity 实体对象
     * @param sql    sql语句
     * @return 成功true，失败false
     */
    Boolean insert(String sql, Entity entity);

    /**
     * 插入数据 Entity格式的数据
     *
     * @param entity 实体对象
     * @return 成功true，失败false
     */
    Boolean insert(Entity entity);

    /**
     * 插入数据并返回主键 Entity格式的数据
     * 返回的主键只能是数据库自动生成的，如果需要Java代码生成主键，请操作Entity
     *
     * @param entity 实体对象
     * @return 成功true，失败false
     */
    Entity insertPrimaryKey(Entity entity);

    /**
     * 批量插入数据 Entity格式的数据
     *
     * @param collection 实体对象集合
     * @return 成功true，失败false
     */
    Boolean insertBatch(Collection<Entity> collection);

    /**
     * 批量插入数据并返回主键 Entity格式的数据
     * 返回的主键只能是数据库自动生成的，如果需要Java代码生成主键，请操作Entity
     *
     * @param collection 实体对象集合
     * @return 成功true，失败false
     */
    Collection<Entity> insertBatchPrimaryKey(Collection<Entity> collection);

    ////--------插入或修改操作

    /**
     * 插入或修改数据 Entity格式的数据
     * 数据不存在时执行插入操作，数据存在时执行修改操作，不为空的字段一律修改
     *
     * @param entity 实体对象
     * @return 成功true，失败false
     */
    Boolean insertOrUpdate(Entity entity);

    /**
     * 插入或修改数据并返回主键 Entity格式的数据
     * 数据不存在时执行插入操作，数据存在时执行修改操作，不为空的字段一律修改
     *
     * @param entity 实体对象
     * @return 成功true，失败false
     */
    Boolean insertOrUpdatePrimaryKey(Entity entity);

    /**
     * 批量插入或修改数据 Entity格式的数据
     * 数据不存在时执行插入操作，数据存在时执行修改操作，不为空的字段一律修改
     *
     * @param collection 实体对象集合
     * @return 成功true，失败false
     */
    Boolean insertOrUpdateBatch(Collection<Entity> collection);

    /**
     * 批量插入或修改数据并返回主键 Entity格式的数据
     * 数据不存在时执行插入操作，数据存在时执行修改操作，不为空的字段一律修改
     *
     * @param collection 实体对象集合
     * @return 成功true，失败false
     */
    Boolean insertOrUpdateBatchPrimaryKey(Collection<Entity> collection);

    ////--------修改操作

    /**
     * 执行update sql语句
     *
     * @param sql sql语句
     * @return 成功true，失败false
     */
    Boolean update(String sql);

    /**
     * 执行update sql语句
     *
     * @param entity 实体对象
     * @param sql    sql语句
     * @return 成功true，失败false
     */
    Boolean update(String sql, Entity entity);

    /**
     * 通过id选择性修改，只修实体对象不为空的字段  Entity类型数据
     *
     * @param entity 实体对象
     * @return true成功，false失败
     */
    Boolean update(Entity entity);

    /**
     * 强制修改全部字段 Entity类型数据
     *
     * @param entity 实体对象
     * @return true成功，false失败
     */
    Boolean updateAllField(Entity entity);

    /**
     * 批量修改，通过id选择性修改，只修实体对象不为空的字段  Entity类型数据
     *
     * @param collection 实体对象集合
     * @return true成功，false失败
     */
    Boolean updateBatch(Collection<Entity> collection);

    /**
     * 批量修改，强制修改全部字段 Entity类型数据
     *
     * @param collection 实体对象集合
     * @return true成功，false失败
     */
    Boolean updateAllFieldBatch(Collection<Entity> collection);

    ////--------删除操作

    /**
     * 执行delete sql语句
     *
     * @param sql sql语句
     * @return 成功true，失败false
     */
    Boolean delete(String sql);

    /**
     * 执行delete sql语句
     *
     * @param entity 实体对象
     * @param sql    sql语句
     * @return 成功true，失败false
     */
    Boolean delete(String sql, Entity entity);

    /**
     * 通过id删除
     *
     * @param id 主键
     * @return true成功，false失败
     */
    Boolean deleteById(Serializable id);

    /**
     * 通过id逻辑删除
     * 逻辑删除要求表中必须有deleted字段，1为已经删除 0为未删除 deleted默认值为0
     *
     * @param id 主键
     * @return true成功，false失败
     */
    Boolean deleteByIdLogic(Serializable id);

    /**
     * 批量删除，通过id删除
     *
     * @param ids 主键集合
     * @return true成功，false失败
     */
    Boolean deleteByIdBatch(Collection<Serializable> ids);

    /**
     * 批量通过id逻辑删除
     * 逻辑删除要求表中必须有deleted字段，1为已经删除 0为未删除 deleted默认值为0
     *
     * @param ids 主键集合
     * @return true成功，false失败
     */
    Boolean deleteByIdBatchLogic(Collection<Serializable> ids);

    ////--------查询操作

    /**
     * 通过id查询 数据类型为Entity
     *
     * @param id 主键
     * @return 实体对象
     */
    Entity selectById(Serializable id);

    /**
     * 通过多个id查询 数据类型为Entity
     *
     * @param ids 主键集合
     * @return 实体对象
     */
    Entity selectByIds(Collection<Serializable> ids);


    /**
     * 查询一条数据 数据类型为Entity
     *
     * @param sql sql语句
     * @return 实体对象
     */
    List<Entity> selectOne(String sql);

    /**
     * 查询一条数据 数据类型为Entity
     *
     * @param sql    sql语句
     * @param entity 实体对象
     * @return 实体对象
     */
    List<Entity> selectOne(String sql, Entity entity);

    /**
     * 统计数量
     *
     * @param sql sql语句
     * @return 实体对象
     */
    Integer selectCount(String sql);

    /**
     * 统计数量 数据类型为Entity
     *
     * @param sql    sql语句
     * @param entity 实体对象
     * @return 实体对象
     */
    Integer selectCount(String sql, Entity entity);

    /**
     * 查询，返回列表 数据类型为Entity
     *
     * @param sql sql语句
     * @return 实体对象
     */
    List<Entity> select(String sql);

    /**
     * 查询，返回列表 数据类型为Entity
     *
     * @param sql    sql语句
     * @param entity 实体对象
     * @return 实体对象
     */
    List<Entity> select(String sql, Entity entity);

    /**
     * 查询全部数据 数据类型为Entity
     *
     * @param tableName 表名
     * @return 实体对象
     */
    List<Entity> selectAll(String tableName);

    /**
     * 分页查询，返回列表 数据类型为Entity
     *
     * @param page 分页对象
     * @param sql  sql语句
     * @return 实体对象
     */
    List<Entity> selectPage(Page page, String sql);

    /**
     * 分页查询，返回列表 数据类型为Entity
     *
     * @param page   分页对象
     * @param sql    sql语句
     * @param entity 实体对象
     * @return 实体对象
     */
    List<Entity> selectPage(Page page, String sql, Entity entity);

    /**
     * 事物操作
     *
     * @param transactionFunction 功能函数，这里可以直接传一段代码做参数
     *                            示例
     *                            DB.transaction(
     *                            ()->{
     *                            //insert
     *                            //update
     *                            //你的代码逻辑
     *                            }
     *                            );
     */
    void transaction(TransactionFunction transactionFunction);


    /**
     * 执行sql
     *
     * @param sql sql语句
     * @return 成功true，失败false
     */
    Boolean executeSql(String sql);

    /**
     * 执行sql
     *
     * @param sql    sql语句
     * @param entity 实体对象
     * @return Integer 数字：数据库受影响的行数
     */
    Integer executeSql(String sql, Entity entity);


    //--------------ActiveRecord 领域模型 结束----------------------------------

    //todo orm操作
    //--------------orm 对象关系型映射 开始----------------------------------

    ////------插入操作

    /**
     * 插入数据 JavaBean格式的数据
     *
     * @param bean JavaBean对象
     * @return 成功true，失败false
     */
    Boolean insert(Object bean);

    /**
     * 插入数据并返回主键 JavaBean格式的数据
     * 返回的主键只能是数据库自动生成的，如果需要Java代码生成主键，请操作Entity
     *
     * @param bean JavaBean对象
     * @return 成功true，失败false
     */
    Entity insertPrimaryKey(Object bean);

    /**
     * 批量插入数据 JavaBean格式的数据
     *
     * @param collection JavaBean对象集合
     * @return 成功true，失败false
     */
    Boolean insertBatch(Collection<?> collection);

    /**
     * 批量插入数据并返回主键 JavaBean格式的数据
     * 返回的主键只能是数据库自动生成的，如果需要Java代码生成主键，请操作Entity
     *
     * @param collection JavaBean对象集合
     * @return 成功true，失败false
     */
    Collection<?> insertBatchPrimaryKey(Collection<?> collection);

    ////--------插入或修改操作

    /**
     * 插入或修改数据 JavaBean格式的数据
     * 数据不存在时执行插入操作，数据存在时执行修改操作，不为空的字段一律修改
     *
     * @param bean JavaBean对象
     * @return 成功true，失败false
     */
    Boolean insertOrUpdate(Object bean);

    /**
     * 插入或修改数据并返回主键 JavaBean格式的数据
     * 数据不存在时执行插入操作，数据存在时执行修改操作，不为空的字段一律修改
     *
     * @param bean JavaBean对象
     * @return 成功true，失败false
     */
    Boolean insertOrUpdatePrimaryKey(Object bean);

    /**
     * 批量插入或修改数据 JavaBean格式的数据
     * 数据不存在时执行插入操作，数据存在时执行修改操作，不为空的字段一律修改
     *
     * @param collection JavaBean对象集合
     * @return 成功true，失败false
     */
    Boolean insertOrUpdateBatch(Collection<?> collection);

    /**
     * 批量插入或修改数据并返回主键 JavaBean格式的数据
     * 数据不存在时执行插入操作，数据存在时执行修改操作，不为空的字段一律修改
     *
     * @param collection JavaBean对象集合
     * @return 成功true，失败false
     */
    Boolean insertOrUpdateBatchPrimaryKey(Collection<?> collection);

    ////--------修改操作

    /**
     * 通过id选择性修改，只修实体对象不为空的字段  JavaBean类型数据
     *
     * @param bean JavaBean对象
     * @return true成功，false失败
     */
    Boolean update(Object bean);

    /**
     * 强制修改全部字段 JavaBean类型数据
     *
     * @param bean JavaBean对象
     * @return true成功，false失败
     */
    Boolean updateAllField(Object bean);

    /**
     * 批量修改，通过id选择性修改，只修实体对象不为空的字段  JavaBean类型数据
     *
     * @param collection JavaBean对象集合
     * @return true成功，false失败
     */
    Boolean updateBatch(Collection<?> collection);

    /**
     * 批量修改，强制修改全部字段 JavaBean类型数据
     *
     * @param collection JavaBean对象集合
     * @return true成功，false失败
     */
    Boolean updateAllFieldBatch(Collection<?> collection);

    /**
     * 查询一条数据 JavaBean数据类型
     *
     * @param sql    sql语句
     * @param bean JavaBean对象
     * @return 实体对象
     */
    List<Entity> selectOne(String sql, Object bean);


    /**
     * 统计数量 JavaBean数据类型
     *
     * @param sql    sql语句
     * @param bean JavaBean对象
     * @return 实体对象
     */
    Integer selectCount(String sql, Object bean);

    /**
     * 查询，返回列表 JavaBean数据类型
     *
     * @param sql    sql语句
     * @param bean JavaBean对象
     * @return 实体对象
     */
    List<Entity> select(String sql, Object bean);


    /**
     * 分页查询，返回列表 JavaBean数据类型
     *
     * @param page   分页对象
     * @param sql    sql语句
     * @param bean JavaBean对象
     * @return 实体对象
     */
    List<Entity> selectPage(Page page, String sql, Object bean);


    /**
     * 执行sql
     *
     * @param sql    sql语句
     * @param bean JavaBean对象
     * @return Integer 数字：数据库受影响的行数
     */
    Integer executeSql(String sql, Object bean);


    //--------------ActiveRecord 领域模型 结束----------------------------------



}
