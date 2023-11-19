package org.firstinspires.ftc.teamcode.Commands;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.deposit.colors.ServoStop;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.intake.intakeHigh;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.intake.intakeLow;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.intake.intakeMidHigh;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.intake.intakeMidLow;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.variables.intake.IntakePower;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.DataOrSomethingDumb.Buttons;
import org.firstinspires.ftc.teamcode.Subsystems.Deposit_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Intake_Subsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Lift_Subsystem;


public class Intake_Command extends CommandBase {
    private final Intake_Subsystem intakeSubsystem;
    private final Deposit_Subsystem depositSubsystem;
    private final Lift_Subsystem liftSubsystem;

    public Intake_Command(Intake_Subsystem intakeSubsystem, Deposit_Subsystem depositSubsystem, Lift_Subsystem liftSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        this.depositSubsystem = depositSubsystem;
        this.liftSubsystem = liftSubsystem;
        addRequirements(intakeSubsystem, depositSubsystem, liftSubsystem);
    }
    @Override
    public void execute(){
        if (liftSubsystem.isLiftAtIntake()) {
            if (Buttons.getDpad() != null) {
                switch (Buttons.getDpad()) {
                    case Down:
                        intakeSubsystem.IntakeHight(intakeLow);
                        telemetry.addData("IntakeHight", "intakeLow");
                        break;
                    case Up:
                        intakeSubsystem.IntakeHight(intakeHigh);
                        telemetry.addData("IntakeHight", "intakeHigh");
                        break;
                    case Right:
                        intakeSubsystem.IntakeHight(intakeMidHigh);
                        telemetry.addData("IntakeHight", "intakeMidHigh");
                        break;
                    case Left:
                        intakeSubsystem.IntakeHight(intakeMidLow);
                        telemetry.addData("IntakeHight", "intakeMidLow");


                }
            }
            if (intakeSubsystem.LeftIntakeServo.getAngle() != intakeHigh) {

                if (depositSubsystem.ColorSensingLeft() == null) {
                    depositSubsystem.IntakeAndDepositLeftWheel(IntakePower);
                    telemetry.addData("IntakeAndDepositLeftWheel", IntakePower);
                }
                else {
                    depositSubsystem.IntakeAndDepositLeftWheel(ServoStop);
                    telemetry.addData("IntakeAndDepositLeftWheel", ServoStop);
                }
                if (depositSubsystem.ColorSensingRight() == null) {
                    depositSubsystem.IntakeAndDepositRightWheel(IntakePower);
                    telemetry.addData("IntakeAndDepositRightWheel", IntakePower);
                }
                else {
                    depositSubsystem.IntakeAndDepositRightWheel(ServoStop);
                    telemetry.addData("IntakeAndDepositLeftWheel", ServoStop);
                }
                if (depositSubsystem.ColorSensingRight() != null && depositSubsystem.ColorSensingLeft() != null) {
                    intakeSubsystem.PowerIntake(-IntakePower);
                    telemetry.addData("PowerIntake", -IntakePower);
                } else {
                    intakeSubsystem.PowerIntake(IntakePower);
                    telemetry.addData("PowerIntake", IntakePower);
                }
            }
        }
        else {
            intakeSubsystem.IntakeHight(intakeHigh);
            telemetry.addData("IntakeHight", intakeHigh);
            intakeSubsystem.StopIntake();
            telemetry.addData("StopIntake", "StopIntake");

        }
    }
}
