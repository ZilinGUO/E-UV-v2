package com.gl52.euv.controller;

import java.util.Stack;

public class test {
    public static void main(String[] args){
        String afs="afaccfa";
        System.out.println(toaw(afs));

    }
    public static String toaw(String almostPalindrome){
        int len = almostPalindrome.length();
        Stack<Character> s1 = new Stack();
        Stack<Character> s2 = new Stack();
        for (int i = 0; i < len/2; i++) {
            if (almostPalindrome.charAt(i) != almostPalindrome.charAt(len-1-i)) {
                if(s1.empty()&&s2.empty()){
                    s1.push(almostPalindrome.charAt(i));
                    s2.push(almostPalindrome.charAt(len-1-i));
                }else{
                    if(s1.empty()&&s1.peek()==almostPalindrome.charAt(i)){
                        s1.pop();
                    }else if(s2.empty()&&s2.peek()==almostPalindrome.charAt(i)){
                        s2.pop();
                    }else{
                        s1.push(almostPalindrome.charAt(i));
                    }
                    if(s1.empty()&&s1.peek()==almostPalindrome.charAt(len-1-i)){
                        s1.pop();
                    }else if(s2.empty()&&s2.peek()==almostPalindrome.charAt(len-1-i)){
                        s2.pop();
                    }else{
                        s2.push(almostPalindrome.charAt(i));
                    }
                }

            }
        }
        if(s1.empty()&&s2.empty()){
            return almostPalindrome;
        }else{
            while (!s1.empty()){
                almostPalindrome.replace(Character.toString(s1.pop()),"");
            }
            while (!s2.empty()&&s2.peek()!=almostPalindrome.length()/2){
                almostPalindrome.replace(Character.toString(s2.pop()),"");
            }
            return almostPalindrome;

        }
    }
}
