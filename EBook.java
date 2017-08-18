public class EBook extends Book
{
    private double size; //size in MB
    
    EBook(String title, double price, boolean available, double size){
        super(title, price, available);
        this.size = size;
    }
    
    public double getSize(){
        return size;
    }
    
    public void setSize(double size){
        this.size = size;
    }
    
    @Override
    public String toString(){
        return "EBook{ " + title + ", " + price 
                + " EUR, " + available + ", " + size + " MB }";
    }
}

