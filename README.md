# Lexical Analysis of FOR LOOP in Java
 A Java utility that checks the syntax of FOR loop statements in input lines. It reads input from a file, and for each line, it uses regular expressions to determine if the line is a valid FOR loop statement. The program outputs the result of the check, along with the tokens extracted from the line.

## Usage
To use the program, simply compile and run the Main.java file. The program reads input from a text file named `"FILE.txt"` located in the same directory as the Main.java file. Each line of input in the text file represents a separate FOR loop. The program will analyze each line of input and output the results to the console.

## Input format
The program expects input in the following format for each line:
`FOR <variable> = <start> TO <end>`
> Where <variable> is a single alphabetical character representing the loop variable, <start> is the starting value for the loop, and <end> is the ending value for the loop.

## Output
The program outputs the results of the lexical analysis and parsing of each line of input.

For valid FOR loops, the program will output the tokens identified in the input, along with the results of parsing those tokens to determine whether the input represents a valid FOR loop. For invalid input, the program will output an error message indicating why the input was rejected.


## Repository structure
This repository contains the following files:
* Main.java: Contains the Java code for the FOR Loop Parser program.
* FILE.txt: Contains sample input for the program.
* README.md: The file you are currently reading, providing an overview of the FOR Loop Parser program.

## Contributing
> Contributions to this project are welcome. If you find a bug or would like to suggest an improvement, please open an issue or submit a pull request.

## License
This project is licensed under the MIT License - see the LICENSE.md file for details.
