package ru.javavision.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;
import ru.javavision.model.SALAS;

public class SalesDAO implements DAO<SALAS,String>{

    private final SessionFactory factory;
    public SalesDAO(@NotNull final SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public  void create(@NotNull final SALAS sales){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(sales);
            session.getTransaction().commit();
        }
    }

    @Override
    public  SALAS read(@NotNull final String model){
        try(final Session session = factory.openSession()) {
            final SALAS result = session.get(SALAS.class,model);
            return result != null ?result : new SALAS();
        }
    }

    @Override
    public  void update(@NotNull final SALAS sales){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(sales);
            session.getTransaction().commit();
        }
    }

    @Override
    public  void delete(@NotNull final SALAS sales){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(sales);
            session.getTransaction().commit();
        }
    }
}
