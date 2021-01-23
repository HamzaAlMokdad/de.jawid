import java.io.*;
/**
 * Beschreiben Sie hier die Klasse ISBNChecker.
 * 
 * @author (Hamza Al Mokdad) 
 * @version (22.01.2021_01)
 */
public class ISBNChecker
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen

    /**
     * Konstruktor für Objekte der Klasse ISBNChecker
     */
    public ISBNChecker()
    {
        // Instanzvariable initialisieren
        System.out.println("############################################################");
        System.out.println("################ ISBNChecker object created ################");
        System.out.println("############################################################");
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public String checkISBN(String isbn)
    {
        // tragen Sie hier den Code ein
        boolean isValid = false;
        System.out.println("ISBN: " + isbn);
        int length = getISBNLength(isbn);
        if ( length != 10 && length != 13) {
            System.err.println("- " + length + "-stellige ISBN ist nicht valide!");
            System.err.println("  - ERROR: ISBN muss entweder 10 oder 13 stellen haben.");
            isValid = false;
        }
        if(length == 10){
            isValid = checkISBN10(loescheStricheUndLeerZeichen(isbn));
        }else{
            isValid = checkISBN13(loescheStricheUndLeerZeichen(isbn));
        }
        if(isValid)
            return "richtig";
        else
            return "falsch";
            
    }
    
    /**
     * ISBN-10
     */
    private boolean checkISBN10(String isbn){
        System.out.println("------------------------------------------------------------");
        System.out.println("----------------- Berechnungsweise ISBN-10 -----------------");
        System.out.println("------------------------------------------------------------");
        
        // Pruefe die Endziffer.
        char last = isbn.charAt(9); 
        if (last != 'X' && last != 'x' && (last < '0' || last > '9')) {
            System.err.println("- Die Endziffer '" + last + "' ist nicht gültig!");
            System.err.println("  - ERROR: Die Endziffer muss '[0-9]', 'X' oder 'x' sein.");
            return false; 
        }
        
        // Pruefe die Summe der Produkte der Ziffern mit INDEX.
        int sum = 0; 
        int INDEX = 10;
        int digit = 0;
        for (int digitIndex = 0; digitIndex < 10; digitIndex++)  
        {
            char digitChar = isbn.charAt(digitIndex);
            System.out.println(" - Schritt(" + (digitIndex + 1) + ") --> Ziffer: " + digitChar);

            // Konvertiere 'X' oder 'x' --> 10
            if (digitChar == 'X' || digitChar == 'x' && digitIndex == 9)
                digit = 10;
            else{
                // Pruefe ob die Stellen Ziffern haben
                digit = Integer.parseInt(Character.toString(digitChar));
                if (0 > digit || 9 < digit){
                    System.err.println("- Die Ziffer '" + digitChar + "' ist nicht gültig!");
                    System.err.println("  - ERROR: Die Ziffer muss [0-9] sein.");
                    return false; 
                }
            }

            System.out.println("       > Berechne: " + sum + " = " + sum + " + " + "(" + digit + " * " + (INDEX - digitIndex) + "))");
            sum += (digit * (INDEX - digitIndex));
            System.out.println(" -------------------------------------------------- ");
        } 

        // Return true if weighted sum  
        // of digits is divisible by 11. 
        int berechnungsErgebnis = sum % 11;
        System.out.println("       >> Berechne: " + sum + " % 11 = " + berechnungsErgebnis);
        if(berechnungsErgebnis != 0){
          System.out.println("       >>>>  Ergebniss MUSS 0 sein.");  
        }
        return (sum % 11 == 0); 
    }
    
    /**
     * ISBN-13
     */
    private boolean checkISBN13(String isbn){
        System.out.println("------------------------------------------------------------");
        System.out.println("----------------- Berechnungsweise ISBN-13 -----------------");
        System.out.println("------------------------------------------------------------");
        
        // Pruefe die Summe der Produkte der Ziffern mit INDEX.
        int sum = 0; 
        int prodZiffer_1_3 = 1;
        int digit = 0;
        for (int digitIndex = 0; digitIndex < 13; digitIndex++)  
        {
            char digitChar = isbn.charAt(digitIndex);
            System.out.println(" - Schritt(" + (digitIndex + 1) + ") --> Ziffer: " + digitChar);

            // Pruefe ob die Stellen Ziffern haben
            digit = Integer.parseInt(Character.toString(digitChar));
            if (0 > digit || 9 < digit){
                System.err.println("- Die Ziffer '" + digitChar + "' ist nicht gültig!");
                System.err.println("  - ERROR: Die Ziffer muss [0-9] sein.");
                return false; 
            }
            if(digitIndex % 2 == 0)
                prodZiffer_1_3 = 1;
            else
                prodZiffer_1_3 = 3;

            System.out.println("       > Berechne: " + sum + " = " + sum + " + " + "(" + digit + " * " + prodZiffer_1_3 + ")");
            sum += (digit * prodZiffer_1_3);
            System.out.println(" -------------------------------------------------- ");
        } 

        // Return true if weighted sum  
        // of digits is divisible by 11. 
        int berechnungsErgebnis = sum % 10;
        System.out.println("       >> Berechne: " + sum + " % 10 = " + berechnungsErgebnis);
        if(berechnungsErgebnis != 0){
          System.out.println("       >>>>  Ergebniss MUSS 0 sein.");  
        }
        return (sum % 10 == 0); 
    }
    
    private int getISBNLength(String isbn){
        int length = isbn.replaceAll("( |-)","").length();
        return length;
    }

    private String loescheStricheUndLeerZeichen(String isbn){
        System.out.println("    - ISBN vorher : " + isbn);
        String result = isbn.replaceAll("( |-)","");
        System.out.println("    - ISBN nachher: " + result);
        return result;
    }
}
