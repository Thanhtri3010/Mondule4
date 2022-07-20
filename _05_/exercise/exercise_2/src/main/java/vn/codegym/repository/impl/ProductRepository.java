package vn.codegym.repository.impl;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Product;
import vn.codegym.repository.ConnectionUtil;
import vn.codegym.repository.IProductRepository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {


    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("select s from Product s",Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        return ConnectionUtil.entityManager.find(Product.class,id);
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction entityTransaction = ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.remove(id);
        entityTransaction.commit();
    }

    @Override
    public List<Product> searchProduct(String name) {
        TypedQuery<Product> typedQuery = ConnectionUtil.entityManager.createQuery("select s from Product s where s.productName like :nameSearch ",Product.class);
        typedQuery.setParameter("nameSearch", "%"+name+"%");
        return typedQuery.getResultList();
    }
}
