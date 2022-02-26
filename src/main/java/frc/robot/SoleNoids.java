// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SoleNoids extends SubsystemBase {
  /** Creates a new SoleNoids. */
  private DoubleSolenoid leftSolenoid;
  private DoubleSolenoid rightSolenoid;
  private boolean areSolenoidsExtended;
  public SoleNoids() {
    // FIXME: check this module type
    // If the solenoids start by extending w/o you doing anything, flip the port IDs
    // Call me if u have questions nerds
    leftSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, /* these are the ports that they are plugged into on the PCM */ 0-9, 0-9);
    rightSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, /* these are the ports that they are plugged into on the PCM */ 0-9, 0-9);
  }

  public void setExtended(boolean extended){
    areSolenoidsExtended = extended;
    if (extended){
      leftSolenoid.set(DoubleSolenoid.Value.kForward);
      rightSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    else{
      leftSolenoid.set(DoubleSolenoid.Value.kReverse);
      rightSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Solenoids", areSolenoidsExtended);
  }
}
