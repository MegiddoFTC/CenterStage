package org.firstinspires.ftc.teamcode.Commands;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;

import org.firstinspires.ftc.teamcode.Subsystems.Deposit_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Drive_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Drone_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Intake_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Lift_Subsystem;

public class TestCommandGroup extends ParallelCommandGroup {



    public TestCommandGroup(Lift_Subsystem liftSubsystem, Intake_Subsystem intakeSubsystem, Deposit_Subsystem depositSubsystem, Drone_Subsystem droneSubsystem)
    {
        addCommands(
                new Lift_Command(liftSubsystem),
                new Intake_Command(intakeSubsystem, depositSubsystem, liftSubsystem),
                new Drone_Command(droneSubsystem),
                new Deposit_Command(depositSubsystem, liftSubsystem)
        );
        addRequirements(liftSubsystem, intakeSubsystem, depositSubsystem, depositSubsystem);
    }
}
