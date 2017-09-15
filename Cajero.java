package cajero;
import java.util.*;
import javax.swing.*;

public class Cajero {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Bienvenidos a nuestro Cajero");
		String cuenta=JOptionPane.showInputDialog("Digite su numero de cuenta : ");
		String clave=JOptionPane.showInputDialog("Digite su clave : ");
		int opcion;
		Cliente usuario=new Cliente(cuenta,clave);
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la opción deseada: \n 1. Consulta Saldo \n 2. Retiro \n 3. Deposito \n 4. Cambio de clave \n 0. Terminar "));
			if(opcion==0||opcion==1||opcion==2||opcion==3||opcion==4) {
				if(opcion==1) {
					JOptionPane.showMessageDialog(null, "Saldo : "+usuario.getSaldo());
				}if(opcion==2) {
					int retiro=Integer.parseInt(JOptionPane.showInputDialog("Valor a retirar"));
					if(retiro-usuario.getSaldo()>=0) {
						usuario.setSaldo(retiro-usuario.getSaldo());
					}else {
						JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE");
					}
					JOptionPane.showMessageDialog(null, "OPERACION REALIZADA");
				}if(opcion==3) {
					int deposito=Integer.parseInt(JOptionPane.showInputDialog("Valor a depositar"));
					usuario.setSaldo(deposito-usuario.getSaldo());
					JOptionPane.showMessageDialog(null, "OPERACION REALIZADA");
				}if(opcion==4) {
					String nuevaClave=JOptionPane.showInputDialog("Digite nueva clave : ");
					usuario.setClave(nuevaClave);
					JOptionPane.showMessageDialog(null, "OPERACION REALIZADA");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Opción incorrecta \n Intente de nuevo");
			}
		}while(opcion!=0);
		JOptionPane.showMessageDialog(null, "Gracias por usar nuestros servicios");
	}
}
