/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EJ Caguiat
 */
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
public class OPCODE {
    public static void main(String[] args) throws UnsupportedEncodingException
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
        String inputCode = "DADDIU R1, R2, #0002";
        
        String breakCode[] = inputCode.split("(, )|( )|(,)");
        
        String opcodeBin;
        int opcodeA;
        int opcodeB;
        int opcodeImm;
        String finalOp;
        String hexOp = "";
        String aBin, bBin, immBin;
        String toConv[] = new String[8];
        int j = 0;
        
        for(int i = 0; i < breakCode.length; i++)
        {
            breakCode[i] = breakCode[i].toUpperCase();
        }
        
        if(breakCode[0].equals("DADDIU"))
        {
            String tempA = breakCode[1].substring(1);
            String tempB = breakCode[2].substring(1);
            String tempC = breakCode[3].substring(1);
            opcodeBin = "011001";
            opcodeA = Integer.parseInt(tempB); //rs
            opcodeB = Integer.parseInt(tempA); //rt
            opcodeImm = Integer.parseInt(tempC,16); //imm
            
            aBin = String.format("%5s", Integer.toBinaryString(opcodeA)).replace(' ', '0');
            bBin = String.format("%5s", Integer.toBinaryString(opcodeB)).replace(' ', '0');
            immBin = String.format("%16s", Integer.toBinaryString(opcodeImm)).replace(' ', '0');
            
            finalOp = opcodeBin + aBin + bBin + immBin;
            
            for(int i = 0; i < 8; i++)
            {
                toConv[i] = finalOp.substring(j, j+4);
                j += 4;
            }
            for(int i = 0; i < toConv.length; i++)
            {
                switch(toConv[i])
                {
                    case "0000" : hexOp += "0";
                        break;
                    case "0001" : hexOp += "1";
                        break;
                    case "0010" : hexOp += "2";
                        break;
                    case "0011" : hexOp += "3";
                        break;
                    case "0100" : hexOp += "4";
                        break;
                    case "0101" : hexOp += "5";
                        break;
                    case "0110" : hexOp += "6";
                        break;
                    case "0111" : hexOp += "7";
                        break;
                    case "1000" : hexOp += "8";
                        break;
                    case "1001" : hexOp += "9";
                        break;
                    case "1010" : hexOp += "A";
                        break;
                    case "1011" : hexOp += "B";
                        break;
                    case "1100" : hexOp += "C";
                        break;
                    case "1101" : hexOp += "D";
                        break;
                    case "1110" : hexOp += "E";
                        break;
                    case "1111" : hexOp += "F";
                        break;
                         
                }
                
            }
            
            System.out.println(hexOp);
        }
        else if(breakCode[0].equals("LD"))
        {
            opcodeBin = "110111";
            String tempA = breakCode[2].substring(6).substring(0,1);
            String tempB = breakCode[1].substring(1);
            String tempC = breakCode[2].substring(0,4);
            
            opcodeA = Integer.parseInt(tempA); //rs
            opcodeB = Integer.parseInt(tempB); //rt
            opcodeImm = Integer.parseInt(tempC , 16); //imm
            
            aBin = String.format("%5s", Integer.toBinaryString(opcodeA)).replace(' ', '0');
            bBin = String.format("%5s", Integer.toBinaryString(opcodeB)).replace(' ', '0');
            immBin = String.format("%16s", Integer.toBinaryString(opcodeImm)).replace(' ', '0');
            
            finalOp = opcodeBin + aBin + bBin + immBin;
            System.out.println(finalOp);
            
        }
        else if(breakCode[0].equals("SD"))
        {
            opcodeBin = "111111";
            String tempA = breakCode[2].substring(6).substring(0,1);
            String tempB = breakCode[1].substring(1);
            String tempC = breakCode[2].substring(0,4);
            
            opcodeA = Integer.parseInt(tempA); //rs
            opcodeB = Integer.parseInt(tempB); //rt
            opcodeImm = Integer.parseInt(tempC , 16); //imm
            
            aBin = String.format("%5s", Integer.toBinaryString(opcodeA)).replace(' ', '0');
            bBin = String.format("%5s", Integer.toBinaryString(opcodeB)).replace(' ', '0');
            immBin = String.format("%16s", Integer.toBinaryString(opcodeImm)).replace(' ', '0');
            
            finalOp = opcodeBin + aBin + bBin + immBin;
             for(int i = 0; i < 8; i++)
            {
                toConv[i] = finalOp.substring(j, j+4);
                j += 4;
            }
            for(int i = 0; i < toConv.length; i++)
            {
                switch(toConv[i])
                {
                    case "0000" : hexOp += "0";
                        break;
                    case "0001" : hexOp += "1";
                        break;
                    case "0010" : hexOp += "2";
                        break;
                    case "0011" : hexOp += "3";
                        break;
                    case "0100" : hexOp += "4";
                        break;
                    case "0101" : hexOp += "5";
                        break;
                    case "0110" : hexOp += "6";
                        break;
                    case "0111" : hexOp += "7";
                        break;
                    case "1000" : hexOp += "8";
                        break;
                    case "1001" : hexOp += "9";
                        break;
                    case "1010" : hexOp += "A";
                        break;
                    case "1011" : hexOp += "B";
                        break;
                    case "1100" : hexOp += "C";
                        break;
                    case "1101" : hexOp += "D";
                        break;
                    case "1110" : hexOp += "E";
                        break;
                    case "1111" : hexOp += "F";
                        break;
                         
                }
                
            }
        }
        else if(breakCode[0].equals("DADDU"))
        {
            opcodeBin = "000000";
            String tempA = breakCode[1].substring(1);
            String tempB = breakCode[2].substring(1);
            String tempC = breakCode[3].substring(1);
            String sa = "00000";
            String func = "101101";
            
            opcodeA = Integer.parseInt(tempA); //rs
            opcodeB = Integer.parseInt(tempB); //rt
            opcodeImm = Integer.parseInt(tempC); //imm
            
            aBin = String.format("%5s", Integer.toBinaryString(opcodeA)).replace(' ', '0');
            bBin = String.format("%5s", Integer.toBinaryString(opcodeB)).replace(' ', '0');
            immBin = String.format("%5s", Integer.toBinaryString(opcodeImm)).replace(' ', '0');
            
            finalOp = opcodeBin + bBin + immBin + aBin + sa + func;
             for(int i = 0; i < 8; i++)
            {
                toConv[i] = finalOp.substring(j, j+4);
                j += 4;
            }
            for(int i = 0; i < toConv.length; i++)
            {
                switch(toConv[i])
                {
                    case "0000" : hexOp += "0";
                        break;
                    case "0001" : hexOp += "1";
                        break;
                    case "0010" : hexOp += "2";
                        break;
                    case "0011" : hexOp += "3";
                        break;
                    case "0100" : hexOp += "4";
                        break;
                    case "0101" : hexOp += "5";
                        break;
                    case "0110" : hexOp += "6";
                        break;
                    case "0111" : hexOp += "7";
                        break;
                    case "1000" : hexOp += "8";
                        break;
                    case "1001" : hexOp += "9";
                        break;
                    case "1010" : hexOp += "A";
                        break;
                    case "1011" : hexOp += "B";
                        break;
                    case "1100" : hexOp += "C";
                        break;
                    case "1101" : hexOp += "D";
                        break;
                    case "1110" : hexOp += "E";
                        break;
                    case "1111" : hexOp += "F";
                        break;
                         
                }
                
            }
            
        }
        else if(breakCode[0].equals("SLT"))
        {
            opcodeBin = "000000";
            String tempA = breakCode[1].substring(1);
            String tempB = breakCode[2].substring(1);
            String tempC = breakCode[3].substring(1);
            String sa = "00000";
            String func = "101010";
            
            opcodeA = Integer.parseInt(tempA); //rs
            opcodeB = Integer.parseInt(tempB); //rt
            opcodeImm = Integer.parseInt(tempC); //imm
            
            aBin = String.format("%5s", Integer.toBinaryString(opcodeA)).replace(' ', '0');
            bBin = String.format("%5s", Integer.toBinaryString(opcodeB)).replace(' ', '0');
            immBin = String.format("%5s", Integer.toBinaryString(opcodeImm)).replace(' ', '0');
            
            finalOp = opcodeBin + bBin + immBin + aBin + sa + func;
             for(int i = 0; i < 8; i++)
            {
                toConv[i] = finalOp.substring(j, j+4);
                j += 4;
            }
            for(int i = 0; i < toConv.length; i++)
            {
                switch(toConv[i])
                {
                    case "0000" : hexOp += "0";
                        break;
                    case "0001" : hexOp += "1";
                        break;
                    case "0010" : hexOp += "2";
                        break;
                    case "0011" : hexOp += "3";
                        break;
                    case "0100" : hexOp += "4";
                        break;
                    case "0101" : hexOp += "5";
                        break;
                    case "0110" : hexOp += "6";
                        break;
                    case "0111" : hexOp += "7";
                        break;
                    case "1000" : hexOp += "8";
                        break;
                    case "1001" : hexOp += "9";
                        break;
                    case "1010" : hexOp += "A";
                        break;
                    case "1011" : hexOp += "B";
                        break;
                    case "1100" : hexOp += "C";
                        break;
                    case "1101" : hexOp += "D";
                        break;
                    case "1110" : hexOp += "E";
                        break;
                    case "1111" : hexOp += "F";
                        break;
                         
                }
                
            }
        }
        else if(breakCode.equals("BC"))
        {
            opcodeBin = "110010";
        }
        else if(breakCode.equals("BGEC"))
        {
            opcodeBin = "010110";
        }
        else if(breakCode.equals("DAUI"))
        {
            opcodeBin = "011101";
            String tempA = breakCode[1].substring(1);
            String tempB = breakCode[2].substring(1);
            String tempC = breakCode[3].substring(1);
            
            opcodeA = Integer.parseInt(tempA); //rs
            opcodeB = Integer.parseInt(tempB); //rt
            opcodeImm = Integer.parseInt(tempC); //imm
            
            aBin = String.format("%5s", Integer.toBinaryString(opcodeA)).replace(' ', '0');
            bBin = String.format("%5s", Integer.toBinaryString(opcodeB)).replace(' ', '0');
            immBin = String.format("%16s", Integer.toBinaryString(opcodeImm)).replace(' ', '0');
            
            finalOp = opcodeBin + bBin + aBin + immBin;
             for(int i = 0; i < 8; i++)
            {
                toConv[i] = finalOp.substring(j, j+4);
                j += 4;
            }
            for(int i = 0; i < toConv.length; i++)
            {
                switch(toConv[i])
                {
                    case "0000" : hexOp += "0";
                        break;
                    case "0001" : hexOp += "1";
                        break;
                    case "0010" : hexOp += "2";
                        break;
                    case "0011" : hexOp += "3";
                        break;
                    case "0100" : hexOp += "4";
                        break;
                    case "0101" : hexOp += "5";
                        break;
                    case "0110" : hexOp += "6";
                        break;
                    case "0111" : hexOp += "7";
                        break;
                    case "1000" : hexOp += "8";
                        break;
                    case "1001" : hexOp += "9";
                        break;
                    case "1010" : hexOp += "A";
                        break;
                    case "1011" : hexOp += "B";
                        break;
                    case "1100" : hexOp += "C";
                        break;
                    case "1101" : hexOp += "D";
                        break;
                    case "1110" : hexOp += "E";
                        break;
                    case "1111" : hexOp += "F";
                        break;
                         
                }
                
            }
        }
        else if(breakCode.equals("NOP"))
        {
            finalOp = "00000000000000000000000000000000";
            hexOp = "00000000";
        }
    }
}
