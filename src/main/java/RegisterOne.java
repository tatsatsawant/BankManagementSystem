import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class RegisterOne extends JFrame {

    Long randomNo;
    JTextField nameText, fatherNameText, emailText, addressText, cityText, stateText, pincodeText;
    JDateChooser date;
    JComboBox<String> maritalText, genderText;


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
        randomNo = (Math.abs((random.nextLong() % 9000L) + 1000L));

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

        JPanel contentTwo = new JPanel();
        contentTwo.setLayout(new GridBagLayout());
        contentTwo.setBackground(Color.white);
        content.add(contentTwo, BorderLayout.CENTER);

        //----------------------------------------------------
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.anchor = GridBagConstraints.WEST;
        gbcLabel.insets = new Insets(10, 10, 10, 20);

        GridBagConstraints gbcField = new GridBagConstraints();
        gbcField.anchor = GridBagConstraints.WEST;
        gbcField.insets = new Insets(10, 10, 10, 10);
        gbcField.gridwidth = GridBagConstraints.REMAINDER;
        //-----------------------------------------------------
        JLabel name = new JLabel("Name:");
        name.setBackground(Color.white);
        name.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(name, gbcLabel);

        nameText = new JTextField(20);
        nameText.setBackground(Color.white);
        nameText.setFont(new Font("Raleway", Font.ITALIC, 12));
        contentTwo.add(nameText, gbcField);

        JLabel fatherName = new JLabel("Father's Name:");
        fatherName.setBackground(Color.white);
        fatherName.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(fatherName, gbcLabel);

        fatherNameText = new JTextField(20);
        fatherNameText.setBackground(Color.white);
        fatherNameText.setFont(new Font("Raleway", Font.ITALIC, 12));
        contentTwo.add(fatherNameText, gbcField);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setBackground(Color.white);
        dob.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(dob, gbcLabel);

        date = new JDateChooser();
        date.setBackground(Color.white);
        date.setPreferredSize(new Dimension(200, 20));
        contentTwo.add(date, gbcField);

        JLabel gender = new JLabel("Gender:");
        gender.setBackground(Color.white);
        gender.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(gender, gbcLabel);

        String[] genderOptions = {"Male", "Female", "Other"};
        genderText = new JComboBox<>(genderOptions);
        genderText.setBackground(Color.white);
        genderText.setFont(new Font("Raleway", Font.ITALIC, 12));
        contentTwo.add(genderText, gbcField);

        JLabel email = new JLabel("Email Address::");
        email.setBackground(Color.white);
        email.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(email, gbcLabel);

        emailText = new JTextField(20);
        emailText.setBackground(Color.white);
        emailText.setFont(new Font("Raleway", Font.ITALIC, 12));
        contentTwo.add(emailText, gbcField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setBackground(Color.white);
        marital.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(marital, gbcLabel);

        String[] maritalOptions = {"Married", "Unmarried", "Other"};
        maritalText = new JComboBox<>(maritalOptions);
        maritalText.setBackground(Color.white);
        maritalText.setFont(new Font("Raleway", Font.ITALIC, 12));
        contentTwo.add(maritalText, gbcField);

        JLabel address = new JLabel("Address:");
        address.setBackground(Color.white);
        address.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(address, gbcLabel);

        addressText = new JTextField(20);
        addressText.setBackground(Color.white);
        addressText.setFont(new Font("Raleway", Font.ITALIC, 12));
        contentTwo.add(addressText, gbcField);

        JLabel city = new JLabel("City:");
        city.setBackground(Color.white);
        city.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(city, gbcLabel);

        cityText = new JTextField(20);
        cityText.setBackground(Color.white);
        cityText.setFont(new Font("Raleway", Font.ITALIC, 12));
        contentTwo.add(cityText, gbcField);

        JLabel state = new JLabel("State:");
        state.setBackground(Color.white);
        state.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(state, gbcLabel);

        stateText = new JTextField(20);
        stateText.setBackground(Color.white);
        stateText.setFont(new Font("Raleway", Font.ITALIC, 12));
        contentTwo.add(stateText, gbcField);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setBackground(Color.white);
        pincode.setFont(new Font("Raleway", Font.BOLD, 12));
        contentTwo.add(pincode, gbcLabel);

        pincodeText = new JTextField(20);
        pincodeText.setBackground(Color.white);
        pincodeText.setFont(new Font("Raleway", Font.ITALIC, 12));
        contentTwo.add(pincodeText, gbcField);

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

}
