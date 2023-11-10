package org.firstinspires.ftc.teamcode.TELEOP;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class Functions {
    public static void Intake(DcMotorEx motor, CRServo servo, double IntakeSpeed){
        motor.setPower(IntakeSpeed);
        servo.setPower(IntakeSpeed);

    }
}
