package provaawt2;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import static java.awt.Label.CENTER;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author federico.scaggiante
 */
class FrameLista extends Frame implements ActionListener {

    String name;
    ListaConcatenata c;
    int pointer;
    Button btn0;
    Label lbl0;
    Button btn2;
    Button btn3;
    Label lbl1;
    Button btn5;
    Button btn6;
    TextField txt0;
    Button btn8;
    //Button btn9;

    public FrameLista(String name, ListaConcatenata c) {
        this.name = name;
        this.c = c;

        this.setSize(300, 300);
        this.setLocation(400, 300);
        this.setLayout(new GridLayout(3, 3));

        this.btn0 = new Button("<<");
        this.lbl0 = new Label("" + c.size(), CENTER);
        this.btn2 = new Button(">>");
        this.btn3 = new Button("<");
        this.lbl1 = new Label("", CENTER);
        this.btn5 = new Button(">");
        this.btn6 = new Button("ADD");
        this.txt0 = new TextField("", CENTER);
        this.btn8 = new Button("DEL");
        //this.btn9 = new Button("INS");

        this.add(btn0);
        this.add(lbl0);
        this.add(btn2);
        this.add(btn3);
        this.add(lbl1);
        this.add(btn5);
        this.add(btn6);
        this.add(txt0);
        this.add(btn8);
        //this.add(btn9);

        this.setBackground(Color.GREEN);
        this.btn0.setBackground(Color.GREEN);
        this.lbl0.setBackground(Color.lightGray);
        this.btn2.setBackground(Color.GREEN);
        this.btn3.setBackground(Color.GREEN);
        this.lbl1.setBackground(Color.lightGray);
        this.btn5.setBackground(Color.GREEN);
        this.btn6.setBackground(Color.GREEN);
        this.txt0.setBackground(Color.lightGray);
        this.btn8.setBackground(Color.GREEN);
        //this.btn9.setBackground(Color.GREEN);

        this.btn0.addActionListener(this);
        this.btn2.addActionListener(this);
        this.btn3.addActionListener(this);
        this.btn5.addActionListener(this);
        this.btn6.addActionListener(this);
        this.btn8.addActionListener(this);
        //this.btn9.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        }
        );
    }

    public void printOut() {
        PrintWriter p;
        try {
            p = new PrintWriter("Output.txt");
            p.println(c.toString());
            p.close();
        } catch (FileNotFoundException ex) {
            System.err.println("File not Found");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn0) {
            this.pointer = 0;
            this.lbl1.setText("" + c.get(pointer));
            this.btn0.setBackground(Color.RED);
            this.btn3.setBackground(Color.RED);
            this.btn2.setBackground(Color.GREEN);
            this.btn5.setBackground(Color.GREEN);
        } else if (e.getSource() == btn2) {
            this.pointer = c.size() - 1;
            lbl1.setText("" + c.get(pointer));
            this.btn2.setBackground(Color.RED);
            this.btn5.setBackground(Color.RED);
            this.btn0.setBackground(Color.GREEN);
            this.btn3.setBackground(Color.GREEN);
        } else if (e.getSource() == btn3) {
            if (pointer - 1 <= 0) {
                this.pointer = 0;
                this.btn2.setBackground(Color.GREEN);
                this.btn5.setBackground(Color.GREEN);
                this.btn0.setBackground(Color.RED);
                this.btn3.setBackground(Color.RED);
            } else {
                this.pointer = this.pointer - 1;
                this.btn0.setBackground(Color.GREEN);
                this.btn2.setBackground(Color.GREEN);
                this.btn3.setBackground(Color.GREEN);
                this.btn5.setBackground(Color.GREEN);
            }
            if (c.size() > 1) {
                this.btn8.setBackground(Color.GREEN);
            }
            if (c.size() <= 1) {
                this.btn8.setBackground(Color.RED);
            }
            lbl1.setText("" + c.get(pointer));
        } else if (e.getSource() == btn5) {
            if (pointer + 1 >= c.size() - 1) {
                this.pointer = c.size() - 1;
                this.btn0.setBackground(Color.GREEN);
                this.btn3.setBackground(Color.GREEN);
                this.btn2.setBackground(Color.RED);
                this.btn5.setBackground(Color.RED);
            } else {
                this.pointer = this.pointer + 1;
                this.btn2.setBackground(Color.GREEN);
                this.btn5.setBackground(Color.GREEN);
                this.btn0.setBackground(Color.GREEN);
                this.btn3.setBackground(Color.GREEN);
            }
            if (c.size() > 1) {
                this.btn8.setBackground(Color.GREEN);
            }
            if (c.size() <= 1) {
                this.btn8.setBackground(Color.RED);
            }
            lbl1.setText("" + c.get(pointer));
        } else if (e.getSource() == btn6) {
            if (!"".equals(txt0.getText())) {
                c.addTail(txt0.getText());
                txt0.setText("");
                this.lbl0.setText("" + c.size());
                this.pointer = c.size() - 1;
                this.lbl1.setText("" + c.get(pointer));
                this.btn2.setBackground(Color.RED);
                this.btn5.setBackground(Color.RED);
                this.btn0.setBackground(Color.GREEN);
                this.btn3.setBackground(Color.GREEN);
            }
            if (c.size() > 1) {
                this.btn8.setBackground(Color.GREEN);
            }
            if (c.size() <= 1) {
                this.btn8.setBackground(Color.RED);
            }
        } else if (e.getSource() == btn8) {
            if (c.size() - 1 > 0) {
                if (pointer - 1 < 0) {
                    this.c.removeHead();
                    this.lbl0.setText("" + c.size());
                    this.pointer = 0;
                    lbl1.setText("" + c.get(pointer));
                    this.btn2.setBackground(Color.GREEN);
                    this.btn5.setBackground(Color.GREEN);
                    this.btn0.setBackground(Color.RED);
                    this.btn3.setBackground(Color.RED);
                } else if (pointer - 1 > 0) {
                    this.c.remove(pointer);
                    this.lbl0.setText("" + c.size());
                    this.pointer = this.pointer - 1;
                    lbl1.setText("" + c.get(pointer));
                    if (pointer == c.size() - 1) {
                        this.btn2.setBackground(Color.RED);
                        this.btn5.setBackground(Color.RED);
                        this.btn0.setBackground(Color.GREEN);
                        this.btn3.setBackground(Color.GREEN);
                    } else {
                        this.btn2.setBackground(Color.GREEN);
                        this.btn5.setBackground(Color.GREEN);
                        this.btn0.setBackground(Color.GREEN);
                        this.btn3.setBackground(Color.GREEN);
                    }
                } else {
                    this.c.remove(pointer);
                    this.lbl0.setText("" + c.size());
                    this.pointer = this.pointer - 1;
                    lbl1.setText("" + c.get(pointer));
                    this.btn2.setBackground(Color.GREEN);
                    this.btn5.setBackground(Color.GREEN);
                    this.btn0.setBackground(Color.RED);
                    this.btn3.setBackground(Color.RED);
                }
            } else {
                this.btn8.setBackground(Color.RED);
            }
            if (c.size() <= 1) {
                this.btn8.setBackground(Color.RED);
            }
        }/*else if(e.getSource() == btn9){
            c.add(pointer,txt0.getText());
            this.lbl0.setText(""+c.size());
            pointer=pointer-2;
            lbl1.setText(""+c.get(pointer));
            this.txt0.setText("");
            if(pointer>=c.size()){
                this.btn2.setBackground(Color.RED);
                this.btn5.setBackground(Color.RED);
                this.btn0.setBackground(Color.GREEN);
                this.btn3.setBackground(Color.GREEN);
            }else{
                this.btn2.setBackground(Color.GREEN);
                this.btn5.setBackground(Color.GREEN);
                this.btn0.setBackground(Color.GREEN);
                this.btn3.setBackground(Color.GREEN);
            }
        }*/
        printOut();
    }
}
