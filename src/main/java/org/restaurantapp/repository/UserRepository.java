package org.restaurantapp.repository;

import org.restaurantapp.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    boolean delete(int id);

    User get(int id);

    User getByEmail(String email);

    List<User> getAll();

    default User getWithVotes(int id) {
        throw new UnsupportedOperationException();
    }
}
