/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RubikJF;

/**
 *
 * @author USUARIO
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Archivo extends JPanel
{

    private File archivo;
    private BufferedReader reader = null;
    private int[][] mat; 
    

    public void seleccionarArchivo() 
    {
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jf.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo De Texto", "txt");
        jf.setFileFilter(filter);

        if (jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            archivo = jf.getSelectedFile();
        } 
        else 
        {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }
    
    public void AbrirArchivo() 
    {
        try 
        {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)));
        } 
        catch(Exception ex) 
        {
            System.out.println("FALLA al Abrir el Archivo: '"+archivo+"' -> "+ex.getMessage());
        }
    }
    
    public int[][] LeerArchivo() 
    {
        int fil = 0, col = 0;
        String sMatrix[][] = null;
        
        try 
        {
            String linea;
            if (archivo.exists()) 
            {
                AbrirArchivo();
                
                // Contar filas y columnas
                while((linea = reader.readLine()) != null) 
                {
                    fil++;
                    StringTokenizer tokenizer = new StringTokenizer(linea, " / ");
                    if(fil == 1) 
                    {
                        col = tokenizer.countTokens();
                    }
                }
                
                reader.close();
                AbrirArchivo();

                int i = 0;
                sMatrix = new String[fil][col];
                while((linea = reader.readLine()) != null) 
                {
                    StringTokenizer tokenizer = new StringTokenizer(linea, " / ");
                    int datos = tokenizer.countTokens();
                    for(int j = 0; j < datos; j++) 
                    {
                        sMatrix[i][j] = tokenizer.nextToken();
                    }
                    i++;
                }
                
                reader.close();
            } 
            else 
            {
                System.out.println("NO se encuentra el Archivo: '"+archivo+"'..!");
            }
        } 
        catch (Exception ex) 
        {
            System.out.println("FALLA al Leer el Archivo: '"+archivo+"' -> "+ex.getMessage());
        }
        
        int Matrix[][] = new int[fil][col];
        for (int a = 0; a < sMatrix.length; a++) 
        {
            for (int b = 0; b < sMatrix[0].length; b++) 
            {
                Matrix[a][b] = Integer.parseInt(sMatrix[a][b]);
            }
        }
        return Matrix;

    }
}