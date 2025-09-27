import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRecordUpdation extends  DatabaseConnectivity implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==search){

    searchStudent();
}
if(e.getSource()==save){
    update();
    JOptionPane.showMessageDialog(null,"Successfully saved record");
    new Database();
    frame.dispose();
}
if(e.getSource()==back){
    new Database();
    frame.dispose();
}
    }

   public void searchStudent() {
        String roll = S_roll.getText();
        try {
            PreparedStatement ps = super.con.prepareStatement(
                    "SELECT name, contact, email, marks, grade FROM studentinfo WHERE rollno=?"
            );
            ps.setString(1, roll);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                S_name.setText(rs.getString("name"));
                S_contact.setText(rs.getString("contact"));
                S_email.setText(rs.getString("email"));
                S_Marks.setText(rs.getString("marks"));
                S_grade.setText(rs.getString("grade"));
            } else {
                JOptionPane.showMessageDialog(null, "No student found with Roll No: " + roll);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
public void update(){
        String roll = S_roll.getText();
        String name = S_name.getText();
        String contact = S_contact.getText();
        String email = S_email.getText();
        String marks = S_Marks.getText();
        String grade = S_grade.getText();
        try{
            PreparedStatement smt= DatabaseConnectivity.con.prepareStatement("UPDATE Studentinfo set name=?,contact=?,email=?,marks=?,grade=? WHERE rollno=?");
            smt.setString(1,name);;
            smt.setString(2,contact);
            smt.setString(3,email);
            smt.setString(4,marks);
            smt.setString(5,grade);
            smt.setString(6,roll);
            smt.executeUpdate();


        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
}
    public static void main(String[] args) {
        new StudentRecordUpdation();
    }

    public TextField S_name,S_contact,S_email,S_grade,S_Marks,S_roll;
    public JButton save,search,back;
    JLabel name,contact,email,marks,grade;
    JFrame frame = new JFrame("Student Record Updation");

    StudentRecordUpdation(){



            frame.setSize(840, 800);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null); // Important for absolute positioning
        ImageIcon icon= new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/studentrecords2.png");
        frame.setIconImage(icon.getImage());
            // Background image
            JLabel background = new JLabel(new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/background1.png"));
            background.setBounds(0, 0, 800, 800);
            background.setLayout(null); // Allow adding components to it

            // Side image
            JLabel sidepic = new JLabel(new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/studentupdate.jpeg"));
            sidepic.setBounds(0, 100, 300, 600);
            sidepic.setOpaque(true);

            // form
            JLayeredPane form= new  JLayeredPane();
            form.setBounds(305,100,600,600);
            JLabel form_background= new JLabel();
            //Background of Form
            form_background.setBackground(new Color(0x172032));
            form_background.setBounds(0,0,700,600);
            form_background.setOpaque(true);
// Headline
            JLabel headline= new JLabel("UPDATE  STUDENT DETAILS ");
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
        name.setBounds(5,170,200,30);
        name.setOpaque(true);

        S_name=new TextField();
        S_name.setForeground(Color.BLACK);
        S_name.setBackground(new Color(0xFFFFFF));
        S_name.setBounds(100,170,300,25);

        //Contact from
        JLabel contact= new JLabel("Phone No: ");
        contact.setFont(new Font("Times New Roman",Font.BOLD,20));
        contact.setBackground(new Color(0x172032));
        contact.setForeground(Color.white);
        contact.setBounds(5,240,95,30);
        contact.setOpaque(true);

        S_contact=new TextField();
        S_contact.setForeground(Color.BLACK);
        S_contact.setBackground(new Color(0xFFFFFF));
        S_contact.setBounds(100,240,300,25);


        //email form
        JLabel email= new JLabel("Email: ");
        email.setFont(new Font("Times New Roman",Font.BOLD,20));
        email.setBackground(new Color(0x172032));
        email.setForeground(Color.white);
        email.setBounds(5,310,95,30);
        email.setOpaque(true);
        S_email=new TextField();
        S_email.setForeground(Color.BLACK);
        S_email.setBackground(new Color(0xFFFFFF));
        S_email.setBounds(100,310,300,25);

        //Marks Form
        JLabel marks= new JLabel("Marks: ");
        marks.setFont(new Font("Times New Roman",Font.BOLD,20));
        marks.setForeground(Color.white);
        marks.setBackground(new Color(0x172032));
        marks.setOpaque(true);
        marks.setBounds(5,380,95,30);

        S_Marks=new TextField();
        S_Marks.setForeground(Color.BLACK);
        S_Marks.setBackground(new Color(0xFFFFFF));
        S_Marks.setBounds(100,380,300,25);

        //Grade form
        JLabel grade= new JLabel("Grade: ");
        grade.setFont(new Font("Times New Roman",Font.BOLD,20));
        grade.setForeground(Color.white);
        grade.setBackground(new Color(0x172032));
        grade.setBounds(5,450,95,30);
        grade.setOpaque(true);

        S_grade=new TextField();
        S_grade.setForeground(Color.BLACK);
        S_grade.setBackground(new Color(0xFFFFFF));
        S_grade.setBounds(100,450,300,25);
// Roll number
        JLabel roll = new JLabel("Roll No : ");
        roll.setFont(new Font("Times New Roman",Font.BOLD,20));
        roll.setForeground(Color.white);
        roll.setBackground(new Color(0x172032));
        roll.setBounds(5,100,95,30);
        roll.setOpaque(true);

        S_roll=new TextField();
        S_roll.setForeground(Color.BLACK);
        S_roll.setBackground(new Color(0xFFFFFF));
        S_roll.setBounds(100,100,300,25);

         search= new JButton("SEARCH");


        search.setBounds(420,100,110,30);

       // search.setBackground(new Color(0x172032));
        search.setForeground(Color.white);
        search.setBackground(new Color(0x0A0AE3));
        search.addActionListener(this);
        search.setOpaque(true);
//Save Button
            save=new JButton("SAVE");
            save.setFont(new Font("Times New Roman",Font.BOLD,20));
            save.addActionListener(this);
            save.setForeground(Color.WHITE);
            save.setBackground(new Color(0xDCD23F));
            save.setBounds(200,520,100,40);
            save.setOpaque(true);
//Back Button
        back=new JButton("BACK");
        back.setFont(new Font("Times New Roman",Font.BOLD,20));
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(0xFA0000));
        back.setBounds(200,570,100,40);
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
         form.add(roll,Integer.valueOf(13));
         form.add(S_roll,Integer.valueOf(14));
         form.add(search,Integer.valueOf(15));
         form.add(back,Integer.valueOf(16));
           background.add(sidepic); // Add sidepic to background
            frame.setContentPane(background); // Set background as content pane
            frame.add(form);
            frame.setResizable(false);
            frame.setVisible(true);
        }
}
