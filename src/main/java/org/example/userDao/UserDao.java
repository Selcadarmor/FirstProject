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
        if(user.getId() == null){
            em.persist(user);
        } else {
            em.merge(user);
        }
    }
    @Transactional
    public User findById(Long id) {
        return em.find(User.class, id);
    }
    @Transactional
    public void delete( Long id) {
        User user = em.find(User.class, id);
        if(user != null) {
            em.remove(em.merge(user));;
        }
    }
    @Transactional
    public void update (User user) {
        em.merge(user);
    }
    @Transactional
    public List<User> findAllUser(){
        return em.createQuery(" FROM User ", User.class).getResultList();
    }
}
