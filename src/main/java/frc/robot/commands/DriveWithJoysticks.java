// Copyright (c) 2023 FRC Team 2881 - The Lady Cans
//
// Open Source Software; you can modify and/or share it under the terms of BSD
// license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveWithJoysticks extends CommandBase {
  // The drive train subsystem used by this command.
  private final Drivetrain m_drivetrain;

  // A supplier of doubles that controls the speed of the robot. By using a
  // DoubleSupplier instead of directly accessing the Xbox controller, it is
  // possible to provide a different source of the robot's speed.
  private final DoubleSupplier m_speed;

  // A supplier of doubles that controls the rotation of the robot.
  private final DoubleSupplier m_rotation;

  /** Creates a new DriveWithJoysticks. */
  public DriveWithJoysticks(Drivetrain drivetrain, DoubleSupplier speed,
                            DoubleSupplier rotation) {
    // Save the supplied values for later use.
    m_drivetrain = drivetrain;
    m_speed = speed;
    m_rotation = rotation;
  
    // Since this command uses the drive train subsystem, it must inform the
    // command scheduler of this fact (especially important since it will be
    // the default command for the drive train subsystem, in which case it
    // _must_ require the drive train subsystem).
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Get the current values of the speed and rotation double suppliers and
    // drive the robot based on their values.
    m_drivetrain.arcadeDrive(m_speed.getAsDouble(), m_rotation.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // When the command ends, stop the robot.
    m_drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // This command never finishes (an important aspect of a default command,
    // which would just get rescheduled if it were to finish).
    return false;
  }
}
