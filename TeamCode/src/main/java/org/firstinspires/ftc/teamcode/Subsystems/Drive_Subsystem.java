package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.driverOp;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive_Subsystem extends SubsystemBase {
    private final MotorEx leftFront, rightFront, leftBack, rightBack;
    private MecanumDrive drive;

    public Drive_Subsystem(HardwareMap hMap, String LeftFront, String RightFront, String LeftBack, String RightBack) {
        leftFront = new MotorEx(hMap, LeftFront);
        rightBack = new MotorEx(hMap, RightBack);
        rightFront = new MotorEx(hMap, RightFront);
        leftBack = new MotorEx(hMap, LeftBack);

        drive = new MecanumDrive(leftFront, rightFront, leftBack, rightBack);
    }
    public void Drive(){
        drive.driveRobotCentric(
                driverOp.getLeftX(),
                driverOp.getLeftY(),
                driverOp.getRightY()
        );
    }
}
