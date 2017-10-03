import java.util.Arrays;
import java.util.List;

public class CharIterator {

    private FileContent fileContent;
    private int index;
    private String content;
    List<String> charsList;

    public  CharIterator(FileContent fileContent) {

        this.fileContent = fileContent;
        this.content = "";
        this.charsList = Arrays.asList(content.split("\\s+"));
    }

    public boolean hasNext() {

        if(index < charsList.size()){
            return true;
        }
        return false;
    }

    public String next() {

        if(this.hasNext()){
            return charsList.get(index++);
        }
        return null;
    }
}

