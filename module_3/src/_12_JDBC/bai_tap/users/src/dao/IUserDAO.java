package dao;

import model.User;

import java.util.List;

public interface IUserDAO {
    public void insertUser(User user);

    public User selectUserById(int id);

    public List<User> selectAllUser();

    public void deleteUser(int id);

    public  void updateUser(User user);

    public List<User> searchUser(String name);
}
