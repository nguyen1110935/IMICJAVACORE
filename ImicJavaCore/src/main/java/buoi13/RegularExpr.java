package buoi13;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpr {

    public static void main(String[] args) {
        String reg_str = "(\\Ba)";
        String match_str = "@afafabg\\Awrab gw$";
        System.out.println(reg_str + " "+ match_str);
        Pattern p = Pattern.compile(reg_str);
        Matcher m = p.matcher(match_str);
        int count =0;
        while (m.find()){
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
            System.out.println("Group(): "+m.group(0));
        }
    }
}
