package org.firstinspires.ftc.teamcode.TELEOP;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.A2;


import com.arcrobotics.ftclib.command.Robot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Commands.Climbing_Command;
import org.firstinspires.ftc.teamcode.Commands.Deposit_Command;
import org.firstinspires.ftc.teamcode.Commands.Drone_Command;
import org.firstinspires.ftc.teamcode.Commands.Intake_Command;
import org.firstinspires.ftc.teamcode.Commands.Lift_Command;
import org.firstinspires.ftc.teamcode.Subsystems.Climbing_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Deposit_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Drive_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Drone_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Intake_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Lift_Subsystem;


public class MyRobot extends Robot {
    Climbing_Subsystem climbingSubsystem;
    Climbing_Command climbingCommand;
    Drone_Subsystem droneSubsystem;
    Drone_Command droneCommand;
    Drive_Subsystem driveSubsystem;
    Lift_Subsystem liftSubsystem;
    Lift_Command liftCommand;
    Intake_Subsystem intakeSubsystem;
    Intake_Command intakeCommand;
    Deposit_Subsystem depositSubsystem;
    Deposit_Command depositCommand;




    // the constructor with a specified opmode type
    public MyRobot() {
        climbingSubsystem = new Climbing_Subsystem(hardwareMap);
        climbingCommand = new Climbing_Command(climbingSubsystem);
        droneSubsystem = new Drone_Subsystem(hardwareMap);
        droneCommand = new Drone_Command(droneSubsystem);
        driveSubsystem = new Drive_Subsystem(hardwareMap);
        liftSubsystem = new Lift_Subsystem(hardwareMap);
        liftCommand = new Lift_Command(liftSubsystem);
        intakeSubsystem = new Intake_Subsystem(hardwareMap);
        intakeCommand = new Intake_Command(intakeSubsystem, depositSubsystem, liftSubsystem);
        depositSubsystem = new Deposit_Subsystem(hardwareMap);
        depositCommand = new Deposit_Command(depositSubsystem, liftSubsystem);

    }

    public void run() {
        register(driveSubsystem, depositSubsystem, climbingSubsystem, liftSubsystem, droneSubsystem, intakeSubsystem);
        schedule(droneCommand, liftCommand, intakeCommand, depositCommand);
        A2.whenPressed(climbingCommand);

    }


}
