package com.beniregev.demos_and_tutorials.examples;

/**
 *  <div>
 *  <p>
 *  <h1>Java Operators</h1>
 *  Java provides a rich set of operators to manipulate variables. We can divide all the Java operators into the following groups −
 *      * Arithmetic Operators
 *      * Relational Operators
 *      * Bitwise Operators
 *      * Logical Operators
 *      * Assignment Operators
 *      * Miscellaneous (Misc) Operators
 *  </p>
 *  <p>
 *  <h2>1. Precedence of Java Operators</h2>
 *  Operator precedence determines the grouping of terms in an expression. This affects how an expression is evaluated. Certain operators have higher precedence than others; for example, the multiplication operator has higher precedence than the addition operator −
 *  For example, x = 7 + 3 * 2; here x is assigned 13, not 20 because operator * has higher precedence than +, so it first gets multiplied with 3 * 2 and then adds into 7.
 *  Here, operators with the highest precedence appear at the top of the table, those with the lowest appear at the bottom. Within an expression, higher precedence operators will be evaluated first.
 *  </p>
 *  <p>
 *  =================================================
 *  Category			Operator		Associativity
 *  =================================================
 *  Postfix				expression++ 	Left to right
 * 	    				expression--
 *  -------------------------------------------------
 *  Unary				++expression 	Right to left
 * 	           			–-expression
 * 			        	+expression
 * 					    –expression
 * 					    ~   !
 *  -------------------------------------------------
 *  Multiplicative		* / %			Left to right
 *  -------------------------------------------------
 *  Additive			+ -			    Left to right
 *  -------------------------------------------------
 *  Shift				<< >> >>>		Left to right
 *  -------------------------------------------------
 *  Relational			< > <= >= 		Left to right
 * 	    				instanceof
 *  -------------------------------------------------
 *  Equality			== !=			Left to right
 *  -------------------------------------------------
 *  Bitwise 			AND	&			Left to right
 *  -------------------------------------------------
 *  Bitwise 			XOR	^			Left to right
 *  -------------------------------------------------
 *  Bitwise 			OR	|			Left to right
 *  -------------------------------------------------
 *  Logical 			AND	&&			Left to right
 *  -------------------------------------------------
 *  Logical 			OR	||			Left to right
 *  -------------------------------------------------
 *  Conditional			?:				Right to left
 *  -------------------------------------------------
 *  Assignment			= += -= *= 		Right to left
 * 	                    /= %= ^= |=
 * 	                    <<= >>= >>>=
 *  =================================================
 *  </p>
 *  </div>
 * @author binyamin.regev
 */
public class JavaOperatorsExamples {

    /**
     *  </div>
     *  <p>
     *  <h2>2. The Arithmetic Operators</h2>
     *  The method to demonstrate <i>The Arithmetic Operators</i> will be using 3 integer variables: a = 10; b = 20; c = 25. Based on those variables and their values are the results in the <i>Example</i> row in the following table.
     *  </p>
     *  <p>
     *  =============================================================================
     *  Operator				Description						    Example
     *  =============================================================================
     *  + (Addition)			Adds values on either side of       a + b will give 30
     * 							the operator.
     *  - (Subtraction)		    Subtracts right-hand operand        a - b will give -10
     * 							from left-hand operand. 	        b - a will give  10
     *  * (Multiplication)	    Multiplies values on either         a * b will give 200
     * 							side of the operator.
     *  / (Division)			Divides left-hand operand by        b / a will give 2
     * 							right-hand operand.
     *  % (Modulus)				Divides left-hand operand by 	    b % a will give 0
     * 							right-hand operand and returns      c % a will give 5
     * 							remainder.
     *  ++ (Increment)			Increases the value of operand      b++ gives 21
     * 							by 1.
     *  -- (Decrement)			Decreases the value of operand      b-- gives 19
     * 							by 1.
     *  =============================================================================
     *  </p>
     *  </div>
     */
    private void arithmeticOperators() {
        int a = 10;
        int b = 20;
        int c = 25;

        System.out.println("\n* Arithmetic Operators examples");
        System.out.println("\t a + b = " + (a + b) );
        System.out.println("\t a - b = " + (a - b) );
        System.out.println("\t a * b = " + (a * b) );
        System.out.println("\t b / a = " + (b / a) );
        System.out.println("\t b % a = " + (b % a) );
        System.out.println("\t c % a = " + (c % a) );
        System.out.println("\t a++   = " +  (a++) );
        System.out.println("\t b--   = " +  (a--) );

        // Check the difference between c++ and ++c
        System.out.println("\n\t NOTE: Check the difference between c++ and ++c");
        System.out.println("\t c++   = " +  (c++) + " ---> the variable c is incremented AFTER  printing, c=" + c);
        System.out.println("\t ++c   = " +  (++c) + " ---> the variable c is incremented BEFORE printing, c=" + c);

    }

    /**
     *  <div>
     *  <p>
     *  <h2>3. The Relational Operators</h2>
     *  There are following relational operators supported by Java language.
     *  Assume variable A holds 10 and variable B holds 20.
     *  </p>
     *  <p>
     *  ==================================================================================================
     *  Operator				        Description						            Example
     *  ==================================================================================================
     *  == (equal to)	                Checks if the values of two operands        (a == b) is not true.
     *                                  are equal or not, if yes then condition
     *                                  becomes true.
     *  != (not equal to)	            Checks if the values of two operands are    (a != b) is true.
     *                                  equal or not, if values are not equal then
     *                                  condition becomes true.
     *  > (greater than)	            Checks if the value of left operand is      (a > b) is not true.
     *                                  greater than the value of right operand,
     *                                  if yes then condition becomes true.
     *  < (less than)	                Checks if the value of left operand is      (a < b) is true.
     *                                  less than the value of right operand,
     *                                  if yes then condition becomes true.
     *  >= (greater than or equal to)   Checks if the value of left operand is      (a >= b) is not true.
     *                                  greater than or equal to the value of
     *                                  right operand, if yes then condition
     *                                  becomes true.
     *  <= (less than or equal to)	    Checks if the value of left operand is      (a <= b) is true.
     *                                  less than or equal to the value of right
     *                                  operand, if yes then condition becomes
     *                                  true.
     *  ==================================================================================================
     *  </p>
     *  </div>
     */
    private void relationalOperators() {
        int a = 10;
        int b = 20;

        System.out.println("\n* Relational Operators examples");
        System.out.println("\t a == b = " + (a == b) );
        System.out.println("\t a != b = " + (a != b) );
        System.out.println("\t a > b = " + (a > b) );
        System.out.println("\t a < b = " + (a < b) );
        System.out.println("\t b >= a = " + (b >= a) );
        System.out.println("\t b <= a = " + (b <= a) );
    }

    /**
     *  <div>
     *  <p>
     *  <h2>4. The Bitwise Operators</h2>
     *  Java defines several bitwise operators, which can be applied to the integer types, long, int, short, char, and byte.
     *  Bitwise operator works on bits and performs bit-by-bit operation.
     *  </p>
     *  <p>
     *  Assume if {@code a = 60}, {@code 0011 1100} in binary format and {@code b = 13}, {@code 0000 1101} in binary format.
     *  a = 0011 1100
     *  b = 0000 1101
     *
     *  The following table lists the bitwise operators
     *  </p>
     *  <p>
     *  ==================================================================================================
     *  Operator				        Description						            Example
     *  ==================================================================================================
     *  & (bitwise and)	                Binary AND Operator copies a bit to the     (a & b) will give 12 which is 0000 1100
     *                                  result if it exists in both operands.
     *  | (bitwise or)	                Binary OR Operator copies a bit if it       (a | b) will give 61 which is 0011 1101
     *                                  exists in either operand.
     *  ^ (bitwise XOR)	                Binary XOR Operator copies the bit if it    (a ^ b) will give 49 which is 0011 0001
     *                                  is set in one operand but not both.
     *  ~ (bitwise compliment)	        Binary Ones Complement Operator is unary    (~a ) will give -61 which is 1100 0011 in 2's complement form due to a signed binary number.
     *                                  and has the effect of 'flipping' bits.
     *  << (left shift)	                Binary Left Shift Operator. The left        a << 2 will give 240 which is 1111 0000
     *                                  operands value is moved left by the number
     *                                  of bits specified by the right operand.
     *  >> (right shift)	            Binary Right Shift Operator. The left       a >> 2 will give 15 which is 1111
     *                                  operands value is moved right by the
     *                                  number of bits specified by the right
     *                                  operand.
     *  >>> (zero fill right shift)     Shift right zero fill operator. The left    b >>> 2 will give 15 which is 0000 1111
     *                                  operands value is moved right by the
     *                                  number of bits specified by the right
     *                                  operand and shifted values are filled up
     *                                  with zeros.
     *  </p>
     *  </div>
     */
    private void bitwiseOperators() {
        int a = 60;	/* 60 = 0011 1100 */
        int b = 13;	/* 13 = 0000 1101 */
        int c = 0;

        System.out.println("\n* Bitwise Operators examples");
        c = a & b;        /* 12 = 0000 1100 */
        System.out.println("\t a & b = " + c );

        c = a | b;        /* 61 = 0011 1101 */
        System.out.println("\t a | b = " + c );

        c = a ^ b;        /* 49 = 0011 0001 */
        System.out.println("\t a ^ b = " + c );

        c = ~a;           /*-61 = 1100 0011 */
        System.out.println("\t ~a = " + c );

        c = a << 2;       /* 240 = 1111 0000 */
        System.out.println("\t a << 2 = " + c );

        c = a >> 2;       /* 15 = 1111 */
        System.out.println("\t a >> 2  = " + c );

        c = a >>> 2;      /* 15 = 0000 1111 */
        System.out.println("\t a >>> 2 = " + c );
    }

    /**
     *  <div>
     *  <p>
     *  <h2>5. The Logical Operators</h2>
     *  The following table lists the logical operators −
     *  Assume Boolean variables {@code a = true} and variable {@code b = false}.
     *  </p>
     *  <p>
     *  The following table lists the logical operators
     *  </p>
     *  <p>
     *  ==================================================================================================
     *  Operator            Description						                            Example
     *  ==================================================================================================
     *  && (logical and)    Called Logical AND operator. If both the operands are       (a && b) is false
     *                      non-zero, then the condition becomes true.
     *  || (logical or)	    Called Logical OR Operator. If any of the two operands      (a || b) is true
     *                      are non-zero, then the condition becomes true.
     *  ! (logical not)	    Called Logical NOT Operator. Use to reverses the logical    !(a && b) is true
     *                      state of its operand. If a condition is true then Logical
     *                      NOT operator will make false.
     *  ==================================================================================================
     *  </p>
     *  </div>
     */
    private void logicalOperators() {
        boolean a = true;
        boolean b = false;

        System.out.println("\n* Logical Operators examples");
        System.out.println("\t a && b = " + (a&&b));
        System.out.println("\t a || b = " + (a||b) );
        System.out.println("\t !(a && b) = " + !(a && b));
    }

    /**
     *  <div>
     *  <p>
     *  <h2>6. The Assignment Operators</h2>
     *  Following are the assignment operators supported by Java language.
     *  </p>
     *  <p>
     *  ==================================================================================================
     *  Operator    Description						                    Example
     *  ==================================================================================================
     *  =	        Simple assignment operator. Assigns values          C = A + B will assign value of A + B into C
     *              from right side operands to left side operand.
     *  +=	        Add AND assignment operator. It adds right          C += A is equivalent to C = C + A
     *              operand to the left operand and assign the
     *              result to left operand.
     *  -=	        Subtract AND assignment operator. It subtracts      C -= A is equivalent to C = C – A
     *              right operand from the left operand and assign
     *              the result to left operand.
     *  *=	        Multiply AND assignment operator. It multiplies     C *= A is equivalent to C = C * A
     *              right operand with the left operand and assign
     *              the result to left operand.
     *  /=	        Divide AND assignment operator. It divides left     C /= A is equivalent to C = C / A
     *              operand with the right operand and assign the
     *              result to left operand.
     *  %=	        Modulus AND assignment operator. It takes modulus   C %= A is equivalent to C = C % A
     *              using two operands and assign the result to left
     *              operand.
     *  <<=	        Left shift AND assignment operator.	                C <<= 2 is same as C = C << 2
     *  >>=	        Right shift AND assignment operator.	            C >>= 2 is same as C = C >> 2
     *  &=	        Bitwise AND assignment operator.	                C &= 2 is same as C = C & 2
     *  ^=	        bitwise exclusive OR and assignment operator.	    C ^= 2 is same as C = C ^ 2
     *  |=	        bitwise inclusive OR and assignment operator.	    C |= 2 is same as C = C | 2
     *  ==================================================================================================
     *  </p>
     *  </div>
     */
    private void assignmentOperators() {
        int a = 10;
        int b = 20;
        int c = 0;

        System.out.println("\n* Assignment Operators examples");
        c = a + b;
        System.out.println("\t c = a + b = " + c );

        c += a ;
        System.out.println("\t c += a  = " + c );

        c -= a ;
        System.out.println("\t c -= a = " + c );

        c *= a ;
        System.out.println("\t c *= a = " + c );

        a = 10;
        c = 15;
        c /= a ;
        System.out.println("\t c /= a = " + c );

        a = 10;
        c = 15;
        c %= a ;
        System.out.println("\t c %= a  = " + c );

        c <<= 2 ;
        System.out.println("\t c <<= 2 = " + c );

        c >>= 2 ;
        System.out.println("\t c >>= 2 = " + c );

        c >>= 2 ;
        System.out.println("\t c >>= 2 = " + c );

        c &= a ;
        System.out.println("\t c &= a  = " + c );

        c ^= a ;
        System.out.println("\t c ^= a   = " + c );

        c |= a ;
        System.out.println("\t c |= a   = " + c );
    }

    /**
     *  <div>
     *  <p>
     *  <h2>7. Miscellaneous (Misc) Operators</h2>
     *  There are few other operators supported by Java Language.
     *  </p>
     *  <p>
     *  <h3>Conditional Operator ( ? : )</h3>
     *  Conditional operator is also known as the ternary operator. This operator consists of three operands and is used to evaluate Boolean expressions. The goal of the operator is to decide, which value should be assigned to the variable.
     *  The operator is written as:
     *      <code>
     *          variable x = (expression) ? value if true : value if fals
     *      </code>
     *  </p>
     *  <p>
     *  <h3>instanceof Operator</h3>
     *  This operator is used only for object reference variables. The operator checks whether the object is of a particular type (class type or interface type).
     *  {@code instanceof} operator is written as:
     *      <code>
     *          ( Object reference variable ) instanceof  (class/interface type)
     *      </code>
     *  If the object referred by the variable on the left side of the operator passes the IS-A check for the class/interface type on the right side, then the result will be true.
     *  </p>
     *  </div>
     */
    private void miscellaneousOperators() {
        System.out.println("\n* Miscellaneous Operators examples");

        System.out.println("\t Conditional Operator ( ? : )");
        int a, b;
        a = 10;
        b = (a == 1) ? 20: 30;
        System.out.println("\t\t Value of b is : " +  b );

        b = (a == 10) ? 20: 30;
        System.out.println("\t\t Value of b is : " + b );

        System.out.println("\n\t instanceof Operator");
        String name = "James";

        // following will return true since name is type of String
        boolean result = name instanceof String;
        System.out.println("\t\t is variable 'name' is instance of class String? " + result);
    }

    public static void main(String[] args) {
        JavaOperatorsExamples example = new JavaOperatorsExamples();

        example.arithmeticOperators();
        example.relationalOperators();
        example.bitwiseOperators();
        example.logicalOperators();
        example.assignmentOperators();
        example.miscellaneousOperators();

        System.out.println("-------------------------------------------------");
        System.out.println("------- JavaOperatorsExamples Completed   -------");
        System.out.println("-------------------------------------------------");
    }

}
