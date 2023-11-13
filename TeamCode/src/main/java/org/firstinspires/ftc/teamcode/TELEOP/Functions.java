package org.firstinspires.ftc.teamcode.TELEOP;


import static org.firstinspires.ftc.teamcode.TELEOP.variables.lift.LiftPoseWasChecked;
import static org.firstinspires.ftc.teamcode.TELEOP.variables.lift.LiftTargPose;
import static org.firstinspires.ftc.teamcode.TELEOP.variables.lift.pController;
import static org.firstinspires.ftc.teamcode.TELEOP.variables.lift.pidf;

import com.arcrobotics.ftclib.controller.wpilibcontroller.ElevatorFeedforward;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Functions {
    public static void Intake(DcMotorEx motor, CRServo servo, double IntakeSpeed){
        motor.setPower(IntakeSpeed);
        servo.setPower(IntakeSpeed);
    }
    public static void Lift(DcMotorEx motor1, DcMotorEx motor2, double LiftPower){
        motor1.setPower(LiftPower);
        motor2.setPower(-LiftPower);
        if (!(motor1.isBusy()&&variables.lift.LiftPoseWasChecked)){
            variables.lift.LiftTargPose = motor1.getCurrentPosition();
        }
        else {
           motor1.setTargetPosition(LiftTargPose);
           LiftPoseWasChecked = true;
        }

    }
}
