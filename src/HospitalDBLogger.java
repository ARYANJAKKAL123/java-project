import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class HospitalDBLogger {
    private static final String LOG_FILE = "hospital_log.txt";

    public static void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            out.println(LocalDateTime.now() + " - " + message);
        } catch (IOException e) {
            System.out.println("Logging failed: " + e.getMessage());
        }
    }
}

