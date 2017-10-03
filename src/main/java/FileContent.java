import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileContent implements IterableText {

    private String fileName;
    private String content = "";

    public FileContent(String fileName) {

        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    private void readFile() {

        File file = new File(this.fileName);

        try {
            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {

                String line = read.nextLine().toLowerCase().trim();
                if (!line.equals("")) {
                    this.content += line + " ";
                }
            }
            this.content = this.content.trim();
            read.close();

        }   catch(FileNotFoundException e)  {
                System.out.println("No file!");
            }
    }

    @Override
    public Iterator<String> charIterator() {

        this.readFile();
        List<String> charsList = new ArrayList<>();

        char[] contentInCharArray = content.toCharArray();
        for(char chara: contentInCharArray) {
            if(chara != ' ') {
                String charToString = String.valueOf(chara);
                charsList.add(charToString);
            }
        }
        Iterator<String> charIterator = charsList.iterator();

        return charIterator;
    }

    @Override
    public Iterator<String> wordIterator() {

        this.readFile();
        List<String> wordsList = Arrays.asList(content.split("\\s+"));
        Iterator<String> wordIterator = wordsList.iterator();

        return wordIterator;
    }
}

