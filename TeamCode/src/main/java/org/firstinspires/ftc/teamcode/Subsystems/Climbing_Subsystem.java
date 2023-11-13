package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.teamcode.TELEOP.constants.climb.ClimdMaxHight;
import static org.firstinspires.ftc.teamcode.TELEOP.constants.climb.FullyRetract;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Climbing_Subsystem extends SubsystemBase {
    private final Motor Climbing_Motor;

    public Climbing_Subsystem(final HardwareMap hMap, final String name) {
        Climbing_Motor = hMap.get(Motor.class, name);
    }

    public Command Open() {
        Climbing_Motor.setTargetPosition(ClimdMaxHight);
        return null;
    }

    public void Retract() {
        Climbing_Motor.setTargetPosition(FullyRetract);
    }
}
