package com.hesshes.studytobe.dao;

import java.util.List;

import com.hesshes.studytobe.domain.User;

//list 5-11
public interface UserDao {
    void add(User user);

    User get(String id);

    List<User> getAll();

    void deleteAll();

    int getCount();
    
    void update(User user1);

}
