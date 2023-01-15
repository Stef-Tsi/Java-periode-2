package com.codecademy2.Logic;
public class Logic {
    
    public boolean dateTool(int day, int month, int year)
    {
        if(day>1 && day<=31  && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12))
        {
            return true;
        }
        else if ((month == 4 || month == 6 || month == 9 || month == 11) && day>1 && day<=30)
        {
            return true;
        }
        else if (month == 2 && day>1 && day<=29 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)))
        {
            return true;
        }
        else if (month == 2 && day>1 && day<=28 && (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean mailTool(String mailAddress)
    {
        //Explain of the regex key
        //^	The beginning of a line
        //[] A group of
        //\\ disables in line code like \n
        //w-_.+ any letter or number and dash, underscore, dot and plus only once
        //* zero or more after this
        //() as a capturing group
        //$	The end of a line
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]*[\\w]$";
        // return outcome determined whether email matches the regex key
        return mailAddress.matches(regex);
    }
    public boolean numericRangeTools(int percentage)
    {
        if(percentage>=0 && percentage<=100)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static String postalCode(String postalCode)
    {
        if(postalCode == null)
        {
            throw new NullPointerException();
        }
        else if (Integer.valueOf(postalCode.trim().substring(0, 4)) > 999 &&
                    Integer.valueOf(postalCode.trim().substring(0, 4)) <= 9999 &&
                    postalCode.trim().substring(4).trim().length() == 2 &&
                    'A' <= postalCode.trim().substring(4).trim().toUpperCase().charAt(0) &&
                    postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <= 'Z' &&
                    'A' <= postalCode.trim().substring(4).trim().toUpperCase().charAt(0) &&
                    postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <= 'Z') 
            {
                String result = postalCode.trim().substring(0, 4) + " " +
                        postalCode.trim().substring(4).trim().toUpperCase();
                return result;
            }
            else {
            throw new IllegalArgumentException();
    }
    
}
}

