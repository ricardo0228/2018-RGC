package hw2;

import java.lang.String;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
    public int Cal(String start, String end, Set<String> dic)
    {
        Set<String> dict = new HashSet<String>();
        dict.addAll(dic);
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