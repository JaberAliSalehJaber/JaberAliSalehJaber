import Classes.Booking;
import Classes.Controlor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.ArrayList;

public class Gui {
    private JPanel mainpanel;
    private JButton diplayHospitalsButton;
    private JPanel allSheets;
    private JPanel makeBooking;
    private JPanel displayBooking;
    private JPanel displayHospitals;
    private JPanel displayClinics;
    private JButton makeBookingButton;
    private JButton displayBookingButton;
    private JButton displayClinicsButton;
    private JButton bookButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JTextArea textArea1;
    private JButton button2;
    private JTextArea textArea2;
    private JButton button3;
    private JTextArea textArea3;
    private JLabel patient_name;
    private JLabel patient_age;
    private JLabel patient_gender;
    Controlor controlor;
    Booking booking;

    public Gui() {
        booking = new Booking();
        controlor = new Controlor();
        makeBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allSheets.removeAll();
                allSheets.add(makeBooking);
                allSheets.repaint();
                allSheets.revalidate();
            }
        });
        displayBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allSheets.removeAll();
                allSheets.add(displayBooking);
                allSheets.repaint();
                allSheets.revalidate();
                String string = "";
                ArrayList<Booking> all = controlor.getBookingArrayList();
                for (Booking b : all) {
                    if (b != null) {
                        string = string + "\n";
                    }

                }
                textArea1.setText(string);
            }
        });
        diplayHospitalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allSheets.removeAll();
                allSheets.add(displayHospitals);
                allSheets.repaint();
                allSheets.revalidate();
            }
        });
        displayClinicsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allSheets.removeAll();
                allSheets.add(displayClinics);
                allSheets.repaint();
                allSheets.revalidate();
            }
        });
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = patient_name.getText();
                int age = Integer.parseInt(patient_age.getText());
                String gender = patient_gender.getText();
                boolean added = controlor.addbook(name, age, gender);
                if (added)
                    JOptionPane.showMessageDialog(null, "added successfully");
                else
                    JOptionPane.showMessageDialog(null, "sorry try again");

            }
        });
        diplayHospitalsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea2.setText(controlor.toString());


            }
        });
        textArea2.addComponentListener(new ComponentAdapter() {

            @Override
            public String toString() {
                return super.toString();

            }

        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gui");
        frame.setContentPane(new Gui().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.pack();
        frame.setVisible(true);
        frame.setSize(400,400);
    }
}
