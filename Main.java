import java.util.Scanner;
public class Main
{
    public static void main(String [] args){
        Stock stock  = Stock.getInstance();
        Scanner scanner = new Scanner(System.in);
        
        Book b1 = new PaperBook("Spioana", 36, true, 300);
        Book b2 = new PaperBook("Ma numesc Rosu", 45, true, 420);
        Book b3 = new EBook("Codul lui DaVinci", 20, false, 1.7);
        Book b4 = new EBook("Cei frumosi si blestemati", 25, true, 2.3);
        
        Runnable runnable = ()->{
            while(true){
                try{
                    Thread.sleep(10000);
                    System.out.println("Produse disponibile: " + stock.getBookList().size());
                }catch(InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        };
        
        new Thread(runnable).start();

        try{
            stock.addBook(b1);
            stock.addBook(b2);
            stock.addBook(b3);
            stock.addBook(b4);
        }catch(TooManyBooksException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("1. afisare carti/eb/pb");
        System.out.println("2. adauga eb/pb titlu pret disponibilitate dimensiune");
        System.out.println("3. sterge titlu");
        System.out.println("4. exit");
                
        String line = "";
        String [] words = null;
        while(true){
            System.out.print("Introduceti comanda: ");
            line = scanner.nextLine();
            words = line.split("\\s+"); //split-uim dupa 1/mai multe spatii
            switch(words[0]){
                case "afisare":
                    switch(words[1]){
                        //1p
                        case "carti": 
                            stock.getBooks();
                            break;
                            //1p
                        case "eb": 
                            stock.getEBooks();
                            break;
                        case "pb": 
                            stock.getPaperBooks();
                            break;
                    }
                break;
                
                
                case "adauga": 
                    try{
                        double pret = Double.parseDouble(words[3]);
                        boolean disponibil = Boolean.parseBoolean(words[4]);
                        double dimensiune = Double.parseDouble(words[5]);
                        Book newBook;
                        if("pb".equalsIgnoreCase(words[1])){
                            newBook = new PaperBook(words[2], pret, disponibil, dimensiune);
                            stock.addBook(newBook);
                        } else if("eb".equalsIgnoreCase(words[1])) {
                            newBook = new EBook(words[2], pret, disponibil, dimensiune);
                            stock.addBook(newBook);
                        } else {
                            System.out.println("Tip necunoscut");
                        }
                    }catch(IndexOutOfBoundsException | NumberFormatException | TooManyBooksException e){
                        System.out.println(e);
                    }
                break;
               
                case "sterge":
                    boolean rez = stock.removeBook(words[1]);
                    if(rez == true){
                        System.out.println("Carte stearsa cu succes");
                    } else {
                        System.out.println("Eroare la stergere");
                    }
                break;
                
                case "exit":
                    System.exit(0);
                break;
                
                default: System.out.println("Comanda inexistenta!");
      
            }
        }

    }
    
}
