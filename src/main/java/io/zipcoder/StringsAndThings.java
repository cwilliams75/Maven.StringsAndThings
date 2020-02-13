package io.zipcoder;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */

    public Integer countYZ(String input){
        String[] arr = input.split(" ");

        int count = 0;
        for (String word : arr) {
            if (word.charAt(word.length() - 1) == 'y' || word.charAt(word.length() - 1) == 'z')
                count++;
        }
        return count;


//        Matcher m = Pattern.compile("[yz]\\b").matcher(input);
//        int count = 0;
//        while (m.find())
//            count++;
//        return count;


    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        return base.replaceAll(remove, "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        //convert every character to lower case
        input = input.toLowerCase();

        input = input.replaceAll("x", "");
        input = input.replaceAll("y", "");
        input = input.replaceAll("is", "x");
        input = input.replaceAll("not", "y");
        int x = 0;
        int y = 0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == 'x'){
                x++;
            } else if (input.charAt(i) == 'y'){
                y++;
            }
        }
        return x == y;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        //split string into array of characters
        char[] arr = input.toCharArray();
        //loop through, starting at index 1 to avoid out of bounds exception
        for (int i = 1; i < arr.length - 2; i++) {
            if(arr[i] == 'g') {
                if (!(arr[i - 1] == 'g' || arr[i + 1] == 'g')) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int count = 0;
        for(int i = 0; i <= input.length()-3; i++){
            if(input.charAt(i) == input.charAt(i+1) && input.charAt(i) == input.charAt(i+2)){
                count++;
            }


        }


        return count;
    }
}
