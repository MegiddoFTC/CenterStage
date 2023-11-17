package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.droneRelease.droneRelease;
import static org.firstinspires.ftc.teamcode.DataOrSomethingDumb.constants.droneRelease.droneStore;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drone_Subsystem extends SubsystemBase {
    private final ServoEx DroneServo;

    public Drone_Subsystem(final HardwareMap hMap){
        DroneServo = hMap.get(ServoEx.class, "ServoDrone");
    }


    @Override
    public void periodic(){

    }

    public void releaseDrone(){
        DroneServo.setPosition(droneRelease);
    }
    public void storeDrone(){
        DroneServo.setPosition(droneStore);
    }
}
