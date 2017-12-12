package provaawt4;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import static java.awt.Label.CENTER;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;

/**
 *
 * @author federico.scaggiante
 */
class FramePila extends Frame implements ActionListener, ItemListener {
    Pila s;
    Button btn0;
    TextField txt0;
    Label lbl0;
    Label lbl1;
    //ci deve essere uno spazio
    Button btn1;
    //ci deve esseree un separatore
    Button btn2;
    Label lbl2;
    Button btn3;
    Choice ch0;
    //Iteratore
    Iterator it;
    public FramePila(String string, Pila s) throws HeadlessException {
        super(string);
        this.s = s;

        this.setSize(250, 250);
        this.setLocation(400, 300);
        this.setLayout(new GridLayout(5, 5));

        this.btn0 = new Button("Push");
        this.txt0 = new TextField("", CENTER);
        this.lbl0 = new Label(s.isEmpty() == false ? "" + this.s.top() : "", CENTER);
        this.lbl1 = new Label(s.isEmpty() == true ? "is Zero" : "", CENTER);
        //ci deve essere uno spazio
        Label lbls0 = new Label("", CENTER);
        this.btn1 = new Button("Pop");
        //ci deve esseree un separatore
        Label lblsep0 = new Label("---------------------------------------", CENTER);
        Label lblsep1 = new Label("---------------------------------------", CENTER);
        Label lblsep2 = new Label("---------------------------------------", CENTER);
        this.btn2 = new Button("<<");
        this.lbl2 = new Label("", CENTER);
        this.btn3 = new Button(">");
        //Spazio
        Label lbls1 = new Label("", CENTER);
        this.ch0 = new Choice();
        //aggiungo possibili elementi esistenti
        for (int i = 0; i < this.s.size(); i++) {
            this.ch0.add("" + this.s.get(i));
        }

        this.add(btn0);
        this.add(txt0);
        this.add(lbl0);
        this.add(lbl1);
        //Spazio
        this.add(lbls0);
        this.add(btn1);
        //3 separatori
        this.add(lblsep0);
        this.add(lblsep1);
        this.add(lblsep2);
        this.add(btn2);
        this.add(lbl2);
        this.add(btn3);
        //Spazio
        this.add(lbls1);
        this.add(ch0);

        this.btn0.addActionListener(this);
        this.btn1.addActionListener(this);
        this.btn2.addActionListener(this);
        this.btn3.addActionListener(this);
        this.ch0.addItemListener(this);
        //Iteratore
        it = s.iterator();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        }
        );
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        //if diverso
        /*
        if ("is Zero".equals(this.lbl1.getText())) {
            this.ch0.removeAll();
        }
         */
        if (this.s.isEmpty()) {
            this.ch0.removeAll();
        }
        if (ae.getSource() == btn0) {
            if (!"".equals(txt0.getText())) {
                this.s.push(txt0.getText());
                this.lbl0.setText("" + s.top());
                this.txt0.setText("");
                ch0.add(s.top().toString());
                //sistemo iteratore
                it = s.iterator();
                if (!lbl2.getText().equals("")) {
                    int i = 0;
                    while (!lbl2.getText().equals(it.next().toString())) {
                        i++;
                    }
                }
            }
        } else if (ae.getSource() == btn1) {
            if (this.s.isEmpty()) {

            } else {
                if (this.s.size() - 1 != 0) {
                    this.s.pop();
                    this.lbl0.setText("" + s.top());
                    this.ch0.remove(ch0.getItemCount() - 1);
                    //Sistemo Iteratore
                    it = s.iterator();
                } else {
                    this.s.pop();
                    this.lbl0.setText("");
                }
            }
            if (this.s.isEmpty()) {
                this.ch0.removeAll();
                this.lbl2.setText("");
            }
        } else if (ae.getSource() == btn2) {
            if (!s.isEmpty()) {
                it = s.iterator();
                this.lbl2.setText((String) it.next());
                this.ch0.select(0);
            } else {
                this.lbl2.setText("");
            }
        } else if (ae.getSource() == btn3) {
            if (this.s.isEmpty()) {

            } else {
                if (it.hasNext()) {
                    this.lbl2.setText((String) it.next());
                }
            }
        }
        if (s.isEmpty()) {
            lbl1.setText("is Zero");
            lbl0.setText("");
        } else {
            lbl1.setText("");
        }
    }
    @Override
    public void itemStateChanged(ItemEvent ie) {
        it = s.iterator();
        int i = 0;
        while (!ie.getItem().toString().equals(it.next().toString())) {
            i++;
        }
        //Provvisoria ma funziona
        this.lbl2.setText(s.get(s.size() - 1 - i).toString());
    }
}
//Btn1 con gestione delle eccezioni anziche if
/*
    else if (ae.getSource() == btn1) {
        this.s.pop();
				this.lbl0.setText("" + s.peek());
                                this.ch0.remove(ch0.getItemCount()-1);        
			} catch (java.lang.RuntimeException e) {
                            //Esegue il catch quando non va piu il pop e il peek
                            if(this.s.empty()){
                                    this.ch0.removeAll();
                                }
			}
    }
 */
