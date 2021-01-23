

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse ISBNCheckerTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ISBNCheckerTest
{
    private ISBNChecker checker;
    private String isbn;
    /**
     * Konstruktor fuer die Test-Klasse ISBNCheckerTest
     */
    public ISBNCheckerTest()
    {

    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
        System.out.println("##############################################");
        System.out.println("################# START Test #################");
        System.out.println("##############################################");
        this.checker = new ISBNChecker();
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
        System.out.println("##############################################");
        System.out.println("################## END Test ##################");
        System.out.println("##############################################");
    }
    @Test
    public void getISBNLengthTest(){
        assert checker.getISBNLength("123-465 987-1") == 10;
        assert checker.getISBNLength("123-465 988877-1") == 13;
        assert checker.getISBNLength("123-465 98X877-1") == 13;
    }
}
