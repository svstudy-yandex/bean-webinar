package ru.practicum.beanwebinar.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class InMemoryUserRepository implements UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    private long nextId = 1;

    public InMemoryUserRepository() {
        System.out.println("InMemoryUserRepository - constructor");
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User save(User user) {
        user.setId(nextId++);
        users.put(user.getId(), user);
        return user;
    }
}
