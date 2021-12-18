package org.example.AccountService;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.Account;
import org.example.dao.AccountDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountService {
    private InputStream inputStream;
    private SqlSession session;
    private AccountDao dao;

    public AccountService() throws IOException {
        String resources = "mybatis.xml";
        inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        dao = session.getMapper(AccountDao.class);
    }

    private void destroy() {
        try {
            session.commit();
            session.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 1查询所有记录
    List<Account> findAll() {
        String sqlId = "org.example.dao.AccountDao.findAll";
        AccountDao mapper = session.getMapper(AccountDao.class);
        List<Account> accounts = mapper.findAll();
        System.out.println(accounts);
        return accounts;
    }
    // 2通过id删除记录
    void deleteByPrimaryKey(String id) {
        String sqlId = "org.example.dao.AccountDao.deleteByPrimaryKey";
        int rows = session.delete(sqlId, id);
        System.out.println("删除了第" + rows + "行数据");
    }
    // 3插入记录
    void insert(Account record) {
        String sqlId = "org.example.dao.AccountDao.insert";
        int rows = session.insert(sqlId, record);
        System.out.println("插入了第" + rows + "行数据");
    }
    // 4通过id查找对象
    Account selectByPrimaryKey(String id) {
        String sqlId = "org.example.dao.AccountDao.selectByPrimaryKey";
        Account temp  =session.selectOne(sqlId, id);
        System.out.println(temp);
        return temp;
    }
    // 5更新Account
    void updateByPrimaryKey(Account record) {
        String sqlId = "org.example.dao.AccountDao.updateByPrimaryKey";
        int rows = session.update(sqlId, record);
        System.out.println("第" + rows + "行数据受到修改");
    }
    // 6转账功能 输入转出人id，转入人id，转账金额 实现转账
    void transfer(String remitterId,String remitteeId,int money) {
        String sqlId1 = "org.example.dao.AccountDao.transfer";
        String sqlId2 = "org.example.dao.AccountDao.gainer";
        Account transfer = new Account();
        transfer.setId(remitterId);
        transfer.setMoney(money);
        session.update(sqlId1, transfer);
        transfer.setId(remitteeId);
        session.update(sqlId2, transfer);
    }
}
