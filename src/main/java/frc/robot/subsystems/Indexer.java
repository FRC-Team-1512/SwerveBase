package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// name of the public class.
public class Indexer extends SubsystemBase {
    private TalonFX _motor;
// controls the movement of the wheels, whether fast or slow.
    public Indexer(int motorPort) {
        _motor = new TalonFX(motorPort);
    }
// moves the robot's wheels at full speed.
    public void spinFullSpeed() {
        _motor.set(1.0);
    }
 // moves wheel at full speed just in the opposite direction
    public void spinFullSpeedInverted() {
        _motor.set(1.0);
    }
// stops the robot wheels from moving.
    public void stopMotor() {
        _motor.set(0.0);
    }
// allows the robot's wheels to move at a set speed.
    public void setSpeed(int speed) {
        _motor.set(speed);
    }
}
