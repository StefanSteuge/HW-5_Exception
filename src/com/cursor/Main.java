package com.cursor;


import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws WrongPasswordException,WrongLoginException {
        String login = "Please, enter your login:";
        String password = "Please, enter your password: ";
        String confirmPassword = "Confirm Password: ";

        Scanner scanner = new Scanner(System.in);

            System.out.println(login);
            String inLog = scanner.nextLine();
            checkInput(login,password,confirmPassword);
            System.out.println(password);
            String inPass = scanner.nextLine();
            checkInput(login,password,confirmPassword);
            System.out.println(confirmPassword);
            String inConfPass = scanner.nextLine();
            checkInput(login,password,confirmPassword);

        }



    private static boolean checkInput(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        if (!login.matches("[\\w]{1,20}")) {
            try {
                throw new WrongLoginException("Incorrect login!");
            } catch (WrongLoginException e) {
                System.out.println("You have entered incorrect login! Please, try again!");
            }
        } else if (!password.matches("[\\w]{1,20}") ||
                !confirmPassword.matches("[\\w]{1,20}") ||
                !password.equals(confirmPassword)) {
            try {
                throw new WrongPasswordException("Incorrect password!");
            } catch (WrongPasswordException e) {
                System.out.println("You have entered incorrect password! Please, try again!");
            }
        }
        return false;
    }
}
