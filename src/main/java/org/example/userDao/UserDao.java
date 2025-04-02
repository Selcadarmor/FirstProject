package org.example.userDao;

import org.springframework.stereotype.Repository;
import org.example.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(User user) {
        em.persist(user);
    }
    @Transactional
    public User getById(Long id) {
        return em.find(User.class, id);
    }
    @Transactional
    public void delete(Long user) {
        if(user != null) {
            em.remove(user);
        }
    }
    @Transactional
    public void update(User user) {
        em.merge(user);
    }
    @Transactional
    public List<User> getAllUser(){
        return em.createQuery("FROM User", User.class).getResultList();
    }
}
