package org.firstinspires.ftc.teamcode.Piper;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.components.GoBildaPinpointDriver;
import com.qualcomm.robotcore.util.ElapsedTime;

// Moving:
public class AutoDrivePark extends OpMode {
    DcMotor FL;
    DcMotor FR;
    DcMotor BL;
    DcMotor BR;
    DcMotor Flywheel;

    ElapsedTime runtime;

    GoBildaPinpointDriver pinpoint;

    int Position = 1; //Based on starting Position: 1 is Red, 2 is Blue

    int Step = 1;

    public void init(){
        DcMotor FL = hardwareMap.get(DcMotor.class, "FL");
        DcMotor FR = hardwareMap.get(DcMotor.class, "FR");
        DcMotor BL = hardwareMap.get(DcMotor.class, "BL");
        DcMotor BR = hardwareMap.get(DcMotor.class, "BR");
        DcMotor Flywheel = hardwareMap.get(DcMotor.class, "Flywheel");

        private ElapsedTime runtime = new ElapsedTime();

        //change offsets: where odo pods are in relation to bot center

        GoBildaPinpointDriver pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");
        pinpoint.setOffsets(0,17.5, DistanceUnit.CM);
        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
            pinpoint.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);

        pinpoint.resetPosAndIMU();
        if (Position == 1){
            Pose2D startingPosition = new Pose2D(DistanceUnit.CM, 150, 330, AngleUnit.RADIANS, 0);
        }

    }

    public void AutoDriveShootPark(){
        if (Position == 1) {
            if (Step == 1) {
                while (y != 270) {
                    FL.setPower(0.5);
                    FR.setPower(0.5);
                    BL.setPower(0.5);
                    BR.setPower(0.5);}

                if (y == 270) {
                    FL.setPower(0);
                    FR.setPower(0);
                    BL.setPower(0);
                    BR.setPower(0);
                    Step += 1;}}

            if (Step == 2) {
                while (X != 90) {
                    FL.setPower(0.5);
                    FR.setPower(-0.5);
                    BL.setPower(-0.5);
                    BR.setPower(0.5);}
                if (X == 90) {
                    FL.setPower(0);
                    FR.setPower(0);
                    BL.setPower(0);
                    BR.setPower(0);
                    Step += 1;} }

            if (Step == 3) {
                while (Y != 90) {
                    FL.setPower(0.5);
                    FR.setPower(0.5);
                    BL.setPower(0.5);
                    BR.setPower(0.5);}

                if (Y == 90) {
                    FL.setPower(0);
                    FR.setPower(0);
                    BL.setPower(0);
                    BR.setPower(0);
                    Step += 1;}
            }

            if (Step == 4) {
                while (X != 150) {
                    FL.setPower(-0.5);
                    FR.setPower(0.5);
                    BL.setPower(0.5);
                    BR.setPower(-0.5);}

                if (X == 150) {
                    FL.setPower(0);
                    FR.setPower(0);
                    BL.setPower(0);
                    BR.setPower(0);
                    tuntime.reset();
                    Step += 1;
                }
        }

            if (Step == 5) {
                while (runtime.seconds() <= 7) {
                    Flywheel.setPower(1);}

                if (runtime.seconds() >= 7) {
                    Flywheel.setPower(0);
                    Step += 1;}

            if (Step == 6) {
                while (X != 90) {
                    FL.setPower(0.5);
                    FR.setPower(-0.5);
                    BL.setPower(-0.5);
                    BR.setPower(0.5);}

                if (X == 90) {
                    FL.setPower(0);
                    FR.setPower(0);
                    BL.setPower(0);
                    BR.setPower(0);
                    Step += 1;}}

            if (Step == 7) {
                while (Y != 270) {
                    FL.setPower(-0.5);
                    FR.setPower(-0.5);
                    BL.setPower(-0.5);
                    BR.setPower(-0.5);}

                if (Y == 270) {
                    FL.setPower(0);
                    FR.setPower(0);
                    BL.setPower(0);
                    BR.setPower(0);
                    Step += 1;}}

            if (Step == 8) {
                while (X != 30) {
                    FL.setPower(0.5);
                    FR.setPower(-0.5);
                    BL.setPower(-0.5);
                    BR.setPower(0.5);}

                if (X == 30) {
                    FL.setPower(0);
                    FR.setPower(0);
                    BL.setPower(0);
                    BR.setPower(0);
                    Step += 1;}

        }
    }

    public void loop() {
        AutoDriveShootPark();
    }

}
