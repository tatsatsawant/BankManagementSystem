import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JButton withdraw, back;
    String pin;
    JTextField amount;

    Withdrawal(String pinNumber) {

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

        JLabel headerText = new JLabel("Cash Withdrawal");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("Osward", Font.BOLD, 28));
        header.add(headerText);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setBackground(Color.BLACK);
        add(content, BorderLayout.CENTER);

        JLabel headerText2 = new JLabel("Please Enter Withdraw Amount");
        headerText2.setFont(new Font("Osward", Font.BOLD, 20));
        headerText2.setForeground(Color.WHITE);
        headerText2.setHorizontalAlignment(SwingConstants.CENTER);
        headerText2.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        content.add(headerText2, BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setPreferredSize(new Dimension(200, 40));
        center.setBackground(Color.black);
        center.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
        content.add(center, BorderLayout.CENTER);

        amount = new JTextField("");
        amount.setSize(new Dimension(600, 100));
        amount.setPreferredSize(new Dimension(400, 75));
        amount.setForeground(Color.white);
        amount.setBackground(Color.black);
        amount.setHorizontalAlignment(SwingConstants.CENTER);
        amount.setMargin(new Insets(5, 10, 5, 10));
        amount.setFont(new Font("Osward", Font.BOLD, 35));
        center.add(amount);

        JPanel footer = new JPanel();
        footer.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 175));
        footer.setBackground(null);
        content.add(footer, BorderLayout.SOUTH);

        withdraw = new JButton();
        withdraw = new JButton("Withdraw");
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.white);
        withdraw.setPreferredSize(new Dimension(200, 50));
        withdraw.setFocusable(false);
        withdraw.setFont(new Font("Raleway", Font.BOLD, 24));

        withdraw.addActionListener(this);
        footer.add(withdraw);

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
        new Withdrawal("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {

            setVisible(false);
            new Transaction(pin).setVisible(true);
        } else if (ae.getSource() == withdraw) {
            String amountEntered = amount.getText();
            Date date = new Date();

            if (amountEntered.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw!");
            } else {
                try {
                    Connection connection = dataBase.getConnection();
                    String query = "INSERT INTO public.bank(\n" +
                            "\tpin, date, type, amount)\n" +
                            "\tVALUES (?, ?, ?, ?);";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, pin);
                    preparedStatement.setString(2, String.valueOf(date));
                    preparedStatement.setString(3, "withdraw");
                    preparedStatement.setString(4, amountEntered);
                    preparedStatement.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Rs. " + amountEntered + " Withdrawn Successfully!");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}
