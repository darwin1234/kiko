package MongoDBConnection;

public class Row {

	  // REMEMBER: each attribute is a column
    //
    private final String title;
    private final String description;
    private final String price;
    private final String location;
    private final String id;
    //private final String date;
    
    public Row(String title, String description, String price, String location,String id)
    {
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    public String getPrice()
    {
        return price;
    }
    
    public String getLocation() {
    	return location;
    }
    public String getID() {
    	return id;
    }


}
