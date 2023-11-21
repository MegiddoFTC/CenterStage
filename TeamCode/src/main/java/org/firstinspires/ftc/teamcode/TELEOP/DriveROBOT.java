package org.firstinspires.ftc.teamcode.TELEOP;

import com.arcrobotics.ftclib.command.Robot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class DriveROBOT extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Robot m_robot = new MyRobot(hardwareMap);

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            m_robot.run();
        }
        m_robot.reset();
    }
}

