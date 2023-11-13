package org.firstinspires.ftc.teamcode.TELEOP;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.teamcode.TELEOP.Buttons.A1;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.Subsystems.Climbing_Command;
import org.firstinspires.ftc.teamcode.Subsystems.Climbing_Subsystem;


public class MyRobot extends Robot {
    Climbing_Subsystem climbingSubsystem = new Climbing_Subsystem(hardwareMap, "clmMotor");
    Climbing_Command climbingCommand = new Climbing_Command(climbingSubsystem);

    public enum OpModeType {
        TELEOP1, TELEOP2
    }

    // the constructor with a specified opmode type
    public MyRobot(OpModeType type) {
        if (type == OpModeType.TELEOP1) {
            initTele1();
        } else {
            initTele2();
        }
    }

    public void initTele1() {
        A1.whenPressed(climbingCommand);


        // initialize teleop-specific scheduler
    }

    public void initTele2() {
        // initialize auto-specific scheduler
    }

}
