import java.awt.*;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BotonesApplet extends Applet implements ActionListener {

	/**
	 * Identificador único de serial
	 */
	private static final long serialVersionUID = 2302L;
	
	/**
	 * Declaramos las atributos o variables globales
	 */
	// Etiquetas del Applet
	private Label lblNum1, lblNum2, lblResultado;
	// Cajas de Texto del Applet
	private TextField txtNum1, txtNum2, txtResultado;
	//Botones del Applet
	private Button btnMas, btnMenos, btnMult, btnDiv, btnRaiz1, btnRaiz2, btnMayor, btnLimpiar;
	// Variable para los paneles
	private Panel pgg, pgg1, pgg2, pgg3, pgg4, pgg5;
	private double atrNum1 = 0.0, atrNum2 = 0.0, atrRes;
	
	
	/**
	 * Constructor no parametrizadode la clase.
	 * Construye la estructura del applet.
	 */
	public BotonesApplet() {
		pgg = new Panel(new GridLayout(5,1,10,10));
		pgg1 = new Panel(new GridLayout(2,2,10,10));
		pgg2 = new Panel(new GridLayout(1,3,10,10));
		pgg3 = new Panel(new GridLayout(1,2,10,10));
		pgg4 = new Panel(new GridLayout(1,3,10,10));
		pgg5 = new Panel(new GridLayout(1,2,10,10));
		
		lblNum1 = new Label("Número 1");
		lblNum2 = new Label("Número 2");
		lblResultado = new Label("Resultado");
		txtNum1 = new TextField();
		txtNum2 = new TextField();
		txtResultado = new TextField();
		txtResultado.setEditable(false);
		btnMas = new Button("Suma");
		btnMenos = new Button("Resta");
		btnMult = new Button("Multiplica");
		btnDiv = new Button("Divide");
		btnRaiz1 = new Button("Raiz de 1");
		btnRaiz2 = new Button("Raiz de 2");
		btnMayor = new Button("Mayor");
		btnLimpiar = new Button("Limpiar");
		
		pgg1.add(lblNum1);
		pgg1.add(txtNum1);
		pgg1.add(lblNum2);
		pgg1.add(txtNum2);
		
		pgg2.add(btnMas);
		pgg2.add(btnMenos);
		pgg2.add(btnMult);
		
		pgg3.add(btnDiv);
		pgg3.add(btnRaiz1);
		
		pgg4.add(btnRaiz2);
		pgg4.add(btnMayor);
		pgg4.add(btnLimpiar);
		
		pgg5.add(lblResultado);
		pgg5.add(txtResultado);
		
		pgg.add(pgg1);
		pgg.add(pgg2);
		pgg.add(pgg3);
		pgg.add(pgg4);
		pgg.add(pgg5);
		
		add(pgg);
		
		btnMas.addActionListener(this);
		btnMenos.addActionListener(this);
		btnMult.addActionListener(this);
		btnDiv.addActionListener(this);
		btnRaiz1.addActionListener(this);
		btnRaiz2.addActionListener(this);
		btnMayor.addActionListener(this);
		btnLimpiar.addActionListener(this);
		
	}
	/**
	 * sobreescritura del Metodo de inicio o arranque que ajusta el tamaño de la pantalla
	 */
	@Override
	public void init() {
		resize(280,320);
	}
	
	/**
	 * Control de eventos
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		atrNum1 = Double.parseDouble(txtNum1.getText());
		atrNum2 = Double.parseDouble(txtNum2.getText());
		
		if (e.getSource() == btnMas) {
			Sumar(atrNum1, atrNum2);
		} else if (e.getSource() == btnMenos) {
			Restar(atrNum1, atrNum2);
		} else if (e.getSource() == btnMult) {
			Multiplicar(atrNum1, atrNum2);
		} else if (e.getSource() == btnDiv) {
			Dividir(atrNum1, atrNum2);
		} else if (e.getSource() == btnRaiz1) {
			Raiz(atrNum1);
		} else if (e.getSource() == btnRaiz2) {
			Raiz(atrNum2);
		} else if (e.getSource() == btnMayor) {
			EsMayor(atrNum1, atrNum2);
		} else if (e.getSource() == btnLimpiar) {
			Limpiar();
		}
		txtResultado.setText(Double.toString(atrRes));
	}
	/**
	 * Suma dos numeros de tipo double
	 * @param prmNum1 primer numero de tipo double a sumar
	 * @param prmNum2 segundo número de tipo double a sumar
	 */
	public void Sumar(double prmNum1, double prmNum2) {
		try {
			atrRes = prmNum1 + prmNum2;
		} catch (Exception e) {
			JOptionPane.showInputDialog(e.getMessage());
		}
	}
	/**
	 * Resta dos números de tipo double
	 * @param prmNum1 primer número de tipo double a restar
	 * @param prmNum2 segundo de tipo double a restar
	 */
	public void Restar(double prmNum1, double prmNum2) {
		try {
			atrRes = prmNum1 - prmNum2;
		} catch (Exception e) {
			JOptionPane.showInputDialog(e.getMessage());
		}
	}
	/**
	 * Multiplica dos números que entran por parámetro de tipo double
	 * @param prmNum1 primer número de tipo double a multiplicar
	 * @param prmNum2 segundo número de tipo double a multiplicar
	 */
	public void Multiplicar(double prmNum1, double prmNum2) {
		try {
			atrRes = prmNum1 * prmNum2;
		} catch (Exception e) {
			JOptionPane.showInputDialog(e.getMessage());
		}
	}
	/**
	 * Divide dos número de tipo double que se reciben por parámetro
	 * @param prmNum1 Numero de tipo double que actua como dividendo 
	 * @param prmNum2 Numero de tipo double que actua como el divisor
	 */
	public void Dividir(double prmNum1, double prmNum2) {
		try {
			atrRes = prmNum1 / prmNum2;
		} catch (Exception e) {
			JOptionPane.showInputDialog(e.getMessage());
		}
	}
	/**
	 * Determina el numero mayor entre dos numeros recibidos por parámetro.
	 * @param prmNum1 numero de tipo double a comparar
	 * @param prmNum2 numero de tipo double a comparar
	 */
	public void EsMayor(double prmNum1, double prmNum2) {
		try {
			if (prmNum1 == prmNum2) {
				atrRes = 0;
			}
			if (prmNum1 > prmNum2) {
				atrRes = prmNum1;
			}
			if (prmNum2 > prmNum1) {
				atrRes = prmNum2;
			}
		} catch (Exception e) {
			JOptionPane.showInputDialog(e.getMessage());
		}
	}
	/**
	 * Calcula la raíz cuadrada de un número ingresado por parámetro.
	 * @param prmNum Numero de tipo double al cual se le calcula a raíz cuadrada.
	 */
	public void Raiz(double prmNum) {
		try {
			atrRes = Math.sqrt(prmNum);
		} catch (Exception e) {
			JOptionPane.showInputDialog(e.getMessage());
		}
	}
	/**
	 * Limpia las entradas y salidad de las cajas de texto.
	 */
	public void Limpiar() {
		txtNum1.setText("");
		txtNum2.setText("");
		txtResultado.setText(null);
	}
}
