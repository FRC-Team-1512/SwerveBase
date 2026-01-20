package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
//lines 3-6 import things

public class Drive extends Command {
    Drivetrain _drivetrain;
    //creates drivetrain object

    public Drive(Drivetrain drivetrain) {
        _drivetrain = drivetrain;
        //assigns drivetrain parameter to drivetrain object
        addRequirements(_drivetrain);
        //requires drivetrain subsystem
    }
    
    @Override
    public void execute() {
        boolean isSlowMode = RobotContainer.driver.leftBumper().getAsBoolean();
        //checks if slow mode is true or false
        double vx = -applyDeadband(RobotContainer.driver.getLeftY(), 0.15);
        //gets forward/backward speed from left joystick y-axis
        double vy = -applyDeadband(RobotContainer.driver.getLeftX(), 0.15);
        //gets left/right speed from left joystick x-axis
        double rot = -applyDeadband(RobotContainer.driver.getRightX(), 0.15);
        //gets rotational speed from right joystick x-axis
        

        if(!isSlowMode) {
            //checkis if slow mode is false
            vx *= 3.0;
            //multiplies forward/backward speed by 3 if not in slow mode
            vy *= 3.0;
            //multiplies left/right speed by 3 if not in slow mode
            rot *= 3.0;
            //multiplies rotational speed by 3 if not in slow mode
        }

        _drivetrain.setFieldRelativeSpeeds(new ChassisSpeeds(vx, vy, rot));
        //sets the drivetrain speeds based on joystick inputs
    
    }

    private static double applyDeadband(double input, double deadband) {
        if (Math.abs(input) <= deadband) {
            return 0.0;
            //if input is within deadband, return 0
        }else {
            return input;
            //otherwise, return the original input
        }
    }
}
