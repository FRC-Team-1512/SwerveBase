// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;

import edu.wpi.first.math.geometry.Rotation2d;
// Robot's rotation and orientation
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
// Xbox controller for robot control
import frc.robot.commands.Drive;
import frc.robot.commands.Snap;
import frc.robot.commands.SetIMU;
import frc.robot.commands.ZeroIMU;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {
	// rOBOT'S SYSTEMS AND COMMANDS
	public static final CommandXboxController driver = new CommandXboxController(0);
	// Xbox control input
	public static final CommandXboxController operator = new CommandXboxController(1);

	private final SendableChooser<Command> autoChooser;
	// Xbox control input

    Drivetrain _drivetrain;

	public RobotContainer() {
        _drivetrain = new Drivetrain();
		// Commands for the drivetrain subsystem

		autoChooser = AutoBuilder.buildAutoChooser();

    	SmartDashboard.putData("Auto Chooser", autoChooser);
// For human controls
		configureBindings();
	}

	private void configureBindings() {
		_drivetrain.setDefaultCommand(new Drive(_drivetrain));
		// human controls robot movement from joystick

		driver.b().onTrue(new SetIMU(_drivetrain, Rotation2d.fromDegrees(45)));
		driver.y().onTrue(new Snap(_drivetrain, Rotation2d.fromDegrees(180.0)));
		driver.x().onTrue(new Snap(_drivetrain, Rotation2d.fromDegrees(-45.0)));
		driver.a().onTrue(new ZeroIMU(_drivetrain));
// All of the above for robot movement and orientation
	}

	public Command getAutonomousCommand() {
		return autoChooser.getSelected();
	}
}
