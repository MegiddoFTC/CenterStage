package org.firstinspires.ftc.teamcode.TELEOP;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;

import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

public class Buttons {
    public static GamepadEx driverOp = new GamepadEx(gamepad1);
    public static GamepadEx toolOp = new GamepadEx(gamepad2);

    public static Button A1 = new GamepadButton(
            driverOp, GamepadKeys.Button.A
    );
}
