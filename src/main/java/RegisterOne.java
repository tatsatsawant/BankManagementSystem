import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RegisterOne extends JFrame {

    private static JPanel contentTwo;

    RegisterOne() {
        setSize(700, 800);
        setMinimumSize(new Dimension(900, 800));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.white);

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        header.setBackground(Color.white);
        add(header, BorderLayout.NORTH);

        Random random = new Random();
        long randomNo = (Math.abs((random.nextLong() % 9000L) + 1000L));

        JLabel formNo = new JLabel("Application Form No. " + randomNo);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setForeground(Color.black);
        header.add(formNo);

        JPanel footer = new JPanel();
        footer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        footer.setBackground(Color.white);
        add(footer, BorderLayout.SOUTH);

        JLabel pageNo = new JLabel("Page 1");
        pageNo.setFont(new Font("Raleway", Font.BOLD, 20));
        pageNo.setForeground(Color.black);
        footer.add(pageNo);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setBackground(Color.white);
        add(content, BorderLayout.CENTER);

        JPanel headerTwo = new JPanel();
        headerTwo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        headerTwo.setBackground(Color.white);
        content.add(headerTwo, BorderLayout.NORTH);

        JLabel personalDetails = new JLabel("Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBackground(Color.white);
        headerTwo.add(personalDetails);

        contentTwo = new JPanel();
        contentTwo.setLayout(new GridBagLayout());
        contentTwo.setBackground(Color.white);
        content.add(contentTwo, BorderLayout.CENTER);
        addFormField("Name:", FieldType.TEXT);
        addFormField("Father's Name:", FieldType.TEXT);
        addFormField("Date of Birth:", FieldType.DATE);
        addFormField("Gender", FieldType.DROP_DOWN_GENDER);
        addFormField("Email Address:", FieldType.TEXT);
        addFormField("Marital Status", FieldType.DROP_DOWN_STATUS);
        addFormField("Address:", FieldType.TEXT);
        addFormField("City", FieldType.TEXT);
        addFormField("State", FieldType.TEXT);
        addFormField("Pincode", FieldType.TEXT);

        JPanel rightPane = new JPanel();
        rightPane.setLayout(new BorderLayout());
        rightPane.setBackground(Color.white);
        rightPane.setPreferredSize(new Dimension(200, 200));
        add(rightPane, BorderLayout.EAST);

        JPanel rightTop = new JPanel();
        rightTop.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        rightTop.setBackground(Color.white);
        rightPane.setPreferredSize(new Dimension(150, 200));
        rightPane.add(rightTop, BorderLayout.NORTH);

        JButton next = new JButton("NEXT");
        next.setFocusable(false);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        rightTop.add(next);

        JPanel leftPane = new JPanel();
        leftPane.setLayout(new BorderLayout());
        leftPane.setBackground(Color.white);
        leftPane.setPreferredSize(new Dimension(200, 200));
        add(leftPane, BorderLayout.WEST);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterOne();
    }

    private void addFormField(String labelText, FieldType fieldType) {
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.anchor = GridBagConstraints.WEST;
        gbcLabel.insets = new Insets(10, 10, 10, 20);

        GridBagConstraints gbcField = new GridBagConstraints();
        gbcField.anchor = GridBagConstraints.WEST;
        gbcField.insets = new Insets(10, 10, 10, 10);
        gbcField.gridwidth = GridBagConstraints.REMAINDER;

        JLabel label = new JLabel(labelText);
        JComponent field;

        switch (fieldType) {
            case TEXT:
                field = new JTextField(20);
                break;
            case PASSWORD:
                field = new JPasswordField(20);
                break;
            case DATE:
                field = new JDateChooser();
                ((JDateChooser) field).setPreferredSize(new Dimension(200, 20));
                break;
            case DROP_DOWN_GENDER:
                String[] genderOptions = {"Male", "Female", "Other"};
                field = new JComboBox<>(genderOptions);
                break;
            case DROP_DOWN_STATUS:
                String[] statusOptions = {"Married", "Unmarried", "Other"};
                field = new JComboBox<>(statusOptions);
                break;
            default:
                field = new JTextField(20);
        }

        label.setBackground(Color.white);
        label.setFont(new Font("Raleway", Font.BOLD, 12));
        field.setBackground(Color.white);
        field.setFont(new Font("Raleway", Font.ITALIC, 12));
        contentTwo.add(label, gbcLabel);
        contentTwo.add(field, gbcField);
    }

    private enum FieldType {
        TEXT, PASSWORD, DATE, DROP_DOWN_GENDER, DROP_DOWN_STATUS
    }
}
