package org.firstinspires.ftc.teamcode.DataOrSomethingDumb;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;

import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

public class Buttons {
    public static GamepadEx driverOp = new GamepadEx(gamepad1);
    public static GamepadEx toolOp = new GamepadEx(gamepad2);

    public static Button AutoButtonMap(GamepadEx gamepadEx, GamepadKeys.Button gamepadButton){
        return gamepadEx.getGamepadButton(gamepadButton);
    }
    public static double autoGetTrigger(GamepadEx gamepadEx, GamepadKeys.Trigger trigger){
        return gamepadEx.getTrigger(trigger);
    }
    public static boolean autoGetButtons(GamepadEx gamepadEx, GamepadKeys.Button button){
        return gamepadEx.getButton(button);
    }
    public static double TriggerAxis(double leftTrigger, double rightTrigger){
        return rightTrigger-leftTrigger;
    }


    public static Button A2 = AutoButtonMap(toolOp, GamepadKeys.Button.A);
    public static double leftTrigger2 = autoGetTrigger(toolOp, GamepadKeys.Trigger.LEFT_TRIGGER);
    public static double rightTrigger2 = autoGetTrigger(toolOp, GamepadKeys.Trigger.RIGHT_TRIGGER);
    public static boolean getX2 = autoGetButtons(toolOp, GamepadKeys.Button.X);

    public static double toolsTriggersAxis = TriggerAxis(leftTrigger2, rightTrigger2);
}
