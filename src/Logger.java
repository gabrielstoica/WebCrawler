import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Logger {
    public Logger() {
        File file;
        file = new File("Logger.txt");
        if(!file.exists())
        {
            try {
                file.createNewFile();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void sendDataToLogger(int log_id, String messageToLog)
    {
        try {
            FileWriter myWriter = new FileWriter("Logger.txt");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("[HH:mm:ss - dd/MM/yyyy]");
            LocalDateTime now = LocalDateTime.now();
            myWriter.write(dtf.format(now));
            if (log_id == 1) {
                myWriter.write(" INFO: ");
            } else if (log_id == 2) {
                myWriter.write(" WARNING: ");
            } else if (log_id == 3) {
                myWriter.write(" ERROR: ");
            }
            myWriter.write(messageToLog);
            myWriter.close();
        }
        catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

//test