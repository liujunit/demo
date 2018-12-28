package jackRabbit;

import java.io.File;

import javax.jcr.GuestCredentials;
import javax.jcr.Repository;
import javax.jcr.Session; 
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.jackrabbit.core.TransientRepository;

/** 
* First hop example. Logs in to a content repository and prints a 
* status message. 
*/ 
public class FirstHop { 

    /** 
    * The main entry point of the example application. 
    * 
    * @param args command line arguments (ignored) 
    * @throws Exception if an error occurs 
    */ 
    public static void main(String[] args) throws Exception { 
    	Repository repository = new TransientRepository(new File("E:\\Jackrabbit1.4\\rep_fs"));
        
        Session session = repository.login(new SimpleCredentials("admin",
				"admin".toCharArray()), "default");
        try { 
            String user = session.getUserID(); 
            String name = repository.getDescriptor(Repository.REP_NAME_DESC); 
            System.out.println( 
            "Logged in as " + user + " to a " + name + " repository."); 
        } finally { 
            session.logout(); 
        } 
    } 
} 
