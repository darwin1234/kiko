package MongoDBConnection;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;




public class Crud extends MongoConnection{
	private String __id;
	public void AddRecord() {
		MongoCollection<Document> userDocuments = db.getCollection("users");
		userDocuments.drop();
		List<Document> testUsers = new ArrayList<>();
		testUsers.add(Document.parse("{\n" +
		            "                    name: \"Chris\",\n" +
		            "                    age: 25,\n" +
		            "                    company: \"UMM\",\n" +
		            "                    email: \"chris@this.that\"\n" +
		            "                    username: \"admin\"\n" +
		            "                    password: \"admin\"\n" +
		            "                }"));
		    testUsers.add(Document.parse("{\n" +
		            "                    name: \"Pat\",\n" +
		            "                    age: 37,\n" +
		            "                    company: \"IBM\",\n" +
		            "                    email: \"pat@something.com\"\n" +
		            "                    username: \"admin1\"\n" +
		            "                    password: \"admin1\"\n" +
		            "                }"));
		    testUsers.add(Document.parse("{\n" +
		            "                    name: \"Jamie\",\n" +
		            "                    age: 37,\n" +
		            "                    company: \"Frogs, Inc.\",\n" +
		            "                    email: \"jamie@frogs.com\"\n" +
		            "                    username: \"admin2\"\n" +
		            "                    password: \"admin2\"\n" +
		            "                }"));
		   userDocuments.insertMany(testUsers);
	}
	
	public static ArrayList<Row> display() {
		
		ArrayList<Row> rows = new ArrayList<>();
        Row row;
		
        MongoCollection<Document> lists = db.getCollection("artist");
        
		//if(__id.equals("ShowAll")) { 
	        try (MongoCursor<Document> cur = lists.find().iterator()) {
	
	            while (cur.hasNext()) {
	
	                var doc = cur.next();
	                var product = new ArrayList<>(doc.values());
	                String title = (String) product.get(1);
	                String description = (String) product.get(2);
	                String price = (String) product.get(3);
	                String location = (String) product.get(1);
	                String id = (String) product.get(1);
	               // System.out.printf("%s: %s%n", product.get(1), product.get(2));
	                row = new Row(title,description,price,location,id);
	  		        rows.add(row);
	            
	            }
	        }
		//}
	       // else {
		//Document test =  lists.find(Filters.eq("__id", this.__id)).first();
		//System.out.print(test.toJson());

		
		//}
		return rows;
	
	}
	
	public void getID(String __id__) {
		
		this.__id =  __id__;
	}
	
}
