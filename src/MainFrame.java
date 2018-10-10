import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JButton jbtnrun=new JButton("RUN");
    private JButton jbtnreset=new JButton("RESET");
    private JButton jbtnexit=new JButton("EXIT");
    private Container cp;
    private JButton jbtns[][]=new JButton[3][3];
    private JPanel A =new JPanel(new GridLayout(3,3,3,3));
    private JPanel B =new JPanel(new GridLayout(3,1,3,3));
    private boolean buttn=true;
    public MainFrame() {
        init();
    }
    private void init(){
        this.setDefaultCloseOperation(3);//設定關閉視窗的按鈕
        this.setLayout(null);//設置布局為空
        this.setBounds(100,100,700,500);//設置介面大小

        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));

        cp.add(A,BorderLayout.CENTER);
        cp.add(B,BorderLayout.EAST);

        B.add(jbtnrun);
        B.add(jbtnreset);
        B.add(jbtnexit);

        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                jbtns [i][j]=new JButton();
                jbtns [i][j].setBackground(new Color(55,251,195));
                jbtns[i][j].setFont(new Font(null,Font.BOLD,72));
                jbtns[i][j].setEnabled(false);
                jbtns [i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton touch=(JButton)e.getSource();
                        if (touch.getText().equals("")){
                            if (buttn){
                                touch.setText("O");
                                touch.setBackground(new Color(251,225,83));
                            }
                            else {
                                touch.setText("X");
                                touch.setBackground(new Color(107,251,93));
                            }
                            buttn=!buttn;
                        }
                        chack();
                    }
                });
                A.add(jbtns[i][j]);
            }
        }
        jbtnrun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        jbtns[i][j].setEnabled(true);
                    }
                }
            }
        });
        jbtnreset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        jbtns[i][j].setText("");
                        jbtns[i][j].setEnabled(false);
                        jbtns[i][j].setBackground(new Color(55,251,195));
                    }
                }
            }
        });

        jbtnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
    private void chack(){

        if (jbtns[0][0].getText().equals(jbtns[0][1].getText() )&&jbtns[0][0].getText().equals(jbtns[0][2].getText())&&!jbtns[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,jbtns[0][0].getText()+"win");}
        if (jbtns[0][0].getText().equals(jbtns[1][1].getText() )&&jbtns[0][0].getText().equals(jbtns[2][2].getText())&&!jbtns[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,jbtns[0][0].getText()+"win");}
        if (jbtns[1][0].getText().equals(jbtns[1][1].getText() )&&jbtns[1][0].getText().equals(jbtns[1][2].getText())&&!jbtns[1][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,jbtns[1][0].getText()+"win");}
        if (jbtns[2][0].getText().equals(jbtns[2][1].getText() )&&jbtns[2][0].getText().equals(jbtns[2][2].getText())&&!jbtns[2][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,jbtns[2][0].getText()+"win");}
        if (jbtns[0][0].getText().equals(jbtns[1][0].getText() )&&jbtns[0][0].getText().equals(jbtns[2][0].getText())&&!jbtns[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,jbtns[0][0].getText()+"win");}
        if (jbtns[0][1].getText().equals(jbtns[1][1].getText() )&&jbtns[0][1].getText().equals(jbtns[2][1].getText())&&!jbtns[0][1].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,jbtns[0][1].getText()+"win");}
        if (jbtns[0][2].getText().equals(jbtns[1][2].getText() )&&jbtns[0][2].getText().equals(jbtns[2][2].getText())&&!jbtns[0][2].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,jbtns[0][2].getText()+"win");}
        if (jbtns[0][2].getText().equals(jbtns[1][1].getText() )&&jbtns[0][2].getText().equals(jbtns[2][0].getText())&&!jbtns[0][2].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,jbtns[0][2].getText()+"win");}

    }
}
