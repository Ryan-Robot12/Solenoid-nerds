// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ControlSolenoids extends CommandBase {
  /** Creates a new ControlSolenodis. */
  // troll name :)
  private SoleNoids soleNoids;
  private BooleanSupplier isExtended;
  public ControlSolenoids(SoleNoids soleNoids, BooleanSupplier isExtended) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(soleNoids);
    this.soleNoids = soleNoids;
    this.isExtended = isExtended;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    soleNoids.setExtended(isExtended.getAsBoolean());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    soleNoids.setExtended(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
