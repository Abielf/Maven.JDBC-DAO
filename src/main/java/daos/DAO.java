package daos;

import java.util.List;

public interface DAO<T> {
    public T findById(int id);
    public List findAll();
    public T update(T dto, int id);
    public T create(T dto);
    public void delete(int id);
}

/*
    User getUser();
    Set<User> getAllUsers();
    User getUserByUserNameAndPassword();
    boolean insertUser();
    boolean updateUser();
    boolean deleteUser();*/