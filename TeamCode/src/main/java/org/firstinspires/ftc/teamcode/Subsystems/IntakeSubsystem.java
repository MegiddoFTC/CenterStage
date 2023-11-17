package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeSubsystem extends SubsystemBase {
    public MotorEx IntakeMotor;
    public SimpleServo LeftIntakeServo, RightIntakeServo;
    CRServo RollerServo;
    public IntakeSubsystem(final HardwareMap hmap){
        IntakeMotor = new MotorEx(hmap, "IntakeMotor", Motor.GoBILDA.RPM_1150);
        RollerServo = new CRServo(hmap, "RollerServo");
        LeftIntakeServo = new SimpleServo(hmap, "LeftIntakeServo", 0, 300);
        RightIntakeServo = new SimpleServo(hmap, "RightIntakeServo", 0, 300);
        RightIntakeServo.setInverted(true);
    }


    @Override
    public void periodic(){

    }

    public void IntakeHight(double intakeAngle){
        RightIntakeServo.turnToAngle(intakeAngle);
        LeftIntakeServo.turnToAngle(intakeAngle);
    }
    public void PowerIntake(double IntakePower){
        IntakeMotor.set(IntakePower);
        RollerServo.set(IntakePower);
    }

}
