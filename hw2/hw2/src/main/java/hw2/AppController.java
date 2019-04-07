package hw2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    private Dictionary dictionary = null;

    @RequestMapping("/WordLadder")
    String isRunning() {
        return "App is running.";
    }

    @RequestMapping("/WordLadder/showDictionary")
    String showDictionary() {
        loadDict();
        return dictionary.show();
    }

    @RequestMapping("/WordLadder/addWord")
    String addDictionary(@RequestParam("word") String word) {
        loadDict();
        dictionary.addWord(word);
        return  dictionary.show();
    }

    @RequestMapping("/WordLadder/search")
    String wordLadder(@RequestParam("start") String start, @RequestParam("end") String end) {
        loadDict();
        WordLadder wordLadder = new WordLadder();
        return String.valueOf(wordLadder.Cal(start, end, dictionary.getDict()));
    }

    private void loadDict(){
        if(dictionary == null) dictionary = new Dictionary();
    }
}
