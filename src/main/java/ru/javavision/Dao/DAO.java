package ru.javavision.Dao;

import org.jetbrains.annotations.NotNull;

public interface DAO<T, String> {

    void create(@NotNull final T t);

    T read(@NotNull final String model);

    void update(@NotNull final T t);

    void delete(@NotNull final T t);


}
