/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EJ Caguiat
 */
import java.util.regex.*;
public class errorcheck {
    public static void main(String[] args)
    {
        String reg[][] = {
        {"R0","0000000000000000"},{"R1","0000000000000000"},{"R2","0000000000000000"},{"R3","0000000000000000"},
        {"R4","0000000000000000"},{"R5","0000000000000000"},{"R6","0000000000000000"},{"R7","0000000000000000"},
        {"R8","0000000000000000"},{"R9","0000000000000000"},{"R10","0000000000000000"},{"R11","0000000000000000"},
        {"R12","0000000000000000"},{"R13","0000000000000000"},{"R14","0000000000000000"},{"R15","0000000000000000"},
        {"R16","0000000000000000"},{"R17","0000000000000000"},{"R18","0000000000000000"},{"R19","0000000000000000"},
        {"R20","0000000000000000"},{"R21","0000000000000000"},{"R22","0000000000000000"},{"R23","0000000000000000"},
        {"R24","0000000000000000"},{"R25","0000000000000000"},{"R26","0000000000000000"},{"R27","0000000000000000"},
        {"R28","0000000000000000"},{"R29","0000000000000000"},{"R30","0000000000000000"},{"R31","0000000000000000"},
        };
        
        String ins[] = {"DADDIU","LD", "SD", "DADDU", "SLT", "NOP" , "BC", "BGEC", "DAUI"};
        
        String inputCode = "DADDIU R1, R0, #0002";
        
        String[] breakCode = inputCode.split("(, )|( )|(,)"); //seperates the inputCode
        int branchError = 0;
        int insError = 0; //use it nalang if 1 sha then error if 0 then no
        int firstRegError = 0; // if register error
        int secRegError = 0;
        int thirdError = 0; // if immError/reg3Error
        
        //to check if instruction is valid
        for(int i = 0; i < ins.length; i++)
        {
            if(breakCode[0].equals(ins[i])){
                insError = 0;
                break;
            }
            else{
                insError = 1;
            }
        }
        //seperate the instructions because these use a format of ins r1, r2, imm/r3
        if(breakCode[0].equals("DADDIU")||breakCode[0].equals("DADDU")||breakCode[0].equals("SLT")||breakCode[0].equals("DAUI")||breakCode[0].equals("BGEC"))
        {
            //if register 1 is valid
            for(int i = 0; i < reg.length; i++)
            {
                System.out.println(breakCode[1] + "         " + reg[i][0]);
                if(breakCode[1].equals(reg[i][0]))
                {
                    firstRegError = 0;
                    break;
                }
                else{
                    firstRegError = 1;
                }
            }

            //if register2 is valid
            for(int i = 0; i < reg.length; i++)
            {
                if(breakCode[2].equals(reg[i][0]))
                {
                    secRegError = 0;
                    break;
                }
                else{
                    secRegError = 1;
                }
            }
            
            //checks what type of parameter the 3rd one is
            if(breakCode[0].equals("DADDIU")||breakCode[0].equals("DAUI")) //commands with IMMEDIATE as their 3rd param
            {
                if(breakCode[3].charAt(0) == '#' && breakCode[3].length() ==  5) //checks if it starts with a # and is 5 chars long (# + hex)
                    thirdError = 0;
                else
                    thirdError = 1;
                   
            }
            
            else if(breakCode[0].equals("DADDU")||breakCode[0].equals("SLT")) //commands with 3RD REGISTER as their 3rd param
            {
                for(int i = 0; i < reg.length; i++)
                {
                    if(breakCode[3].equals(reg[i][0]))
                    {
                        thirdError = 0;
                        break;
                    }
                    else{
                        thirdError = 1;
                    }
                }
            }
            else { //BGEC
                for(int i = 0 ; i < reg.length; i++)
                {
                    if(breakCode[3].equals(reg[i][0]))
                    {
                        thirdError = 1;
                        break;
                    } 
                    else
                    {
                        thirdError = 0;
                    }
                }
                
                if(!breakCode[3].matches("[A-Za-z0-9]+"))
                {
                    thirdError = 1;
                }
            }
        }

        else if(breakCode[0].equals("LD")||breakCode[0].equals("SD")) //2 PARAMETER INSTRUCTIONS
        {
            if(breakCode[0].equals("LD"))
            {    //checks first parameter
                for(int i = 0; i < reg.length; i++)
                {
                    if(breakCode[1].equals(reg[i][0]))
                    {
                        firstRegError = 0;
                        break;
                    }
                    else{
                        firstRegError = 1;
                    }
                }

                if(!breakCode[2].matches("[A-Za-z0-9()]+"))
                {
                        thirdError = 1;
                }
            }
            else{
                for(int i = 0; i < reg.length; i++)
                {
                    if(breakCode[2].equals(reg[i][0]))
                    {
                        firstRegError = 0;
                        break;
                    }
                    else{
                        firstRegError = 1;
                    }
                }

                if(!breakCode[1].matches("[A-Za-z0-9()]+"))
                {
                        thirdError = 1;
                }
            }
        }
        
        else if(breakCode[0].equals("BC"))
        {
            if(breakCode[1].matches("[A-Za-z0-9]+"))
            {
                branchError = 0;
            }
            else{
                branchError = 1;
            }
 
        }
        
        else { //NOP instruction
            //checks 1st parameter
        }
        
        System.out.println(insError);
        System.out.println(firstRegError);
        System.out.println(secRegError);
        System.out.println(thirdError);
        System.out.println(branchError);
        if(insError == 1)
        {
            System.out.println("instruction Error");
        }
        if(firstRegError == 1)
        {
            System.out.println("register Error");
        }
        if(secRegError == 1)
        {
            System.out.println("register Error");
        }
        if(thirdError == 1)
        {
            System.out.println("Third parameter error");
        }
        if(branchError == 1)
        {
            System.out.println("Branch error");
        }
    }
}
