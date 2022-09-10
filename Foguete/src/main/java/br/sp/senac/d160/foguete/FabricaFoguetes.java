
package br.sp.senac.d160.foguete;

/**
 *
 * @author wallace.waraujo
 */
public class FabricaFoguetes {
    
    public static void main(String[] args){
        Foguete foguete01 = new Foguete();
        foguete01.setCor("Prata");
        
        
        Foguete foguete02 = new Foguete();
        foguete02.setCor("Inox");
        
        System.out.println("A cor do primeiro foguete é: "+foguete01.getCor());
        System.out.println("A cor do segundo foguete é: "+foguete02.getCor());
        
        
        
    }
    
}
