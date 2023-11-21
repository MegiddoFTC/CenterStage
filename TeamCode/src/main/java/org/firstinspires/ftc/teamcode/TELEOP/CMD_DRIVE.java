package org.firstinspires.ftc.teamcode.TELEOP;

import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.A2;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.TriggerAxis;

import com.arcrobotics.ftclib.command.CommandScheduler;

public class CMD_DRIVE extends OpModeTemplate{
    @Override
    public void initialize(){
        initHardware();
        droneCommand.initialize();
    }
    @Override
    public void run(){
        super.run();
        driveSubsystem.periodic();
        A2.whenPressed(climbingCommand);
        droneCommand.execute();
        depositCommand.execute();
        liftCommand.execute();
        intakeCommand.execute();
    }

}
