package com.proj1;

import java.lang.String;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WordLadder 
{
    public static void main( String[] args )
    {
        Set<String> dict = new HashSet<String>();
        Scanner sc = new Scanner(System.in);
        String start = sc.nextLine();
        String end = sc.nextLine();
        String tmp = sc.nextLine();
        while(!tmp.equals(""))
        {
            dict.add(tmp);
            tmp = sc.nextLine();
        }
        sc.close();
        System.out.println(Cal(start, end, dict));
    }

    private static int Cal(String start, String end, Set<String> dict)
    {
        Queue<String> Q = new LinkedList<String>();
        Q.add(start); 
        Q.add("");
        int res = 1;
        while(!Q.isEmpty())
        {
            String str = Q.poll();
            if(str != "")
            {
                int strLen = str.length();
                for(int i = 0; i < strLen; i++)
                {
                    char tmp = str.charAt(i);
                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        if(c == tmp)continue;
                        str = Replace(str, c, i);
                        //System.out.println(str);
                        if(str.equals(end)) return res+1;
                        if(dict.contains(str))
                        {
                        //System.out.println(str);
                            Q.add(str);
                            dict.remove(str);
                        }
                    }
                    str = Replace(str, tmp, i);
                }
            }
            else if(!Q.isEmpty())
            {
                res++;
                Q.add("");
            }
        }
        return 0;
    }

    private static String Replace(String old, char c, int location)
    {
        return old.substring(0, location) + c + old.substring(location+1);
    }
}
