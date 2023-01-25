2023BasicDrive
==============

This project contains very simple code for controlling a differential drive
(tank drive/skid steer/etc.) robot using a pair of SparkMAX motor controllers.
It contains a command for teleop that allows the robot to be driven using an
Xbox controller, and a super simple autonomous command that drives the robot
forward at half speed for two seconds.

Adjustments that might need to be made to the code to adapt to your robot:

- The CAN IDs of the SparkMAX controllers need to match the controllers on your
  robot. Either the SparkMAX controllers need to be reprogrammed to match the
  values in Constants.java or the values in Constants.java need to be updated
  to match the SparkMAX controllers.

- The right drive train motors are inverted in this code. Depending on the
  gearing in your robot, this might make your robot drive backwards when it
  should drive forwards. If this is the case, the left motors should be
  inverted instead.

- The autonomous command in RobotContainer.java may drive too fast or too
  slow and should be adjusted accordingly. When trying it for the first time,
  be sure to have plenty of space just in case!