import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton is500, is1000, is2000, is5000, is10000, balanceEnquiry, back;
    String pin;

    FastCash(String pinNumber) {

        this.pin = pinNumber;

        setSize(900, 700);
        setMinimumSize(new Dimension(900, 700));
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(new BorderLayout());

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
        header.setBackground(Color.BLACK);
        header.setPreferredSize(new Dimension(0, 60));
        add(header, BorderLayout.NORTH);

        JLabel headerText = new JLabel("FAST CASH");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("Osward", Font.BOLD, 28));
        header.add(headerText);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setBackground(Color.BLACK);
        add(content, BorderLayout.CENTER);

        JLabel headerText2 = new JLabel("SELECT WITHDRAWAL AMOUNT");
        headerText2.setFont(new Font("Osward", Font.BOLD, 20));
        headerText2.setForeground(Color.WHITE);
        headerText2.setHorizontalAlignment(SwingConstants.CENTER);
        headerText2.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        content.add(headerText2, BorderLayout.NORTH);

        JPanel buttonGroups = new JPanel();
        buttonGroups.setLayout(new GridBagLayout());
        buttonGroups.setBackground(Color.black);
        content.add(buttonGroups, BorderLayout.CENTER);

        GridBagConstraints gb = new GridBagConstraints();
        gb.anchor = GridBagConstraints.NORTHWEST;
        gb.insets = new Insets(0, 25, 25, 25);

        is500 = new JButton("500");
        is500.setBackground(Color.BLACK);
        is500.setForeground(Color.white);
        is500.setFocusable(false);
        is500.setFont(new Font("Raleway", Font.BOLD, 25));
        is500.setPreferredSize(new Dimension(200, 50));
        is500.addActionListener(this);
        gb.gridx = 0;
        gb.gridy = 0;
        buttonGroups.add(is500, gb);

        is1000 = new JButton("1000");
        is1000.setBackground(Color.BLACK);
        is1000.setForeground(Color.white);
        is1000.setFocusable(false);
        is1000.setFont(new Font("Raleway", Font.BOLD, 25));
        is1000.setPreferredSize(new Dimension(200, 50));
        is1000.addActionListener(this);
        gb.gridx = 1;
        gb.gridy = 0;
        buttonGroups.add(is1000, gb);

        is2000 = new JButton("2000");
        is2000.setBackground(Color.BLACK);
        is2000.setForeground(Color.white);
        is2000.setFocusable(false);
        is2000.setFont(new Font("Raleway", Font.BOLD, 25));
        is2000.setPreferredSize(new Dimension(200, 50));
        is2000.addActionListener(this);
        gb.gridx = 0;
        gb.gridy = 1;
        buttonGroups.add(is2000, gb);

        is5000 = new JButton("5000");
        is5000.setBackground(Color.BLACK);
        is5000.setForeground(Color.white);
        is5000.setFocusable(false);
        is5000.setFont(new Font("Raleway", Font.BOLD, 25));
        is5000.setPreferredSize(new Dimension(200, 50));
        is5000.addActionListener(this);
        gb.gridx = 1;
        gb.gridy = 1;
        buttonGroups.add(is5000, gb);

        is10000 = new JButton("10000");
        is10000.setBackground(Color.BLACK);
        is10000.setForeground(Color.white);
        is10000.setFocusable(false);
        is10000.setFont(new Font("Raleway", Font.BOLD, 25));
        is10000.setPreferredSize(new Dimension(200, 50));
        is10000.addActionListener(this);
        gb.gridx = 0;
        gb.gridy = 2;
        buttonGroups.add(is10000, gb);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFocusable(false);
        back.setFont(new Font("Raleway", Font.BOLD, 25));
        back.setPreferredSize(new Dimension(200, 50));
        back.addActionListener(this);
        gb.gridx = 1;
        gb.gridy = 2;
        buttonGroups.add(back, gb);

        setVisible(true);
    }

    public static void main(String[] args) {
        new FastCash("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText();
            Date date = new Date();
            try {

                Connection connection = dataBase.getConnection();

                ResultSet rs = connection.createStatement().executeQuery("select * from bank where pin = '" + pin + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));

                    } else if (rs.getString("type").equals("withdraw")) {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if ((ae.getSource() != back) && (balance < Integer.parseInt(amount))) {

                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");

                } else {

                    String query = "insert into bank values('" + pin + "', '" + date + "', 'withdraw', '" + amount + "')";
                    connection.createStatement().executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdrawn Successfully!");

                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
