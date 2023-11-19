package org.firstinspires.ftc.teamcode.Commands;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.getX2;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.toolOp;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.Drone_Subsystem;

public class Drone_Command extends CommandBase {
    private final Drone_Subsystem droneSubsystem;

    public Drone_Command(Drone_Subsystem subsystem){
        this.droneSubsystem = subsystem;
        addRequirements(droneSubsystem);
    }

    @Override
    public void initialize(){
        droneSubsystem.storeDrone();
    }
    @Override
    public void execute(){
        if (getX2) {
            droneSubsystem.releaseDrone();
            telemetry.addData("Drone", "Drone");
        }
    }





}
