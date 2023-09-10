package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.drive.util.ButterflyDriveMode;
import org.firstinspires.ftc.teamcode.drive.util.PowerMultiplier;

public class ButterflyDrive {

    private MecanumDrive mecanumDrive;
    private TankDrive tankDrive;
    private ButterflyDriveMode mode;

    public ButterflyDrive(HardwareMap hardwareMap, ButterflyDriveMode mode) {
        mecanumDrive = new MecanumDrive(hardwareMap);
        tankDrive = new TankDrive(hardwareMap);
        this.mode = mode;
    }

    public void setMode(ButterflyDriveMode mode) {
        if (this.mode == mode) return;

        if(mode == ButterflyDriveMode.MECANUM) {
            // TODO: change servo pos

        }
        else {
            // TODO: change servo pos
        }
        this.mode = mode;
    }

    public void swapMode() {
        this.setMode(this.mode == ButterflyDriveMode.MECANUM ? ButterflyDriveMode.TANK : ButterflyDriveMode.MECANUM);
    }

    // Telemetry purposes
    public ButterflyDriveMode getMode() {
        return mode;
    }


    public void setPower(double x1, double y1, double x2, PowerMultiplier<Double, Double> func) {
        if(mode == ButterflyDriveMode.TANK) tankDrive.setPowersByGamepad(y1, x2, func);
        else mecanumDrive.setPowersByGamepad(x1, y1, x2, func);

    }


}
