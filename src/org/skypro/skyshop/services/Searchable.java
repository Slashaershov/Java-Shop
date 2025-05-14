package org.skypro.skyshop.services;

public interface Searchable
{
    String searchTerm();

    String getType();

    default void getStringRepresentation()
    {
        System.out.println("имя Searchable-объекта +" + getType());
    }

    default int getSearchTerm(String substring)
    {
        String str = searchTerm();
        int count = 0;
        int index = 0;
        int subIndex = str.indexOf(substring, index);
        while (subIndex != -1)
        {
            count++;
            index = subIndex + substring.length();
            subIndex = str.indexOf(substring, index);
        }
        return count;
    }
}
