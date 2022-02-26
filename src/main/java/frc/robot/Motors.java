// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motors extends SubsystemBase {
  /** Creates a new Motors. */
  private WPI_TalonFX leftClimbMotor;
  private WPI_TalonFX rightClimbMotor;
  private double speed;
  public Motors() {
    // FIXME: add IDs
    // Tyler knows how to do this one
    // As always, call if u have questions nerds
    leftClimbMotor = new WPI_TalonFX(0-9);
    rightClimbMotor = new WPI_TalonFX(0-9);
  }

  public void setSpeed(double speed){
    // Limit the speed to 50%
    leftClimbMotor.set(ControlMode.MotionMagic, speed / 2);
    rightClimbMotor.set(ControlMode.MotionMagic, speed / 2);
    // If Z is there tell him I know this is inefficient but its what I'm doing
    this.speed = speed;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Motor Speed", speed);
  }
}
