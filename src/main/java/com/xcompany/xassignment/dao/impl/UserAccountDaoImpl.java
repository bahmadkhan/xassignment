/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xcompany.xassignment.dao.impl;

import com.xcompany.xassignment.dao.AbstractDao;
import com.xcompany.xassignment.dao.UserAccountDao;
import com.xcompany.xassignment.model.Users;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bilalahmad
 */
@Repository("userAccountDao")
public class UserAccountDaoImpl extends AbstractDao<Users, Long> implements UserAccountDao {

    @Override
    public List<Users> readAllUsers() {
        return findAll();
    }

    @Override
    public Long createUser(Users user) {
        persist(user);
        return user.getId();
    }

    @Override
    public Users readUser(Long userId) {
        return find(userId);
    }

    @Override
    public Long updateUser(Users user) {
        merge(user);
        return user.getId();
    }

    @Override
    public void deleteUser(Users user) {
        remove(user);
    }
}
