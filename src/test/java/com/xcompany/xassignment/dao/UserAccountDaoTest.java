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
public class UserAccountDaoTest {

    @Autowired
    UserAccountDao userDao;

    /**
     *
     */
    public UserAccountDaoTest() {
    }
    //Create User Constants
    private static final String USER_NAME_CREATE = "Bilal";
    private static final String USER_EMAIL_CREATE = "bilal@truemeridian.com";
    private static final String USER_PASSWORD_CREATE = "P@33W0RD";
    private static final Authority USER_AUTHORITY_CREATE = Authority.ROLE_NORMAL;
    //Update User Constants
    private static final String USER_NAME_UPDATE = "Ahmad";
    private static final String USER_EMAIL_UPDATE = "ahmad@truemeridian.com";
    private static final String USER_PASSWORD_UPDATE = "NewP@33W0RD";
    private static final Authority USER_AUTHORITY_UPDATE = Authority.ROLE_ADMIN;

    @Test    
    public void testCreateAndReadUser() {
        //Creating User
        Users adminUser = new Users();
        adminUser.setName(USER_NAME_CREATE);
        adminUser.setEmail(USER_EMAIL_CREATE);
        adminUser.setPassword(USER_PASSWORD_CREATE);
        adminUser.setAuthority(USER_AUTHORITY_CREATE);
        Long userId = userDao.createUser(adminUser);
        //Assertions
        assertNotNull(userId);
        assertTrue(userId instanceof Long);
        Users dbAdminUser = userDao.readUser(adminUser.getId());
        assertEquals(dbAdminUser.getName(), USER_NAME_CREATE);
        assertEquals(dbAdminUser.getEmail(), USER_EMAIL_CREATE);
        assertEquals(dbAdminUser.getPassword(), USER_PASSWORD_CREATE);
        assertEquals(dbAdminUser.getAuthority(), USER_AUTHORITY_CREATE);
    }

    @Test    
    public void testUpdateUser() {
        //Creating User
        Users createdUser = new Users();
        createdUser.setName(USER_NAME_CREATE);
        createdUser.setEmail(USER_EMAIL_CREATE);
        createdUser.setPassword(USER_PASSWORD_CREATE);
        createdUser.setAuthority(USER_AUTHORITY_CREATE);
        Long userId = userDao.createUser(createdUser);
        //Assertions
        assertNotNull(userId);
        assertTrue(userId instanceof Long);
        Users updatedUser = userDao.readUser(createdUser.getId());
        updatedUser.setName(USER_NAME_UPDATE);
        updatedUser.setEmail(USER_EMAIL_UPDATE);
        updatedUser.setPassword(USER_PASSWORD_UPDATE);
        updatedUser.setAuthority(USER_AUTHORITY_UPDATE);
        Long updatedUserId = userDao.updateUser(updatedUser);
        assertNotNull(updatedUserId);
        Users dbUser = userDao.readUser(createdUser.getId());
        assertEquals(dbUser.getName(), USER_NAME_UPDATE);
        assertEquals(dbUser.getEmail(), USER_EMAIL_UPDATE);
        assertEquals(dbUser.getPassword(), USER_PASSWORD_UPDATE);
        assertEquals(dbUser.getAuthority(), USER_AUTHORITY_UPDATE);
    }
    @Test
    public void testDeleteUser() {
        //Creating User
        Users createdUser = new Users();
        createdUser.setName(USER_NAME_CREATE);
        createdUser.setEmail(USER_EMAIL_CREATE);
        createdUser.setPassword(USER_PASSWORD_CREATE);
        createdUser.setAuthority(USER_AUTHORITY_CREATE);
        Long userId = userDao.createUser(createdUser);
        //Assertions
        assertNotNull(userId);
        Users dbUser = userDao.readUser(userId);
        userDao.deleteUser(dbUser);
        Users deletedUser = userDao.readUser(userId);        
        assertNull(deletedUser);
    }
}
