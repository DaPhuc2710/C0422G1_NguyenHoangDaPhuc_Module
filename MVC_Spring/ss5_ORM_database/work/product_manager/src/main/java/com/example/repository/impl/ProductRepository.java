package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select m " +
                "from Product as m", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select m " +
                "from Product m where m.id= :idProduct", Product.class);
        typedQuery.setParameter("idProduct",id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void add(Product product) {
        EntityTransaction entityTransaction =
                BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();

    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction= BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Product.class,id));
        entityTransaction.commit();

    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();

    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select m " +
                "from Product m where m.name= :nameProduct", Product.class);
        typedQuery.setParameter("nameProduct",name);
        return typedQuery.getResultList();
    }
}