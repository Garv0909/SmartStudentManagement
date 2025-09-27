import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;


public class AdminPanel extends DatabaseConnectivity implements ActionListener {

    static Button login;
    static String name;
    static String password1;
    static JTextField username;
    static JPasswordField password;
    JFrame frame;

    public static void main(String[] args) {
        new AdminPanel();
    }

    AdminPanel() {
        JLabel bg_label = new JLabel(new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/background1.png"));
        bg_label.setBounds(0, 0, 800, 800);
        bg_label.setOpaque(true);

        frame = new JFrame("AdminPanel");
        frame.setBounds(0, 0, 800, 800);
        ImageIcon icon= new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/studentrecords2.png");
        frame.setIconImage(icon.getImage());
        bg_label.setLayout(null);
        frame.setContentPane(bg_label);

        JLayeredPane login_layer = new JLayeredPane();
        login_layer.setBounds(80, 70, 550, 650);

        JLabel loginpanel = new JLabel(new ImageIcon("C:/Users/vansh/IdeaProjects/SmartStudentManagement/src/untitleddesign.png"));
        loginpanel.setBounds(80, 70, 540, 650);
        loginpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginpanel.setLayout(null);

        JLabel text = new JLabel("Admin Panel");
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        text.setOpaque(true);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Times New Roman", Font.BOLD, 20));
        text.setBackground(new Color(2, 15, 51, 3));
        text.setBounds(250, 200, 150, 50);

        username = new JTextField();
        username.setFont(new Font("Times New Roman", Font.BOLD, 20));
        username.setBounds(200, 300, 250, 30);
        username.setBackground(new Color(0x6C08083E, true));
        username.setSelectedTextColor(Color.WHITE);
        username.setForeground(Color.WHITE);
        username.setOpaque(true);

        password = new JPasswordField();
        password.setFont(new Font("Times New Roman", Font.BOLD, 25));
        password.setBounds(200, 350, 250, 30);
        password.setBackground(new Color(0xED08083E, true));
        password.setSelectedTextColor(Color.WHITE);
        password.setForeground(Color.WHITE);
        password.setOpaque(true);

        JLabel passwordlabel = new JLabel("PASSWORD :");
        passwordlabel.setBounds(110, 350, 100, 30);
        passwordlabel.setForeground(Color.WHITE);
        passwordlabel.setBackground(new Color(0x008083E, true));
        passwordlabel.setOpaque(true);

        JLabel usernamelabel = new JLabel("USERNAME  :");
        usernamelabel.setBounds(110, 300, 100, 30);
        usernamelabel.setForeground(Color.WHITE);
        usernamelabel.setBackground(new Color(0x008083E, true));
        usernamelabel.setOpaque(true);

        login = new Button("Login");
        login.setForeground(Color.WHITE);
        login.setBackground(new Color(0xEDFFCE00, true));
        login.setBounds(270, 450, 100, 30);
        login.addActionListener(this);

        login_layer.add(loginpanel, Integer.valueOf(0));
        login_layer.add(text, Integer.valueOf(1));
        login_layer.add(username, Integer.valueOf(2));
        login_layer.add(password, Integer.valueOf(3));
        login_layer.add(passwordlabel, Integer.valueOf(4));
        login_layer.add(usernamelabel, Integer.valueOf(5));
        login_layer.add(login, Integer.valueOf(6));

        frame.add(login_layer);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            name = username.getText();
            password1 = new String(password.getPassword());

            if (name.equals(USER) && password1.equals(PASSWORD)) {
                new Database();
                frame.dispose(); // ✅ Correct way to close the current frame
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Username or Password");
            }
        }
    }
}
