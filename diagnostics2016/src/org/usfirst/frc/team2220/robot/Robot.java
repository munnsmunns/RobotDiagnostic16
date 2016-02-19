
package org.usfirst.frc.team2220.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;

import org.usfirst.frc.team2220.robot.XBoxController.Button;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a demo program showing the use of the RobotDrive class.
 * The SampleRobot class is the base of a robot application that will automatically call your
 * Autonomous and OperatorControl methods at the right time as controlled by the switches on
 * the driver station or the field controls.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're inexperienced,
 * don't. Unless you know what you are doing, complex code will be much more difficult under
 * this system. Use IterativeRobot or Command-Based instead if you're new.
 */
public class Robot extends SampleRobot {

    public Robot() {

    }
    
    public void robotInit() {

    }

    public void autonomous() {
    	
    	
    	
    }


    public void operatorControl() {

        
    }

    /**
     * Runs during test mode
     */
  
    public void test() {
    	XBoxController stick = new XBoxController(0);
    	int canID = 1;
    	double motorPower = .1;
    	SmartDashboard.putNumber("CAN ID", canID);
    	while(isTest() && isEnabled()) 
    	{
    		stick.update();
    		//change talon that is tested
    		if(stick.onPress(Button.aButton))
    		{
    			if (canID >= 8) {
    				canID = 1;
    			}
    			else {
    				canID++;
    			}
    			SmartDashboard.putNumber("CAN ID", canID);
    		}
    		//run talon forward
    		if(stick.onPress(Button.bButton))
    		{
    			CANTalon talon = new CANTalon(canID);
    			talon.set(motorPower);
    			Timer.delay(3);
    			talon.set(0);
    			talon = null;
    		}
    		//run talon backward
    		if(stick.onPress(Button.xButton))
    		{
    			CANTalon talon = new CANTalon(canID);
    			talon.set(-motorPower);
    			Timer.delay(3);
    			talon.set(0);
    			talon = null;
    		}
    		
    	}
    }
}
