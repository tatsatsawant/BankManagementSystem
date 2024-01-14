import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class BalanceInquiry extends JFrame implements ActionListener {

    String pin;
    JButton back;

    BalanceInquiry(String pinNumber) {
        this.pin = pinNumber;
        int balance = 0;

        try {

            Connection connection = dataBase.getConnection();

            ResultSet rs = connection.createStatement().executeQuery("select * from bank where pin = '" + pin + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));

                } else if (rs.getString("type").equals("withdraw")) {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

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

        JLabel headerText = new JLabel("Balance Inquiry");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("Osward", Font.BOLD, 28));
        header.add(headerText);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setBackground(Color.BLACK);
        add(content, BorderLayout.CENTER);

        JLabel headerText2 = new JLabel("Your current balance is Rs." + balance);
        headerText2.setFont(new Font("Osward", Font.BOLD, 20));
        headerText2.setForeground(Color.WHITE);
        headerText2.setHorizontalAlignment(SwingConstants.CENTER);
        headerText2.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        content.add(headerText2, BorderLayout.CENTER);


        JPanel footer = new JPanel();
        footer.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        footer.setBackground(Color.black);
        add(footer, BorderLayout.SOUTH);

        back = new JButton();
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFocusable(false);
        back.setFont(new Font("Raleway", Font.BOLD, 24));
        back.setPreferredSize(new Dimension(200, 50));
        back.addActionListener(this);
        footer.add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceInquiry("");
    }

    public void actionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }
}
