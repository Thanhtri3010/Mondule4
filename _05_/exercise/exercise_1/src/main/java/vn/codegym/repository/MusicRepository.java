package vn.codegym.repository;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Music;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MusicRepository implements IMusicRepository {
    Session session = null;
    List<Music> musicList;

    @Override
    public List<Music> findAll() {

//        try{
//            session = ConnectionUtil.sessionFactory.openSession();
//            musicList = session.createQuery("from Music").getResultList();
//        }finally {
//            if (session!=null){
//                session.close();
//            }
//        }return musicList;
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
        return ConnectionUtil.entityManager.find(Music.class,id);
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
