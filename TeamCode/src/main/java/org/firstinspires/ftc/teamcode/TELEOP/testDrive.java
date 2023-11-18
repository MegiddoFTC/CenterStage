package org.firstinspires.ftc.teamcode.TELEOP;

import com.arcrobotics.ftclib.command.Robot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class testDrive extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot m_robot = new MyRobot(MyRobot.OpModeType.TEELEOP_PARALLEL);

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            m_robot.run();
        }
        m_robot.reset();
    }
}
