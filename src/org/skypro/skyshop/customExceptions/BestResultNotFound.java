package org.skypro.skyshop.customExceptions;

public class BestResultNotFound extends Exception
{
    private String argument;

    public BestResultNotFound(String argument)
    {
        this.argument = argument;
    }

    @Override
    public String toString()
    {
        return super.toString() + "for '" + argument + "' not found best result";
    }
}
