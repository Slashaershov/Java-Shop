package org.skypro.skyshop.services;

import org.skypro.skyshop.customExceptions.BestResultNotFound;

public class SearchEngine
{
    private Searchable[] allSearchableObjects;

    public SearchEngine(int lenght)
    {
        allSearchableObjects = new Searchable[lenght];
    }

    public void add(Searchable searchableObject)
    {
        for (int i = 0; i < allSearchableObjects.length; i++)
        {
            if (allSearchableObjects[i] == null)
            {
                allSearchableObjects[i] = searchableObject;
                break;
            }
        }
    }

    public Searchable search(String substr) throws BestResultNotFound
    {
        if (substr == null || substr.isBlank()){
            throw new IllegalArgumentException("substr is empty");
        }
        Searchable result = null;
        int maxRepeatCount = 0;
        int currentRepeatCount = 0;
        for (Searchable searchable : allSearchableObjects)
        {
            if (searchable == null)
            {
                continue;
            }
            currentRepeatCount = searchable.getSearchTerm(substr);
            if (currentRepeatCount > maxRepeatCount)
            {
                maxRepeatCount = currentRepeatCount;
                result = searchable;
            }
        }
        if (result == null)
        {
            throw new BestResultNotFound(substr);
        }
        return result;
    }
}
