package org.firstinspires.ftc.teamcode.TELEOP;


import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.variables.lift.LiftPoseWasChecked;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.variables.lift.LiftTargPose;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.DataOrSomethingDumb.variables;

public class Functions {
    public static void Intake(DcMotorEx motor, CRServo servo, double IntakeSpeed){
        motor.setPower(IntakeSpeed);
        servo.setPower(IntakeSpeed);
    }
    public static void Lift(DcMotorEx motor1, DcMotorEx motor2, double LiftPower){
        motor1.setPower(LiftPower);
        motor2.setPower(-LiftPower);
        if (!(motor1.isBusy()&& variables.lift.LiftPoseWasChecked)){
            variables.lift.LiftTargPose = motor1.getCurrentPosition();
        }
        else {
           motor1.setTargetPosition(LiftTargPose);
           LiftPoseWasChecked = true;
        }

    }
}
