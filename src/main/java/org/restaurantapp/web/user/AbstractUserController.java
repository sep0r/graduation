package org.restaurantapp.web.user;

import org.restaurantapp.model.User;
import org.restaurantapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import static org.restaurantapp.util.ValidationUtil.*;


public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private final UserRepository repository;

    @Autowired
    public AbstractUserController(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        log.info("getAll");
        return repository.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return checkNotFoundWithId(repository.get(id), id);
    }

    public User create(User user) {
        log.info("create {}", user);
        checkNew(user);
        return repository.save(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        checkNotFoundWithId(repository.delete(id), id);
    }

    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
        assureIdConsistent(user, id);
        checkNotFoundWithId(repository.save(user), user.getId());
    }

    public User getByMail(String email) {
        log.info("getByEmail {}", email);
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }
}