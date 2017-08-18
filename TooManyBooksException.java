
public class TooManyBooksException extends Exception
{
    TooManyBooksException(){
        super("You cannot add more than 30 books");
    }
}
