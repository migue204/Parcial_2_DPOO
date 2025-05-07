package Logica;

public class Parcial {

    public int potencia(int b, int e) {

        if (e < 0) {
            throw new IllegalArgumentException("no puede ser negativo el exponente");
        }
        if (e == 0) {
            return 1;
        }
        if (b == 0) {
            return 0;
        }
        if (b == 1) {
            return 1;
        }
        long resultado = 1;
        
        for (int i = 0; i < e; i++) {
            resultado *= b;
    
            if (resultado > Integer.MAX_VALUE || resultado < Integer.MIN_VALUE) {
                throw new ArithmeticException(" excede el rango de integer");
            }
        }
        
        return (int) resultado;
    }
}