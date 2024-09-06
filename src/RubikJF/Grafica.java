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
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Grafica extends Canvas
{
    private int Matriz[][] ;
    
    public void setMatriz(int[][] Matriz) 
    {
        this.Matriz = Matriz;
        this.repaint();
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);

        if (Matriz != null) 
        {
            int cy = (this.getHeight()-1) / Matriz.length;
            int cx = (this.getWidth()-1) / Matriz[0].length;
            Color transparente = new Color(0, 0, 0, 0);

            for(int a = 0; a < Matriz.length; a++)
            {
                for(int b = 0;b < Matriz[a].length; b++)
                {
                   switch(Matriz[a][b])
                    {
                        case 0:
                            g.setColor(transparente);
                            break;
                        case 1:
                            g.setColor(Color.YELLOW);
                            break;
                        case 2:
                            g.setColor(Color.WHITE);
                            break;
                        case 3:
                            g.setColor(Color.BLUE);
                            break;
                        case 4:
                            g.setColor(Color.ORANGE);
                            break;
                        case 5:
                            g.setColor(Color.GREEN);
                            break;
                        case 6:
                            g.setColor(Color.RED);
                            break;
                    }
                    
                    
                    g.fillRect((b*cx)+10, (a*cy)+5, cx, cy);
                    
                    if(Matriz[a][b] == 0)
                    {
                        g.setColor(transparente);
                    }
                    else
                    {
                        g.setColor(Color.BLACK);
                    }
                                        
                    g.drawRect((b*cx)+10, (a*cy)+5, cx, cy);
                    
                }

            }
        } 
    g.setColor(Color.BLACK);
    g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
    }
}