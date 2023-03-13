package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);

    }

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("SELECT user from User user").getResultList();

    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

}
