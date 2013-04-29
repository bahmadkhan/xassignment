/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xcompany.xassignment.dao;

import com.xcompany.xassignment.model.Users;
import java.util.List;

/**
 *
 * @author bilalahmad
 */
public interface UserAccountDao {    
    public abstract List<Users> readAllUsers(); 
    public abstract Long createUser(Users user);
    public abstract Users readUser(Long userId);
    public abstract Long updateUser(Users user);
    public abstract void deleteUser(Users user);    
}
