package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.LeftStickX1;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.LeftStickY1;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.RightStickX1;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.driverOp;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.getRightBumper1;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.variables.drive.SpinPower;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.variables.drive.drivePower;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.variables.drive.xPower;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.variables.drive.yPower;


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
                xPower,
                yPower,
                SpinPower
        );
        if (getRightBumper1){
            drivePower = 0.3;
        }
        else {
            drivePower = 1;
        }
    }

}
