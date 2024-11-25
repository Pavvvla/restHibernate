package ru.javavision.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;
import ru.javavision.model.SKIRTS;

public class SkirtsDAO implements DAO<SKIRTS,String>{

    private final SessionFactory factory;
    public SkirtsDAO(@NotNull final SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public  void create(@NotNull final SKIRTS skirts){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(skirts);
            session.getTransaction().commit();
        }
    }

    @Override
    public  SKIRTS read(@NotNull final String model){
        try(final Session session = factory.openSession()) {
            final SKIRTS result = session.get(SKIRTS.class,model);
            return result != null ?result : new SKIRTS();
        }
    }

    @Override
    public  void update(@NotNull final SKIRTS skirts){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(skirts);
            session.getTransaction().commit();
        }
    }

    @Override
    public  void delete(@NotNull final SKIRTS skirts){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(skirts);
            session.getTransaction().commit();
        }
    }
}

