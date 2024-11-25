package ru.javavision.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;
import ru.javavision.model.PRODUCTS;

public class ProductsDAO implements DAO<PRODUCTS,String>{

    private final SessionFactory factory;
    public ProductsDAO(@NotNull final SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public  void create(@NotNull final PRODUCTS products){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(products);
            session.getTransaction().commit();
        }
    }

    @Override
    public  PRODUCTS read(@NotNull final String model){
        try(final Session session = factory.openSession()) {
            final PRODUCTS result = session.get(PRODUCTS.class,model);
            return result != null ?result : new PRODUCTS();
        }
    }

    @Override
    public  void update(@NotNull final PRODUCTS products){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(products);
            session.getTransaction().commit();
        }
    }

    @Override
    public  void delete(@NotNull final PRODUCTS products){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(products);
            session.getTransaction().commit();
        }
    }
}