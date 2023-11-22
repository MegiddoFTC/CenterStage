package org.firstinspires.ftc.teamcode.TELEOP;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.Robot;

public class test extends CommandOpMode {
    @Override
    public void initialize() {
        Robot m_robot = new MyRobot();

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            m_robot.run();
        }
        m_robot.reset();
    }
}
