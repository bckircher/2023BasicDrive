// Copyright (c) 2023 FRC Team 2881 - The Lady Cans
//
// Open Source Software; you can modify and/or share it under the terms of BSD
// license file in the root directory of this project.

package frc.robot;

// This contains all of the configuration constants for the robot.
public final class Constants {
  // This contains all of the configuration constants for the drivetrain.
  public static final class Drivetrain {
    // The CAN Id of the SparkMAX that drives the left front motor.
    public static final int kLeftFrontCANId = 1;

    // The CAN Id of the SparkMAX that drives the left back motor.
    public static final int kLeftBackCANId = 2;

    // The CAN Id of the SparkMAX that drives the right front motor.
    public static final int kRightFrontCANId = 3;

    // The CAN Id of the SparkMAX that drives the right back motor.
    public static final int kRightBackCANId = 4;
  }
}
