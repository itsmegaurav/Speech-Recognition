package tester;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;


class ncalc extends JFrame implements ActionListener {
    JFrame f;
    JButton b[], c[],sound, eq, cl,pi, del, close,sqrt,trig[],ln,log,input, point, change;
    TextArea ta;
    int pos1=0,pos2=0,pos=0,q=0;
    String op1 = "", op2 = "", op = "", str,reflect;
    double mem;
    Font font = new Font("Serif",Font.BOLD,30);
    
    static int fl, ct, vc, temp;

        ncalc() {
        	f=new JFrame("CALCULATOR");
        //	ta.setForeground(Color.BLUE);
            sound = new JButton("");
            del = new JButton("");
            b = new JButton[10];
            c = new JButton[4];
            trig=new JButton[6];
            ln=new JButton("");
            log=new JButton("");
            pi=new JButton("");
            input = new JButton("");
            ta = new TextArea("",1,1);
            eq = new JButton("");
            eq.setIcon(new ImageIcon("E:\\project\\buttons\\button (14).png"));
            eq.setFocusable(false);
            eq.setBorder(BorderFactory.createEmptyBorder());
            eq.setContentAreaFilled(false);
            ta.setFont(font);
            point = new JButton("");
            cl = new JButton("");
            sqrt=new JButton("");
            change = new JButton("");
            close = new JButton("");
            
            f.setLayout(null);

            for (int i = 0; i < 10; i++) {
                b[i] = new JButton("");
                String a=  "E:\\project\\buttons\\button ("+i+").png";
                b[i].setIcon(new ImageIcon(a));
                b[i].setAlignmentX(CENTER_ALIGNMENT);
            	b[i].setAlignmentY(CENTER_ALIGNMENT);
            	b[i].setFocusable(false);
                b[i].setBorder(BorderFactory.createEmptyBorder());
                b[i].setContentAreaFilled(false);
                b[i].addActionListener(this);

                if (i < 4) {
                    c[i] = new JButton();
                    c[i].addActionListener(this);
                }
                
                if (i < 6) {
                    trig[i] = new JButton();
                    trig[i].addActionListener(this);
                }
            }

            c[0].setText("");
            c[1].setText("");
            c[2].setText("");
            c[3].setText("");
            b[0].setText("");
            trig[0].setText("");
            
            trig[1].setText("");
            trig[2].setText("");
            trig[3].setText("");
            trig[4].setText("");
            trig[5].setText("");

            for(int i=0;i<6;i++)
            {
            	int j = i+15;
                String a=  "E:\\project\\buttons\\button ("+j+").png";
                trig[i].setIcon(new ImageIcon(a));
                trig[i].setBorder(BorderFactory.createEmptyBorder());
                trig[i].setContentAreaFilled(false);
                trig[i].setAlignmentX(CENTER_ALIGNMENT);
            	trig[i].setAlignmentY(CENTER_ALIGNMENT);
            	trig[i].setFocusable(false);	
            }
            int k = 80;

            for (int i = 0; i < 4; i++) {
                int j = i+10;
                String a=  "E:\\project\\buttons\\button ("+j+").png";
                c[i].setFocusable(false);  
                c[i].setIcon(new ImageIcon(a));
                c[i].setBorder(BorderFactory.createEmptyBorder());
                c[i].setContentAreaFilled(false);
                c[i].setAlignmentX(CENTER_ALIGNMENT);
            	c[i].setAlignmentY(CENTER_ALIGNMENT);
            	
               
            }
            
            int z=20;
            ta.setBounds(15, 55, 344+z+5, 100);
            
            int l = 3;
            c[0].setBounds(227+z-l, 110+k, 64, 44);
            c[1].setBounds(227+z-l, 159+k, 64, 44);
            c[2].setBounds(227+z-l, 207+k, 64, 44);
            c[3].setBounds(227+z-l, 256+k, 64, 44);
            //
            b[0].setBounds(89-l, 256+k, 64, 44);
            b[1].setBounds(20-l, 110+k, 64, 44);
            b[2].setBounds(89-l, 110+k, 64, 44);
            b[3].setBounds(158-l, 110+k, 64, 44);
            b[4].setBounds(20-l, 159+k, 64, 44);
            b[5].setBounds(89-l, 159+k, 64, 44);
            b[6].setBounds(158-l, 159+k, 64, 44);
            b[7].setBounds(20 -l, 207+k, 64, 44);
            b[8].setBounds(89-l, 207+k, 64, 44);
            b[9].setBounds(158-l, 207+k, 64, 44);
            
            trig[0].setBounds(20-l, 305+k+z, 64, 44);
            trig[1].setBounds(89-l, 305+k+z, 64, 44);
            trig[2].setBounds(158-l, 305+k+z, 64, 44);
            trig[3].setBounds(20-l, 354+k+z, 64, 44);
            trig[4].setBounds(89-l, 354+k+z, 64, 44);
            trig[5].setBounds(158-l, 354+k+z, 64, 44);
            
            sound.setBounds(54,525,124,44);
            cl.setBounds(296+z+5-l, 159+k, 64, 44);
            del.setBounds(296+z+5-l, 110+k, 64, 44);
            close.setBounds(296+z+5-l, 256+k, 64, 44);
            input.setBounds(220,525,124,44);
            eq.setBounds(158-l, 256+k, 64, 44);
            point.setBounds(20-l, 256+k, 64, 44);
            change.setBounds(296+z+5-l, 207+k, 64, 44);      
            sqrt.setBounds(227+z-l,305+k+z,64,44);
            ln.setBounds(296+z+5-l,305+k+z, 64, 44);
            pi.setBounds(227+z-l,354+k+z,64,44);
            log.setBounds(296+z+5-l,354+k+z,64,44);
            
            sound.setIcon(new ImageIcon("E:\\project\\buttons\\button (29).png"));
            sound.setBorder(BorderFactory.createEmptyBorder());
            sound.setContentAreaFilled(false);
            sound.setAlignmentX(CENTER_ALIGNMENT);
        	sound.setAlignmentY(CENTER_ALIGNMENT);
        	sound.setFocusable(false);
        	
            cl.setIcon(new ImageIcon("E:\\project\\buttons\\button (27).png"));
            cl.setBorder(BorderFactory.createEmptyBorder());
            cl.setContentAreaFilled(false);
            cl.setAlignmentX(CENTER_ALIGNMENT);
        	cl.setAlignmentY(CENTER_ALIGNMENT);
        	cl.setFocusable(false);
        	
            del.setIcon(new ImageIcon("E:\\project\\buttons\\button (26).png"));
            del.setBorder(BorderFactory.createEmptyBorder());
            del.setContentAreaFilled(false);
            del.setAlignmentX(CENTER_ALIGNMENT);
        	del.setAlignmentY(CENTER_ALIGNMENT);
        	del.setFocusable(false);
        	
            close.setIcon(new ImageIcon("E:\\project\\buttons\\button (31).png"));
            close.setBorder(BorderFactory.createEmptyBorder());
            close.setContentAreaFilled(false);
            close.setAlignmentX(CENTER_ALIGNMENT);
        	close.setAlignmentY(CENTER_ALIGNMENT);
        	close.setFocusable(false);
            
            input.setIcon(new ImageIcon("E:\\project\\buttons\\button (30).png"));
            input.setBorder(BorderFactory.createEmptyBorder());
            input.setContentAreaFilled(false);
            input.setAlignmentX(CENTER_ALIGNMENT);
        	input.setAlignmentY(CENTER_ALIGNMENT);
        	input.setFocusable(false);
        	
            point.setIcon(new ImageIcon("E:\\project\\buttons\\button (24).png"));
            point.setBorder(BorderFactory.createEmptyBorder());
            point.setContentAreaFilled(false);
            point.setAlignmentX(CENTER_ALIGNMENT);
        	point.setAlignmentY(CENTER_ALIGNMENT);
        	point.setFocusable(false);
        	
            change.setIcon(new ImageIcon("E:\\project\\buttons\\button (28).png"));      
            change.setBorder(BorderFactory.createEmptyBorder());
            change.setContentAreaFilled(false);
            change.setAlignmentX(CENTER_ALIGNMENT);
        	change.setAlignmentY(CENTER_ALIGNMENT);
        	change.setFocusable(false);
        	
            sqrt.setIcon(new ImageIcon("E:\\project\\buttons\\button (23).png"));
            sqrt.setBorder(BorderFactory.createEmptyBorder());
            sqrt.setContentAreaFilled(false);
            sqrt.setAlignmentX(CENTER_ALIGNMENT);
        	sqrt.setAlignmentY(CENTER_ALIGNMENT);
        	sqrt.setFocusable(false);
        	
            ln.setIcon(new ImageIcon("E:\\project\\buttons\\button (21).png"));
            ln.setBorder(BorderFactory.createEmptyBorder());
            ln.setContentAreaFilled(false);
            ln.setAlignmentX(CENTER_ALIGNMENT);
        	ln.setAlignmentY(CENTER_ALIGNMENT);
        	ln.setFocusable(false);
        	
            pi.setIcon(new ImageIcon("E:\\project\\buttons\\button (22).png"));
            pi.setBorder(BorderFactory.createEmptyBorder());
            pi.setContentAreaFilled(false);
            pi.setAlignmentX(CENTER_ALIGNMENT);
        	pi.setAlignmentY(CENTER_ALIGNMENT);
        	pi.setFocusable(false);
        	
            log.setIcon(new ImageIcon("E:\\project\\buttons\\button (25).png"));
            log.setBorder(BorderFactory.createEmptyBorder());
            log.setContentAreaFilled(false);
            log.setAlignmentX(CENTER_ALIGNMENT);
        	log.setAlignmentY(CENTER_ALIGNMENT);
        	log.setFocusable(false);
            
            del.addActionListener(this);
            cl.addActionListener(this);
            eq.addActionListener(this);
            close.addActionListener(this);
            input.addActionListener(this);
            change.addActionListener(this);
            point.addActionListener(this);
            sqrt.addActionListener(this);
            ln.addActionListener(this);
            log.addActionListener(this);
            pi.addActionListener(this);
            sound.addActionListener(this);
            
            try {
        		f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\project\\buttons\\back.png")))));
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
            
            f.add(sound);
            f.add(ta);
            f.add(cl);
            f.add(del);
            f.add(eq);
            f.add(input);
            f.add(close);
            f.add(change);
            f.add(ln);
            f.add(log);
            f.add(point);
            f.add(pi);
            f.add(sqrt);
            
            for (int i = 0; i < 10; i++)
            {
            	f.add(b[i]);
            	
            	if(i<4)
            		  f.add(c[i]);
            	if(i<6)
            		  f.add(trig[i]);
            }
            f.setSize(406, 610);
            f.setVisible(true);
            f.setDefaultCloseOperation(EXIT_ON_CLOSE);
            f.setResizable(false);
        }

    public static void main(String args[]) {
        new ncalc();
    }

    public void voice() {
   //     input.setText("JButtons");
    	input.setIcon(new ImageIcon("E:\\project\\buttons\\button (32).png"));
        ConfigurationManager cm;


        cm = new ConfigurationManager(ncalc.class.getResource("calc.config.xml"));

        int s=0;
        Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
        recognizer.allocate();
        
        
        Microphone microphone = (Microphone) cm.lookup("microphone");
        if (!microphone.startRecording()) {
            System.out.println("Cannot start microphone.");
            recognizer.deallocate();
            System.exit(1);
        }
 //       ta.setText("Start speaking. Press Ctrl-C to quit.\n");
 //       audio file start speaking       
        vc = 0;
        temp = 0;
        while (true) {

            System.out.println("Start speaking. Press Ctrl-C to quit.\n");

            Result result = recognizer.recognize();
            

            if (result != null) {
                String resultText = result.getBestFinalResultNoFiller();
                if(resultText=="")
                	continue;
                System.out.println("You said: " + resultText + '\n');
                int pos = resultText.indexOf(" "); 
				String str = resultText.substring(pos+1,resultText.length());
                System.out.println(str);
                	switch(str)
                	{
                	case("one"):
                		b[1].doClick();
                		break;
                	case("two"):
                		b[2].doClick();
                		break;
                	case("three"):
                		b[3].doClick();
                  		break;
                	case("four"):
                		b[4].doClick();
                  		break;
                	case("five"):
                		b[5].doClick();
                  		break;
                	case("six"):
                		b[6].doClick();
                  		break;
                	case("seven"):
                		b[7].doClick();
                  		break;
                	case("eight"):
                		b[8].doClick();
                  		break;
                	case("nine"):
                		b[9].doClick();
                		break;
                	case("zero"):
                		b[0].doClick();
                		break;
                	case("add"):
                		c[0].doClick();
                		break;
                	case("multiply"):
                		c[3].doClick();
                		break;
                	case("divide"):
                		c[2].doClick();
                		break;
                	case("minus"):
                		c[1].doClick();
                		break;
                	case("clear"):
                		cl.doClick();
                		break;
                	case("delete"):
                		del.doClick();
                		break;
                	case("exit"):
                		System.exit(1);
                	case("stop"):
                		{
                		echo("stop");
                    		s=1;
                		break;
                		}
                	case("equals"):
                		eq.doClick();
                		break;
                	case("narrator"):
                		sound.doClick();
                		break;
                	case("change sign"):
                		change.doClick();
                		break;
                	case("sound"):
                		sound.doClick();
                   		break;
                	case("log"):
                		ln.doClick();
	               		break;
                	case("log ten"):
                		log.doClick();
	               		break;
                	case("ten"):
                		log.doClick();
	               		break;
                	case("pie"):
                		pi.doClick();
	               		break;
                	case("point"):
                		point.doClick();
	               		break;
                	case("sine"):
                		trig[0].doClick();
	               		break;
                	case("cos"):
                		trig[1].doClick();
	               		break;
                	case("tan"):
                		trig[2].doClick();
	               		break;
                	case("cosic"):
                		trig[3].doClick();
	               		break;
                	case("sec"):
                		trig[4].doClick();
	               		break;
                	case("cot"):
                		trig[5].doClick();
	               		break;
                	}
                	if(s==1)
                		break;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
   //   JButton g = new JButton((String) e.getSource());
    	reflect = ta .getText();
    	JButton g = (JButton) e.getSource();

    	Boolean bool = false;
    	if(reflect.matches("[0-9[.]]+") == true)
    		bool = true;
    	
        if (g == input) {
        	//input.setIcon(new ImageIcon("E:\\project\\buttons\\button (33).png"));
        	echo("start speaking");
            voice();
           // input.setIcon(new ImageIcon("E:\\project\\buttons\\button (33).png"));
        }
        for (int i = 0; i < 10; ++i) {
            if ((b[i] == g && !reflect.contains(")"))) {
                if (fl == 0) {
                    ta.setText(""+i);
                    fl = 1;
                } else {
                    ta.setText(ta.getText() + i);
                }
                if(q==1)
                	echo(""+i);
            }
        }

        for (int i = 0; i < 4; i++) {
            if (c[i] == g && !reflect.contains(")")) {
                if (ct != 0 && !op2.equals("")) {		//for continuous calculations without pressing equals
                  docal(op1, ta.getText(), op);		
                }

                op1 = ta.getText();
                switch(i){
                case 0: op = "+";
                		if(q==1)
                			echo("+");
                		break;
                case 1: op = "-";
                		if(q==1)
                			echo("-");
                		break;
                case 2: op = "/";
                		if(q==1)
                			echo("/");
                		break;
                case 3: op = "*";
                		if(q==1)
                			echo("*");
                		break;      	
                }
                fl = 0;
                ct++;
            }
        }
        
        for(int i=0;i<6;i++)
        {
        	if(g==trig[i] && bool)
        	{
        		op1=ta.getText();
        		switch(i){
                case 0: op = "sin";
                		if(q==1)
                			echo("sin");
                		break;
                case 1: op = "cos";
                		if(q==1)
                			echo("cos");
                		break;
                case 2: op = "tan";
                		if(q==1)
                			echo("tan");
                		break;
                case 3: op = "cosec";
                		if(q==1)
                			echo("cosec");
                		break; 
                case 4: op = "sec";
                		if(q==1)
                			echo("sec");
        				break; 
                case 5: op = "cot";
                		if(q==1)
                			echo("cot");
        				break; 
                }
        		ta.append(")");
        		ta.insert(op+"(",0);
        		op2="#";
        		break;

        	}
        }
        	
        	 if(g==ln && bool)
        	{	if(q==1)
        		 	echo("ln");
        		op1=ta.getText();
        		op="ln";
	    		ta.append(")");
	    		ta.insert(ln.getText()+"(",0);
	       		op2="#";
        	}
        	 
        	 else if(g==log && bool)
        	{	op1=ta.getText();
        		if(q==1)
        			echo("log 10");
        		op="log10";
	    		ta.append(")");
	    		ta.insert(log.getText()+"(",0);
	       		op2="#";
        	}
        	 
        	 else if(g==sqrt && bool)
        	 {
        		 {	op1=ta.getText();
	        		op="√"; 
	 	    		ta.append(")");
	 	    		ta.insert(sqrt.getText()+"(",0);	
	 	    		if(q==1)
	 	    			echo("sqrt");
	 	    		
	 	    		op2="#"; 	        	
        		 }		 
        	 }
        
        	 else if (g == eq) {	
        		if(ta.getText().contains("0") || ta.getText().contains("1") || ta.getText().contains("2") || ta.getText().contains("3") || ta.getText().contains("4") || ta.getText().contains("5") || ta.getText().contains("6") || ta.getText().contains("7") || ta.getText().contains("8") || ta.getText().contains("9")){
        			if(!op2.equals("#"))
		        		 {	System.out.println("dfdf");
		        			op2=ta.getText();
		        		 }
        			if(op1.indexOf(".") == op1.length()-1)
        				op1 = op1 + "0";
        			if(op2.indexOf(".") == op2.length()-1)
        				op2 = op2 + "0";
        			
		            docal(op1,op2, op);
		            if(op2.equals("#") && Character.toString(reflect.charAt(0)).equals("-") ){
		            	ta.insert("-", 0);
		            }
		            ct = 0;
		            reflect=ta.getText();
		            if(q==1)
		            	echo("equals");
		            if(reflect.equals("Infinity") || reflect.equals("NaN")){
			            ta.append(" (Not Defined)");
			            if(q==1)
			            	echo("not defined");
			            try{
			            	Thread.sleep(600);
			            }
			            catch(Exception x){}
			            ta.setText("");
		            }
		            if(q==1){
			            for(int i=0;i<reflect.length();i++)
			            	echo(""+reflect.charAt(i));
		            }
		            op2=op="";
        		}
        	 }

        	 else if (g == cl) {
        		 if(q==1)
        			 echo("clear");
        		 ta.setText("");
        		 fl = 0;
        		 ct = 0;
        }

        	 else if (g == change && reflect.length()>0) {
        		 if(reflect.charAt(0)=='-')
        			 ta.replaceRange("",0,1);
        			 
	        	 else if(reflect.length()>0)
	        		 ta.insert("-",0);
          
        		 if(q==1)
        			 echo("change sign");
    		 
           }

        	 else if (g == point)
	        {
    			 char c = reflect.charAt(reflect.length()-1);
    			 if(Character.isDigit(c) &&(reflect.indexOf("."))==-1){
		        	ta.append(".");
		        	if(q==1)
		        		echo(".");
	        	}
	        }
        
        	 else if(g==pi)
        {
        		 if(q==1)
        	echo("pi");
        	ta.setText(String.format("%.3f", Math.PI));
        	if(op1.equals(""))
        		op1=""+String.format("%.4f", Math.PI);
        	else
        		op2=""+String.format("%.4f", Math.PI);
        }
        
        else  if (g == del) {
        	if(!ta.getText().equals("")){
        		if(q==1)
        			echo("del");
	            String rep = ta.getText();  
	            ta.setText(rep.substring(0, rep.length() - 1));
        	}
        }

        else if (g == close) {
        	if(q==1)
        		echo("exit");
            f.dispose();
            System.exit(0);
        }
        else if(g == sound){
     			if(q==0){
     				echo("sound enabled");
   //  				sound.setIcon(new ImageIcon("E:\\project\\buttons\\button (30).png"));
     				q=1;
     			}
     			else{
     				echo("sound disabled");
     //				sound.setIcon(new ImageIcon("E:\\project\\buttons\\button (29).png"));
     				q=0;
     			}
     	}
    }

    public void docal(String op1, String op2, String c) {
    	if(!(op1.equals("") || c.equals(""))){
	        double a = Double.parseDouble(op1);
	        double b;
	        
	        double rslt;
	        System.out.println(op1 + " " + op2 + " " + op);
	       // System.out.println(a + " " + b + " " + c);
	        
	        if(!op2.equals("#"))
		        {b = Double.parseDouble(op2);
			        if (c.equals("+"))
			            rslt = a + b;
			
			        else if (c.equals("-"))
			            rslt = a - b;
			
			        else if (c.equals("/"))
			      		rslt = a / b;
			    
			        else if (c.equals("*"))
			            rslt = a * b;			
			        else 
			        	rslt = 0;				        
			        ta.setText(String.format("%.2f", rslt));
		        }
	        
	        else
	        {
	        	if(op.equals("sin")||op.equals("sine"))
	        		ta.setText ("" + String.format("%.2f", Math.sin(a)));
	
	        	else if(op.equals("cos"))
	        		ta.setText (("" + String.format("%.2f", (Math.cos(a)))));
	
	        	else if(op.equals("tan"))
	        		ta.setText ("" + String.format("%.2f", (Math.tan(a))));
	
	        	else if(op.equals("cosec"))
	        		ta.setText ("" + String.format("%.2f", (1/Math.sin(a))));
	
	        	else if(op.equals("sec"))
	        		ta.setText ("" + String.format("%.2f", (1/Math.cos(a))));
	
	        	else if(op.equals("cot"))
	        		ta.setText ("" + String.format("%.2f", (1/Math.tan(a))));
	        	
	        	else if(op.equals("√"))
	        		ta.setText ("" + String.format("%.2f", (Math.sqrt(a))));
	        	
	        	else if(op.equals("ln"))
	        		ta.setText("" + String.format("%.2f", (Math.log(a))));
	        	
	        	else if(op.equals("log10"))
	        		ta.setText("" + String.format("%.2f", (Math.log10(a))));
	        	
	        }
    	}
    	else
    		ta.setText("");
    }

    public void echo(String s)
    {
    	MakeSound ms=new MakeSound();
    	
	    	if(s.equals("1"))
	    		ms.playSound("E:\\project\\audio-numbers\\one.wav");
	    	
	    	else if(s.equals("2"))
	    		ms.playSound("E:\\project\\audio-numbers\\two.WAV");
	
	    	else if(s.equals("3"))
	    		ms.playSound("E:\\project\\audio-numbers\\three.WAV");
	
	    	else if(s.equals("4"))
	    		ms.playSound("E:\\project\\audio-numbers\\four.WAV");
	
	    	else if(s.equals("5"))
	    		ms.playSound("E:\\project\\audio-numbers\\five.WAV");
	
	    	else if(s.equals("6"))
	    		ms.playSound("E:\\project\\audio-numbers\\six.WAV");
	
	    	else if(s.equals("7"))
	    		ms.playSound("E:\\project\\audio-numbers\\seven.WAV");
	
	    	else if(s.equals("8"))
	    		ms.playSound("E:\\project\\audio-numbers\\eight.WAV");
	
	    	else if(s.equals("9"))
	    		ms.playSound("E:\\project\\audio-numbers\\nine.WAV");
	
	    	else if(s.equals("0"))
	    		ms.playSound("E:\\project\\audio-numbers\\zero.WAV");
	
	    	else if(s.equals("+"))
	    		ms.playSound("E:\\project\\audio-numbers\\plus.WAV");
	
	    	else if(s.equals("-"))
	    		ms.playSound("E:\\project\\audio-numbers\\minus.WAV");
	
	    	else if(s.equals("/"))
	    		ms.playSound("E:\\project\\audio-numbers\\divided by.WAV");
	
	    	else if(s.equals("*"))
	    		ms.playSound("E:\\project\\audio-numbers\\multiplied by.WAV");
	
	    	else if(s.equals("."))
	    		ms.playSound("E:\\project\\audio-numbers\\point.WAV");

	    	else if(s.equals("sin"))
	    		ms.playSound("E:\\project\\audio-numbers\\sine.wav");
	    	
	    	else if(s.equals("cos"))
	    		ms.playSound("E:\\project\\audio-numbers\\cos.wav");
	    	
	    	else if(s.equals("tan"))
	    		ms.playSound("E:\\project\\audio-numbers\\tan.wav");
	    	
	    	else if(s.equals("cosec"))
	    		ms.playSound("E:\\project\\audio-numbers\\cosec.wav");
	    	
	    	else if(s.equals("sec"))
	    		ms.playSound("E:\\project\\audio-numbers\\sec.wav");
	    	
	    	else if(s.equals("cot"))
	    		ms.playSound("E:\\project\\audio-numbers\\cot.wav");
	    	
	    	else if(s.equals("del"))
	    		ms.playSound("E:\\project\\audio-numbers\\delete.wav");
	    	
	    	else if(s.equals("exit"))
	    		ms.playSound("E:\\project\\audio-numbers\\exit.wav");
	    	
	    	else if(s.equals("pi"))
	    		ms.playSound("E:\\project\\audio-numbers\\pi.wav");
	    	
	    	else if(s.equals("ln"))
	    		ms.playSound("E:\\project\\audio-numbers\\log.wav");
	    	
	    	else if(s.equals("log 10"))
	    		ms.playSound("E:\\project\\audio-numbers\\log 10.wav");
	    	
	    	else if(s.equals("change sign"))
	    		ms.playSound("E:\\project\\audio-numbers\\change sign.wav");
	    	
	    	else if(s.equals("sound enabled"))
	    		ms.playSound("E:\\project\\audio-numbers\\sound enabled.wav");
	    	
	    	else if(s.equals("sound disabled"))
	    		ms.playSound("E:\\project\\audio-numbers\\sound disabled.wav");
	    	
	    	else if(s.equals("equals"))
	    		ms.playSound("E:\\project\\audio-numbers\\equals.wav");
	    	
	    	else if(s.equals("clear"))
	    		ms.playSound("E:\\project\\audio-numbers\\clear.wav");
	    	
	    	else if(s.equals("stop"))
	    		ms.playSound("E:\\project\\audio-numbers\\stop.wav");
	    	
	    	else if(s.equals("start speaking"))
	    		ms.playSound("E:\\project\\audio-numbers\\start speaking.wav");
	    	
	    	else if(s.equals("sqrt"))
	    		ms.playSound("E:\\project\\audio-numbers\\square root.wav");
	    	
	    	else if(s.equals("not defined"))
	    		ms.playSound("E:\\project\\audio-numbers\\not defined.wav");
	    	
    }
}