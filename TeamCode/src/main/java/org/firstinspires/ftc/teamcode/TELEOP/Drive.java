package org.firstinspires.ftc.teamcode.TELEOP;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class Drive extends LinearOpMode {
    DcMotorEx IntakeMotor;
    CRServo IntakeServo;


    @Override
    public void runOpMode() throws InterruptedException {
        IntakeMotor = hardwareMap.get(DcMotorEx.class,"IntakeMotor");
        waitForStart();
        while (opModeIsActive()){
            Functions.Intake(IntakeMotor, IntakeServo,1);
        }
    }
}

