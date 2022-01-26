package com.cursor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static String passwordResult;
    private static String confirmPasswordResult;

    public static void main(String[] args) throws WrongPasswordException, WrongLoginException {

        while (!login(initScanner("Please, enter your Login"))) {
            login(initScanner("Please, enter your Login"));
            break;
        }
        while (!password(initScanner("Please, enter your Password"))) {
            password(initScanner("Please, enter your Password"));
            break;
        }
        while (!confirmPassword(initScanner("Please, confirm Password"))) {
            confirmPassword(initScanner("Please, confirm Password"));
        }
        passwordEquals(passwordResult, confirmPasswordResult);
    }

    public static String initScanner(String inputType) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(inputType);
        inputType = scanner.nextLine();
        return inputType;
    }

    public static boolean checkInputCorrect(String input) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]{0,20}");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean login(String login) {
        boolean flag = false;
        if (checkInputCorrect(login)) {
            flag = true;
            System.out.println("Login is correct");
        } else {
            flag = false;
            try {
                throw new WrongLoginException("Login is WRONG!");
            } catch (WrongLoginException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return flag;
    }

    public static boolean password(String password) {
        boolean flag = false;
        if (checkInputCorrect(password)) {
            flag = true;
            System.out.println("Password is correct");
            passwordResult = password;
        } else {
            flag = false;
            try {
                throw new WrongPasswordException("Password is WRONG!");
            } catch (WrongPasswordException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return flag;
    }

    public static boolean confirmPassword(String confirmPassword) {
        boolean flag = false;
        if (checkInputCorrect(confirmPassword)) {
            flag = true;
            System.out.println("Password is correct");
            confirmPasswordResult = confirmPassword;
        } else {
            flag = false;
            try {
                throw new WrongPasswordException("Password is WRONG!");
            } catch (WrongPasswordException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return flag;
    }

    private static void passwordEquals(String passwordResult, String confirmPasswordResult) {
        if (passwordResult.equals(confirmPasswordResult)) {
            System.out.println("Passwords is Equals");
        } else {
            System.out.println("Passwords not Equals");
        }
    }
}
   
