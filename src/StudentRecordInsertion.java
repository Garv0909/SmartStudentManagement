import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentRecordInsertion extends DatabaseConnectivity implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==save){
            String name1,contact1,email1,marks1,grade1;
            name1=S_name.getText();
            contact1=S_contact.getText();
            email1=S_email.getText();
            marks1=S_Marks.getText();
            grade1=S_grade.getText();
            try {

                insertion(name1, email1, contact1, marks1, grade1);
                JOptionPane.showMessageDialog(null, "Record Insertion Successful");
                new Database();
                frame.dispose();
            } catch (HeadlessException ex) {
                throw new RuntimeException(ex);
            }

        }
        if(e.getSource()==back){
            frame.dispose();
            new Database();
        }
    }

    public static void main(String[] args) {
        new StudentRecordInsertion();
    }
public TextField S_name,S_contact,S_email,S_grade,S_Marks;
   public JButton save,back;
    JFrame frame = new JFrame("Student Record Insertion");

    StudentRecordInsertion() {
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Important for absolute positioning
        ImageIcon icon= new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/studentrecords2.png");
        frame.setIconImage(icon.getImage());
        // Background image
        JLabel background = new JLabel(new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/background1.png"));
        background.setBounds(0, 0, 800, 800);
        background.setLayout(null); // Allow adding components to it

        // Side image
        JLabel sidepic = new JLabel(new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/studentrecord.png"));
        sidepic.setBounds(0, 100, 300, 600);
        sidepic.setOpaque(true);

        // form
        JLayeredPane form= new  JLayeredPane();
        form.setBounds(305,100,500,600);
        JLabel form_background= new JLabel();
        //Background of Form
        form_background.setBackground(new Color(0x172032));
        form_background.setBounds(0,0,500,600);
        form_background.setOpaque(true);
// Headline
        JLabel headline= new JLabel("INSERT STUDENT DETAILS ");
        headline.setBounds(70,10,400,50);
        headline.setFont(new Font("Times New Roman",Font.BOLD,25));
        headline.setForeground(Color.white);
        headline.setBackground(new Color(0x172032));
        headline.setOpaque(true);

//name form
        JLabel name= new JLabel(" Name: ");
        name.setFont(new Font("Times New Roman",Font.BOLD,20));
        name.setBackground(new Color(0x172032));
        name.setForeground(Color.white);
        name.setBounds(5,100,200,30);
        name.setOpaque(true);

S_name=new TextField();
        S_name.setForeground(Color.BLACK);
        S_name.setBackground(new Color(0xFFFFFF));
        S_name.setBounds(100,100,300,25);

        //Contact from
        JLabel contact= new JLabel("Phone No: ");
        contact.setFont(new Font("Times New Roman",Font.BOLD,20));
        contact.setBackground(new Color(0x172032));
        contact.setForeground(Color.white);
        contact.setBounds(5,170,95,30);
        contact.setOpaque(true);

        S_contact=new TextField();
        S_contact.setForeground(Color.BLACK);
        S_contact.setBackground(new Color(0xFFFFFF));
        S_contact.setBounds(100,170,300,25);


        //email form
        JLabel email= new JLabel("Email: ");
        email.setFont(new Font("Times New Roman",Font.BOLD,20));
        email.setBackground(new Color(0x172032));
        email.setForeground(Color.white);
        email.setBounds(5,240,95,30);
        email.setOpaque(true);
        S_email=new TextField();
        S_email.setForeground(Color.BLACK);
        S_email.setBackground(new Color(0xFFFFFF));
        S_email.setBounds(100,240,300,25);

        //Marks Form
        JLabel marks= new JLabel("Marks: ");
        marks.setFont(new Font("Times New Roman",Font.BOLD,20));
        marks.setForeground(Color.white);
        marks.setBackground(new Color(0x172032));
        marks.setOpaque(true);
        marks.setBounds(5,310,95,30);

        S_Marks=new TextField();
        S_Marks.setForeground(Color.BLACK);
        S_Marks.setBackground(new Color(0xFFFFFF));
        S_Marks.setBounds(100,310,300,25);

        //Grade form
JLabel grade= new JLabel("Grade: ");
grade.setFont(new Font("Times New Roman",Font.BOLD,20));
grade.setForeground(Color.white);
grade.setBackground(new Color(0x172032));
grade.setBounds(5,380,95,30);
grade.setOpaque(true);

S_grade=new TextField();
S_grade.setForeground(Color.BLACK);
S_grade.setBackground(new Color(0xFFFFFF));
S_grade.setBounds(100,380,300,25);

//Save Button
        save=new JButton("SAVE");
        save.setFont(new Font("Times New Roman",Font.BOLD,20));
       save.addActionListener(this);
        save.setForeground(Color.WHITE);
        save.setBackground(new Color(0xDCD23F));
        save.setBounds(200,450,100,40);
        save.setOpaque(true);
//Back Button
        back=new JButton("Back");
        back.setFont(new Font("Times New Roman",Font.BOLD,20));
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(0xFA0000));
        back.setBounds(200,520,100,40);
        back.setOpaque(true);
 //Implementation

        form.add(form_background,Integer.valueOf(0));
        form.add(headline,Integer.valueOf(1));
        form.add(name,Integer.valueOf(2));
        form.add(S_name,Integer.valueOf(3));
        form.add(S_contact,Integer.valueOf(4));
        form.add(contact,Integer.valueOf(5));
        form.add(S_email,Integer.valueOf(6));
        form.add(email,Integer.valueOf(7));
        form.add(marks,Integer.valueOf(8));
        form.add(S_Marks,Integer.valueOf(9));
        form.add(grade,Integer.valueOf(10));
        form.add(S_grade,Integer.valueOf(11));

form.add(save,Integer.valueOf(12));
form.add(back,Integer.valueOf(13));

        background.add(sidepic); // Add sidepic to background
        frame.setContentPane(background); // Set background as content pane
frame.add(form);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
