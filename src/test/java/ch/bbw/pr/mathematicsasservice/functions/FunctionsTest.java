package ch.bbw.pr.mathematicsasservice.functions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Peter Rutschmann
 * @version 12.6.2023
 */

class FunctionsTest {
   Functions functions = null;

   @BeforeEach
   void setUp() {
      functions = new Functions();
   }

   @AfterEach
   void tearDown() {
   }

   @Test
   @DisplayName("testUnsafeAdditionWith10And20Is30")
   void testUnsafeAdditionWith10And20Is30() {
      assertEquals(30, functions.unsafeAddition(10, 20));
   }

   @Test
   @DisplayName("testUnsafeAdditionWithMAX_VALUE")
   void testUnsafeAdditionWithMAX_VALUE() {
      long result = 2L*(long)Integer.MAX_VALUE;
      assertEquals(result, functions.unsafeAddition(Integer.MAX_VALUE, Integer.MAX_VALUE));
   }

   @Test
   void testSafeAdditionWith10And20Is30() {
      assertEquals(30, functions.safeAddition(10, 20));
   }

   @Test
   void testSafeAdditionWithMAX_VALUE() {
      Throwable exception = assertThrows(ArithmeticException.class, () -> functions.safeAddition(Integer.MAX_VALUE, Integer.MAX_VALUE));
      assertEquals("Value overflow.", exception.getMessage());
   }

   @Test
   void unsafeDivision() {
      //TODO Should be implemented
   }
}