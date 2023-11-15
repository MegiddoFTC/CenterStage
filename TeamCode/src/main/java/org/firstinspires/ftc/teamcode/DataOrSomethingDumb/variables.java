package org.firstinspires.ftc.teamcode.DataOrSomethingDumb;

import com.arcrobotics.ftclib.controller.PController;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;

public class variables {
    public static class lift{
        public static double kP = 0, kI = 0, kD = 0;
        public static double kF = 0;
        public static boolean LiftPoseWasChecked;
        public static int LiftTargPose;
        public static PIDFController pidf = new PIDFController(lift.kP, lift.kI, lift.kD, lift.kF);
        public static double output;
        public static PController pController = new PController(kP);


    }
    public static class climb{
        public static boolean ClimbIsOpen = false;
    }

}
