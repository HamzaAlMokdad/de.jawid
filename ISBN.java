import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

/**
 * Beschreiben Sie hier die Klasse ISBN.
 * 
 * @author (Hamza Al Mokdad) 
 * @version (20210121_01)
 */
public class ISBN
{
    public static void main(String[] args){
    
        checkISBNsFromFile("eingang_isbn.txt");
        /*
        ISBNChecker checker = new ISBNChecker();
        List<String> isbns = new ArrayList<String>();
        
        isbns.add("0-596-52068-9");  
        isbns.add("978-0-306-40615-7");  

 
        //Invalid ISBNs
        isbns.add(" 0-596-52068-x");
        isbns.add("- 0-596-52068-X");
        isbns.add("1 1 1 2 2 2 3 3 3  a");
        for (String isbn : isbns)
        {
            System.out.println("RESULT ================ ISBN: " + isbn + ": "+ checker.checkISBN(isbn) + "\n");
        }
        
        */
    }
    
    public static void checkISBNsFromFile(String inputFilePath){
        ISBNChecker checker = new ISBNChecker();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            FileWriter fw = new FileWriter("ausgang_isbn.txt");
            String line = reader.readLine();
            while (line != null) {
                System.out.println("ISBN: " + line);
                fw.write(line + " ..... \""+ checker.checkISBN(line) +"\"\n");
                // read next line
                line = reader.readLine();
            }
            reader.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
