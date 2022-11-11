package examples;

import java.util.Date;
import java.util.Scanner;

public class CajeroAutomatico {
	public void cajero(Scanner scan) {
		String opcion = null, historico = "", uno = "\n- Consulta Saldo ", dos = "\n- Retirar Saldo ";
		Date date = new Date();
		Integer saldo = 1000, retiro = 0;
		
		while(saldo >= 0) {
			if(saldo == 0) {
				System.out.println("No se cuenta con fondos suficientes\n1 = Continuar\n2 = Salir");
				if(scan.nextInt() == 2) {
					saldo = -1;
				}
			}else {
				System.out.println("\nBienvenido Erick Duran\n1 = Consulta Saldo\n2 = Retirar Saldo\n3 = Historico de movimientos\n4 = Salir");
				opcion = scan.next();
				
				switch(opcion) {
					case "1":
						System.out.println("1.------Su saldo actual es: ".concat(saldo.toString()));
						historico+=uno.concat(" Fecha:".concat(date.toGMTString()));
						break;
					case "2":
						System.out.println("2.------Cantidad a retirar");
						retiro = scan.nextInt();
						if(retiro > saldo) {
							System.err.println("No cuenta con saldo suficiente para retirar");
						}else {
							saldo = saldo - retiro;
						}
						historico+=dos.concat(("|saldo alterior = " + (saldo+retiro)).concat(" Fecha:".concat(date.toGMTString())));
						break;
					case "3":
						System.out.println("\n3.------Movimientos:");
						System.out.println(historico);
						break;
					case "4":
						saldo = -1;
						break;
					default:
						System.out.println("Opcion no valida");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CajeroAutomatico cajero = new CajeroAutomatico();
		String pin = null;
		byte intentos = 0;
		
		do {
			System.out.println("BIENVENIDO\nIngrese PIN:");
			pin = scan.nextLine();
			if(pin.equals("1235") && intentos < 3) {
				cajero.cajero(scan);
				intentos = 3;
			}else {
				intentos++;
			}
		}while(intentos < 3 && !pin.equals("1235"));
		
		System.out.println("Hasta pronto");
		scan.close();
	}
}