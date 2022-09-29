package com.example.javabasics.model;

import java.sql.Connection;

public interface IDatabaseSupport {
    void addToDatabase(Connection connection);
    void removeFromDatabase(Connection connection);
}
