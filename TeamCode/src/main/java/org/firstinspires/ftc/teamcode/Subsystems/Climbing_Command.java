package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.teamcode.TELEOP.variables.climb.ClimbIsOpen;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Climbing_Command extends CommandBase {

    private final Climbing_Subsystem ClimbingSubsystem;

    public Climbing_Command(Climbing_Subsystem subsystem){
        ClimbingSubsystem = subsystem;
        addRequirements(ClimbingSubsystem);
    }

    @Override
    public void initialize(){
        if (!ClimbIsOpen) {
            ClimbingSubsystem.Open();
            ClimbIsOpen = true;
        }
        else {
            ClimbingSubsystem.Retract();
            ClimbIsOpen = false;
        }

    }

    @Override
    public boolean isFinished(){
        return true;
    }


}
