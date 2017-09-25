import com.util.DateUtil;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by chen on 2017/9/20.
 */
public class TestDemo {
    public static void main(String[] args) throws ParseException {
        System.out.println(DateUtil.getDayOfWeek(
                DateUtil.getDate("2017-9-18", "yyyy-MM-dd")
        ));
    }
}
