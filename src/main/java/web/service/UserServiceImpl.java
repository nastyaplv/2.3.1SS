package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.models.User;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {


    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDao) {
        this.userDAO = userDao;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }
}