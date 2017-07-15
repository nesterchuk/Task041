import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader  {

    public int readInteger() {
        Integer integer = null;
        boolean doesRead = false;
        do {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                integer = Integer.parseInt(reader.readLine().trim());
                doesRead = true;
            } catch (NumberFormatException|IOException e){}
        } while (!doesRead);

        return integer;
    }

    public String readString()  {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine().trim();
        } catch (Exception e){ return "";}
    }

}