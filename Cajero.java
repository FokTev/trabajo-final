import java.util.Scanner;

public class Cajero {
 
	//Variables/objetos
	private static Cuenta[] cuentas;
	private static Scanner teclado = new Scanner(System.in);
 
	//Programa principal
	public static void main (String[] args) {
		inicializarCuentas();
		int opcion = 0;
        
        //Menú de opciones
		while (opcion != 4) {
			System.out.println("\n\t\tCAJERO AUTOMATICO");
			System.out.println("\t\t------ ----------\n");
			System.out.println("[1] Retirar saldo");
			System.out.println("[2] Depositar saldo");
			System.out.println("[3] Consultar saldo");
			System.out.println("[4] SALIR");
			System.out.print("Elija opcion: ");
			opcion = Integer.parseInt(teclado.nextLine());
            
			switch(opcion) {
			case 1:
				retirar();
				break;
			case 2:
				ingresar();
				break;
			case 3:
				consultarSaldo();
				break;
			case 4:
				System.out.println("\n\n\t\tSALIENDO...");
				break;
			default:
				System.out.println("\nOpción no válida.");
			}
		}
	}
 
	/**
	 * Inicio de array con los datos de los usuarios
	 */
	private static void inicializarCuentas() {
		cuentas = new Cuenta[7];
		cuentas[0] = new Cuenta("María Pérez", "1734", 430050.35);
		cuentas[1] = new Cuenta("Sara Vega", "0141", 35980.80);
		cuentas[2] = new Cuenta("Carmen Torres", "9876", 20459.05);
		cuentas[3] = new Cuenta("Lucho Villa", "6127", 14984.48);
		cuentas[4] = new Cuenta("Nicolas Rodriguez", "5665", 1259.90);
        cuentas[5] = new CuentaVIP("Gabriela Avendaño", "3812", 23500, 10000);
        cuentas[6] = new CuentaVIP("Juan Soliz", "4908", 340240.98, 40000);
 
	}
    
    //Métodos para las operaciones a realizar

	/**
	 * (Supongamos que se ingresa la tarjeta) El programa pide el PIN
	 * Si lo encuentra, devuelve el valor de Cuenta.
	 * Si no lo encuentra, devuelve null
	 */
	private static Cuenta buscarPorPIN() {
		System.out.println("\nIntroduzca su PIN:");
		String PIN = teclado.nextLine();
 
		//Buscamos la cuenta con el PIN puesto
		for (int i = 0; i < cuentas.length; i++)
			if (cuentas[i].getPIN().equals(PIN))
				return cuentas[i]; //Si la encontramos, devolvemos los datos
 
		//Si el bucle FOR no devuelve nada, el PIN es incorrecto y devolvemos null
		return null;
	}
 
	/**
	 * Permite retirar plata, identificamos la cuenta
	 * mediante el PIN de acceso
	 */
	private static void retirar() {
 
		Cuenta usuario = buscarPorPIN();
 
		if (usuario == null)
			System.out.println("\nPIN Incorrecto.");
		else {
            System.out.println("Bienvenido/a " + usuario.getTitular());
			System.out.print("\nCantidad a retirar: ");
			double cantidad = Double.parseDouble(teclado.nextLine());
			usuario.retirar(cantidad);
		}
	}
 
	/**
	 * Permite ingresar plata, identificamos la cuenta
	 * mediante el PIN de acceso
	 */
	private static void ingresar() {
 
		Cuenta usuario = buscarPorPIN();
 
		if (usuario == null)
			System.out.println("\nPIN Incorrecto.");
		else {
            System.out.println("Bienvenido/a " + usuario.getTitular());
			System.out.print("\nCantidad a ingresar: ");
			double cantidad = Double.parseDouble(teclado.nextLine());
			usuario.ingresar(cantidad);
		}
	}
 
	/**
	 * Permite consultar si hay plata, identificamos la cuenta
	 * mediante el PIN de acceso
	 */
	private static void consultarSaldo() {
 
		Cuenta usuario = buscarPorPIN();
 
		if (usuario == null)
			System.out.println("\nPIN Incorrecto.");
		else {
            System.out.println("Bienvenido/a " + usuario.getTitular());
			System.out.println("\nSaldo actual: " + usuario.getSaldo());
        }
	}
}