package Presentacion;

import javax.swing.*;
import java.awt.event.*;
import Logica.Parcial;

public class Interfaz extends JFrame {
	private static final long serialVersionUID = 1L;
    
    private JTextField txtBase;
    private JTextField txtExponente;
    private JLabel resultadoLabel;
    private JButton calcularBtn;
    private Parcial parcial;
    
    public Interfaz() {
        parcial = new Parcial();
    
        setTitle("calcular potenciasd");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(null); 

        JLabel baseLabel = new JLabel("Base:_");
        baseLabel.setBounds(20, 20, 80, 25);
        panel.add(baseLabel);
        
        JLabel expLabel = new JLabel("Exponente: ");
        expLabel.setBounds(20, 50, 100, 25);
        panel.add(expLabel);
        

        txtBase = new JTextField();
        txtBase.setBounds(130, 20, 120, 25);
        panel.add(txtBase);
        
        txtExponente = new JTextField();
        txtExponente.setBounds(130, 50, 120, 25);
        panel.add(txtExponente);
        
        JLabel resTexto = new JLabel("Resultado:  ");
        resTexto.setBounds(20, 90, 100, 25);
        panel.add(resTexto);
        
        resultadoLabel = new JLabel("");
        resultadoLabel.setBounds(130, 90, 150, 25);
        panel.add(resultadoLabel);
        
        calcularBtn = new JButton("Calcular");
        calcularBtn.setBounds(100, 130, 100, 25);
        calcularBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
        panel.add(calcularBtn);
        
        add(panel);
        
        setLocationRelativeTo(null);
    }
    
    private void calcular() {
        try {
            int b = Integer.parseInt(txtBase.getText());
            int e = Integer.parseInt(txtExponente.getText());
            
            int resultado = parcial.potencia(b, e);
            resultadoLabel.setText(String.valueOf(resultado));
            
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("numeros invalidos");
        } catch (IllegalArgumentException ex) {
            resultadoLabel.setText(ex.getMessage());
        } catch (ArithmeticException ex) {
            resultadoLabel.setText("estas fuera de rango, genio");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Interfaz calculadora = new Interfaz();
                calculadora.setVisible(true);
            }
        });
    }
}