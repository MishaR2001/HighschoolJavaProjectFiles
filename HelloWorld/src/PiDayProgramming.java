import java.awt.*;
import javax.swing.*;

public class PiDayProgramming extends JPanel {

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawRect(0, 0, 400, 400);

    int numberOfTrials = 990000000;

    int numberOfSuccesses = 0;
    double x = 0, y = 0; // coordinates
    double result = 0.0;

//  $$$$$$$$\                                         $$\                             $$\   
//  $$  _____|                                        \__|                          $$$$ |  
//  $$ |      $$\   $$\  $$$$$$\   $$$$$$\   $$$$$$$\ $$\  $$$$$$$\  $$$$$$\        \_$$ |  
//  $$$$$\    \$$\ $$  |$$  __$$\ $$  __$$\ $$  _____|$$ |$$  _____|$$  __$$\         $$ |  
//  $$  __|    \$$$$  / $$$$$$$$ |$$ |  \__|$$ /      $$ |\$$$$$$\  $$$$$$$$ |        $$ |  
//  $$ |       $$  $$<  $$   ____|$$ |      $$ |      $$ | \____$$\ $$   ____|        $$ |  
//  $$$$$$$$\ $$  /\$$\ \$$$$$$$\ $$ |      \$$$$$$$\ $$ |$$$$$$$  |\$$$$$$$\       $$$$$$\ 
//  \________|\__/  \__| \_______|\__|       \_______|\__|\_______/  \_______|      \______|

      // - write a for loop to iterate numberOfTrials times
      // - generate 2 random double values between 0.0 and 400.0
      //   and assign them to x and y
      // - if the distance from point (x,y) to (0,0) is less than 400
      //   then increment numberOfSuccesses .. hint: use the distance formula
      //        and draw a point at (x,y) .. see the g.fillRect below ..
      // - you should see a quarter of a circle in the window
      
      //YOUR CODE GOES HERE 
    for(int i = 0; i < numberOfTrials; i++) {
    	x=(Math.random()*400);
    	y=(Math.random()*400);
    	double d = Math.sqrt(Math.pow((x-0), 2)+Math.pow((y-0), 2));
    	if(d<400) { 
    		numberOfSuccesses++;
    		g.fillRect((int)x,(int)y,1,1);
    	}
    	  
    }
    
      //g.fillRect((int)x,(int)y,1,1); // draws the point (x,y)


    // after the loop...
    // calculate the ratio of numberOfSuccesses to the numberOfTrials,
    // multiply it by 4 and assign it to variable result
    
    result = ((double)numberOfSuccesses/numberOfTrials)*4;

    result = (int) (100.0 * result + 0.5) / 100.0; // round to two decimal places
    g.drawString("Circle dots approximation for \u03C0 ...  " + result, 50, 420);

    g.drawString("Leibniz approximation for \u03C0 ...      " + leibniz(numberOfTrials), 50, 440);

    // please try increasing the numberOfTtrials
  }

//  $$$$$$$$\                                         $$\                            $$$$$$\  
//  $$  _____|                                        \__|                          $$  __$$\ 
//  $$ |      $$\   $$\  $$$$$$\   $$$$$$\   $$$$$$$\ $$\  $$$$$$$\  $$$$$$\        \__/  $$ |
//  $$$$$\    \$$\ $$  |$$  __$$\ $$  __$$\ $$  _____|$$ |$$  _____|$$  __$$\        $$$$$$  |
//  $$  __|    \$$$$  / $$$$$$$$ |$$ |  \__|$$ /      $$ |\$$$$$$\  $$$$$$$$ |      $$  ____/ 
//  $$ |       $$  $$<  $$   ____|$$ |      $$ |      $$ | \____$$\ $$   ____|      $$ |      
//  $$$$$$$$\ $$  /\$$\ \$$$$$$$\ $$ |      \$$$$$$$\ $$ |$$$$$$$  |\$$$$$$$\       $$$$$$$$\ 
//  \________|\__/  \__| \_______|\__|       \_______|\__|\_______/  \_______|      \________|
                                                                                          
                                                                                          
  // look up on wikipedia the formula Leibniz discovered to approximate pi
  // write a for loop ... for(int i = 0; i < n; i++) {
  // and add the n terms in the alternating series 
  // .. you MUST use variable sum ..

  public double leibniz(int n) {
    double sum = 0.0; 
    double sign = 1.0;
    for(int i = 1; i < n; i=i+2) {
    	sum+=(sign/i);
    	sign=sign*-1;
    }
    //YOUR CODE GOES HERE
    
    return 4.0 * sum;
  }

  // please do not modify the main...
  public static void main(String[] args) {
    JFrame window = new JFrame("Monte Carlo Pi Day Program");
    window.setBounds(200, 200, 500, 500);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    PiDayProgramming panel = new PiDayProgramming();
    panel.setBackground(Color.WHITE); // the default color is light gray
    Container c = window.getContentPane();
    c.add(panel);
    window.setVisible(true);
  }

}
