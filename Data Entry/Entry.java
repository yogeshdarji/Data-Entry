
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Entry extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField firstname;
	private static JTextField lname1;
	private static JTextField addr1;
	private static JTextField addr2;
	private static JTextField city1;
	private static JTextField state1;
	private static JTextField zipcode;
	private static JTextField phone_num;
	private static JTextField country_name;
	private static JTextField email_id;
	private static JTable table;
	
	private static JLabel Proof;
	private static DefaultTableModel data_model;
	private static JTextField middle_name;
	ArrayList<Store_data> mydata;
	private static JLabel email_valid;
	private static JLabel status;
	private static JLabel phone_val;
	private static JLabel zipval;
	boolean isFnameCorrect;
	boolean isMnameCorrect;
	boolean isLnameCorrect;
	boolean isadd1Correct;
	boolean isadd2Correct;
	boolean isPhoneValid;
	boolean isZipValid;
	boolean isCityValid;
	boolean isStateValid;
	boolean isCountryValid;
	static Store_data d = new Store_data();
	int selRow = 0;
private static JCheckBox prf = new JCheckBox();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entry frame = new Entry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	/**
	 * @throws IOException
	 */
	// Constructor of main GUI class
	public Entry() throws IOException {
		super("Data Entry Form");
        
		mydata = new ArrayList<Store_data>();
		mydata = Changes.read();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 700, 600);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new LineBorder(Color.BLUE, 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel fname = new JLabel("Firstname *");
		fname.setForeground(new Color(0, 0, 205));
		fname.setFont(new Font("Tahoma", Font.BOLD, 12));
		fname.setBounds(21, 11, 102, 14);
		contentPane.add(fname);

		JLabel lname = new JLabel("Lastname *");
		lname.setForeground(new Color(0, 0, 205));
		lname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lname.setBounds(21, 50, 74, 14);
		contentPane.add(lname);

		JLabel address1 = new JLabel("Address 1 *");
		address1.setForeground(new Color(0, 0, 205));
		address1.setFont(new Font("Tahoma", Font.BOLD, 12));
		address1.setBounds(21, 94, 74, 14);
		contentPane.add(address1);

		JLabel address2 = new JLabel("Address 2 ");
		address2.setForeground(new Color(0, 0, 205));
		address2.setFont(new Font("Tahoma", Font.BOLD, 12));
		address2.setBounds(21, 139, 74, 14);
		contentPane.add(address2);

		JLabel city = new JLabel("City *");
		city.setForeground(new Color(0, 0, 205));
		city.setFont(new Font("Tahoma", Font.BOLD, 12));
		city.setBounds(21, 184, 46, 14);
		contentPane.add(city);

		JLabel state = new JLabel("State *");
		state.setForeground(new Color(0, 0, 205));
		state.setFont(new Font("Tahoma", Font.BOLD, 12));
		state.setBounds(21, 228, 46, 14);
		contentPane.add(state);

		JLabel zip = new JLabel("Zip *");
		zip.setForeground(new Color(0, 0, 205));
		zip.setFont(new Font("Tahoma", Font.BOLD, 12));
		zip.setBounds(21, 264, 46, 14);
		contentPane.add(zip);

		JLabel phone = new JLabel("Phone *");
		phone.setForeground(new Color(0, 0, 205));
		phone.setFont(new Font("Tahoma", Font.BOLD, 12));
		phone.setBounds(21, 305, 74, 14);
		contentPane.add(phone);

		JLabel country = new JLabel("Date-");
		country.setForeground(new Color(0, 0, 205));
		country.setFont(new Font("Tahoma", Font.BOLD, 12));
		country.setBounds(21, 354, 74, 14);
		contentPane.add(country);

		JLabel email = new JLabel("Email *");
		email.setForeground(new Color(0, 0, 205));
		email.setFont(new Font("Tahoma", Font.BOLD, 12));
		email.setBounds(21, 399, 46, 14);
		contentPane.add(email);
		
		JLabel proof = new JLabel("<html>Proof of<br> Purchase</html> ");
		
		proof.setForeground(new Color(0, 0, 205));
		proof.setFont(new Font("Tahoma", Font.BOLD, 12));
		proof.setBounds(21, 460, 60, 34);
		contentPane.add(proof);
		

		firstname = new JTextField(20);
		firstname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				isFnameCorrect = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isFnameCorrect = false;
				}
				if (!isFnameCorrect) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}		
				
				
				
				
				
				
			}
		});
		firstname.setForeground(Color.BLACK);
		firstname.setBackground(Color.WHITE);
		firstname.setBounds(114, 9, 164, 20);
		contentPane.add(firstname);
		firstname.setColumns(10);
		// Code For Limiting Characters Length
		firstname.setDocument(new Limit(20));

		lname1 = new JTextField(20);
		lname1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				isLnameCorrect = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isLnameCorrect = false;
				}
				if (!isLnameCorrect) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}		
				
				
				
				
				
				
				
			}
		});
		lname1.setForeground(Color.BLACK);
		lname1.setBounds(114, 48, 164, 20);
		contentPane.add(lname1);
		lname1.setColumns(10);
		lname1.setDocument(new Limit(20));

		addr1 = new JTextField(35);
		addr1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				/* isadd1Correct = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isadd1Correct = false;
				}
				if (!isadd1Correct) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}	*/
				
		}
		});
		addr1.setForeground(Color.BLACK);
		addr1.setBounds(114, 92, 164, 20);
		contentPane.add(addr1);
		addr1.setColumns(10);
		addr1.setDocument(new Limit(35));

		addr2 = new JTextField(35);
		addr2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				/*isadd2Correct = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isadd2Correct = false;
				}
				if (!isadd2Correct) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}*/
				
	}
		});
		addr2.setForeground(Color.BLACK);
		addr2.setBounds(114, 137, 164, 20);
		contentPane.add(addr2);
		addr2.setColumns(10);
		addr2.setDocument(new Limit(35));

		city1 = new JTextField(25);
		city1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				isCityValid = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isCityValid = false;
				}
				if (!isCityValid) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}
				
				
			}	});
		city1.setForeground(Color.BLACK);
		city1.setBounds(114, 182, 164, 20);
		contentPane.add(city1);
		city1.setColumns(10);
		city1.setDocument(new Limit(25));

		state1 = new JTextField(2);
		state1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				isStateValid = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isStateValid = false;
				}
				if (!isStateValid) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}
				
	}
		});
		state1.setForeground(Color.BLACK);
		state1.setBounds(114, 226, 164, 20);
		contentPane.add(state1);
		state1.setColumns(10);
		state1.setDocument(new Limit(2));

		zipcode = new JTextField(20);
		zipcode.setForeground(Color.BLACK);
		// Code for zipcode validation
		zipcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				isZipValid = true;
				char c = ev.getKeyChar();
				if (!Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
						|| (c == KeyEvent.VK_DELETE)) {
					getToolkit().beep();
					ev.consume();
					isZipValid = false;
				}
				if (!isZipValid) {
					zipval.setText("Please Enter Valid Zipcode ");

				} else {
					zipval.setText("");

				}

			}
		});
		zipcode.setBounds(114, 262, 164, 20);
		contentPane.add(zipcode);
		zipcode.setColumns(10);
		zipcode.setDocument(new Limit(9));

		phone_num = new JTextField(21);
		phone_num.setForeground(Color.BLACK);

		// Code for phone number validation
		phone_num.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ex) {
				isPhoneValid = true;
				char ch = ex.getKeyChar();
				if (!Character.isDigit(ch) || (ch == KeyEvent.VK_BACK_SPACE)
						|| (ch == KeyEvent.VK_DELETE)) {
					getToolkit().beep();
					ex.consume();
					isPhoneValid = false;
				}
				if (!isPhoneValid) {
					phone_val.setText("Please Enter Valid Phone Number ");

				} else {
					phone_val.setText("");

				}

			}
		});
		phone_num.setBounds(114, 303, 164, 20);
		contentPane.add(phone_num);
		phone_num.setColumns(10);
		phone_num.setDocument(new Limit(21));

		country_name = new JTextField(30);
		country_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				isCountryValid = true;
				char c = ev.getKeyChar();
				if (Character.isAlphabetic(c)) {
					getToolkit().beep();
					ev.consume();
					isCountryValid = false;
				}
				if (!isCountryValid) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}
				
	}
		});
		country_name.setForeground(Color.BLACK);
		country_name.setBounds(114, 352, 164, 20);
		contentPane.add(country_name);
		country_name.setColumns(10);
		country_name.setDocument(new Limit(30));

		email_id = new JTextField(100);
		email_id.setForeground(Color.BLACK);
		email_id.setBounds(114, 397, 164, 20);
		contentPane.add(email_id);
		email_id.setColumns(10);
		email_id.setDocument(new Limit(100));
		
		prf = new JCheckBox();
		prf.setForeground(Color.BLACK);
		prf.setBounds(114, 450, 22, 20);
		prf.setSelected(true);;
		contentPane.add(prf);

		JButton Add = new JButton("ADD");
		Add.setBackground(new Color(230, 230, 250));
		Add.setForeground(new Color(0, 0, 205));
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fileSave();

			}
		});
		Add.setFont(new Font("Tahoma", Font.BOLD, 12));
		Add.setBounds(312, 346, 89, 31);
		contentPane.add(Add);

		final JButton Update = new JButton("UPDATE");
		Update.setBackground(new Color(230, 230, 250));
		Update.setForeground(new Color(0, 0, 205));
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
         // Code for preventing empty setData records being entered
				
				if ((firstname.getText().equalsIgnoreCase(""))
						&& (lname1.getText().equalsIgnoreCase(""))
						&& (addr1.getText().equalsIgnoreCase(""))
						&& (city1.getText().equalsIgnoreCase(""))
						&& (state1.getText().equalsIgnoreCase(""))
						&& (zipcode.getText().equalsIgnoreCase(""))
						&& (country_name.getText().equalsIgnoreCase(""))
						&& (phone_num.getText().equalsIgnoreCase(""))
						&& (email_id.getText().equalsIgnoreCase(""))) {
					status.setText("Please Select Row");
				} else {

					int selRow = table.getSelectedRow();

					if (selRow != -1) {
						mydata.remove(selRow);
						Changes.write(mydata);
						data_model.removeRow(selRow);
						fileSave();
						status.setText("Record Modified Successfully ");
						refreshdata();
					}
				}
			}
		}

		);

		Update.setFont(new Font("Tahoma", Font.BOLD, 12));
		Update.setBounds(435, 345, 89, 33);
		contentPane.add(Update);

		final JButton Delete = new JButton("DELETE");
		Delete.setBackground(new Color(230, 230, 250));
		Delete.setForeground(new Color(0, 0, 205));
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				// Code for preventing empty setData records being entered 
				if ((firstname.getText().equalsIgnoreCase(""))
						&& (lname1.getText().equalsIgnoreCase(""))
						&& (addr1.getText().equalsIgnoreCase(""))
						&& (city1.getText().equalsIgnoreCase(""))
						&& (state1.getText().equalsIgnoreCase(""))
						&& (zipcode.getText().equalsIgnoreCase(""))
						&& (country_name.getText().equalsIgnoreCase(""))
						&& (phone_num.getText().equalsIgnoreCase(""))
						&& (email_id.getText().equalsIgnoreCase(""))) {
					status.setText("Please Select Row");
				} else {

					int selRow = table.getSelectedRow();

					if (selRow != -1) {
						

						mydata.remove(selRow);

						Changes.write(mydata);
						// Changes.removeSelectedRow(f1, m1, l1);
						data_model.removeRow(selRow);
						// table.setModel(Changes.displayDataInTable(mydata));
						status.setText("Record Deleted Successfully ");
					}
					refreshdata();
				}
			}
		});
		Delete.setFont(new Font("Tahoma", Font.BOLD, 12));
		Delete.setBounds(553, 345, 89, 33);
		contentPane.add(Delete);

		JLabel NoteCompulsoryField = new JLabel("Note : * Compulsory Field");
		NoteCompulsoryField.setForeground(new Color(0, 0, 205));
		NoteCompulsoryField.setFont(new Font("Tahoma", Font.BOLD, 11));
		NoteCompulsoryField.setBounds(486, 412, 191, 14);
		contentPane.add(NoteCompulsoryField);

		JLabel studentlist = new JLabel("STUDENT LIST");
		studentlist.setForeground(new Color(0, 0, 205));
		studentlist.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentlist.setBounds(408, 49, 133, 14);
		contentPane.add(studentlist);

		// data_model = new DefaultTableModel();

		data_model = new DefaultTableModel() {
			/**
             * 
             */
			private static final long serialVersionUID = -3140186159369930753L;
           // Code for making table cells non-editable
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false; // Disallow the editing of any cell
			}
		};

		data_model.addColumn("First Name");
		data_model.addColumn("Middle Name");
		data_model.addColumn("Last Name");
		data_model.addColumn("Phone No");

		// Code for displaying initial setData
		BufferedReader br1 = null;
		try {
			br1 = new BufferedReader(new InputStreamReader(new FileInputStream(
					new File("Textfile.txt"))));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String line;
		int count = 0;
		String lines[] = new String[100];
		// System.out.println("Row"+row);
		while (((lines[count] = br1.readLine()) != null)) {
			String line = lines[count];
			String[] splitArray = line.split("\t");
			if (splitArray.length == 11) {
				// String[] splitArray = new String[11];
				String[] tableData = new String[4];
				tableData[0] = splitArray[0];
				tableData[1] = splitArray[1];
				tableData[2] = splitArray[2];
				tableData[3] = splitArray[8];
				data_model.addRow(tableData);
			}
		}

		// Code for Default table
		table = new JTable();
		table.setBorder(new EmptyBorder(1, 1, 1, 1));
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setBounds(296, 35, 360, 100);
		table.setModel(data_model);
		// table.setValueAt("",0,0);
		table.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		contentPane.add(table);
		table.setVisible(true);

		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						try {
							// System.out.println("event:"+arg0.toString()+";"+arg0.getValueIsAdjusting()+";"+arg0.getSource());
							// int row = table.getSelectedRow();

							// String firstName = (String)table.getValueAt(1,
							// 1);
							// String lastName = (String) table.getValueAt(1,
							// 2);
							// int selRow=0;
							if (arg0.getValueIsAdjusting()) {
								Changes.UpdateSelected(firstname, middle_name,
										lname1, addr1, addr2, city1, state1,
										phone_num, zipcode, country_name, email_id,
										table.getSelectedRow());
							}

							/*
							 * f(selRow!=-1) selRow = table.getSelectedRow();
							 * mydata = new ArrayList<Store_data>(); mydata =
							 * Changes.read();
							 */
							// mydata.remove(selRow);
							// JOptionPane.showMessageDialog(null,
							// "Record Deleted Successfully: ");
							// Changes.removeSelectedRows(table, data_model,
							// fname1, middle_name, lname1, phone_num,
							// table.getSelectedRowCount());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});

		// Code for adding table under ScrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane);
		scrollPane.setVisible(true);
		scrollPane.setBounds(296, 102, 360, 100);
		scrollPane.setViewportView(table);

		JLabel Mi = new JLabel("M.I ");
		Mi.setForeground(new Color(0, 0, 205));
		Mi.setFont(new Font("Tahoma", Font.BOLD, 12));
		Mi.setBounds(341, 12, 46, 14);
		contentPane.add(Mi);

		middle_name = new JTextField(1);
		middle_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				isMnameCorrect = true;
				char c = ev.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					ev.consume();
					isMnameCorrect = false;
				}
				if (!isMnameCorrect) {
					status.setText("Please Enter Valid Characters ");

				} else {
					status.setText("");

				}	
				
				
				
				
			}
		});
		middle_name.setBounds(376, 9, 35, 20);
		contentPane.add(middle_name);
		middle_name.setColumns(10);
		middle_name.setDocument(new Limit(1));

		email_valid = new JLabel("");
		email_valid.setForeground(Color.RED);
		email_valid.setFont(new Font("Tahoma", Font.BOLD, 11));
		email_valid.setBounds(312, 400, 164, 14);
		contentPane.add(email_valid);

		phone_val = new JLabel("");
		phone_val.setForeground(Color.RED);
		phone_val.setFont(new Font("Tahoma", Font.BOLD, 11));
		phone_val.setBounds(312, 306, 212, 14);
		contentPane.add(phone_val);

		zipval = new JLabel("");
		zipval.setFont(new Font("Tahoma", Font.BOLD, 11));
		zipval.setForeground(Color.RED);
		zipval.setBounds(312, 265, 212, 14);
		contentPane.add(zipval);

		status = new JLabel("");
		status.setForeground(Color.RED);
		status.setFont(new Font("Tahoma", Font.BOLD, 12));
		status.setBounds(408, 229, 234, 20);
		contentPane.add(status);
		scrollPane.repaint();
		// contentPane.add(new JScrollPane(table));

	}

	// Code for adding setData to file

	protected void fileSave() {
		 // Code for preventing empty setData records being entered
		if (!(firstname.getText().equalsIgnoreCase(""))
				&& !(lname1.getText().equalsIgnoreCase(""))
				&& !(addr1.getText().equalsIgnoreCase(""))
				&& !(city1.getText().equalsIgnoreCase(""))
				&& !(state1.getText().equalsIgnoreCase(""))
				&& !(zipcode.getText().equalsIgnoreCase(""))
				&& !(country_name.getText().equalsIgnoreCase(""))
				&& !(phone_num.getText().equalsIgnoreCase(""))
				&& !(email_id.getText().equalsIgnoreCase(""))) {

			// Validating email-address and duplicate enteries being entered

			boolean isEmailValid = Checks.isValidEmailAddress(email_id
					.getText());
			if (isEmailValid) {
				email_valid.setText("");
			} else {
				email_valid.setText("Please Enter Valid Email ");
				return;
			}
			setData();

			boolean isDuplicate = Changes.duplicateCheck(d);
			if (isDuplicate == true) {
				status.setText("Record Already Exists");
			} else {
				try {

					// Code for getting input from user in textfields
					BufferedWriter reader = new BufferedWriter(new FileWriter(
							"Textfile.txt", true));

					reader.write(firstname.getText());
					reader.write("\t");
					reader.write(middle_name.getText());
					reader.write("\t");
					reader.write(lname1.getText());
					reader.write("\t");
					reader.write(addr1.getText());
					reader.write("\t");
					reader.write(addr2.getText());
					reader.write("\t");
					reader.write(city1.getText());
					reader.write("\t");
					reader.write(zipcode.getText());
					reader.write("\t");
					reader.write(state1.getText());
					reader.write("\t");
					reader.write(phone_num.getText());
					reader.write("\t");
					reader.write(country_name.getText());
					reader.write("\t");
					reader.write(email_id.getText());
					reader.write("\t");
					reader.newLine();
					reader.close();

					Changes.addingRows(table, data_model, firstname, middle_name,
							lname1, phone_num);
					Store_data sd = new Store_data();
					sd.setFname1(firstname.getText());
					sd.setMname(middle_name.getText());
					sd.setFname1(lname1.getText());
					sd.setAdd1(addr1.getText());
					sd.setAdd2(addr2.getText());
					sd.setCity1(city1.getText());
					sd.setZip1(zipcode.getText());
					sd.setState1(state1.getText());
					sd.setPhone1(phone_num.getText());
					sd.setCountry1(country_name.getText());
					sd.setEmail1(email_id.getText());
					mydata.add(sd);
					refreshdata();

				}

				catch (IOException ex) {
					System.out.println("File not found: ");

				}
			}

		} else {
			status.setText("* Fields are Compulsory");
		}

	}

	// Code for storing all fields setData records

	public static void setData() {

		d.setFname1(firstname.getText());
		d.setMname(middle_name.getText());
		d.setLname1(lname1.getText());
		d.setAdd1(addr1.getText());
		d.setAdd2(addr2.getText());
		d.setCity1(city1.getText());
		d.setZip1(zipcode.getText());
		d.setState1(state1.getText());
		d.setPhone1(phone_num.getText());
		d.setCountry1(country_name.getText());
		d.setEmail1(email_id.getText());

	}

	// Code for clearing up all the setData after each add, update and delete
	public void refreshdata() {
		firstname.setText("");
		middle_name.setText("");
		lname1.setText("");
		addr1.setText("");
		addr2.setText("");
		city1.setText("");
		state1.setText("");
		zipcode.setText("");
		phone_num.setText("");
		country_name.setText("");
		email_id.setText("");

	}
}
