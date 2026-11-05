//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
//
//@TeleOp(name = "Intake TeleOp", group = "Mechanism")
//public class IntakeTeleOp extends LinearOpMode {
//
//    private DcMotor intakeMotor;
//
//    @Override
//    public void runOpMode() {
//
//        intakeMotor = hardwareMap.get(DcMotor.class, "intake");
//        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
//
//        waitForStart();
//
//        while (opModeIsActive()) {
//            if (gamepad1.x) {
//                intakeMotor.setPower(1.0);
//            } else {
//                intakeMotor.setPower(0);
//            }
//
//        }
//
//        intakeMotor.setPower(0);
//    }
//}