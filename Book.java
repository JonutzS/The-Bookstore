public  class Book implements Readable
{
    protected String title;
    protected double price;
    protected boolean available;
    
    Book(){}
    
    Book(String title, double price, boolean available) {
        this.title = title;
        this.price = price;
        this.available = available;
    }
    
    @Override
    public int hashCode(){
        return 13 * this.title.length();
    }
    
    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        
        if(object instanceof Book){
            Book book = (Book) object;
            if(this.title.equals(book.title)){
                return true;
            }else{
                return false;
            }
        }         
        return false;
    }
    
    public String getTitle(){
        return title;
    }
    
    public double getPrice(){
        return price;
    }
    
    public boolean isAvailable(){
        return available;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setAvailable(boolean available){
        this.available = available;
    }
}
