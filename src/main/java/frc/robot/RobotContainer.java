// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/** Add your docs here. */
public class RobotContainer {
    private Motors motors;
    private SoleNoids solenoids;
    private Joystick stick;
    public RobotContainer(){
        motors = new Motors();
        solenoids = new SoleNoids();
        stick = new Joystick(0);
        motors.setDefaultCommand(new ControlMotors(motors, ()->stick.getRawAxis(1)));
        solenoids.setDefaultCommand(new ControlSolenoids(solenoids, ()->stick.getRawButton(2)));
        configureButtonBindings();
    }
    public void configureButtonBindings(){

    }
}
