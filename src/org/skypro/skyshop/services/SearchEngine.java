package org.skypro.skyshop.services;

public class SearchEngine
{
    private Searchable[] allSearchableObjects;

    public SearchEngine(int lenght)
    {
        allSearchableObjects = new Searchable[lenght];
    }

    public Searchable[] search(String str)
    {
        int mathces = 0;
        Searchable[] res = new Searchable[5];
        for (Searchable searchableObject : allSearchableObjects)
        {
            if (searchableObject != null && searchableObject.searchTerm().contains(str))
            {
                res[mathces] = searchableObject;
                mathces++;
                if (mathces == 5)
                {
                    break;
                }
            }
        }
        return res;
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
}
