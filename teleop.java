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
    DcMotor flywheel;
    private static final double SHOOT_POWER = 1.0; // Tune from 0.0 to 1.0 on the robot.

    float LeftStick_x;
    float LeftStick_y;
    float RightStick_x;



    boolean Up;
    boolean A;
    boolean B;
    boolean Left;
    boolean Right;

    public void init(){
        DcMotor FL = hardwareMap.get(DcMotor.class, "FL");
        DcMotor FR = hardwareMap.get(DcMotor.class, "FR");
        DcMotor BL = hardwareMap.get(DcMotor.class, "BL");
        DcMotor BR = hardwareMap.get(DcMotor.class, "BR");

        flywheel = hardwareMap.get(DcMotor.class, "flywheel");
        flywheel.setPower(0.0);
        flywheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        flywheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


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

        @Override
        public void loop(){
            LeftStick_x = gamepad1.left_stick_x;
            LeftStick_y = gamepad1.left_stick_y;
            RightStick_x = gamepad1.right_stick_x;
            Drive();

            // Hold gamepad 1's right bumper to shoot; release to cut power.
            // The flywheel coasts down after power is removed.
            flywheel.setPower(gamepad1.right_bumper ? SHOOT_POWER : 0.0);
        }

        @Override
        public void stop(){
            flywheel.setPower(0.0);
            FL.setPower(0.0);
            FR.setPower(0.0);
            BL.setPower(0.0);
            BR.setPower(0.0);
        }
    }

    public void loop(){
        Drive();
    }

}
