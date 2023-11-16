package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.driverOp;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive_Subsystem extends SubsystemBase {
    protected final MotorEx leftFront, rightFront, leftBack, rightBack;
    private final MecanumDrive drive;

    public Drive_Subsystem(HardwareMap hMap) {
        leftFront = new MotorEx(hMap, "LeftFront");
        rightBack = new MotorEx(hMap, "RightBack");
        rightFront = new MotorEx(hMap, "RightFront");
        leftBack = new MotorEx(hMap, "LeftBack");

        drive = new MecanumDrive(leftFront, rightFront, leftBack, rightBack);
    }
    @Override
    public void periodic(){
        drive.driveRobotCentric(
                driverOp.getLeftX(),
                driverOp.getLeftY(),
                driverOp.getRightY()
        );    }

}
