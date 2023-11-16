package org.firstinspires.ftc.teamcode.TELEOP;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.A2;


import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;

import org.firstinspires.ftc.teamcode.Commands.Climbing_Command;
import org.firstinspires.ftc.teamcode.Commands.Drone_Command;
import org.firstinspires.ftc.teamcode.Commands.Lift_Command;
import org.firstinspires.ftc.teamcode.Subsystems.Climbing_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Drive_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Drone_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Lift_Subsystem;


public class MyRobot extends Robot {
    Climbing_Subsystem climbingSubsystem = new Climbing_Subsystem(hardwareMap);
    Climbing_Command climbingCommand = new Climbing_Command(climbingSubsystem);
    Drone_Subsystem droneSubsystem = new Drone_Subsystem(hardwareMap, "DroneServo");
    Drone_Command droneCommand = new Drone_Command(droneSubsystem);
    Drive_Subsystem driveSubsystem = new Drive_Subsystem(hardwareMap);
    Lift_Subsystem liftSubsystem = new Lift_Subsystem(hardwareMap);
    Lift_Command liftCommand = new Lift_Command(liftSubsystem);


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
        register(driveSubsystem);
        schedule(droneCommand, liftCommand);
        A2.whenPressed(climbingCommand);

    }

    public void Tele_INIT() {

    }

}
