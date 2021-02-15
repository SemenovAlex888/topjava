package ru.javawebinar.topjava.repository.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepository.class);
    private final Map<Integer, User> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public boolean delete(int id) {
        log.info("delete {}", id);
        return repository.remove(id) != null;
    }

    @Override
    public User save(User user) {
        log.info("save {}", user);

        if(user.isNew()) {
            user.setId(counter.incrementAndGet());
            repository.put(user.getId(), user);
            return user;
            /*
            TODO read Interface BiFunction<T,U,R>
             */
        }
        return repository.computeIfPresent(user.getId(), (id, oldUser) -> user);
    }

    @Override
    public User get(int id) {
        log.info("get {}", id);
        return repository.get(id);
    }

    /*
    TODO add sort
     */
    @Override
    public List<User> getAll() {
        log.info("getAll");
        return (List<User>) repository.values();
    }

    /*
        TODO try to do with stream; take into account different users with different emails
    */
    @Override
    public User getByEmail(String email) {
        log.info("getByEmail {}", email);

        List<User> usersList = (List<User>) repository.values();
        for (User exemplar: usersList) {
            if(email.equals(exemplar.getEmail())) {
                return exemplar;
            }
        }
        return null;
    }
}
