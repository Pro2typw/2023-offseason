package org.firstinspires.ftc.teamcode.game;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.ButterflyDrive;
import org.firstinspires.ftc.teamcode.drive.util.ButterflyDriveMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp Test", group = "Test")
public class TeleOp extends LinearOpMode {

    ButterflyDrive butterflyDrive;

    @Override
    public void runOpMode() throws InterruptedException {
        butterflyDrive = new ButterflyDrive(hardwareMap, telemetry, ButterflyDriveMode.MECANUM);

        waitForStart();

        if(gamepad1.a) butterflyDrive.setMode(ButterflyDriveMode.MECANUM);
        if(gamepad1.b) butterflyDrive.setMode(ButterflyDriveMode.TANK);

        if(butterflyDrive.getMode() == ButterflyDriveMode.MECANUM) {

        }
        else {
            telemetry.addData("Drive Train Mode", "TANK");
        }

        telemetry.update();
        butterflyDrive.setPower(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x, (x) -> 0.8 * Math.pow(x, 3));
    }
}
