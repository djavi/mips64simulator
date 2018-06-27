import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
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
	JPanel panel;
	JLabel lblNewLabel;
	JTabbedPane tabbedPane;
	JPanel panel_1;
	JPanel panel_3;
	JLabel lblEnterCodeBelow;
	JButton button;
	JScrollPane scrollPane_1;
	JTextArea textArea;
	JPanel panel_4;
	JTabbedPane tabbedPane_1;
	JPanel panel_6;
	JScrollPane scrollPane_2;
	JTextArea textArea_1;
	JPanel panel_7;
	JScrollPane scrollPane_3;
	JTextArea textArea_2;
	JPanel panel_2;
	JTabbedPane tabbedPane_2;
	JPanel panel_5;
	JScrollPane scrollPane_4;
	JTextPane txtpndataIbytebyte;
	JPanel panel_8;
	JScrollPane scrollPane;
	JTextPane txtpnAvailableInstructions;
	private JFrame frmUmips;
	
	
	
	
	//ErrorCheck Variables
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
	        
	String inputCode = "DADDIU R1, R2, #0000";
	        
	String[] breakCode = inputCode.split("(, )|( )|(,)"); //seperates the inputCode
	int insError = 0; //use it nalang if 1 sha then error if 0 then no
	int regError = 0; // if register error
	int thirdError = 0; // if immError/reg3Error
	
	
	
	//Opcode Variables
	String test = "DADDIU R3,R0,#0002";    
    //String test = "LD R1,ALPHA(R0)";
    String upper = null,
            lower = null,
            output = null;
    
    int offset = 0, dec, low_int, up_int; 
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
		
		button = new JButton("submit");
		button.setBounds(95, 387, 99, 33);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
	
	
	
	
}
