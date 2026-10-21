package org.firstinspires.ftc.teamcode.Piper;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.components.GoBildaPinpointDriver;

// Moving:
public class CaptainsCup extends OpMode {
    DcMotor FL;
    DcMotor FR;
    DcMotor BL;
    DcMotor BR;

    float LeftStick_x;
    float LeftStick_y;
    float RightStick_x;

    GoBildaPinpointDriver pinpoint;


    boolean Up;
    boolean A;
    boolean B;
    boolean Left;
    boolean Right;
    //nice naming conventions, really easy to read for an unfamiliar teammate (me)
    int Position = 1; //Based on starting Position: 1 is Blue Far, 2 is Blue Near, 3 is Red Far, 4 is Red Near
    //Nice commenting!!

    public void init(){
        DcMotor FL = hardwareMap.get(DcMotor.class, "FL");
        DcMotor FR = hardwareMap.get(DcMotor.class, "FR");
        DcMotor BL = hardwareMap.get(DcMotor.class, "BL");
        DcMotor BR = hardwareMap.get(DcMotor.class, "BR");

        GoBildaPinpointDriver pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");
        pinpoint.setOffsets(18,18, DistanceUnit.CM);
        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        if (Position == 1 || Position == 2) {
            pinpoint.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);
        }
        if (Position == 3 || Position == 4) {
            pinpoint.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.REVERSED, GoBildaPinpointDriver.EncoderDirection.FORWARD);
        }

        pinpoint.resetPosAndIMU();
        if (Position == 1 || Position == 3){
            Pose2D startingPosition = new Pose2D(DistanceUnit.INCH, 48, 12, AngleUnit.DEGREES, 0);
        }
        if (Position == 2 || Position == 4) {
            Pose2D startingPosition = new Pose2D(DistanceUnit.INCH, 22, 122, AngleUnit.DEGREES, 135);
        }

        float LeftStick_x = gamepad1.left_stick_x;
        float LeftStick_y = gamepad1.left_stick_y;
        float RightStick_x = gamepad1.right_stick_x;
        float LeftTrigger = gamepad1.left_trigger;
        boolean A = gamepad1.a;
        boolean B = gamepad1.b;
        boolean Up = gamepad1.dpad_up;
        boolean Left = gamepad1.dpad_left;
        boolean right = gamepad1.dpad_right;

    }

    public void Drive(){
        FL.setPower(LeftStick_x + LeftStick_y + RightStick_x);
        FR.setPower(-LeftStick_x + LeftStick_y - RightStick_x);
        BL.setPower(LeftStick_x + LeftStick_y + RightStick_x);
        BR.setPower(-LeftStick_x + LeftStick_y - RightStick_x);
    }

    public void loop(){
        Drive();
    }

}
