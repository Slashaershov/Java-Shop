package org.skypro.skyshop.services;

public interface Searchable
{
    String searchTerm();

    String getType();

    default void getStringRepresentation()
    {
        System.out.println("имя Searchable-объекта +" + getType());
    }
}
