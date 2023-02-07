package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {
    //Declaring all text fields and labels.
    @FXML
    TextField txtInput1X, txtInput1Y, txtInput2, txtInput3, txtInput4X, txtInput4Y, txtInput5, txtInput6, txtInput8, txtInput91, txtInput92, txtInput10, txtInput11, txtInput12, txtInput13, txtInput14, txtInput15;
    @FXML
    Label lblDisplay1, lblDisplay2, lblDisplay3, lblDisplay41, lblDisplay42, lblDisplay43, lblDisplay5, lblDisplay6, lblDisplay7, lblDisplay8, lblDisplay9, lblDisplay10, lblDisplay11, lblDisplay12, lblDisplay13, lblDisplay14, lblDisplay15, lblDisplay161, lblDisplay162;

    @FXML
    //Piece #1
    private void handleClick1() {
        //x and y variables set to the user inputs for the number, and number of multiples.
        int x = Integer.parseInt(txtInput1X.getText());
        int y = Integer.parseInt(txtInput1Y.getText());
        //total string for all values combined.
        String total = "";
        //loop that multiplies y by the multiples variable, which increases by 1 everytime, printing all the multiples as a result.
        for (int multiples = 1; multiples < x + 1; multiples++) {
            //constantly updates, and as a result, prints all the multiples
            total += y * multiples + ", ";
        }
        //displays all x multiples of y
        lblDisplay1.setText(total.substring(0, total.length() - 2));
    }

    @FXML
    //Piece #2
    private void handleClick2() {
        //variables that get the user input, and a total string for total end value.
        String userInput = txtInput2.getText();
        String total = "";
        //this is in a double loop because we are not just printing the substrings starting from the first character, we are printing all the substrings starting from every character of the string.
        //first loop basically tells second loop to run the number of times the length of the string is, so that all substring are displayed.
        for (int a = 0; a <= userInput.length(); a++) {
            //runs a loop that prints the first letter, but keeps on adding letters everytime.
            for (int b = a + 1; b <= userInput.length(); b++) {
                //constantly updates and as a result, prints full string of substrings.
                total += userInput.substring(a, b) + ", ";
            }
        }
        //displays substrings of the user input.
        lblDisplay2.setText(total.substring(0, total.length() - 2));
    }

    @FXML
    //Piece #3
    private void handleClick3() {
        //variables that get the user input, and the total string.
        String userInput = txtInput3.getText();
        String total = "";
        //first loop that prints the single lettered permutations.
        for (int a = 0; a < userInput.length(); a++) {
            //adds the permutations to the total variable.
            total += userInput.charAt(a) + ", ";
        }
        //second loop that prints the double lettered permutations.
        for (int a = 0; a < userInput.length() - 1; a++) {
            for (int b = a + 1; b < userInput.length(); b++) {
                //adds the permutations to the total variable.
                total += userInput.charAt(a);
                total += userInput.charAt(b) + ", ";
            }
        }
        //third loop that prints the triple lettered permutations.
        for (int a = 0; a < userInput.length() - 1; a++) {
            for (int b = a + 1; b < userInput.length(); b++) {
                for (int c = b + 1; c < userInput.length(); c++) {
                    //adds the permutations to the total variable.
                    total += userInput.charAt(a);
                    total += userInput.charAt(b);
                    total += userInput.charAt(c) + ", ";
                }
            }
        }
        //fourth loop that prints the quadruple lettered permutations, only if the string is 5 characters long (essentially, I only got #3 to work if the user inputs strings of 4 or 5 letters long).
        if (userInput.length() == 5) {
            for (int a = 0; a < userInput.length() - 1; a++) {
                for (int b = a + 1; b < userInput.length(); b++) {
                    for (int c = b + 1; c < userInput.length(); c++) {
                        for (int d = c + 1; d < userInput.length(); d++) {
                            //adds the permutations to the total variable.
                            total += userInput.charAt(a);
                            total += userInput.charAt(b);
                            total += userInput.charAt(c);
                            total += userInput.charAt(d) + ", ";
                        }
                    }
                }
            }
        }
        //this adds the total string at the end (if a 4 character string was inputted, it will print all 4 letters, and if a 5 character string was inputted, it will print all 5 letters).
        total += userInput;
        //displays the total string.
        lblDisplay3.setText(total);
    }

    @FXML
    //Piece #4
    private void handleClick4() {
        //variables that get the user input for number of die and rolls.
        int die = Integer.parseInt(txtInput4X.getText());
        int rolls = Integer.parseInt(txtInput4Y.getText());
        //variables for the random number generated, the sum of the die values, and the minimum and maximum die values.
        double random;
        double sum = 0;
        double max = 0;
        double min = 6;

        //loop that runs the number of die times the number of rolls amount of times.
        for (int a = 0; a < die * rolls; a++) {
            //sets a random dice roll(number from 1-6) everytime.
            random = Math.floor(Math.random() * 6) + 1;
            //adds the dice roll value to the sum.
            sum += random;
            //constantly updates the maximum value - if the dice roll is greater than the current maximum value, it will change it to the dice roll value.
            if (random > max) {
                max = random;
            }
            //constantly updates the minimum value - if the dice roll is less than the current minimum value, it will change it to the dice roll value.
            if (random < min) {
                min = random;
            }
        }
        //displays average, minimum, and maximum values.
        lblDisplay41.setText("Average: " + sum / (die * rolls));
        lblDisplay42.setText("Max: " + (int) max);
        lblDisplay43.setText("Min: " + (int) min);
    }

    @FXML
    //Piece 5
    private void handleClick5() {
        //variables that get the user input, change the user input into a string, get the length of that string, an extra string length variable to be used in the loop, and a total string.
        int userInputInt = Integer.parseInt(txtInput5.getText());
        String userInputStr = txtInput5.getText();
        int userInputLength = userInputStr.length();
        int loopNum = userInputLength;
        String total = "";
        //loop that runs for the amount of times the length of the number that the user inputted is.
        for (int i = 0; i < loopNum; i++) {
            //adds the current number in order based on the length of the user input.
            total += (((int) (userInputInt - userInputInt % Math.pow(10, userInputLength - 1))) + "+");
            //changes the user input variable to equal the old user input number subtracted by the number that was just displayed.
            userInputInt %= Math.pow(10, userInputLength - 1);
            //reduces the user input length by 1 everytime so that the first line in the loop can decide how much to raise 10 to the power to.
            userInputLength -= 1;
        }
        //displays what the user input integer expands to.
        lblDisplay5.setText(txtInput5.getText() + " expands to " + total.substring(0, total.length() - 1));
    }

    @FXML
    //Piece #6
    private void handleClick6() {
        //variable set to the user input for the number, and boolean to know if the number is prime or not - defaulted to true.
        int num = Integer.parseInt(txtInput6.getText());
        boolean primeNum = true;
        //since these values will not work well in the for loop, an if statement runs to see if 1 and 0 are the input; if so, it will display that those are not prime numbers, else, it will run the actual prime number code.
        if (num == 1 || num == 0) {
            lblDisplay6.setText("This number is not a prime number");
        } else {
            //loop that runs from 2 to 1 less than the value of the user input number.
            for (int a = 2; a < num; a++) {
                //if the number is divisible by a number in the loop process, it will print that the number is not prime.
                if (num % a == 0) {
                    //prints that the number is not prime.
                    lblDisplay6.setText("This number is not a prime number");
                    //sets the primeNum boolean to false, since it is not a prime number.
                    primeNum = false;
                }
            }
            //if the entire function and loop above runs, that means that there was no divisible numbers found; if this is so, then the primeNum boolean would not have changed (it would still be true), so then if the boolean is true, it will print that the number is prime.
            if (primeNum) {
                //prints that the number is prime.
                lblDisplay6.setText("This number is a prime number");
            }

        }

    }

    @FXML
    //Piece #7
    private void handleClick7() {
        //variables set to the first prime number, 2, a boolean which is set to true or false depending on if the number is prime or not, a counter variable to stop the loop at a certain point, and a total string.
        int num = 2;
        boolean primeNum = true;
        int counter = 0;
        String total = "";
        //loop that runs while counter is less than 10, making it run 10 times.
        while (counter < 10) {
            //loop that makes a j variable starting from 2 and ending at the number 1 before the value of num.
            for (int j = 2; j < num; j++) {
                //detects if at any point, if the number divisible by j has a remainder of 0, then it is not prime, and it sets the prime number boolean to false.
                if (num % j == 0) {
                    primeNum = false;
                }
            }
            //if statement saying that if the number is prime, it will add it to the total string and add 1 to counter.
            if (primeNum) {
                //adds prime number to string.
                total += num + ", ";
                //adds 1 to counter(counter will only increase when a prime number is present; this is to make sure the function prints a total of 10 prime numbers.
                counter++;
            }
            //sets the prime number variable back to true, to reset it.
            primeNum = true;
            //adds 1 to the number variable.
            num++;
        }
        //displays the prime numbers.
        lblDisplay7.setText(total.substring(0, total.length() - 2));

    }

    @FXML
    //Piece #8
    private void handleClick8() {
        //variables for getting user input number, total string, prime number variable, and 2 boolean variables for the code segment.
        int num = Integer.parseInt(txtInput8.getText());
        String total = "";
        int primeNum = 2;
        boolean primeNumBoolean1;
        boolean primeNumBoolean2;

        //loop that runs while num is greater than 1, so that it prints all the prime factors of the number.
        while (num > 1) {
            //sets both booleans to true.
            primeNumBoolean1 = true;
            primeNumBoolean2 = true;
            //this if statement finds out if the number divided by prime number has a remainder of 0; if so, it will add the prime number to the total string as one of the prime factors.
            if (num % primeNum == 0) {
                //adds prime number to string.
                total += primeNum + " * ";
                //divides the number by the prime number so that we can figure out the other prime factors of the number.
                num /= primeNum;
                //if the number is not divisible by the prime number, this runs below.
            } else {
                //loop that runs while this first boolean is true.
                while (primeNumBoolean1) {
                    //adds 1 to the prime number variable.
                    primeNum++;
                    //this segment essentially finds the next prime number.
                    for (int j = 2; j < primeNum; j++) {
                        //divides the prime number by the numbers 2 to 1 less than prime number, and if the prime number is ever divisible by j, then it sets the second boolean to false.
                        if (primeNum % j == 0) {
                            //sets second boolean to false.
                            primeNumBoolean2 = false;
                        }
                    }
                    //if the second boolean is true, this means that the prime number variable is prime, so it will set the first boolean to false in order to stop this prime number loop, and send the prime number back to the code segment at the top.
                    if (primeNumBoolean2) {
                        //sets the first boolean to false.
                        primeNumBoolean1 = false;
                        //otherwise, if the second boolean is false, that means that the prime number variable is not prime, so it will set the second boolean to true, and then it will run this code segment repeatedly until the prime number variable is a prime number.
                    } else {
                        //sets the second boolean to false.
                        primeNumBoolean2 = true;
                    }
                }
            }
        }
        //displays all the prime factorials.
        lblDisplay8.setText(total.substring(0, total.length() - 2));
    }

    @FXML
    //Piece #9
    private void handleClick9() {
        //variables for the numbers inputted by the user, and the string total variable.
        int num1 = Integer.parseInt(txtInput91.getText());
        int num2 = Integer.parseInt(txtInput92.getText());
        String total = "";
        //loop that runs in order to find the greatest common factor, and stops once there is a result (once there are characters in the total string).
        for (int i = num1; total.length() == 0; i--) {
            //if both numbers are divisible by the integer i, then i is the greatest common factor.
            if (num1 % i == 0 && num2 % i == 0) {
                //adds each number value divided by i, and turns it into a fraction, therefore reducing it.
                total += num1 / i + "/" + num2 / i;
            }
        }
        //displays reduced number.
        lblDisplay9.setText(total);
    }

    @FXML
    //Piece #10
    private void handleClick10() {
        //variables for the two numbers set to 2, the sum, the counts variable which is the user input for the amount of numbers they want to see, and the total string.
        int num1 = 1;
        int num2 = 1;
        int sum;
        int counts = Integer.parseInt(txtInput10.getText());
        String total = "";
        //first, this prints the starting 2 numbers of the fibonacci sequence, 1 and 1.
        total += num1 + ", " + num2 + ", ";
        //loop that prints the fibonacci sequence the amount of times the user inputted subtracted by 2, since the first 2 numbers were 1 and 1 added earlier.
        for (int i = 0; i < counts - 2; i++) {
            //sets sum to total of two numbers.
            sum = num1 + num2;
            //adds the sum to the total string.
            total += sum + ", ";
            //sets first number to the second number, in order to move on in the sequence.
            num1 = num2;
            //sets the second number to the sum, in order to move on in the sequence.
            num2 = sum;
        }
        //displays the total string.
        lblDisplay10.setText(total.substring(0, total.length() - 2));
    }

    @FXML
    //Piece #11
    private void handleClick11() {
        //variables that get the user input number, and the total string.
        int num = Integer.parseInt(txtInput11.getText());
        String total = "";
        //loop that runs until i^2 is greater or equal to num, which ensures that the factor pairs are not repeated when displayed.
        for (int i = num; i * i >= num; i--) {
            //if the number is divisible by the integer i in the loop, then it is a factor.
            if (num % i == 0) {
                //this prints i, the factor, and num/i, the other factor.
                total += "(" + i + "," + num / i + "), ";
            }
        }
        //displays the total string.
        lblDisplay11.setText(total.substring(0, total.length() - 2));
    }

    @FXML
    //Piece #12
    private void handleClick12() {
        //variable that gets the user input number.
        int num = Integer.parseInt(txtInput12.getText());
        //loop that runs for all numbers between 1 less than i, and 0.
        for (int i = num - 1; i > 1; i--) {
            //multiples num by i.
            num *= i;
        }
        //displays the total string.
        lblDisplay12.setText("" + num);
    }

    @FXML
    //Piece #13
    private void handleClick13() {
        //variables that get the user input number for the number they want to test, the number string variable, the sum variable, and the character a variable.
        int num = Integer.parseInt(txtInput13.getText());
        String numString = Integer.toString(num);
        int sum = 0;
        char a;
        //loop that takes each digit in the number to the power of the amount of digits there are in the number, and adds them up.
        for (int i = 0; i < numString.length(); i++) {
            //character variable to find the character of each digit.
            a = numString.charAt(i);
            //adds the digit to the power of the number of digits to the sum variable, which is the total sum of the digits to the power of the number of digits.
            sum += Math.pow(Integer.parseInt(String.valueOf(a)), numString.length());
        }
        //if statement that checks if the sum variable value is equivalent to the num variable value.
        if (sum == num) {
            //if the two values are equal, then the number is a narcissistic number, and it displays that it is.
            lblDisplay13.setText(num + " is a narcissistic number.");
            //otherwise...
        } else {
            //if the two values are not equal, then the number is not a narcissistic number, and it displays that it is not.
            lblDisplay13.setText(num + " is not a narcissistic number.");
        }
    }

    @FXML
    //Piece #14
    private void handleClick14() {
        //variables that get the user input number for the amount of narcissistic numbers to print, the starting number (1), the number string variable, the counter variable, the temporary sum variable, the boolean run variable for the loop, the character a variable, and the total string variable.
        int numTimes = Integer.parseInt(txtInput14.getText());
        int num = 1;
        String numString;
        int counter = 0;
        int tempSum = 0;
        boolean run = true;
        char a;
        String total = "";
        //loop that runs the amount of times the user inputted, to display that many narcissistic numbers.
        while (counter < numTimes) {
            //sets run variable to true at beginning every time so that the second loop runs.
            run = true;
            //loop that finds the next narcissistic number.
            while (run) {
                //sets the number string variable to the string version of the num integer.
                numString = Integer.toString(num);
                //loop that takes each digit in the number to the power of the amount of digits there are in the number, and adds them up.
                for (int i = 0; i < numString.length(); i++) {
                    //character variable to find the character of each digit.
                    a = numString.charAt(i);
                    //adds the digit to the power of the number of digits to the temporary sum variable, which is the total sum of the digits to the power of the number of digits.
                    tempSum += Math.pow(Integer.parseInt(String.valueOf(a)), numString.length());
                }
                //if statement that sees if the temporary sum is equal to the current number, then it is narcissistic, so it adds the number to the total string, and then sets the run boolean from false, temporarily preventing the second while loop from running again.
                if (tempSum == num) {
                    //adds the number to the total string.
                    total += num + ", ";
                    //sets the run boolean to false.
                    run = false;
                }
                //adds 1 to the number variable, so that it can continue to find the next narcissistic number.
                num++;
                //sets the temporary sum variable to 0, to reset it, since the sum is different every time.
                tempSum = 0;
            }
            //adds 1 to counter, so that the first while loop will only run the amount of times the user inputted.
            counter++;
        }
        //displays the total string.
        lblDisplay14.setText(total.substring(0, total.length() - 2));
    }

    @FXML
    //Piece #15
    private void handleClick15() {
        //variables that get the number the user inputted, the 2 testing variables used in the loop (the first testing variable is set to 1 more than the square root of the greatest integer you can input in java, for reasons i will say later on in this code segment), the equal boolean which helps stop the loop, and the counter variable.
        double num = Integer.parseInt(txtInput15.getText());
        double test1 = 46341;
        double test2;
        boolean equal = false;
        int counter = 0;
        //loop that runs until the equal boolean is true, as this will stop once the two test variables are less than 0.0000001 apart.
        while (!equal) {
            //runs the code segment shown in the website from the video, setting the second test variable to the equivalent of that equation.
            test2 = (test1 + (num / test1)) / 2;
            //if statement that checks to see if the difference of the 2 test variables is less than 0.0000001 (additionally, for example, if the first test variable was originally set to 1, then in many circumstances, the second test variable would be greater than the first test variable, test1-test2 to be negative, and then it would always display that the square root of the number inputted was 1; since I set my first test variable to 1 greater than the square root of the greatest integer in java, it will never give me this error).
            if (test1 - test2 < 0.0000001) {
                //sets equal boolean to true in order to stop the loop.
                equal = true;
                //the next 3 lines rounds the number to the nearest ten millionth, or 7 decimal places.
                //multiplies the variable by 10 million.
                test1 *= 10000000;
                //rounds the variable.
                test1 = Math.round(test1);
                //divides the variable by 10 million, concluding in a rounded number.
                test1 /= 10000000;
                //displays the result.
                lblDisplay15.setText("The square root of " + num + " is approximately " + test1);
            }
            //sets test 1 equal to test 2 every time, so that the loop can be ran over and over again without creating a new variable every time.
            test1 = test2;
        }
    }

    @FXML
    //Piece #16 - James Gregory Method
    private void handleClick161() {
        //variables for the number variable, which starts at 3 which is what the first denominator is after the starting number, the sum variable which starts at 4 which is what the sequence starts at, the rounded sum variable, the counter variable, the rounded pi variable, and the run boolean to control how long the loop runs.
        double num = 3;
        double sum = 4;
        double sumRounded = 0;
        int counter = 1;
        double piRounded = Math.round((Math.PI * 1000000000));
        piRounded /= 1000000000;
        boolean run = true;
        //loop that runs until the run boolean is false (once the number is equal to the pi variable).
        while (run) {
            //there is a counter constantly adding 1 everytime, and this segment basically tells the program whether it should add or subtract each time it is run, and it keeps switching between adding and subtracting constantly.
            if (counter % 2 == 1) {
                //subtracts the fraction from the number variable.
                sum -= (4 / num);
                //if the remainder of counter/2 is 0...
            } else {
                //adds the fraction to the number variable.
                sum += (4 / num);
            }
            //these next 2 lines round sum to the nearest 9 digits, so it can be compared to pi.
            //multiples the sum variable by 1 billion and rounds it.
            sumRounded = Math.round((sum * 1000000000));
            //divides the sum variable by 1 billion.
            sumRounded /= 1000000000;
            //this is basically checking if the sum variable rounded to the nearest 9 digits is equal to the pi variable rounded to the nearest 9 digits, then they are exactly the same, and the loop should be stopped because pi has been found.
            if (sumRounded == piRounded) {
                //sets run to false if the statement is true.
                run = false;
            }
            //adds 2 to the num variable everytime, since it needs to be 2 greater than the previous number every time it runs again.
            num = num + 2;
            //adds 1 to counter, so it can be determined whether the computer should add or subtract.
            counter++;
        }
        //displays pi found by the James Gregory method.
        lblDisplay161.setText("Using the James Gregory Method, Pi is " + sumRounded);
    }

    @FXML
    //Piece #16 - Nilakantha method
    private void handleClick162() {
        //variables for the number variable, which starts at 2 which is what the first number in the first denominator sequence is after the starting number, the sum variable which starts at 3 which is what the sequence starts at, the rounded sum variable, the counter variable, the rounded pi variable, and the run boolean to control how long the loop runs.
        double num = 2;
        double sum = 3;
        double sumRounded = 0;
        int counter = 1;
        double piRounded = Math.round((Math.PI * 1000000000));
        piRounded /= 1000000000;
        boolean run = true;
        //loop that runs until the run boolean is false (once the number is equal to the pi variable).
        while (run) {
            //there is a counter constantly adding 1 everytime, and this segment basically tells the program whether it should add or subtract each time it is run, and it keeps switching between adding and subtracting constantly.
            if (counter % 2 == 1) {
                //adds the fraction to the number variable.
                sum += (4 / (num * (num + 1) * (num + 2)));
                //if the remainder of counter/2 is 0...
            } else {
                //subtracts the fraction from the number variable.
                sum -= (4 / (num * (num + 1) * (num + 2)));
            }
            //these next 2 lines round sum to the nearest 9 digits, so it can be compared to pi.
            //multiples the sum variable by 1 billion and rounds it.
            sumRounded = Math.round((sum * 1000000000));
            //divides the sum variable by 1 billion.
            sumRounded /= 1000000000;
            //this is basically checking if the sum variable rounded to the nearest 9 digits is equal to the pi variable rounded to the nearest 9 digits, then they are exactly the same, and the loop should be stopped because pi has been found.
            if (sumRounded == piRounded) {
                //sets run to false if the statement is true.
                run = false;
            }
            //adds 2 to the num variable everytime, since it needs to be 2 greater than the previous number every time it runs again.
            num = num + 2;
            //adds 1 to counter, so it can be determined whether the computer should add or subtract.
            counter++;
        }
        //displays pi found by the Nilakantha method.
        lblDisplay162.setText("Using the Nilakantha Method, Pi is " + sumRounded);
    }
}