package org.firstinspires.ftc.teamcode.TELEOP;

import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.A2;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.TriggerAxis;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.X2;

import com.arcrobotics.ftclib.command.CommandScheduler;

public class CMD_DRIVE extends OpModeTemplate{
    @Override
    public void initialize(){
        initHardware();
        droneSubsystem.storeDrone();
    }
    @Override
    public void run(){
        super.run();
        driveSubsystem.periodic();
        A2.whenPressed(climbingCommand);
        X2.whenPressed(droneCommand);
        depositCommand.execute();
        liftCommand.execute();
        intakeCommand.execute();
    }

    @Override
    public void reset() {
        super.reset();
    }
}
