package com.beniregev.demos_and_tutorials.examples;

/**
 * <div>
 *     <p>
 *         <div>Java has basic 8 primitives:</div>
 *         <p>
 *             <table>
 *                 <tr>
 *                     <th>Data Type</th>
 *                     <th>Size</th>
 *                     <th>Description</th>
 *                 </tr>
 *                 <tr>
 *                     <td>byte</td>
 *                     <td>1 byte</td>
 *                     <td>Stores whole numbers. From -128 to +127</td>
 *                 </tr>
 *                 <tr>
 *                     <td>short</td>
 *                     <td>2 bytes</td>
 *                     <td>Stores whole numbers. From -32,768 to +32,767</td>
 *                 </tr>
 *                 <tr>
 *                     <td>int</td>
 *                     <td>4 bytes</td>
 *                     <td>Stores whole numbers. From -2,147,483,648 to +2,147,483,647</td>
 *                 </tr>
 *                 <tr>
 *                     <td>long</td>
 *                     <td>8 bytes</td>
 *                     <td>Stores whole numbers. From -9,223,372,036,854,775,808 to +9,223,372,036,854,775,807</td>
 *                 </tr>
 *                 <tr>
 *                     <td>float</td>
 *                     <td>4 bytes</td>
 *                     <td>Stores fractional numbers. Sufficient for storing 6 to 7  decimal digits</td>
 *                 </tr>
 *                 <tr>
 *                     <td>double</td>
 *                     <td>8 bytes</td>
 *                     <td>Stores fractional numbers. Sufficient for storing 15 decimal digits</td>
 *                 </tr>
 *                 <tr>
 *                     <td>boolean</td>
 *                     <td>1 bit</td>
 *                     <td>Stores <em>true</em> or <em>false</em> values</td>
 *                 </tr>
 *                 <tr>
 *                     <td>char</td>
 *                     <td>2 bytes</td>
 *                     <td>Stores a single character/letter or ASCII values</td>
 *                 </tr>
 *             </table>
 *         </p>
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class VariablesAndPrimitivesExamples {
    private void primitiveByteExample() {
        System.out.println("primitiveByteExample(): ");
        byte myByte;

        myByte = 9;
        System.out.println("\tmyByte = " + myByte);

        //  Number over +127, what will happen? interesting...
        myByte = (byte) 137;
        System.out.println("\tmyByte = " + myByte);

        //  Just checking we didn't mess up anything
        myByte = 33;
        System.out.println("\tmyByte = " + myByte);
        System.out.println("-------------------------------------------------\n");
    }

    private void primitiveShortExample() {
        System.out.println("primitiveShortExample(): ");

        System.out.println("-------------------------------------------------\n");
    }

    private void primitiveIntExample() {
        System.out.println("primitiveIntExample(): ");
        int myInt;

        myInt = 9;
        System.out.println("\tmyInt = " + myInt);

        myInt = 107;
        System.out.println("\tmyInt = " + myInt);

        myInt = 33;
        System.out.println("\tmyInt = " + myInt);
        System.out.println("-------------------------------------------------\n");
    }

    private void primitiveLongExample() {
        System.out.println("primitiveLongExample(): ");
        long myLong;

        myLong = 9;
        System.out.println("\tmyLong = " + myLong);

        myLong = 910733;
        System.out.println("\tmyLong = " + myLong);

        myLong = 33;
        System.out.println("\tmyLong = " + myLong);
        System.out.println("-------------------------------------------------\n");
    }

    private void primitiveFloatExample() {
        System.out.println("primitiveFloatExample(): ");

        System.out.println("-------------------------------------------------\n");
    }

    private void primitiveDoubleExample() {
        System.out.println("primitiveDoubleExample(): ");
        double myDouble;

        myDouble = 9;
        System.out.println("\tmyDouble = " + myDouble);

        myDouble = 107;
        System.out.println("\tmyDouble = " + myDouble);

        myDouble = 33;
        System.out.println("\tmyDouble = " + myDouble);
        System.out.println("-------------------------------------------------\n");
    }

    private void primitiveBooleanExample() {
        System.out.println("primitiveBooleanExample(): ");

        System.out.println("-------------------------------------------------\n");
    }

    private void primitiveCharExample() {
        System.out.println("primitiveCharExample(): ");

        System.out.println("-------------------------------------------------\n");
    }

    public static void main(String[] args) {
        VariablesAndPrimitivesExamples examples = new VariablesAndPrimitivesExamples();

        examples.primitiveByteExample();
        examples.primitiveShortExample();
        examples.primitiveIntExample();
        examples.primitiveLongExample();
        examples.primitiveFloatExample();
        examples.primitiveDoubleExample();
        examples.primitiveBooleanExample();
        examples.primitiveCharExample();
    }
}
