package com.example.repository.impl;

import com.example.model.MusicApp;
import com.example.repository.IMusicAppRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.List;

@Repository
public class MusicAppRepository implements IMusicAppRepository {


    @Override
    public void create(MusicApp musicApp) {
        EntityTransaction entityTransaction =
                BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(musicApp);
        entityTransaction.commit();
    }

    @Override
    public void update(MusicApp musicApp) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(musicApp);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction= BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(MusicApp.class,id));
        entityTransaction.commit();

    }

    @Override
    public List<MusicApp> findAll() {
        TypedQuery<MusicApp> typedQuery = BaseRepository.entityManager.createQuery("select m " +
                "from MusicApp as m", MusicApp.class);
        return typedQuery.getResultList();
    }

    @Override
    public MusicApp findById(int id) {
        TypedQuery<MusicApp> typedQuery = BaseRepository.entityManager.createQuery("select m " +
                "from MusicApp m where m.id= :idMusic", MusicApp.class);
        typedQuery.setParameter("idMusic",id);
        return typedQuery.getSingleResult();
    }
}
