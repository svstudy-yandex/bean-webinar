package ru.practicum.beanwebinar.user;


import java.util.List;

interface UserRepository {
    List<User> findAll();
    User save(User user);
}
