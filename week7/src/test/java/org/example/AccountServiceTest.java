package org.example;

import org.example.AccountService.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.List;

public class AccountServiceTest {
    private AccountService accountService;

    @Before
    public void init() throws Exception {
        accountService = new AccountService();
    }

    @Test
    public void testInsert() throws Exception {
        Date date = new Date(System.currentTimeMillis());
        Account temp1 = new Account("1", "王五", 1000, date, date);
        Account temp2 = new Account("2", "李四", 2000, date, date);
        Method insert = accountService.getClass().getDeclaredMethod("insert", Account.class);
        insert.setAccessible(true);
        insert.invoke(accountService, temp1);
        insert.invoke(accountService, temp2);
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception{
        String id = "1";
        Method select = accountService.getClass().getDeclaredMethod("selectByPrimaryKey", String.class);
        select.setAccessible(true);
        Account temp = (Account) select.invoke(accountService, id);
        System.out.println(temp);
    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {
        String id = "2";
        Date date = new Date(System.currentTimeMillis());
        Account temp = new Account(id, "李四", 2500, date, date);
        Method update = accountService.getClass().getDeclaredMethod("updateByPrimaryKey", Account.class);
        update.setAccessible(true);
        update.invoke(accountService, temp);
    }

    @Test
    public void testTransfer() throws Exception {
        Method trans = accountService.getClass().getDeclaredMethod("transfer", String.class, String.class, int.class);
        trans.setAccessible(true);
        trans.invoke(accountService, "1", "2", 500);
    }

    @Test
    public void testFindAll() throws Exception {
        Method findAll = accountService.getClass().getDeclaredMethod("findAll");
        findAll.setAccessible(true);
        List<Account> accounts = (List<Account>) findAll.invoke(accountService);
        System.out.println(accounts);
    }

    @Test
    public void testDeleteByPrimaryKey() throws Exception{
        Method delete = accountService.getClass().getDeclaredMethod("deleteByPrimaryKey", String.class);
        delete.setAccessible(true);
        delete.invoke(accountService, "1");
    }

    @After
    public void close() throws Exception {
        Method destroy = accountService.getClass().getDeclaredMethod("destroy");
        destroy.setAccessible(true);
        destroy.invoke(accountService);
    }
}
