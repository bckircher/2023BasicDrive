// Copyright (c) 2023 FRC Team 2881 - The Lady Cans
//
// Open Source Software; you can modify and/or share it under the terms of BSD
// license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {
  // Create an instance of the drive train.
  private final Drivetrain m_drivetrain = new Drivetrain();
  
  // Create an Xbox controller for driving the robot.
  private final XboxController m_driver = new XboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    // Make drive with joysticks be the default command for the drive train
    // (meaning it will run whenever there is not another command that wants
    // to use the drive train subsystem).
    //
    // The Y axis is negated since moving the joystick up returns a negative
    // value while a postive values makes the robot move forward.
    //
    // The X axis is not negated since left returns a negative value and a
    // negative values makes the robot turn to the left.
    m_drivetrain.setDefaultCommand(new DriveWithJoysticks(m_drivetrain,
                                                          () -> -m_driver.getLeftY(),
                                                          () -> m_driver.getRightX()));
  }

  // Gets the command that will run during autonomous.
  public Command getAutonomousCommand() {
    // Use the drive with joysticks command to drive the robot forward at half
    // motor power for 2 seconds. The speed, steering, and timeout values can
    // be adjusted to change the robots behavior in autonomous (albeit in only
    // the most simple way, but should be more than adequate to score points
    // for exiting the alliance's community).
    //
    // This demonstrates the value of using double suppliers...drive with
    // joysticks is controlled during autonomous with fixed values instead of
    // the Xbox controller (which can't be held and doesn't provide any input
    // to the robot code even if it were used).
    return new DriveWithJoysticks(m_drivetrain, () -> 0.5, () -> 0.0).
                 withTimeout(2);
  }
}
