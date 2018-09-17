




package star.wars;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;





public class Space extends JPanel {

    final int marginX;
    final int marginY;
    private Hero hero;  
    private Enemy enemy;
    private Timer timer;
    
public Space() {
    super();
    marginX = 5;
    marginY = 5;
    hero = new Hero(600, 480, Color.MAGENTA, 20, "Hero");
    enemy = new Enemy(500, 500, Color.RED, 20, "Enemy");
    timer = new Timer();
    timer.scheduleAtFixedRate(new ScheduleTask(), 100, 100);
    
}
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        g.setColor(Color.YELLOW);
        drawStars(g);
        
        hero.draw(g);
        enemy.draw(g);
        //g.dispose();  
    }
    
        private class ScheduleTask extends TimerTask {
    
        @Override
        public void run() {
            hero.update();
            enemy.update();
            repaint();
        }
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.setDX(1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.setDX(-1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.setDY(-1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.setDY(1);
        }
    } 
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            hero.setDX(0);   
        if (e.getKeyCode() == KeyEvent.VK_LEFT) 
            hero.setDX(0); 
        if (e.getKeyCode() == KeyEvent.VK_UP) 
            hero.setDY(0);
        if (e.getKeyCode() == KeyEvent.VK_DOWN) 
            hero.setDY(0);   
    }
        
    
    private void drawStars(Graphics g) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 1000; i++) {
          y = (int) (Math.random()*960);
          x = (int) (Math.random()*1200);
          Color curr = g.getColor();
          if (x % 2 == 0) 
              g.setColor(curr.brighter());
          else
              g.setColor(curr.darker());
          g.fillOval(x, y, 3, 3);
          
          System.out.println(x+" "+y);
          //if ( x > 1100 || y > 860) {
           //  break;
          //}
        }
    }
}
    
