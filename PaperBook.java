public class PaperBook extends Book
{
    private double weight; 
    
    PaperBook(String title, double price, boolean available, double weight){
        super(title, price, available);
        this.weight = weight;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public void setWeigth(double weight){
        this.weight = weight;
    }
    
    @Override
    public String toString(){
        return "PaperBook{ " + title + ", " + price 
                + " EUR, " + available + ", " + weight + " }";
    }
}
