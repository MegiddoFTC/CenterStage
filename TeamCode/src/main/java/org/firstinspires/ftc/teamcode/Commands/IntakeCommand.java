package org.firstinspires.ftc.teamcode.Commands;

import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.intGetLeftBumper2;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons.intGetRightBumper2;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.intake.intakeHigh;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.intake.intakeLow;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.intake.intakeMidHigh;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.intake.intakeMidLow;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.variables.intake.IntakePower;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons;
import org.firstinspires.ftc.teamcode.Subsystems.Deposit_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Lift_Subsystem;


public class IntakeCommand extends CommandBase {
    private final IntakeSubsystem intakeSubsystem;
    private final Deposit_Subsystem depositSubsystem;
    private final Lift_Subsystem liftSubsystem;

    public IntakeCommand(IntakeSubsystem intakeSubsystem, Deposit_Subsystem depositSubsystem, Lift_Subsystem liftSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        this.depositSubsystem = depositSubsystem;
        this.liftSubsystem = liftSubsystem;
        addRequirements(intakeSubsystem, depositSubsystem, liftSubsystem);
    }
    @Override
    public void execute(){
        if (Buttons.getDpad() != null) {
            switch (Buttons.getDpad()){
                case Down:
                    intakeSubsystem.IntakeHight(intakeLow);
                    break;
                case Up:
                    intakeSubsystem.IntakeHight(intakeHigh);
                    break;
                case Right:
                    intakeSubsystem.IntakeHight(intakeMidHigh);
                    break;
                case Left:
                    intakeSubsystem.IntakeHight(intakeMidLow);


            }
        }
        if (liftSubsystem.LiftMotors.getCurrentPosition()<20){
            intakeSubsystem.IntakeHight(intakeHigh);
        }
        if (intakeSubsystem.LeftIntakeServo.getAngle()!=intakeHigh) {

            intakeSubsystem.PowerIntake(IntakePower);
            depositSubsystem.IntakeAndDepositWheels(IntakePower);
        }

    }
}
