/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import be.vdab.entities.Carnivoor;
import be.vdab.entities.Herbivoor;
import be.vdab.entities.Omnivoor;
import be.vdab.entities.Organisme;
import be.vdab.entities.Plant;
import be.vdab.entities.Terrarium;
import be.vdab.services.SpelService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
public class SwingTerrarium extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form SwingTerrarium
     */
    private static final int DEFAULT_GROOTTE = 6;
    private JPanel paneel, paneel2;
    private SpelService service;
    private Terrarium terrarium;
    private int grootte, aantalPlanten, aantalExtraPlanten, aantalHerbivoren, aantalCarnivoren, aantalOmnivoren;
    private JLabel label, dag;
    private JButton volgendeDag, stoppen, opnieuw;
    private Organisme[][] array;

    public SwingTerrarium(int grootte, int aantalPlanten, int aantalExtraPlanten, int aantalHerbivoren, int aantalCarnivoren, int aantalOmnivoren) {
        this.grootte = grootte;
        this.aantalPlanten = aantalPlanten;
        this.aantalExtraPlanten = aantalExtraPlanten;
        this.aantalHerbivoren = aantalHerbivoren;
        this.aantalCarnivoren = aantalCarnivoren;
        this.aantalOmnivoren = aantalOmnivoren;
        service = new SpelService(grootte, aantalPlanten,
                aantalExtraPlanten, aantalHerbivoren, aantalCarnivoren, aantalOmnivoren);
        terrarium = service.getTerrarium();
        initComponents();

    }

    private void initComponents() {
        paneel = new JPanel(new GridLayout(grootte, grootte));
        paneel.setPreferredSize(new Dimension(600, 600));
        array = terrarium.getArray();

        print();

        paneel2 = new JPanel(new FlowLayout());

        volgendeDag = new JButton("Volgende dag");
        stoppen = new JButton("Stop");
        opnieuw = new JButton("Opnieuw");

        paneel2.add(volgendeDag);
        paneel2.add(stoppen);
        paneel2.add(opnieuw);
        volgendeDag.addActionListener(this);
        stoppen.addActionListener(this);
        opnieuw.addActionListener(this);

        dag = new JLabel("Dag: " + terrarium.getDag());
        
        this.setLayout(new BorderLayout());
        dag.setBackground(Color.WHITE);
        paneel.setBackground(Color.WHITE);
        paneel2.setBackground(Color.WHITE);
        add(dag, BorderLayout.NORTH);
        add(paneel, BorderLayout.CENTER);
        add(paneel2, BorderLayout.SOUTH);
        
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == volgendeDag) {
            service.nieuweDag();
            terrarium = service.getTerrarium();
            array = terrarium.getArray();
            dag.setText("Dag: " + terrarium.getDag());
            this.getContentPane().remove(paneel);
            paneel.removeAll();
            print();
            add(paneel, BorderLayout.CENTER);
            this.setVisible(true);

        } else if (e.getSource() == stoppen) {
            SwingEinde einde = new SwingEinde();
            this.dispose();
        } else {
            this.dispose();
        }
    }

    private void print() {
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array.length; x++) {
                label = new JLabel();
                if (array[x][y] instanceof Plant) {
                    label = new JLabel();
                    ImageIcon icon = new ImageIcon("D:\\cursist\\project\\ScrumTerrarium\\src\\java\\be\\vdab\\images\\besjes.png");
                    label.setIcon(icon);

                    //label.setSize(40, 40);
                    paneel.add(label);
                } else if (array[x][y] instanceof Herbivoor) {
                    label = new JLabel();
                    ImageIcon icon = new ImageIcon("D:\\cursist\\project\\ScrumTerrarium\\src\\java\\be\\vdab\\images\\smurf.png");
                    label.setIcon(icon);
                    paneel.add(label);
                } else if (array[x][y] instanceof Carnivoor) {
                    label = new JLabel();
                    ImageIcon icon = new ImageIcon("D:\\cursist\\project\\ScrumTerrarium\\src\\java\\be\\vdab\\images\\azreal.png");
                    label.setIcon(icon);
                    paneel.add(label);
                } else if (array[x][y] instanceof Omnivoor) {
                    label = new JLabel();
                    ImageIcon icon = new ImageIcon("D:\\cursist\\project\\ScrumTerrarium\\src\\java\\be\\vdab\\images\\gargamel.png");
                    label.setIcon(icon);
                    paneel.add(label);
                } else {
                    label = new JLabel();
                    ImageIcon icon = new ImageIcon("D:\\cursist\\project\\ScrumTerrarium\\src\\java\\be\\vdab\\images\\aarde.png");
                    label.setIcon(icon);
                    paneel.add(label);
                }

            }
        }
    }

}
