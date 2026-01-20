package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
//imports something

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//imports something

public class Shooter extends SubsystemBase {
    private TalonFX _motor;
    //creates motor object

    public Shooter(int motorPort) {
        _motor = new TalonFX(motorPort);
    //constructor that initializes motor at given port
    }

    public void spinFullSpeed() {
        _motor.set(1.0);
    //tells motor to spin at full speed
    }

    public void spinFullSpeedInverted() {
        _motor.set(1.0);
    //tells motor to spin at full speed in the opposite direction
    }

    public void stopMotor() {
        _motor.set(0.0);
    //tells motor to stop spinning
    }

    public void setSpeed(int speed) {
        _motor.set(speed);
    //tells motor to spin at a specific speed
    }
}
