package ru.javavision.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;
import ru.javavision.model.ARTICLE;

public class ArticleDAO implements DAO<ARTICLE,String>{

    private final SessionFactory factory;
    public ArticleDAO(@NotNull final SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final ARTICLE article){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(article);
            session.getTransaction().commit();
        }
    }

    @Override
    public ARTICLE read(@NotNull final String model){
        try(final Session session = factory.openSession()) {
            final ARTICLE result = session.get(ARTICLE.class,model);
            return result != null ?result : new ARTICLE();
        }
    }

    @Override
    public void update(@NotNull final ARTICLE article){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(article);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final ARTICLE article){
        try(final Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete((article));
            session.getTransaction().commit();
        }
    }
}