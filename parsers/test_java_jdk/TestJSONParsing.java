import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.File;
import java.util.Map;
import java.util.json.Json;
import java.util.json.JsonValue;

public class TestJSONParsing {
    
    public static boolean isValidJSON(byte[] bytes) {
        try {        
            JsonValue rootValue = Json.parse(new String(bytes));
            return rootValue != null;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static void main(String[] args) {
        
        if(args.length == 0) {
            System.out.println("Usage: java TestJSONParsing file.json");            
            System.exit(2);
        }
        
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(args[0]));
            if(isValidJSON(bytes)) {
                System.out.println("valid");
                System.exit(0);            
            }
            System.out.println("invalid");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("not found");
            System.exit(2);
        }   
    }
}
