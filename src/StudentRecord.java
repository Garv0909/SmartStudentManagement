import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class StudentRecord extends DatabaseConnectivity implements ActionListener {

    JComboBox<String> filterType;
    JTextField filterValue;
    JButton searchBtn, clearBtn, backbtn;
    JTable table;
    DefaultTableModel model;
    JFrame frame = new JFrame("📖 Student Record Viewer");

    public StudentRecord() {
        // Main Frame

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon= new ImageIcon("C:/Users/vansh/ideaProjects/SmartStudentManagement/src/studentrecords2.png");
        frame.setIconImage(icon.getImage());
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(230, 240, 250));

        // 🔹 Top Panel (Filters + Search)
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(60, 90, 150));
        topPanel.setPreferredSize(new Dimension(800, 100));
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JLabel title = new JLabel("🔍 Search Student Records");
        title.setFont(new Font("Times New Roman", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        topPanel.add(title);

        // Filter Controls
        filterType = new JComboBox<>(new String[]{
                "All Records",
                "By Grade",
                "By Marks",
                "By Marks > 90",
                "By Roll No",
                "By Name"
        });
        filterType.setFont(new Font("Arial", Font.PLAIN, 16));
        topPanel.add(filterType);

        filterValue = new JTextField(10);
        filterValue.setFont(new Font("Arial", Font.PLAIN, 16));
        topPanel.add(filterValue);

        searchBtn = new JButton("Search");
        searchBtn.setBackground(new Color(46, 204, 113));
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setFont(new Font("Arial", Font.BOLD, 16));
        searchBtn.addActionListener(this);
        topPanel.add(searchBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBackground(new Color(231, 76, 60));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFont(new Font("Arial", Font.BOLD, 16));
        clearBtn.addActionListener(e -> model.setRowCount(0)); // clears table
        topPanel.add(clearBtn);
         backbtn= new JButton("Back");
         backbtn.setBackground(new Color(220, 210, 63));
         backbtn.setForeground(Color.WHITE);
         backbtn.setFont(new Font("Arial", Font.BOLD, 16));
         backbtn.addActionListener(this);
         topPanel.add(backbtn);
        frame.add(topPanel, BorderLayout.NORTH);

        // 🔹 Table
        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Roll No");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Contact");
        model.addColumn("Marks");
        model.addColumn("Grade");

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(780, 650));
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backbtn) {
            new Database();
            frame.dispose();
        }
        String selectedFilter = (String) filterType.getSelectedItem();
        String query = "";
        boolean needsValue = true;

        switch (selectedFilter) {
            case "All Records":
                query = "SELECT * FROM studentinfo";
                needsValue = false;
                break;
            case "By Grade":
                query = "SELECT * FROM studentinfo WHERE grade=?";
                break;
            case "By Marks":
                query = "SELECT * FROM studentinfo WHERE marks=?";
                break;
            case "By Marks > 90":
                query = "SELECT * FROM studentinfo WHERE marks > 90";
                needsValue = false;
                break;
            case "By Roll No":
                query = "SELECT * FROM studentinfo WHERE rollno=?";
                break;
            case "By Name":
                query = "SELECT * FROM studentinfo WHERE name LIKE ?";
                break;
        }

        try {
            if (super.con == null) {
                JOptionPane.showMessageDialog(null, "❌ Database not connected!");
                return;
            }

            PreparedStatement ps = super.con.prepareStatement(query);

            if (needsValue) {
                String input = filterValue.getText().trim();

                if (selectedFilter.equals("By Name")) {
                    ps.setString(1, "%" + input + "%"); // partial search
                } else if (selectedFilter.equals("By Marks")) {
                    ps.setInt(1, Integer.parseInt(input)); // marks as int
                } else {
                    ps.setString(1, input);
                }
            }

            ResultSet rs = ps.executeQuery();

            // Clear old data
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("rollno"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("contact"),
                        rs.getString("marks"),
                        rs.getString("grade")
                });
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "❌ Error fetching records");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "⚠️ Marks must be a number!");
        }
    }

    public static void main(String[] args) {
        new StudentRecord();
    }

}

