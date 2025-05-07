package Test;

import org.junit.jupiter.api.Test;

import Logica.Parcial;

import static org.junit.jupiter.api.Assertions.*;

class ParcialTest {
    
    private final Parcial parcial = new Parcial();
    
    @Test
    void testExponenteCero() {
        assertEquals(1, parcial.potencia(7, 0));
        assertEquals(1, parcial.potencia(0, 0));
        assertEquals(1, parcial.potencia(-5, 0));
    } //cualquier numero elevado a 0 es 1, test del caso
    
    @Test
    void testBaseCero() {
        assertEquals(0, parcial.potencia(0, 3));
        assertEquals(0, parcial.potencia(0, 9));
    }//0 como base, elevado a cualquier numero que sea positivo es 0, test del caso
    
    @Test
    void testBaseUno() {
        assertEquals(1, parcial.potencia(1, 15));
        assertEquals(1, parcial.potencia(1, 1));
        assertEquals(1, parcial.potencia(1, 43));
    }// 1 elevado a cualquier numero positivo es uno, test del caso
    
    @Test
    void testPotenciasPositivas() {
        assertEquals(9, parcial.potencia(3, 2));
        assertEquals(32, parcial.potencia(2, 5));
        assertEquals(64, parcial.potencia(4, 3));
        assertEquals(343, parcial.potencia(7, 3));
    }//test de potencias con valores positivos
    
    @Test
    void testBaseNegativa() {
        assertEquals(9, parcial.potencia(-3, 2));  
        assertEquals(-27, parcial.potencia(-3, 3));
        assertEquals(81, parcial.potencia(-3, 4)); 
    }// test de potencias con bases negativas, (cuando la potencia es impar, el resultado es negativo)
    
    @Test
    void testExponenteNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            parcial.potencia(3, -5);
        });
        
        String mensajeEsperado = "no puede ser negativo el expo";
        String mensajeActual = exception.getMessage();
        assertTrue(mensajeActual.contains(mensajeEsperado));
    }//excepciones cuando exponente negativo
    
    @Test
    void testDesbordamiento() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            parcial.potencia(99999, 2);
        });
        
        String mensajeEsperado = "excede el rago de integer";
        String mensajeActual = exception.getMessage();
        assertTrue(mensajeActual.contains(mensajeEsperado));
    }//excepcion cuando excedemos integer
}
