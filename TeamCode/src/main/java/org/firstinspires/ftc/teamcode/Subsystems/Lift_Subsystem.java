package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.variables.lift.LiftTargPose;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.R;

public class Lift_Subsystem extends SubsystemBase {
    private final MotorGroup LiftMotors;


    public Lift_Subsystem(HardwareMap hardwareMap, String LeftName, String RightName) {
        MotorEx leftLiftMotor = new MotorEx(hardwareMap, LeftName, MotorEx.GoBILDA.RPM_435);
        MotorEx rightLiftMotor = new MotorEx(hardwareMap, RightName, MotorEx.GoBILDA.RPM_435);
        rightLiftMotor.setInverted(true);
        LiftMotors = new MotorGroup(leftLiftMotor, rightLiftMotor);
        LiftMotors.resetEncoder();
    }


    public void MoveLift(double LiftPower){
        LiftMotors.setRunMode(Motor.RunMode.RawPower);
        LiftMotors.set(LiftPower);
    }
    public void KeepLiftPose(){
        LiftMotors.setRunMode(Motor.RunMode.PositionControl);
        LiftMotors.setTargetPosition(LiftTargPose);
    }
}
