package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private TalonFX _motor;

    // Constructor that takes the motor port as a parameter
    public Intake(int motorPort) {
        _motor = new TalonFX(motorPort);
    }

    // Spins the motor at full speed for intake
    public void spinFullSpeed() {
        _motor.set(1.0);  // Forward direction
    }

    // Spins the motor in reverse to eject balls
    public void spinFullSpeedInverted() {
        _motor.set(-1.0); // Reverse direction
    }

    // Stops the motor
    public void stopMotor() {
        _motor.set(0.0);  // Stops the motor
    }

    // Optionally, set the motor speed to a specific value
    public void setSpeed(double speed) {
        _motor.set(speed); // Sets motor speed between -1.0 and 1.0
    }
}

