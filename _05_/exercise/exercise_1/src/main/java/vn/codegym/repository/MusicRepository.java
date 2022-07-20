package vn.codegym.repository;


import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Music;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MusicRepository implements IMusicRepository {
    @Override
    public List<Music> findAll() {
        TypedQuery<Music> query = ConnectionUtil.entityManager.createQuery("select s from Music as s", Music.class);
        return query.getResultList();
    }

    @Override
    public void create(Music music) {
        EntityTransaction entityTransaction = ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public Music findById(int id) {
        return ConnectionUtil.entityManager.find(Music.class, id);
    }

    @Override
    public void update(int id, Music music) {
        EntityTransaction entityTransaction = ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.remove(findById(id));
        entityTransaction.commit();
    }
}
