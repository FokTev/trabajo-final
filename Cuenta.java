public class Cuenta {
	//Atributos de clase
    private String titular;
    private String PIN;
    private double saldo;
 
    //Constructor
    public Cuenta(String titular, String PIN, double saldo) {
        this.titular = titular;
        this.PIN = PIN;
        if (saldo < 0) //para que no se inicie con saldo negativo
            this.saldo = 0;
        else
            this.saldo = saldo;
    }
 
    //get y set
    public String getTitular() {
        return titular;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getPIN() {
    	return PIN;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setPIN(String PIN) {
    	this.PIN = PIN;
    }
 
    //Métodos para las operaciones con Cuenta
    public void ingresar(double cantidad) {
        if (cantidad > 0) {
        	saldo += cantidad;
        	System.out.println("\nOperación completada.");
        }
        else
        	System.out.println("\nLa cantidad ingresada debe ser un monto positivo.");
    }
 
    public void retirar(double cantidad) {
        if (saldo - cantidad < 0)
        	System.out.println("\nNo tenés saldo suficiente para la extracción.");
        else {
        	saldo -= cantidad;
        	System.out.println("\nOperación completada.");
        }
    }
}