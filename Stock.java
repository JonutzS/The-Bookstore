import java.util.List;
import java.util.ArrayList;
public class Stock
{
  private List<Book> bookList;
  
  
  private Stock(){
    this.bookList = new ArrayList<Book>();
  }
  
 
  
  private static final class SingletonHolder{
      private static final Stock INSTANCE = new Stock();
  }
  
  public List<Book> getBookList(){
    return this.bookList;
  }
  
  
  public static Stock getInstance(){
      return SingletonHolder.INSTANCE;
  }
  
  public void getBooks(){
      
      bookList.stream().forEach(System.out::println);
  }
  
  public void addBook(Book newBook) throws TooManyBooksException{
    if(bookList.size()<30) {
        bookList.add(newBook);
    } else {
        throw new TooManyBooksException();
    }
  }
  
  public void getPaperBooks(){
    
      bookList
        .stream()
        .filter(carte->carte instanceof PaperBook)
        .forEach(System.out::println);
  }
  
   public void getEBooks(){
       bookList
        .stream()
        .filter(carte->carte instanceof EBook)
        .forEach(System.out::println);
  }
  
  public boolean removeBook(String titlu){
      Book bookToBeRemoved = new Book();
      bookToBeRemoved.setTitle(titlu);
      
      return bookList.remove(bookToBeRemoved);
  }
}
