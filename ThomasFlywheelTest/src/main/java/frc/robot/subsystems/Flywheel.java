// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flywheel extends SubsystemBase {

  private TalonFX rightMaster;
  private TalonFX leftFollower;
  private double percentInput;

  /** Creates a new ExampleSubsystem. */
  public Flywheel() {
    rightMaster = new TalonFX(21);
    leftFollower = new TalonFX(11);
    leftFollower.follow(rightMaster);
    leftFollower.setInverted(InvertType.OpposeMaster);

    SmartDashboard.putNumber("Percent Output", 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    percentInput = SmartDashboard.getNumber("Percent Output", 0);
    rightMaster.set(ControlMode.PercentOutput, percentInput);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void initLogging() {
    
  }

  // public void reportToSmartDashboard(){
  //   SmartDashboard.
  // }
}
