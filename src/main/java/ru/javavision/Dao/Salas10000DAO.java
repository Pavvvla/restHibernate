package ru.javavision.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;
import ru.javavision.model.SALAS10000;

public class Salas10000DAO implements DAO<SALAS10000,String>{

    private final SessionFactory factory;
    public Salas10000DAO(@NotNull final SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public  void create(@NotNull final SALAS10000 sales10000){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(sales10000);
            session.getTransaction().commit();
        }
    }

    @Override
    public  SALAS10000 read(@NotNull final String model){
        try(final Session session = factory.openSession()) {
            final SALAS10000 result = session.get(SALAS10000.class,model);
            return result != null ?result : new SALAS10000();
        }
    }

    @Override
    public  void update(@NotNull final SALAS10000 sales10000){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(sales10000);
            session.getTransaction().commit();
        }
    }

    @Override
    public  void delete(@NotNull final SALAS10000 sales10000){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(sales10000);
            session.getTransaction().commit();
        }
    }
}

