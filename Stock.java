import java.util.List;
import java.util.ArrayList;
public class Stock
{
  private List<Book> bookList;
  
  //1. Constructor privat
  private Stock(){
    this.bookList = new ArrayList<Book>();
  }
  
  //2. O singura instanta privata, statica si constanta de Stock
  
  private static final class SingletonHolder{
      private static final Stock INSTANCE = new Stock();
  }
  
  public List<Book> getBookList(){
    return this.bookList;
  }
  
  //3. O metoda publica si statica care sa intoarca instanta de singleton
  public static Stock getInstance(){
      return SingletonHolder.INSTANCE;
  }
  
  public void getBooks(){
      /*for(Book book: bookList){
          System.out.println(book);
      }*/
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
    //     for(Book book: bookList){
    //         if(book instanceof PaperBook) {
    //             System.out.println(book);
    //         }
    //     }
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