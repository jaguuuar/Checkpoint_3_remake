import java.util.Arrays;
import java.util.List;

public class WordIterator {

    private FileContent fileContent;
    private int index;
    private String content;
    List<String> wordsList;

    public  WordIterator(FileContent fileContent) {

        this.fileContent = fileContent;
        this.content = "";
        this.wordsList = Arrays.asList(content.split("\\s+"));
    }

    public boolean hasNext() {

        if(index < wordsList.size()){
            return true;
        }
        return false;
    }

    public String next() {

        if(this.hasNext()){
            return wordsList.get(index++);
        }
        return null;
    }
}

