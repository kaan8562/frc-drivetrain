// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  
  private final XboxController controller = new XboxController(0);

  private final PWMSparkMax m_leftMotor = new PWMSparkMax(11);
  private final PWMSparkMax m_rightMotor = new PWMSparkMax(12);

  private final DifferentialDrive drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  @Override
  public void robotInit() {
    m_rightMotor.setInverted(true);
  }

  @Override
  public void teleopPeriodic() {
    double speed = controller.getLeftY();
    double rotation = controller.getRightX();

    drive.arcadeDrive(speed, rotation);
  }
}
