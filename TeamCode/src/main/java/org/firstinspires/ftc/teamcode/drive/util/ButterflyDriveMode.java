package org.firstinspires.ftc.teamcode.drive.util;

public enum ButterflyDriveMode {
    MECANUM {
        @Override
        public String toString() {
            return "Mecanum";
        }
    },
    TANK {
        @Override
        public String toString() {
            return "Tank";
        }
    }
}
