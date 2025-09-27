import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRecordDeletion extends DatabaseConnectivity implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==save){
   delete();
   JOptionPane.showMessageDialog(null,"Student Record Deleted Successfully");
   new Database();
frame.dispose();
}
if(e.getSource()==backbtn){
    new Database();
    frame.dispose();

}
    }
void delete() {
    String rollno = S_Rollno.getText();
    try {
        PreparedStatement pst = DatabaseConnectivity.con.prepareStatement("DELETE FROM studentinfo WHERE rollno=?");
        pst.setString(1, rollno);
        pst.executeUpdate();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public static void main(String[]args){
        new StudentRecordDeletion();
    }
    public TextField S_Rollno;
    public JButton save,backbtn;
    JFrame frame= new JFrame();
    StudentRecordDeletion(){

        frame.setTitle("Student Record Deletion");
        frame.setSize(800,800);
        ImageIcon icon= new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/studentrecords2.png");
        frame.setIconImage(icon.getImage());
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

            // Background image
            JLabel background = new JLabel(new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/background1.png"));
            background.setBounds(0, 0, 800, 800);
            background.setLayout(null); // Allow adding components to it

            // Side image
            JLabel sidepic = new JLabel(new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/studentdeletion.png"));
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
            JLabel headline= new JLabel("ENTER THE ROLL NUMBER ");
            headline.setBounds(70,10,400,50);
            headline.setFont(new Font("Times New Roman",Font.BOLD,25));
            headline.setForeground(Color.white);
            headline.setBackground(new Color(0x172032));
            headline.setOpaque(true);

//name form
            JLabel name= new JLabel(" ROLL NO: ");
            name.setFont(new Font("Times New Roman",Font.BOLD,20));
            name.setBackground(new Color(0x172032));
            name.setForeground(Color.white);
            name.setBounds(5,100,200,30);
            name.setOpaque(true);

            S_Rollno=new TextField();
            S_Rollno.setForeground(Color.BLACK);
            S_Rollno.setBackground(new Color(0xFFFFFF));
            S_Rollno.setBounds(120,100,300,25);


//Save Button
            save=new JButton("SAVE");
            save.setFont(new Font("Times New Roman",Font.BOLD,20));
            save.addActionListener(this);
            save.setForeground(Color.WHITE);
            save.setBackground(new Color(0xDCD23F));
            save.setBounds(200,450,100,40);
            save.setOpaque(true);
//Back Button
        backbtn= new JButton("Back");
        backbtn.setFont(new Font("Times New Roman",Font.BOLD,20));
        backbtn.setBackground(new Color(0xFA0000));
        backbtn.setForeground(Color.WHITE);
        backbtn.setBounds(200,520,100,40);
        backbtn.setOpaque(true);
        backbtn.addActionListener(this);


            //Implementation

            form.add(form_background,Integer.valueOf(0));
            form.add(headline,Integer.valueOf(1));
            form.add(name,Integer.valueOf(2));
            form.add(S_Rollno,Integer.valueOf(3));
            form.add(save,Integer.valueOf(4));
            form.add(backbtn,Integer.valueOf(5));

            background.add(sidepic); // Add sidepic to background
            frame.setContentPane(background); // Set background as content pane
            frame.add(form);
        frame.setVisible(true);
    }
}
