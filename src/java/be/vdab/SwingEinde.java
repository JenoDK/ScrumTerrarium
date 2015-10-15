/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jonas Cromheeke;
 */
public class SwingEinde extends javax.swing.JFrame implements ActionListener{

    private JPanel paneel;
     
    private JLabel hoofding1, hoofding2, lorien, jeno, nils,  jonas, christophe, foto ;
    private JButton opnieuw;
    
    public SwingEinde() {
        initComponents();
    }

    private void initComponents() {
        
        setLayout(new FlowLayout());
        
        paneel = new JPanel(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        
        
        hoofding1 = new JLabel("Bedankt om ons spel te spelen!");
        hoofding1.setFont(new java.awt.Font("Tahoma", 1, 20));
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;        
        paneel.add(hoofding1,c);
        
        hoofding2 = new JLabel("Dit spel werd mede mogelijk gemaakt door: ");
        hoofding2.setFont(new java.awt.Font("Tahoma", 1, 16));
        c.fill = GridBagConstraints.VERTICAL;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 2; 
        paneel.add(hoofding2,c );
        
        lorien = new JLabel("Lorien Van de Roy");
        lorien.setFont(new java.awt.Font("Tahoma", 2, 12));
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 4; 
        paneel.add(lorien,c );
        
        jeno = new JLabel("Jeno De Keyzer");
        jeno.setFont(new java.awt.Font("Tahoma", 2, 12));
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 5; 
        paneel.add(jeno,c);
        
        jonas = new JLabel("Jonas Cromheeke");
        jonas.setFont(new java.awt.Font("Tahoma", 2, 12));
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 6; 
        paneel.add(jonas,c);
        
        nils = new JLabel("Nils D'hont");
        nils.setFont(new java.awt.Font("Tahoma", 2, 12));
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 7; 
        paneel.add(nils,c);
        
        christophe = new JLabel("Christophe Devos");
        christophe.setFont(new java.awt.Font("Tahoma", 2, 12));
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 8; 
        paneel.add(christophe,c);
        
        opnieuw = new JButton("Opnieuw");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 2.0;
        c.gridx = 0;
        c.gridy = 10; 
        paneel.add(opnieuw,c);
        opnieuw.addActionListener(this);
        
        foto = new JLabel();
        ImageIcon icon = new ImageIcon("D:\\cursist\\project\\ScrumTerrarium\\src\\java\\be\\vdab\\images\\welkomsmurf.png");
        
        foto.setIcon(icon);
        
        
        add(paneel);
        add(foto);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.dispose();
    }
    
    
}
