package hw2;

import java.util.HashSet;
import java.util.Set;

public class Dictionary {
    private Set<String> dict;

    public Dictionary(){
        dict = new HashSet<String>();
        dict.add("hat");
        dict.add("had");
        dict.add("hid");
        dict.add("did");
    }

    public Set<String> getDict(){
        return dict;
    }

    public void addWord(String word){
        dict.add(word);
    }
    
    public String show(){
        String result = "";
        for(String tmp : dict){
            result += tmp + " ";
        }
        return result;
    }
}