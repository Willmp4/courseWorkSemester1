package Java.semesterOneCourseWork.AmericanFlag;

/**
 * This is a programme to diplay the American Flag
 * Uses two for loops for the row and coloums
 * 
 * @author William Bruckmann
 */
public class americanFlag {
    public static void main(String[] args) {
        // Where I got the colours from
        // https://www.codegrepper.com/code-examples/java/java+console+text+color
        String ANSI_RED_BACKGROUND = "\u001B[41m";
        String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        String TEXT_RED = "\u001B[31m";
        String TEXT_WHITE = "\u001B[37m";
        for (int i = 0; i < 15; i++) {
            // for loop for i, prints the number or rows.
            for (int j = 0; j < 46; j++)
            // number of chars on each row, gets run 15 times
            // run for loop to print stars until i < 9
            // after 9 rows only print = for 6 rows
            {
                if (i < 9 && j < 12)
                // on first iteration 0 + 0 % 2 = 0 even, next chars is a star
                // follow this patter until i < 9 and j < 12, then print = until j more than 45
                // to complete first line
                // print line
                // second itarration 1 + 0 % 2 != 0 printing a space.
                // to make the 9 x 12 rectangle made up of stars and spaces
                // where even line print 6 stars and odd print 5 stars
                {
                    if ((i + j) % 2 == 0 && j != 11)
                    // checking weather i+ j odd or even
                    // if j = 11 then print space
                    {
                        System.out.print(ANSI_BLUE_BACKGROUND + TEXT_WHITE + "*");
                        // adds blue backround and white stars and prints the starts(no new line)
                    } else {
                        System.out.print(ANSI_BLUE_BACKGROUND + " ");
                    }
                } else {
                    if (i % 2 == 0) {
                        System.out.print(ANSI_RED_BACKGROUND + TEXT_WHITE + "=");
                        // adds the WHITE = sing and a RED backround for every char
                    } else {
                        System.out.print(TEXT_RED + ANSI_WHITE_BACKGROUND + "=");
                        // adds the red backround = sing and a white backround for every char

                    }
                } // End for
            }
            System.out.println();// prints new line
        } // End for
    }
}