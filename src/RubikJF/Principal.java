package RubikJF;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class Principal 
{
    private Ventana ventana;
    private int n;
    private int matriz[][] = new int[n*3][n*4] ;
    
    public void Ejecutar()
    {
        ventana = new Ventana();

        while(true)
        {
            ventana.repaint();
            Retardo(250);
        }
        
    }
    public static void main(String[] args) 
    {
        new Principal().Ejecutar();
    }
    private void Retardo(int lapse)
    {
        try{Thread.sleep(lapse);}
        catch (InterruptedException ex){}
    }

    public void setMatriz(int n, int[][] matriz)
    {
        this.n = n;
        this.matriz = matriz;
    }
}