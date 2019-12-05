package MongoDBConnection;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;

public class Login extends MongoConnection{
	
	public Login() {
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean verify(String username, String Password) {
		MongoCollection<Document> userDocuments = db.getCollection("users");
		Bson resultClass = null;
		userDocuments.find(resultClass);
		return false;
	}

}
