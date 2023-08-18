package com.praveen.entity;

public class ReverseNumber {
    public static void main(String[] args) {
        String s ="praveen" , n="";
        char ch;
        System.out.println("Enter Original word : " +s);
        for(int i=0;i<s.length();i++){
            ch= s.charAt(i);
            n = ch+n;
        }
        System.out.println("Enter Reversed word : " +n);
    }
}
