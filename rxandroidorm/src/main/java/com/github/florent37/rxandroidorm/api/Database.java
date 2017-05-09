package com.github.florent37.rxandroidorm.api;
import java.util.List;

import io.reactivex.Observable;

/**
 * Common interface for Database
 * Created by thibaud on 09/05/2017.
 */
public interface Database<T> {
    Observable<T> add(final T object);

    Observable<List<T>> add(final List<T> objects);

    Observable<T> update(final T object);

    Observable<List<T>> update(final List<T> objects);

    Observable<Boolean> delete(final T object);

    Observable<Boolean> delete(final List<T> objects);

    Observable<Boolean> deleteAll();

    Observable<Integer> count();
}
