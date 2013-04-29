/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xcompany.xassignment.dao;

import com.xcompany.xassignment.model.Authority;
import com.xcompany.xassignment.model.Users;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bilalahmad
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
public class CreateAdminTest {

    @Autowired
    UserAccountDao userDao;

    public CreateAdminTest() {
    }
    private static final String ADMIN_USER_NAME = "Admin";
    private static final String ADMIN_USER_EMAIL = "admin@admin.com";
    private static final String ADMIN_USER_PASSWORD = "JTO33";
    private static final Authority ADMIN_USER_AUTHORITY = Authority.ROLE_ADMIN;

    @Test
    @Rollback(false)
    public void testCreateAdmin() {
        //Creating Admin User
        Users adminUser = new Users();
        adminUser.setName(ADMIN_USER_NAME);
        adminUser.setEmail(ADMIN_USER_EMAIL);
        adminUser.setPassword(ADMIN_USER_PASSWORD);
        adminUser.setAuthority(ADMIN_USER_AUTHORITY);
        userDao.createUser(adminUser);
        
        //Assertions
        Users dbAdminUser = userDao.readUser(adminUser.getId());
        assertEquals(dbAdminUser.getName(), ADMIN_USER_NAME);
        assertEquals(dbAdminUser.getEmail(), ADMIN_USER_EMAIL);
        assertEquals(dbAdminUser.getPassword(), ADMIN_USER_PASSWORD);
        assertEquals(dbAdminUser.getAuthority(), ADMIN_USER_AUTHORITY);
        
    }
}
