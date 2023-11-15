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
        gamepadEx.getGamepadButton(gamepadButton);
        return null;
    }

    public static Button A2 = AutoButtonMap(toolOp, GamepadKeys.Button.A);
}
