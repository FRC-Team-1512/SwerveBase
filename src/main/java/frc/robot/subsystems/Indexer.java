package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {
    private TalonFX _motor;

    public Indexer(int motorPort) {
        _motor = new TalonFX(motorPort);
    }

    public void spinFullSpeed() {
        _motor.set(1.0);
    }

    public void spinFullSpeedInverted() {
        _motor.set(1.0);
    }

    public void stopMotor() {
        _motor.set(0.0);
    }

    public void setSpeed(int speed) {
        _motor.set(speed);
    }
}
