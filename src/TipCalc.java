import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class TipCalc extends JFrame implements ActionListener, KeyListener {
    private JPanel TipCalc;
    private JButton subPeople;
    private JButton addPeople;
    private JButton subTip;
    private JTextField textField3;
    private JTextArea TipAmount;
    private JTextArea totalBill;
    private JLabel tip;
    private JLabel numPeople;
    private JButton addTip;
    private JTextArea textAreaP;
    private JTextArea textAreaT;
    private TipCalculator calc;
    private double bill;
    private int tipP;
    private int people;

    public TipCalc() {
        createUIComponents();
        bill = Double.parseDouble(textField3.getText());
        tipP = Integer.parseInt(textAreaT.getText());
        people = Integer.parseInt(textAreaP.getText());
        calc = null;
    }

    public void createUIComponents() {
        setContentPane(TipCalc);
        setTitle("MY GUI!");
        setSize(500, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        subPeople.addActionListener(this);
        addPeople.addActionListener(this);
        addTip.addActionListener(this);
        subTip.addActionListener(this);
        textAreaP.addKeyListener(this);
        textAreaT.addKeyListener(this);
        setVisible(true);


    }

   @Override
   public void actionPerformed(ActionEvent e){
       Object source = e.getSource();
       if(source instanceof JButton){
           JButton button = (JButton) source;
           String text = button.getText();
           if(text.equals("-") && tipP!= 0){
               tipP--;
               calc.setTipPercentage(tipP);
               textAreaT.setText("" + tipP);
           }else if(text.equals("+")){
               calc.setTipPercentage(tipP++);
               textAreaT.setText("" + tipP);
           }else if(text.equals("--") && people != 0){
               calc.setNumberOfPeople(people--);
               textAreaP.setText("" + people);
           }else if(text.equals("++")){
               calc.setNumberOfPeople(people++);
               textAreaP.setText("" + people);
           }
       }
       bill = Double.parseDouble(textField3.getText());
       calc = new TipCalculator(bill, tipP, people);
       TipAmount.setText("" + calc.tipPerPerson());
       totalBill.setText("" + calc.totalBill());
   }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


}
