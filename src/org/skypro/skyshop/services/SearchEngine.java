package org.skypro.skyshop.services;

public class SearchEngine
{
    private Searchable[] allObjects;

    public SearchEngine (int lenght){
        allObjects = new Searchable[lenght];

    }

    public Searchable[] search(String str){
        int mathces = 0;
        Searchable[] res = new Searchable[5];
        for (Searchable x : allObjects){
            if (x!=null && x.searchTerm().contains(str)){
                res[mathces] = x;
                mathces++;
                if (mathces ==5){
                    break;
                }
            }
        }
        return res;
    }

    public void add (Searchable itm){
        for (int i= 0; i< allObjects.length; i++)
        {
            if (allObjects[i] == null){
                allObjects[i] = itm;
                break;
            }
        }
    }
}
