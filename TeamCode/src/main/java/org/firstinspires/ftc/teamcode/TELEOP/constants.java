package org.firstinspires.ftc.teamcode.TELEOP;

import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public final class constants {
    public final static class climb{
        //TODO: ADD MAX HIGHT
        public static int ClimdMaxHight = 100;
        public static int FullyRetract = 0;
    }
    public final static class droneRelease{
        //TODO: Check pos of servo
        public final int droneRelease = 1;
        public final int droneStore = 0;
    }
    public final static class intake{
        //TODO: Check pos of servo
        public final double intakeHigh = 1;
        public final double intakeMidHigh = 0.7;
        public final double intakeMidLow = 0.4;
        public final double intakeLow = 0;


    }

}
