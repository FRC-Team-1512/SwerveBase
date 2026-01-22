package frc.robot.commands;
// Angle of rotation for the robot's wheels.
import edu.wpi.first.math.geometry.Rotation2d;
// for human interface and command
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
//for reading joystick output
import frc.robot.RobotContainer;
import frc.robot.subsystems.SwerveModule;

public class SingleSwerveTest extends Command {
    SwerveModule _module;
    //  Subsystem to controlmotors
// Used for storing information
    public SingleSwerveTest(SwerveModule module) {
        _module = module;
        addRequirements(_module);
    }
    
    @Override
    public void execute() {
        // Gains joystick values
        double vx = RobotContainer.driver.getLeftX();
        double vy = RobotContainer.driver.getLeftY();

        double vel = Math.sqrt(vx*vx + vy*vy);
        double rot = -Math.atan2(vx, -vy);

        Rotation2d angle = new Rotation2d(rot);

        SmartDashboard.putNumber("raw rot", angle.getRotations());
// Converts the joystick values
        _module.setState(vel, angle);
    }// Sets wheels speed and computed values
}
