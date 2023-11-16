package org.firstinspires.ftc.teamcode.Commands;

import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.toolsTriggersAxis;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.variables.lift.LiftPower;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Drone_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Lift_Subsystem;

public class Lift_Command extends CommandBase {
    private final Lift_Subsystem liftSubsystem;

    public Lift_Command(Lift_Subsystem subsystem){
         liftSubsystem = subsystem;
        addRequirements(liftSubsystem);
    }

    @Override
    public void execute(){
        LiftPower = toolsTriggersAxis;
        if (LiftPower!=0){
            liftSubsystem.MoveLift(LiftPower);
        }
        else {
            liftSubsystem.KeepLiftPose();
        }
    }
}
