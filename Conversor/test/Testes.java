/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import conversor.Conversor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jean.loose
 */
public class Testes {
    
    public Testes() {
    }
    
    @Test
    public void testeBinarioDecimal(){
        String binario = "10000";
        final int teste = Conversor.converteBinarioParaDecimal(binario);
        assertTrue(teste == 16);        
    }
    
     @Test
    public void testeBinarioHx(){
        String binario = "10000";
        final String teste = Conversor.converteBinarioParaHexadecimal(binario);
        assertTrue(teste.equals("10"));        
    }
    
     @Test
    public void testeBinarioOctal(){
        String binario = "10000";
        final String teste = Conversor.converteBinarioParaOctal(binario);
        assertTrue(teste.equals("20"));        
    }
    
    @Test
    public void testeDecimalBinario(){
        int decimal = 16;
        final String teste = Conversor.converteDecimalParaBinario(decimal);
        assertTrue(teste.equals("10000"));        
    }
    
     @Test
    public void testeDecimalHx(){
        int decimal = 16;
        final String teste = Conversor.converteDecimalParaBinario(decimal);
        assertTrue(teste.equals("10000"));        
    }
    
    @Test
    public void testeDecimalOc(){
        int decimal = 16;
        final String teste = Conversor.converteDecimalParaOctal(decimal);
        assertTrue(teste.equals("20"));        
    }
    
    @Test
    public void testeHxDecimal(){
        String Hx = "10";
        final int teste = Conversor.converteHexadecimalParaDecimal(Hx);
        assertTrue(teste == 16);        
    }
    
    @Test
    public void testeHxBinario(){
        String Hx = "10";
        final String teste = Conversor.converteHexadecimalParaBinario(Hx);
        assertTrue(teste.equals("10000"));        
    }
    
    @Test
    public void testeHxOctal(){
        String Hx = "10";
        final String teste = Conversor.converteHexadecimalParaOctal(Hx);
        assertTrue(teste.equals("20"));        
    }
    
    @Test
    public void testeOcDecimal(){
        String Oc = "20";
        final int teste = Conversor.converteOctalParaDecimal(Oc);
        assertTrue(teste == 16);        
    }
    
    @Test
    public void testeOcBinario(){
        String Oc = "20";
        final String teste = Conversor.converteOctalParaBinario(Oc);
        assertTrue(teste.equals("10000"));        
    }
    
    @Test
    public void testeOcHx(){
        String Oc = "20";
        final String teste = Conversor.converteOctalParaHexadecimal(Oc);
        assertTrue(teste.equals("10"));        
    }
}