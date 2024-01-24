package org.example.Interface;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
}
