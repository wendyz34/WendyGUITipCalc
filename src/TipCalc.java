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
    private JTextArea TipAmount;
    private JTextArea totalBill;
    private JLabel tip;
    private JLabel numPeople;
    private JButton addTip;
    private JTextArea textAreaP;
    private JTextArea textAreaT;
    private JTextArea textAreaB;
    private TipCalculator calc;
    private double bill;
    private int tipP;
    private int people;

    public TipCalc() {
        createUIComponents();
        bill = Double.parseDouble(textAreaB.getText());
        tipP = Integer.parseInt(textAreaT.getText());
        people = Integer.parseInt(textAreaP.getText());
        calc = new TipCalculator(bill, tipP, people);
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
        /*textAreaP.addKeyListener(this);
        textAreaT.addKeyListener(this);
        textAreaB.addKeyListener(this);*/
        setVisible(true);


    }

   @Override
   public void actionPerformed(ActionEvent e){
       Object source = e.getSource();
       if(source instanceof JButton){
           JButton button = (JButton) source;
           String text = button.getText();
           if(text.equals("sub") && tipP!= 0){
               tipP--;
               textAreaT.setText("" + tipP);
               calc.setTipPercentage(tipP);
           }
           if(text.equals("add")){
               tipP++;
               calc.setTipPercentage(tipP);
               textAreaT.setText("" + tipP);
           }
           if(text.equals("subP") && people != 0){
               people--;
               calc.setNumberOfPeople(people);
               textAreaP.setText("" + people);
           }
           if(text.equals("addP")){
               people++;
               calc.setNumberOfPeople(people);
               textAreaP.setText("" + people);
           }
       }
       bill = Double.parseDouble(textAreaB.getText());
      // TipAmount.setText("" + calc.calculateTip());
       //totalBill.setText("" + calc.totalBill());
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
