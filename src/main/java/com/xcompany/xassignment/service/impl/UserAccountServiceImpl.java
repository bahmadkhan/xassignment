/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xcompany.xassignment.service.impl;

import com.xcompany.xassignment.dao.UserAccountDao;
import com.xcompany.xassignment.model.Users;
import com.xcompany.xassignment.service.UserAccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bilalahmad
 */
@Service("userAccountService")
@Transactional
public class UserAccountServiceImpl implements UserAccountService{
    
    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    @Autowired
    UserAccountDao userAccountDao;

    @Override
    @Secured(ROLE_ADMIN)
    public List<Users> readAllUsers() {
       return userAccountDao.readAllUsers();
    }

    @Secured(ROLE_ADMIN)
    @Override   
    public Long createUser(Users user) {
        return userAccountDao.createUser(user);
    }

    @Secured(ROLE_ADMIN)
    @Override
    public Users readUser(Long userId) {
        return userAccountDao.readUser(userId);
    }

    @Secured(ROLE_ADMIN)
    @Override
    public Long updateUser(Users user) {
        Users dbUser = readUser(user.getId());
        dbUser.setName(user.getName());
        dbUser.setEmail(user.getEmail());
        dbUser.setAuthority(user.getAuthority());
        return userAccountDao.updateUser(dbUser);
    }
    
    @Secured(ROLE_ADMIN)
    @Override
    public void deleteUser(Long userId) {
        Users user = readUser(userId);
        userAccountDao.deleteUser(user);
    }
    
    @Secured(ROLE_ADMIN)
    @Override
    public void createRequest() {
        
    }
    
    
}
