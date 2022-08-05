package com.lambdaexception;

import java.util.Scanner;
import java.util.regex.Pattern;

@FunctionalInterface
interface UserIsValid {
    boolean mathPattern(String pattern, String name);
}

public class UserRegistractionLambdaFunction {
	
    static String namePattern = "^[A-Z]{1}+[a-z]{3,}$";
    static String emailPattern1 = "^[a-z]*([.]?[a-z]+)*@bl[.]co([.]?in)*";
    static String emailPattern2 = "[a-zA-Z0-9_.]*[-]*[+]*[0-9]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+";
    static String phoneNumPattern = "^91\\s[6789][0-9]{9}";
    static String passWordPattern1 = "[a-zA-Z0-9_.]*[-]*[+]*[0-9]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+";
    static String passWordPattern2 = "[A-Z]{1}[a-z]{5,}[0-9]{1}[!@#$%^&*~]{1}";

    UserIsValid checkValid = (String pattern, String name) -> Pattern.matches(pattern, name);

    public void nameIsValid(String name) throws UserRegistrationException{
        try {
            if (checkValid.mathPattern(namePattern, name)){
                System.out.println("Perfect! First #Name");
            }else {
                throw new UserRegistrationException("Please Enter a Valid First name with Only \"One Starting Capital\" latter");
            }
        }catch (UserRegistrationException e){
            System.out.println(e.getMessage());
        }
    }

    public void eMailIsValid(String email) throws UserRegistrationException{
        try {
            if ( (checkValid.mathPattern(emailPattern1, email)) || (checkValid.mathPattern(emailPattern2, email)) ){
                System.out.println("Perfect! Email #Name");
            }else {
                throw new UserRegistrationException("Please Enter a Valid Email with Only \"example.abc@bl.co.in\" and universal email latter");
            }
        }catch (UserRegistrationException e){
            System.out.println(e.getMessage());
        }
    }


    public void phoneNumIsValid(String phonenum) throws UserRegistrationException{
        try {
            if (checkValid.mathPattern(phoneNumPattern, phonenum)){
                System.out.println("Perfect! #phoneNum");
            }else {
                throw new UserRegistrationException("Please Enter a Valid Mobile Num ex:- 90 9533182605");
            }
        }catch (UserRegistrationException e){
            System.out.println(e.getMessage());
        }
    }


    public void passWordIsValid(String password) throws UserRegistrationException{
        try {
            if ( (checkValid.mathPattern(passWordPattern1, password)) || (checkValid.mathPattern(passWordPattern2, password)) ){
                System.out.println("Perfect! #password");
            }else {
                throw new UserRegistrationException("Please Enter a Valid password, it should have minimum 8 characters Or it should have minimum 8 characters with, 1 upper case, 1 Numeric and 1 Special Char");
            }
        }catch (UserRegistrationException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws UserRegistrationException {
    	UserRegistractionLambdaFunction usr = new UserRegistractionLambdaFunction();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;

        do {
            System.out.println("***Welcome to Lambda Function to validate User Entry***");
            System.out.println("1: Check Name Pattern");
            System.out.println("2: Check e-Mail Pattern");
            System.out.println("3: Check phoneNum Pattern");
            System.out.println("4: Check passWord Pattern");
            System.out.println("5: Exit");
            System.out.println("Enter to option : ");
            int opt = sc.nextInt();
            switch (opt){
                case 1:
                    System.out.println("Enter the Name : ");
                    String name =  sc.next();
                    usr.nameIsValid(name);
                    break;
                case 2:
                    System.out.println("Enter the e-Mail : ");
                    String eMail =  sc.next();
                    usr.nameIsValid(eMail);
                    break;
                case 3:
                    System.out.println("Enter the phoneNum : ");
                    String phoneNum =  sc.next();
                    usr.nameIsValid(phoneNum);
                    break;
                case 4:
                    System.out.println("Enter the passWord : ");
                    String passWord =  sc.next();
                    usr.nameIsValid(passWord);
                    break;
                case 5:
                    flag = true;
                    break;
            }

        }while (flag);
    }


}
