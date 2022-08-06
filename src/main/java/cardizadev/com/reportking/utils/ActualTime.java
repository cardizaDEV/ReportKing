package cardizadev.com.reportking.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActualTime {

    public static String realTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

}
