import java.lang.*;
import java.util.Iterator;
import java.util.Set;

public class Application {

    private static View view = new View();

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        if (args.length > 0) {

            for (int i = 0; i < args.length; i++) {

                FileContent fileContentChar = new FileContent(args[i]);
                FileContent fileContentWord = new FileContent(args[i]);

                Iterator<String> charIterator = fileContentChar.charIterator();
                Iterator<String> wordIterator = fileContentWord.wordIterator();

                StatisticalAnalysis charStats = new StatisticalAnalysis(charIterator);
                StatisticalAnalysis wordStats = new StatisticalAnalysis(wordIterator);

                // FILE NAME
                view.printString("==" + fileContentChar.getFileName() + "==");

                // CHAR COUNT
                view.printStringAndNumber("\nChar count: ", charStats.size());

                // WORD COUNT
                view.printStringAndNumber("\nWord count: ", wordStats.size());

                // DICT SIZE
                view.printStringAndNumber("\nDict size: ", wordStats.dictionarySize());

                // MOST USED WORDS (>1%)
                view.printString("\nMost used words (>1%): ");
                view.printCollection(wordStats.occurMoreThan(2));

                // LOVE COUNT
                view.printStringAndNumber("\n'love' count: ", wordStats.countOf("love"));

                // LOVE HATE
                view.printStringAndNumber("\n'hate' count: ", wordStats.countOf("hate"));

                // LOVE MUSIC
                view.printStringAndNumber("\n'music' count: ", wordStats.countOf("music"));

                // VOWELS %
                float vowels = charStats.countOf("a", "o", "i", "e", "u");
                float percent = 100 * vowels / charStats.size();
                view.printString("\n'vowels %: " + String.format("%.0f", percent));

                // A:E COUNT RATIO
                float aOccur = charStats.countOf("a");
                float eOccur = charStats.countOf("e");
                float ratio = aOccur / eOccur;
                view.printString("\n'a:e count ratio' : " + String.format("%.2f", ratio));

                // % OF LETTER IN WHOLE TEXT
                view.printString("\n");
                Set<String> charList = charStats.occurMoreThan(0);
                for (String chara: charList) {
                    float charaCount = charStats.countOf(chara);
                    float charPercent = 100 * charaCount / charStats.size();
                    view.printString(String.format("[%s -> %.2f] ", chara.toUpperCase(), charPercent).trim());
                }
                view.printString("\n");
            }
        }
        else {
            view.printString("No instructions! Read about 'wc' linux bash method.");
        }
        long endTime = System.currentTimeMillis();
        view.printString("Benchmark time: " + ((endTime-startTime)/1000.0) + " secs");
    }

}