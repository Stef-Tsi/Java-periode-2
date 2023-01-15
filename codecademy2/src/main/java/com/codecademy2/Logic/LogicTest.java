
// IMPORTANT, COMMENT OUT IF NOT WORKING.

package com.codecademy2.Logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class LogicTest {
    @Test
    public void testDateFebInLeapYearOutOfRange(){
        //arrange
        Logic validator= new Logic();

        //act
       boolean valid = validator.dateTool(30, 2, 2022);

        //assert
        assertEquals(false, valid);
    }
     @Test
    public void testDateFebInLeapYearInRange(){
        //arrange
        Logic validator= new Logic();

        //act
       boolean valid = validator.dateTool(12, 2, 2022);

        //assert
        assertEquals(true, valid);
    }
    @Test
    public void testDateNovInRange(){
        //arrange
        Logic validator= new Logic();

        //act
       boolean valid = validator.dateTool(23, 11, 2022);

        //assert
        assertEquals(true, valid);
    }
   
    @Test
    public void testDateAprOutOfRange(){
        //arrange
        Logic validator= new Logic();

        //act
       boolean valid = validator.dateTool(31, 4, 2006);

        //assert
        assertEquals(false, valid);
    }

    @Test
    public void validateMailAddressReturnsFalseNoAt(){
        //arrange
        Logic validator = new Logic();
        String mailAddress = "atnguyen.com";
        //act
        Boolean result = validator.mailTool(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsFalseNoMailbox(){
        //arrange
        Logic validator = new Logic();
        String mailAddress = "@mail.com";
        //act
        Boolean result = validator.mailTool(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsTrueNoSubdomainTLDDelimiter(){
        //arrange
        Logic validator = new Logic();
        String mailAddress = "mail@mail.hfgs.com";
        //act
        Boolean result = validator.mailTool(mailAddress);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void validateMailAddressReturnsFalseNoSubdomain(){
        //arrange
        Logic validator = new Logic();
        String mailAddress = "mail@.com";
        //act
        Boolean result = validator.mailTool(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsFalseNoTLD(){
        //arrange
        Logic validator = new Logic();
        String mailAddress = "mail@mail.";
        //act
        Boolean result = validator.mailTool(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsTrue(){
        //arrange
        Logic validator = new Logic();
        String mailAddress = "at.nguyen2@mail.com";
        //act
        Boolean result = validator.mailTool(mailAddress);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void testIsValidPercentageReturnsTrue(){
        //arrange
        Logic validator = new Logic();
        int percentage = 50;
        //act
        Boolean result = validator.numericRangeTools(percentage);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void testIsValidPercentageReturnsFalseBelowZero(){
        //arrange
        Logic validator = new Logic();
        int percentage = -1;
        //act
        Boolean result = validator.numericRangeTools(percentage);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void testIsValidPercentageReturnsFalseAboveOneHundred(){
        //arrange
        Logic validator = new Logic();
        int percentage = 110;
        //act
        Boolean result = validator.numericRangeTools(percentage);
        //assert
        assertEquals(false, result);
    }


    @Test
    public void nullPointerExceptionPostalCode (){
         //arrange
         Logic validator = new Logic();

         //act
        
 
         //assert
         assertThrows(NullPointerException.class, () -> validator.postalCode(null));
        
    }
    @Test
    public void notEnoughNumbers (){
        //arrange
        Logic validator = new Logic();

        //act
       

        //assert
        assertThrows(IllegalArgumentException.class, () -> validator.postalCode("123A"));
   }
   @Test
   public void rightInput (){
     //arrange
     Logic validator = new Logic();

     //act
    String valid = validator.postalCode("1234ab");

     //assert
     assertEquals("1234 AB", valid);
}
    @Test
    public void differentInput (){
     //arrange
     Logic validator = new Logic();

     //act

     //assert
     assertThrows(IllegalArgumentException.class, () -> validator.postalCode("test"));
}
}
