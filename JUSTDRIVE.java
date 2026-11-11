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
//    DcMotor flywheel;
//    DcMotor intakeMotor;
//    servo intakeServo;
//    private static final double SHOOT_POWER = 1.0; // Tune from 0.0 to 1.0 on the robot.

    float LeftStick_x;
    float LeftStick_y;
    float RightStick_x;



    //    boolean Up;
//    boolean A;
//    boolean B;
//    boolean Left;
//    boolean Right;
//    boolean Right_Bumper;

    public void init(){
        DcMotor FL = hardwareMap.get(DcMotor.class, "FL");
        DcMotor FR = hardwareMap.get(DcMotor.class, "FR");
        DcMotor BL = hardwareMap.get(DcMotor.class, "BL");
        DcMotor BR = hardwareMap.get(DcMotor.class, "BR");

        servo intakeServo = hardwareMap.get(servo.class, "intakeServo");

//        flywheel = hardwareMap.get(DcMotor.class, "flywheel");
//        flywheel.setPower(0.0);
//        flywheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        flywheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

//        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
//        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        intakeMotor.setDirection(DcMotor.Direction.FORWARD);


        float LeftStick_x = gamepad1.left_stick_x;
        float LeftStick_y = gamepad1.left_stick_y;
        float RightStick_x = gamepad1.right_stick_x;
//        float LeftTrigger = gamepad1.left_trigger;
//        boolean A = gamepad1.a;
//        boolean B = gamepad1.b;
//        boolean Up = gamepad1.dpad_up;
//        boolean Left = gamepad1.dpad_left;
//        boolean right = gamepad1.dpad_right;
//        boolean Right_Bumber = gamepad1.dpad_right_bumber;

    }

    public void Drive(){
        FL.setPower(LeftStick_x + LeftStick_y + RightStick_x);
        FR.setPower(-LeftStick_x + LeftStick_y - RightStick_x);
        BL.setPower(LeftStick_x + LeftStick_y + RightStick_x);
        BR.setPower(-LeftStick_x + LeftStick_y - RightStick_x);
    }

//    public void shoot(){
  //      while (opModeIsActive()) {
    //        if (Right_Bumper) {
      //          flywheel.setPower(1.0);
        //        intakeServo.setPosition(.25);
          //  } else {
            //    flywheel.setPower(0);
//            }
  //      }
    //}
//    public void Intake() {
  //      waitForStart();
    //    while (opModeIsActive()) {
      //      if (gamepad1.x) {
        //        intakeMotor.setPower(1.0);
          //      intakeServo.setPosition(.25);
            //} else {
              //  intakeMotor.setPower(0);
            //}
        //}

//        intakeMotor.setPower(0);
//    }

    public void loop(){
        Drive();
//        shoot();
//        Intake()
    }

}
