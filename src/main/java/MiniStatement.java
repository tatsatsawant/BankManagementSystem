import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    private String pin;
    private JLabel cardText;
    private DefaultListModel<String> statementListModel;
    private JList<String> statementList;

    public MiniStatement(String pinNumber) {
        this.pin = pinNumber;

        int balance = calculateBalance();
        statementListModel = fetchStatementData();

        setTitle("Mini Statement");
        setLayout(new BorderLayout());
        setSize(new Dimension(400, 600));
        setMinimumSize(new Dimension(400, 600));
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);

        JLabel header = new JLabel("Swiss Bank");
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(new Font("Raleway", Font.BOLD, 25));
        header.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(header, BorderLayout.NORTH);

        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.white);
        add(content, BorderLayout.CENTER);

        cardText = new JLabel(getCardNumberText());
        cardText.setFont(new Font("Raleway", Font.BOLD, 15));
        cardText.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
        cardText.setHorizontalAlignment(SwingConstants.CENTER);
        content.add(cardText, BorderLayout.NORTH);


        statementList = new JList<>(statementListModel);
        JScrollPane scrollPane = new JScrollPane(statementList);
        scrollPane.setBackground(Color.white);
        scrollPane.setFont(new Font("Raleway", Font.ITALIC, 10));
        content.add(scrollPane, BorderLayout.CENTER);

        JLabel footer = new JLabel("Your current balance is Rs." + balance);
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setFont(new Font("Raleway", Font.BOLD, 15));
        footer.setBorder(BorderFactory.createEmptyBorder(20, 0, 50, 0));
        add(footer, BorderLayout.SOUTH);

        setVisible(true);
    }

    private int calculateBalance() {
        int calculatedBalance = 0;

        try {
            Connection connection = dataBase.getConnection();
            ResultSet rs = connection.createStatement().executeQuery("select * from bank where pin = '" + pin + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    calculatedBalance += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equals("withdraw")) {
                    calculatedBalance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return calculatedBalance;
    }

    private DefaultListModel<String> fetchStatementData() {
        DefaultListModel<String> listModel = new DefaultListModel<>();

        try {
            Connection connection = dataBase.getConnection();
            ResultSet rs = connection.createStatement().executeQuery("select * from bank where pin = '" + pin + "'");

            while (rs.next()) {
                String statementEntry = "Date: " + rs.getString("date") +
                        ", Type: " + rs.getString("type") +
                        ", Amount: " + rs.getString("amount");
                listModel.addElement(statementEntry);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return listModel;
    }

    private String getCardNumberText() {
        try {
            Connection connection = dataBase.getConnection();
            ResultSet rs = connection.createStatement().executeQuery("select * from login where pinnumber = '" + pin + "'");

            if (rs.next()) {
                String cardNumber = rs.getString("cardNumber");
                return "Card Number: " + cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return "Card Number: Not Available";
    }

    public static void main(String[] args) {
        new MiniStatement("4242");
    }
}
