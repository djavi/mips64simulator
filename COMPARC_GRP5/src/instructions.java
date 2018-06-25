import java.util.Scanner;
import java.util.regex.Pattern;

public class instructions {
    
    public instructions (){
    
        Scanner input = new Scanner(System.in);
        
        Pattern LD =  Pattern.compile("^LD");
        Pattern SD =  Pattern.compile("^SD");
        Pattern DADDIU = Pattern.compile("^DADDIU");
        Pattern SLT = Pattern.compile("^NOP");
        Pattern BC = Pattern.compile("^BC");
        Pattern BGEC = Pattern.compile("^BGEC");
        Pattern DAUI = Pattern.compile("^DAUI");
        String test = "DADDIU R1,R0,R0";
        String[] split = test.split(" ");
    }
    
    
}
