package org.firstinspires.ftc.teamcode.game;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.acmerobotics.roadrunner.control.PIDFController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.internal.opmode.OpModeServices;
import org.firstinspires.ftc.teamcode.drive.ButterflyDrive;
import org.firstinspires.ftc.teamcode.drive.util.ButterflyDriveMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp Test", group = "Test")
public class TeleOp extends LinearOpMode {

    ButterflyDrive butterflyDrive;
    TelemetryPacket telemetryPacket;

    @Override
    public void runOpMode() throws InterruptedException {
        butterflyDrive = new ButterflyDrive(hardwareMap, ButterflyDriveMode.MECANUM);
        telemetryPacket = new TelemetryPacket();
        telemetryPacket.put("Butterfly Mode", butterflyDrive.getMode());
        telemetryPacket.addLine("Butterfly Mode");

        waitForStart();

        while(opModeIsActive()) {
            if(gamepad1.a) butterflyDrive.swapMode();

            telemetry.addData("Drive Train Mode", butterflyDrive.getMode());
            telemetry.update();
            telemetryPacket.put("Butterfly Mode", butterflyDrive.getMode());
            telemetryPacket.addLine("Butterfly Mode");

            telemetry.update();
            butterflyDrive.setPower(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x, (x) -> 0.8 * Math.pow(x, 0.8));

        }
    }
}
