package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import web.models.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class UserServiceImpl implements UserService {

@PersistenceContext
    private EntityManager entityManager;
    @Autowired
    UserDAO userDAO = new UserDAOImpl();


    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }


    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }


    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }


    @Override
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }
}