package ru.javavision.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;
import ru.javavision.model.DRESS;

public class DressDAO implements DAO<DRESS,String>{

    private final SessionFactory factory;
    public DressDAO(@NotNull final SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final DRESS dress){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(dress);
            session.getTransaction().commit();
        }
    }

    @Override
    public DRESS read(@NotNull final String model){
        try(final Session session = factory.openSession()) {
            final DRESS result = session.get(DRESS.class,model);
            return result != null ?result : new DRESS();
        }
    }

    @Override
    public void update(@NotNull final DRESS dress){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(dress);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final DRESS dress){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(dress);
            session.getTransaction().commit();
        }
    }
}
