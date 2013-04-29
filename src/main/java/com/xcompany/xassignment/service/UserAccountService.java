/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xcompany.xassignment.service;

import com.xcompany.xassignment.model.Users;
import java.util.List;

/**
 *
 * @author bilalahmad
 */
public interface UserAccountService {

    public abstract List<Users> readAllUsers();

    public void createRequest();

    public abstract Long createUser(Users user);

    public abstract Users readUser(Long userId);

    public abstract Long updateUser(Users user);

    public abstract void deleteUser(Long userId);
}
