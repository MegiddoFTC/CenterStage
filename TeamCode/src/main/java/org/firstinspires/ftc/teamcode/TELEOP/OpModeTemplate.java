package org.firstinspires.ftc.teamcode.TELEOP;

import com.arcrobotics.ftclib.command.CommandOpMode;
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

abstract public class OpModeTemplate extends CommandOpMode {
    protected Climbing_Subsystem climbingSubsystem;
    protected Climbing_Command climbingCommand;
    protected Drone_Subsystem droneSubsystem;
    protected Drone_Command droneCommand;
    protected Drive_Subsystem driveSubsystem;
    protected Lift_Subsystem liftSubsystem;
    protected Lift_Command liftCommand;
    protected Intake_Subsystem intakeSubsystem;
    protected Intake_Command intakeCommand;
    protected Deposit_Subsystem depositSubsystem;
    protected Deposit_Command depositCommand;

    protected void initHardware(){
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
        register(climbingSubsystem, droneSubsystem, driveSubsystem, liftSubsystem, intakeSubsystem, depositSubsystem);
        schedule(climbingCommand, droneCommand, liftCommand, intakeCommand, depositCommand);
    }



}
