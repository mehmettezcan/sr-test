package sr_test;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class sr_test_gui extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public sr_tests my_RE;
	public JTextArea log_RE;
	public JTextField tf_RE;
	
	public void set_RE(sr_tests a) {
		  my_RE = a;
		  }
	  
	public sr_test_gui() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				my_RE.exit();
			}
		});
		
		this.setSize(490,300);
		setResizable(false);
		getContentPane().setLayout(null);
		
				
		tf_RE = new JTextField();
		tf_RE.setBounds(10, 11, 460, 30);
		getContentPane().add(tf_RE);
		tf_RE.setColumns(10);
		
		log_RE = new JTextArea();
		getContentPane().add(log_RE);
		
		
	    JScrollPane scrollP = new JScrollPane(log_RE);
		scrollP.setBounds(10, 120, 350, 120);
		getContentPane().add(scrollP);

		
		JButton butonImport = new JButton("Import(.txt)");
		butonImport.setBounds(10, 60, 100, 30);
		getContentPane().add(butonImport);
		
		JButton butonRun = new JButton("Run");
		butonRun.setBounds(365, 60, 100, 30);
		getContentPane().add(butonRun);
		
		JButton butonSave = new JButton("Save");
		butonSave.setBounds(365, 140, 100, 30);
		getContentPane().add(butonSave);
		
		JButton butonClear = new JButton("Clear");
		butonClear.setBounds(365, 180, 100, 30);
		getContentPane().add(butonClear);
		
		butonImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser filesave = new JFileChooser();
                filesave.showOpenDialog(null);
                File dosya = filesave.getSelectedFile();
                String filelocate= dosya.getAbsolutePath();
                
                try {
                	FileReader fileRead = new FileReader(filelocate);
                	BufferedReader bufread = new BufferedReader(fileRead);
                	tf_RE.read(bufread,null);
                	bufread.close();
                	tf_RE.requestFocus();
                }
                catch(Exception e3) {
                	JOptionPane.showMessageDialog(sr_test_gui.this, "WARNING!", "WARNING!", JOptionPane.WARNING_MESSAGE);
                }

			}
		});
		
		butonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Tezcan\\Desktop\\mt_RE.txt", true)));
				    out.println(sr_tests.stack2.toString()+"\n");
				    out.println(sr_tests.stack3.toString()+"\n");
				    out.close();
				    JOptionPane.showMessageDialog(sr_test_gui.this, "Regular Expression Saved", "SAVED", JOptionPane.WARNING_MESSAGE);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(sr_test_gui.this, "WARNING!", "WARNING!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		butonRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					my_RE.create_test_case(tf_RE.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(sr_test_gui.this, "Please write Regular Expression!", "WARNING!", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		butonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_RE.setText("");
				log_RE.setText("");
			}
		});
		
	}
	public void writeRE(String cases) {
		log_RE.append(cases+"\n");
	}
}

