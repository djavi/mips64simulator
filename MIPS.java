import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Toolkit;
import java.lang.String;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MIPS {
	
	//GUI Variables
	public static JPanel panel;
	public static JLabel lblNewLabel;
	public static JTabbedPane tabbedPane;
	public static JPanel panel_1;
	public static JPanel panel_3;
	public static JLabel lblEnterCodeBelow;
	public static JButton button;
	public static JScrollPane scrollPane_1;
	public static JTextArea textArea;
	public static JPanel panel_4;
	public static JTabbedPane tabbedPane_1;
	public static JPanel panel_6;
	public static JScrollPane scrollPane_2;
	public static JTextArea textArea_1;
	public static JPanel panel_7;
	public static JScrollPane scrollPane_3;
	public static JTextArea textArea_2;
	public static JPanel panel_2;
	public static JTabbedPane tabbedPane_2;
	public static JPanel panel_5;
	public static JScrollPane scrollPane_4;
	public static JTextPane txtpndataIbytebyte;
	public static JPanel panel_8;
	public static JScrollPane scrollPane;
	public static JTextPane txtpnAvailableInstructions;
	private JFrame frmUmips;
	
	
	
	
	//ErrorCheck Variables
	public static String reg[][] = {
	        {"R0","0000000000000000"},{"R1","0000000000000000"},{"R2","0000000000000000"},{"R3","0000000000000000"},
	        {"R4","0000000000000000"},{"R5","0000000000000000"},{"R6","0000000000000000"},{"R7","0000000000000000"},
	        {"R8","0000000000000000"},{"R9","0000000000000000"},{"R10","0000000000000000"},{"R11","0000000000000000"},
	        {"R12","0000000000000000"},{"R13","0000000000000000"},{"R14","0000000000000000"},{"R15","0000000000000000"},
	        {"R16","0000000000000000"},{"R17","0000000000000000"},{"R18","0000000000000000"},{"R19","0000000000000000"},
	        {"R20","0000000000000000"},{"R21","0000000000000000"},{"R22","0000000000000000"},{"R23","0000000000000000"},
	        {"R24","0000000000000000"},{"R25","0000000000000000"},{"R26","0000000000000000"},{"R27","0000000000000000"},
	        {"R28","0000000000000000"},{"R29","0000000000000000"},{"R30","0000000000000000"},{"R31","0000000000000000"},
	        };
	        
	public static String ins[] = {"DADDIU","LD", "SD", "DADDU", "SLT", "NOP" , "BC", "BGEC", "DAUI"};
	        
	public static String inputCode;
	        
	public static String[] breakCode; //seperates the inputCode
	public static int insError = 0; //use it nalang if 1 sha then error if 0 then no
	public static int regError = 0; // if register error
	public static int thirdError = 0; // if immError/reg3Error
	
	
	
	//Opcode Variables
	public static String test = "";    
	public static String upper = null,
            lower = null,
            output = null;
    
    public static int offset = 0, dec, low_int, up_int; 
    public static String regop[][] ={
                        {"R0","00000"},{"R1","00001"},{"R2","00010"},{"R3","00011"},
                        {"R4","00100"},{"R5","00101"},{"R6","00110"},{"R7","00111"},
                        {"R8","01000"},{"R9","01001"},{"R10","01010"},{"R11","01011"},
                        {"R12","01100"},{"R13","01101"},{"R14","01110"},{"R15","01111"},
                        {"R16","0000000000000000"},{"R17","0000000000000000"},{"R18","0000000000000000"},{"R19","0000000000000000"},
                        {"R20","0000000000000000"},{"R21","0000000000000000"},{"R22","0000000000000000"},{"R23","0000000000000000"},
                        {"R24","0000000000000000"},{"R25","0000000000000000"},{"R26","0000000000000000"},{"R27","0000000000000000"},
                        {"R28","0000000000000000"},{"R29","0000000000000000"},{"R30","0000000000000000"},{"R31","000000000000000X"},
                    };
    
    public static String[] split;
    public static String[] split_1;
    public static String instruction;   
    public static int x =0;
    public static String op_inst = null,RD = null,RS = null,RT = null, imm = null,base = null, off = "0001000000000000";
   
    public static int size;
    public static String[] op_register;
    public static String[] split_3 = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MIPS window = new MIPS();
					window.frmUmips.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MIPS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUmips = new JFrame();
		frmUmips.getContentPane().setBackground(Color.PINK);
		frmUmips.setBackground(Color.PINK);
		frmUmips.setForeground(Color.PINK);
		frmUmips.setFont(new Font("Monospaced", Font.PLAIN, 15));
		frmUmips.setResizable(false);
		frmUmips.setType(Type.UTILITY);
		frmUmips.setTitle("MIPS64 simulator v1.0");
		frmUmips.setBounds(100, 100, 675, 570);
		frmUmips.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUmips.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(158, 16, 350, 33);
		frmUmips.getContentPane().add(panel);
		
		lblNewLabel = new JLabel("\u273Fmips64 simulator v1.0\u273F");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Monospaced", Font.ITALIC, 24));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Monospaced", Font.PLAIN, 16));
		tabbedPane.setBounds(15, 57, 639, 457);
		frmUmips.getContentPane().add(tabbedPane);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("code", null, panel_1, null);
		panel_1.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 289, 421);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		lblEnterCodeBelow = new JLabel("enter code below:");
		lblEnterCodeBelow.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterCodeBelow.setBounds(0, 0, 289, 22);
		lblEnterCodeBelow.setFont(new Font("Monospaced", Font.PLAIN, 16));
		panel_3.add(lblEnterCodeBelow);
		
		button = new JButton("run");
		button.setBounds(37, 388, 99, 33);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetVar();
				//badumtsssssss run here
				String[] temp = textArea.getText().split("\n");
				int error = 0;
				int xd = temp.length;
				int cnt = 0;
				int errtype = 0; //1=insterror, 2=regerror, 3=immerror
				
				//check if may error
				while(error == 0 && cnt != xd){
					//set variable
					error = errorCheck(temp[cnt])[0];
					if(error == 1)
						if(errorCheck(temp[cnt])[1] == 1)
							errtype = 1;
						else if(errorCheck(temp[cnt])[2] == 1)
							errtype = 2;
						else
							errtype = 3;
					else
						cnt++;
				}
				
				//if no error continue to opcode, if error, alert "ERROR!"
				switch(error){
					case 0: 
						String henlo;
						//loop for opcode of each inst and print
						for(int q = 0; q < xd; q++){
							henlo = wopCode(temp[q]);
							textArea_2.setText(temp[q]+ ": " + textArea_2.getText() + henlo);
						}	
						break;
						
					case 1:
						//alert error
						JOptionPane.showMessageDialog(null, "Error! Please reset and try again.", "Error!", 1);
						textArea_2.setText("Error!");
						
						//add errors to txt area 1.
						switch(errtype){
							case 1:
								textArea_1.setText("_Syntax Error_ on line" + (cnt+1));
								break;
							case 2:
								textArea_1.setText("_Register Error_ on line" + (cnt+1));
								break;
							case 3:
								textArea_1.setText("_Third Parameter/Immediate Error_ on line" + (cnt+1));
								break;
							default:
								break;
						}
						break;
				}
			}
		});
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 27, 289, 355);
		panel_3.add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setWrapStyleWord(true);
		scrollPane_1.setViewportView(textArea);
		button.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panel_3.add(button);
		
		JButton btnReset = new JButton("reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//reset method reset all important variables
				reset();
			}
		});
		btnReset.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btnReset.setBounds(151, 388, 99, 33);
		panel_3.add(btnReset);
		
		panel_4 = new JPanel();
		panel_4.setBounds(290, 0, 344, 421);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setFont(new Font("Monospaced", Font.PLAIN, 16));
		tabbedPane_1.setBounds(0, 0, 344, 421);
		panel_4.add(tabbedPane_1);
		
		panel_6 = new JPanel();
		tabbedPane_1.addTab("errors", null, panel_6, null);
		panel_6.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(15, 16, 309, 353);
		panel_6.add(scrollPane_2);
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_1.setEditable(false);
		textArea_1.setWrapStyleWord(true);
		scrollPane_2.setViewportView(textArea_1);
		
		panel_7 = new JPanel();
		tabbedPane_1.addTab("opcodes", null, panel_7, null);
		panel_7.setLayout(null);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(15, 16, 309, 353);
		panel_7.add(scrollPane_3);
		
		textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_2.setEditable(false);
		textArea_2.setWrapStyleWord(true);
		scrollPane_3.setViewportView(textArea_2);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("help", null, panel_2, null);
		panel_2.setLayout(null);
		
		tabbedPane_2 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_2.setFont(new Font("Monospaced", Font.PLAIN, 16));
		tabbedPane_2.setBounds(15, 16, 604, 389);
		panel_2.add(tabbedPane_2);
		
		panel_5 = new JPanel();
		tabbedPane_2.addTab("sample code", null, panel_5, null);
		panel_5.setLayout(null);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 0, 463, 384);
		panel_5.add(scrollPane_4);
		
		txtpndataIbytebyte = new JTextPane();
		txtpndataIbytebyte.setText(".data\r\nibyte: .byte 0xF0\r\nibyte1: .byte 0x20, 0x30\r\n\r\ndouble: .double 4.0\r\ndouble1: .double 1.0, 2.0\r\n\r\nmessage: .asciiz \"hello, world\"\r\nmessage2: .asciiz \"hello COMPARC\"\r\n\r\n.code\r\nLD R2, double(R0)\r\nDADDIU R1, R0, #0000\r\nSD R3, double1(R0)");
		txtpndataIbytebyte.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtpndataIbytebyte.setEditable(false);
		scrollPane_4.setViewportView(txtpndataIbytebyte);
		
		panel_8 = new JPanel();
		tabbedPane_2.addTab("instructions", null, panel_8, null);
		panel_8.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 463, 384);
		panel_8.add(scrollPane);
		
		txtpnAvailableInstructions = new JTextPane();
		txtpnAvailableInstructions.setText("available instructions:\r\n\r\nLD\r\nSD\r\nDADDIU\r\nDADDU\r\nSLT\r\nNOP\r\nBC\r\nBGEC\r\nDAUI\r\n\r\navailable registers:\r\nR0-R31");
		txtpnAvailableInstructions.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtpnAvailableInstructions.setEditable(false);
		scrollPane.setViewportView(txtpnAvailableInstructions);
	}
	
	public int[] errorCheck(String yes){
		inputCode = yes;
		breakCode = inputCode.split("(, )|( )|(,)");
		int[] myArray = new int[4];
		
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
	            for(int i = 0; i < ins.length; i++)
	            {
	                if(breakCode[1].equals(reg[i][0]))
	                {
	                    regError = 0;
	                    break;
	                }
	                else{
	                    regError = 1;
	                }
	            }

	            //if register2 is valid
	            for(int i = 0; i < ins.length; i++)
	            {
	                if(breakCode[2].equals(reg[i][0]))
	                {
	                    regError = 0;
	                    break;
	                }
	                else{
	                    regError = 1;
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
	                for(int i = 0; i < ins.length; i++)
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
	                
	                if(!breakCode[3].equals("[^A-Za-z0-9]"))
	                {
	                    thirdError = 1;
	                }
	            }
	        }

	        else if(breakCode[0].equals("LD")||breakCode[0].equals("SD")) //2 PARAMETER INSTRUCTIONS
	        {
	            //checks first parameter
	            for(int i = 0; i < ins.length; i++)
	            {
	                if(breakCode[1].equals(reg[i][0]))
	                {
	                    regError = 0;
	                    break;
	                }
	                else{
	                    regError = 1;
	                }
	            }
	            
	            if(!breakCode[3].equals("[^A-Za-z0-9]"))
	            {
	                    thirdError = 1;
	            }
	        }
	        
	        else if(breakCode[0].equals("BC"))
	        {
	            if(breakCode[1].equals("[^A-Za-z0-9]"))
	            {
	                regError = 0;
	            }
	            else{
	                regError = 1;
	            }
	 
	        }
	        
	        else { //NOP instruction
	            //checks 1st parameter
	        }
	        
	        
	        //returns if error and error typez
	        if(insError == 0 && regError == 0 && thirdError == 0)
	        	myArray[0] = 0;
	        else
	        	myArray[0] = 1;
	        
	        myArray[1] = insError;
	        myArray[2] = regError;
	        myArray[3] = thirdError;
	        
	        return myArray;
	    }
	
	public String wopCode(String yes){
		test = yes;
		split = test.split(" ");
        split_1 = split[1].split(","); 
        instruction = split[0];   
        x =0;
        op_inst = null;
        RD = null;
        RS = null;
        RT = null;
        imm = null;
        base = null;
        off = "0001000000000000";
       
        size = split_1.length; 
        op_register = new String[size];
        
        for(int ctr=0; ctr < size; ctr++){
            
            for(int ctr_2=0; ctr_2 < 32; ctr_2++){
           
                if (split_1[ctr].equals(regop[ctr_2][0])){
                    op_register[x] = regop[ctr_2][1];
                    x++;
                }
            }
         } 
        
        split_3 = null;
		
		
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
    
    return output;
	}
	
	public void resetVar(){
			textArea_1.setText("");
			textArea_2.setText("");

			inputCode = "";
			breakCode = null;
			insError = 0;
			regError = 0;
			thirdError = 0;

			test = "";
			upper = null;
			lower = null;
			output = null;
			offset = 0;
			dec = 0;
			low_int = 0;
			up_int = 0;
			split = null;
			split_1 = null;
			instruction = null;
			x=0;
			op_inst = null;
			RD = null;
			RS = null;
			RT = null;
			imm = null;
			base = null;
			off = "0001000000000000";
			size = 0;
			op_register = null;
			split_3 = null;
	}
	
	public void reset(){
		textArea.setText("");
		resetVar();
	}
	
}
