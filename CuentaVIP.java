//Hereda la clase Cuenta
public class CuentaVIP extends Cuenta {
    private double limiteExtendido;

    //Constructor
    public CuentaVIP(String titular, String PIN, double saldo, double limiteExtendido) {
        super(titular, PIN, saldo);
        this.limiteExtendido = limiteExtendido;
    }
    
    //Método
    public void retirar(double cantidad) {
        if (getSaldo() - cantidad < -limiteExtendido) {
            System.out.println("\nNo tenés fondos suficientes ni con la extensión.");
        } else {
            setSaldo(getSaldo() - cantidad);
            System.out.println("\nOperación completada con extensión.");
        }
    }

    //get y set
    public double getLimiteExtendido() {
        return limiteExtendido;
    }

    public void setLimiteExtendido(double limiteExtendido) {
        this.limiteExtendido = limiteExtendido;
    }
}
