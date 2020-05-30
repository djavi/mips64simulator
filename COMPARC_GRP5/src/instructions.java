import java.util.Scanner;
import java.util.regex.Pattern;

public class instructions {
    
    public instructions (){
    
       
        String test = "DADDIU R3,R0,#0002";    
        //String test = "LD R1,ALPHA(R0)";
        String upper = null,
                lower = null,
                output = null;
        
        int offset = 0,
            dec, low_int, up_int;
        Scanner input = new Scanner(System.in);   
        String regop[][] ={
                            {"R0","00000"},{"R1","00001"},{"R2","00010"},{"R3","00011"},
                            {"R4","00100"},{"R5","00101"},{"R6","00110"},{"R7","00111"},
                            {"R8","01000"},{"R9","01001"},{"R10","01010"},{"R11","01011"},
                            {"R12","01100"},{"R13","01101"},{"R14","01110"},{"R15","01111"},
                            {"R16","0000000000000000"},{"R17","0000000000000000"},{"R18","0000000000000000"},{"R19","0000000000000000"},
                            {"R20","0000000000000000"},{"R21","0000000000000000"},{"R22","0000000000000000"},{"R23","0000000000000000"},
                            {"R24","0000000000000000"},{"R25","0000000000000000"},{"R26","0000000000000000"},{"R27","0000000000000000"},
                            {"R28","0000000000000000"},{"R29","0000000000000000"},{"R30","0000000000000000"},{"R31","000000000000000X"},
                        };
        
        String[] split = test.split(" ");
        String[] split_1 = split[1].split(","); 
        String instruction = split[0];   
        int x =0;
        String op_inst = null,RD = null,RS = null,RT = null, imm = null,base = null, off = "0001000000000000";
       
        int size = split_1.length; 
        String[] op_register = new String[size];
        
        for(int ctr=0; ctr < size; ctr++){
            
            for(int ctr_2=0; ctr_2 < 32; ctr_2++){
           
                if (split_1[ctr].equals(regop[ctr_2][0])){
                    op_register[x] = regop[ctr_2][1];
                    x++;
                }
            }
         } 
        String[] split_3 = null;
        switch(instruction){         
            case "LD": op_inst = "110111"; break; //base, rt, offset*
            case "SD": op_inst = "111111"; break; //base, rt, offset*
            case "DADDIU": op_inst = "011001"; break;   //rs, rt, immediate*
            case "SLT": op_inst = "000000"; break;   //rs, rt, ||rd, 00000, 101010*
            case "BC": op_inst = "110010"; break;   //offset
            case "BGEC": op_inst = "010110"; 
                         off = "11110000000000000001"; break; //rs, rt, offset
            case "DAUI": op_inst = "011101"; break; //rs, rt, immediate*  | rt rs
        }
        
        if(instruction.equals("LD") || instruction.equals("SD")){
            String[] split_2 = split_1[1].split("[()]");
            System.out.println(split_2[0]);
            for(int ctr=0; ctr < 32; ctr++){
                if(split_2[1].equals(regop[ctr][0])){
                    base = regop[ctr][1];
                }
            }           
            RT = op_register[0];
            upper = op_inst + base + RT;
            offset = Integer.parseInt(off, 2);
            lower = Integer.toString(offset,16);   
            dec = Integer.parseInt(upper,2);
            output = Integer.toString(dec,16) + lower;
        }
        else if(instruction.equals("DADDIU") || instruction.equals("DAUI")){
            split_3 = split_1[2].split("#");
            RT = op_register[0];
            RS = op_register[1];
            imm = split_3[1];
            upper = op_inst + RS + RT;
            lower = imm;
            //System.out.println(op_inst + " " + RS + " " + RT + " " + imm);
            up_int = Integer.parseInt(upper,2);
            //low_int = Integer.parseInt(lower,2);
            
            output = Integer.toString(up_int,16) + lower;
        }
        else if(instruction.equals("SLT")){
            RD = op_register[0];
            RS = op_register[1];
            RT = op_register[2];
            
            upper = "1111" + op_inst + RS +  RT;
            lower = RD + "00000101010";
            up_int = Integer.parseInt(upper,2);
            low_int = Integer.parseInt(lower,2);
            output = Integer.toString(up_int,16).substring(1) + Integer.toString(low_int,16);
        }
        else if(instruction.equals("BGEC")){
            RS = op_register[0];
            RT = op_register[1];
            upper = op_inst + RS + RT;
            offset = Integer.parseInt(off, 2);
            lower = Integer.toString(offset,16).substring(1); 
            dec = Integer.parseInt(upper,2);
            output = Integer.toString(dec,16) + lower;
            
        }
        
        System.out.println(output);
        
    }
    
    
}
