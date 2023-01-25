// Copyright (c) 2023 FRC Team 2881 - The Lady Cans
//
// Open Source Software; you can modify and/or share it under the terms of BSD
// license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.Drivetrain.kLeftBackCANId;
import static frc.robot.Constants.Drivetrain.kLeftFrontCANId;
import static frc.robot.Constants.Drivetrain.kRightBackCANId;
import static frc.robot.Constants.Drivetrain.kRightFrontCANId;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private final CANSparkMax m_leftFront = new CANSparkMax(kLeftFrontCANId, MotorType.kBrushless);
  private final CANSparkMax m_leftBack = new CANSparkMax(kLeftBackCANId, MotorType.kBrushless);
  private final CANSparkMax m_rightFront = new CANSparkMax(kRightFrontCANId, MotorType.kBrushless);
  private final CANSparkMax m_rightBack = new CANSparkMax(kRightBackCANId, MotorType.kBrushless);
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftFront, m_rightFront);

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    // Restore the factory default settings (instead of possibly having random
    // settings based on the previous use of this motor controller) and set
    // the motors to brake mode when idle. Additionally, the right motors are
    // inverted since they are mounted 180 degrees opposite of the left motors.
    m_leftFront.restoreFactoryDefaults();
    m_leftFront.setIdleMode(IdleMode.kBrake);
    m_leftBack.restoreFactoryDefaults();
    m_leftBack.setIdleMode(IdleMode.kBrake);
    m_rightFront.restoreFactoryDefaults();
    m_rightFront.setIdleMode(IdleMode.kBrake);
    m_rightFront.setInverted(true);
    m_rightBack.restoreFactoryDefaults();
    m_rightBack.setIdleMode(IdleMode.kBrake);
    m_rightBack.setInverted(true);

    // Make the two back motors "follow" the two front motors. This means that
    // any command sent to the front motor will also be applied to the back
    // motor (without having to explicit send it the same command).
    m_leftBack.follow(m_leftFront);
    m_rightBack.follow(m_rightFront);

    // Change the motor safety timeout for the DifferentialDrive instance to
    // 100 ms, providing a bit more time before it starts producing errors.
    m_drive.setExpiration(0.1);
  }

  // Provide a method for commands to drive the robot in arcade drive mode.
  public void arcadeDrive(double speed, double rotation) {
    m_drive.arcadeDrive(speed, rotation);
  }
}
