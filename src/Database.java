import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Database extends JFrame implements  ActionListener {

 public JButton  recordupdate,recordupdate1,recorddelete,recorddelete2,record,record2,recordinsertion,
         recordinsertion1,Logout1,Logout2;
    JFrame frame = new JFrame("STUDENT MANAGEMENT");
 public static void main(String[] args){
     new Database();
 }
    public Database(){

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            ImageIcon icon= new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/studentrecords2.png");
            frame.setIconImage(icon.getImage());
            JLabel framework = new JLabel(new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/background1.png"));
            framework.setBounds(0, 0, 800, 800);

            JLayeredPane layeredPane = new JLayeredPane();
            layeredPane.setBounds(20, 90, 740, 600);
            layeredPane.setLayout(null);
            layeredPane.setBackground(new Color(0x172032));
            layeredPane.setOpaque(true);
            //Headline
            JLabel headline= new JLabel();
            headline.setText("STUDENT MANAGEMENT SYSTEM");
           headline.setBounds(200, 0, 400, 50);
            headline.setBackground(new Color(0x172032));
            headline.setFont(new Font("Times New Roman", Font.BOLD, 20));
            headline.setForeground(new Color(255, 255, 255));
            headline.setOpaque(true);
            //Update
            JLabel RecordUpdate= new JLabel();
            RecordUpdate.setBounds(10,80,230,250);
            RecordUpdate.setBackground(new Color(0xFFFFFF));

             recordupdate= new JButton();
            ImageIcon icon1= new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/studentupdate.jpeg");
           recordupdate.setBounds(0,0,230,200);
           recordupdate.setIcon(icon1);
           recordupdate.addActionListener(this);
            recordupdate1= new JButton("Update Student Record");
            recordupdate1.setFont(new Font("Segoe UI", Font.BOLD, 16));
            recordupdate1.setBackground(new Color(39, 174, 96));
           recordupdate1.setForeground(Color.white);
           recordupdate1.setBounds(0,200,230,50);
           recordupdate1.addActionListener(this);

           RecordUpdate.add(recordupdate1);
           RecordUpdate.add(recordupdate);
           RecordUpdate.setOpaque(true);

          //Deletion
            JLabel RecordDelete= new JLabel();
            RecordDelete.setBounds(250,80,230,250);
            RecordDelete.setBackground(new Color(0x172032));

             recorddelete= new JButton();
            ImageIcon icon2= new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/studentdeletion.png");
            recorddelete.setBounds(0,0,230,200);
            recorddelete.setIcon(icon2);
            recorddelete.addActionListener(this);
             recorddelete2= new JButton("Delete Student Record");
             recorddelete2.setBackground(new Color(192, 57, 43));
            recorddelete2.setForeground(Color.WHITE);
            recorddelete2.setFont(new Font("Segoe UI", Font.BOLD, 16));
            recorddelete2.setBounds(0,200,230,50);
            recorddelete2.addActionListener(this);

            RecordDelete.add(recorddelete);
            RecordDelete.add(recorddelete2);
            RecordDelete.setOpaque(true);

            //Seeing Student Record

            JLabel Record= new JLabel();

           Record.setBounds(100,340,250,250);
             record= new JButton();
            ImageIcon icon3= new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/studentrecords2.png");
            record.setBounds(0,0,230,200);
            record.setIcon(icon3);
            record.addActionListener(this);
             record2= new JButton("See Student Record");
             record2.setFont(new Font("Times New Roman", Font.BOLD, 20));
             record2.setBackground(new Color(142, 68, 173));
            record2.setForeground(Color.WHITE);
            record2.setBounds(0,200,230,50);
            record2.addActionListener(this);

            Record.add(record);
            Record.add(record2);
            Record.setOpaque(true);

            //Insertion
            JLabel RecordInsertion= new JLabel();
            RecordInsertion.setBounds(490,80,240,250);

            RecordInsertion.setBackground(new Color(0xFFFFFF));
            ImageIcon icon4 = new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/studenticon.jpeg");
             recordinsertion= new JButton();
            recordinsertion.setBounds(0,0,230,200);
            recordinsertion.setIcon(icon4);
            recordinsertion.addActionListener(this);
             recordinsertion1= new JButton("Insert Student Record");
             recordinsertion1.setFont(new Font("Segoe UI", Font.BOLD, 16));
             recordinsertion1.setBackground(new Color(41, 128, 185));

            recordinsertion1.setForeground(Color.white);
            recordinsertion1.setBounds(0,200,230,50);
            recordinsertion1.addActionListener(this);
            RecordInsertion.add(recordinsertion);
            RecordInsertion.add(recordinsertion1);

            RecordInsertion.setOpaque(true);

            //Logout
            JLabel Logout = new JLabel();
            Logout.setBounds(370,340,250,250);
            Logout.setBackground(Color.WHITE);
             Logout1= new JButton();
            ImageIcon icon5= new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/download.png");
            Logout1.setBounds(0,0,230,200);
            Logout1.setIcon(icon5);
            Logout1.addActionListener(this);
             Logout2= new JButton("Logout");
             Logout2.setFont(new Font("Segoe UI", Font.BOLD, 16));
             Logout2.setForeground(Color.WHITE);
             Logout2.setBackground(new Color(127, 140, 141));
            Logout2.setBounds(0,200,230,50);
            Logout2.addActionListener(this);
            Logout.add(Logout2);
            Logout.add(Logout1);
            Logout.setOpaque(true);

            layeredPane.add(RecordUpdate,Integer.valueOf(0));
           layeredPane.add(RecordDelete,Integer.valueOf(1));
           layeredPane.add(Record,Integer.valueOf(2));
            layeredPane.add(Logout,Integer.valueOf(4));
            layeredPane.add(RecordInsertion,Integer.valueOf(5));
            layeredPane.add(headline,Integer.valueOf(6));

            frame.add(layeredPane);
            frame.add(framework);
            frame.setResizable(false);
            frame.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==recordupdate || e.getSource()==recordupdate1){
            new StudentRecordUpdation();
            frame.dispose();
        }
        if(e.getSource()==recorddelete||e.getSource()==recorddelete2){
            new StudentRecordDeletion();
            frame.dispose();
        }
        if(e.getSource()==recordinsertion||e.getSource()==recordinsertion1){
            new StudentRecordInsertion();
            frame.dispose();
        }
        if(e.getSource()==record||e.getSource()==record2){
            new StudentRecord();
            frame.dispose();
        }
        if(e.getSource()==Logout1||e.getSource()==Logout2){
            new AdminPanel();
            frame.dispose();
        }
    }
}


