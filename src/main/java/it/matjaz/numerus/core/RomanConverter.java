package it.matjaz.numerus.core;

import javafx.util.Pair;

/**
 * Offers conversion methods from roman numerals as Strings to arabic numerals
 * as Integers and vice-versa.
 * <p>
 * Uses a {@link RomanCharMapFactory} generated array of pairs (romanChar, its
 * integer value) as reference for translations of the digits in both numeral
 * systems.
 *
 * @author Matjaž <a href="mailto:dev@matjaz.it">dev@matjaz.it</a>
 * <a href="http://matjaz.it">www.matjaz.it</a>
 */
public class RomanConverter {

    private final Pair[] charValues;

    /**
     * Constructs the converter by preparing its reference for translating roman
     * character into numeric values.
     */
    public RomanConverter() {
        this.charValues = RomanCharMapFactory.generateCharPairsArray();
    }

    /**
     * Converts the given syntactically correct roman numeral as String to its
     * int value.
     * <p>
     * This method performs no checks on the correctness of the roman numeral
     * String so the correct result is <b>not</b> guaranteed if the input is
     * incorrect.
     * <p>
     * Works with 2 indexes: one is iterating through the given romanString, the
     * other through the reference array of Pairs
     * {@link RomanCharMapFactory#generateCharPairsArray() (roman char, value)}.
     * The array is iterated until a char the romanString starts with is found:
     * its values is added to the arabicValue and the search continues on the
     * next romanString char (or pair of chars).
     *
     * @param romanString a string representing a syntactically correct roman
     * numeral to be converted.
     * @return int value of the given String.
     */
    public int romanStringToInteger(String romanString) {
        int arabicValue = 0;
        int romanStringIndex = 0;
        int romanCharIndex = 0;
        while (romanStringIndex < romanString.length()) {
            String romanChar = (String) charValues[romanCharIndex].getKey();
            int romanCharValue = (int) charValues[romanCharIndex].getValue();
            if (romanString.startsWith(romanChar, romanStringIndex)) {
                arabicValue += romanCharValue;
                romanStringIndex += romanChar.length();
            } else {
                romanCharIndex++;
            }
        }
        return arabicValue;
    }

    /**
     * Converts the given int value to its representation in roman numerals as
     * String.
     * <p>
     * Throws an exception if the given int is not positve or is bigger than
     * 3999, which are the extremes of the roman numerals range of
     * representation.
     * <p>
     * The algorithm is based on the
     * <a href="http://www.fredosaurus.com/notes-java/examples/components/romanNumerals/romanNumeral.html">fredosaurus.com</a>
     * roman numerals example. Iterates through the array of roman chars and
     * appends as many chars as necessary to the output string so that the value
     * could not be decreased anymore with the same roman char. Then switches to
     * a char with less value.
     *
     * @param arabic int to be converted to a roman numeral as String.
     * @return a string representing a sytactically correct roman numeral with
     * the given value.
     * @throws IllegalArgumentException if the arabic int is not in [1, 3999]
     * range.
     */
    public String integerToRomanString(int arabic) {
        if (arabic < 1 || arabic > 3999) {
            throw new IllegalArgumentException("Arabic numeral should be an integer in [1, 3999].");
        }
        String romanString = "";
        for (Pair charAndValue : charValues) {
            // Remove as many of this value as possible (maybe none).
            int romanCharValue = (int) charAndValue.getValue();
            String romanChar = (String) charAndValue.getKey();
            while (arabic >= romanCharValue) {
                romanString += romanChar;
                arabic -= romanCharValue;
            }
        }
        //RomanNumeral roman = new RomanNumeral(romanString);
        return romanString;
    }
}
