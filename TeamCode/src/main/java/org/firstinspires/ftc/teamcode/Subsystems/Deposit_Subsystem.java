package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.deposit.colors.greenMax;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.deposit.colors.greenMin;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.deposit.colors.purpleMin;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.deposit.colors.purpleMax;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.deposit.colors.whiteMax;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.deposit.colors.whiteMin;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.variables.deposit.IsIntakeMode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SensorColor;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.checkerframework.checker.units.qual.C;

public class Deposit_Subsystem extends SubsystemBase {
    public final SimpleServo ArmServoLeft, ArmServoRight, DepositAngleServo;
    public final CRServo ServoWheelLeft, ServoWheelRight;
    public final SensorColor LeftColorSensor, RightColorSensor;
    public enum Color{
        white,
        green,
        purple,
        yellow
    };

    public Deposit_Subsystem(HardwareMap hMap) {
        DepositAngleServo = new SimpleServo(hMap, "DepositAngleServo", 0, 300);
        ArmServoLeft = new SimpleServo(hMap, "ArmServoLeft", 0, 300);
        ArmServoRight = new SimpleServo(hMap, "ArmServoRight", 0, 300);
        ArmServoRight.setInverted(true);
        ServoWheelLeft = new CRServo(hMap, "ServoWheelLeft");
        ServoWheelRight = new CRServo(hMap, "ServoWheelRight");
        LeftColorSensor = new SensorColor(hMap.get(ColorSensor.class, "LeftColorSensor"));
        RightColorSensor = new SensorColor(hMap.get(ColorSensor.class, "RightColorSensor"));
    }

    public void ArmMove(double ArmAngle){
        ArmServoRight.turnToAngle(ArmAngle);
        ArmServoLeft.turnToAngle(ArmAngle);
    }
    public void DepositAngle(double DepositAngle){
        DepositAngleServo.turnToAngle(DepositAngle);
    }
    public void IntakeAndDepositWheels(double ServoWheelPower){
        if (IsIntakeMode) {
            if (ColorSensingRight() == null) {
                ServoWheelRight.set(ServoWheelPower);
            }
            if (ColorSensingLeft() == null) {
                ServoWheelLeft.set(ServoWheelPower);
            }
        }


    }
    public Color ColorSensingLeft(){
        return ColorSensing(LeftColorSensor);
    }
    public Color ColorSensingRight(){
        return ColorSensing(RightColorSensor);
    }
    public Color ColorSensing(SensorColor colorSensor){
        if (CheckColor(colorSensor, purpleMin, purpleMax)){
            return Color.purple;
        }
        else if (CheckColor(colorSensor, whiteMin, whiteMax)){
            return Color.white;
        }
        else if (CheckColor(colorSensor, greenMin, greenMax)){
            return Color.green;
        }
        else if (CheckColor(colorSensor, greenMin, greenMax)){
            return Color.yellow;
        }
        else return null;
    }
    public boolean CheckColor(SensorColor colorSensor, int[] MinRange, int[] MaxRange){
        int[] CheckedColor = colorSensor.getARGB();
        boolean[] CurrectRange ={false, false, false};
        for (int i = 0; i<3; i++){
            if (MinRange[i]<CheckedColor[i]&&MaxRange[i]>CheckedColor[i]){
                CurrectRange[i] = true;
            }
        }
        return (CurrectRange[0] && CurrectRange[1] && CurrectRange[2]);
    }

}
