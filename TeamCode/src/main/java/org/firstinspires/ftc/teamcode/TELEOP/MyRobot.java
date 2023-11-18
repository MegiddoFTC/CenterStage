package org.firstinspires.ftc.teamcode.TELEOP;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.A2;


import com.arcrobotics.ftclib.command.Robot;

import org.firstinspires.ftc.teamcode.Commands.Climbing_Command;
import org.firstinspires.ftc.teamcode.Commands.Deposit_Command;
import org.firstinspires.ftc.teamcode.Commands.Drone_Command;
import org.firstinspires.ftc.teamcode.Commands.Intake_Command;
import org.firstinspires.ftc.teamcode.Commands.Lift_Command;
import org.firstinspires.ftc.teamcode.Commands.TestCommandGroup;
import org.firstinspires.ftc.teamcode.Subsystems.Climbing_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Deposit_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Drive_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Drone_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Intake_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Lift_Subsystem;


public class MyRobot extends Robot {
    Climbing_Subsystem climbingSubsystem = new Climbing_Subsystem(hardwareMap);
    Climbing_Command climbingCommand = new Climbing_Command(climbingSubsystem);
    Drone_Subsystem droneSubsystem = new Drone_Subsystem(hardwareMap);
    Drone_Command droneCommand = new Drone_Command(droneSubsystem);
    Drive_Subsystem driveSubsystem = new Drive_Subsystem(hardwareMap);
    Lift_Subsystem liftSubsystem = new Lift_Subsystem(hardwareMap);
    Lift_Command liftCommand = new Lift_Command(liftSubsystem);
    Intake_Subsystem intakeSubsystem = new Intake_Subsystem(hardwareMap);
    Deposit_Subsystem depositSubsystem = new Deposit_Subsystem(hardwareMap);
    Intake_Command intakeCommand = new Intake_Command(intakeSubsystem, depositSubsystem, liftSubsystem);
    Deposit_Command depositCommand = new Deposit_Command(depositSubsystem,liftSubsystem);
    TestCommandGroup testCommandGroup = new TestCommandGroup(liftSubsystem, intakeSubsystem, depositSubsystem, droneSubsystem);


    public enum OpModeType {
        TEELEOP_FC, TEELEOP_PARALLEL
    }

    // the constructor with a specified opmode type
    public MyRobot(OpModeType type) {
        if (type == OpModeType.TEELEOP_FC) {
            Tele_FC();
        } else {
            Tele_Parallel();
        }
    }

    public void Tele_FC() {
        register(driveSubsystem);
        schedule(droneCommand, liftCommand, intakeCommand, depositCommand);
        A2.whenPressed(climbingCommand);

    }

    public void Tele_Parallel() {
        schedule(testCommandGroup);
        A2.whenPressed(climbingCommand);
        register(driveSubsystem);
    }

}
