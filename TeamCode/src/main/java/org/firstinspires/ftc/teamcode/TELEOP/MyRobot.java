package org.firstinspires.ftc.teamcode.TELEOP;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.A2;


import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;

import org.firstinspires.ftc.teamcode.Commands.Climbing_Command;
import org.firstinspires.ftc.teamcode.Subsystems.Climbing_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Drive_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Drone_Subsystem;


public class MyRobot extends Robot {
    Climbing_Subsystem climbingSubsystem = new Climbing_Subsystem(hardwareMap, "clmMotor");
    Climbing_Command climbingCommand = new Climbing_Command(climbingSubsystem);
    Drone_Subsystem droneSubsystem = new Drone_Subsystem(hardwareMap, "DroneServo");
    Drive_Subsystem driveSubsystem = new Drive_Subsystem(hardwareMap, "leftFront", "rightFront", "leftBack", "rightBack");


    public enum OpModeType {
        TEELEOP_LOOP, TEELEOP_INIT
    }

    // the constructor with a specified opmode type
    public MyRobot(OpModeType type) {
        if (type == OpModeType.TEELEOP_LOOP) {
            Tele_Loop();
        } else {
            Tele_INIT();
        }
    }

    public void Tele_Loop() {
        A2.whenPressed(climbingCommand);
        driveSubsystem.Drive();
    }

    public void Tele_INIT() {

    }

}
