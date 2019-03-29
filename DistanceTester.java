import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.utility.Delay;

public class DistanceTester {
	EV3MediumRegulatedMotor motorArm;
	EV3LargeRegulatedMotor motorLeft;
	EV3LargeRegulatedMotor motorRight;
	EV3ColorSensor colorSensorLeft;
	EV3ColorSensor colorSensorRight;
	EV3ColorSensor colorSensorSide;
	
	DistanceTester() {
		this.motorArm = new EV3MediumRegulatedMotor(MotorPort.A);
		this.motorLeft = new EV3LargeRegulatedMotor(MotorPort.B);
		this.motorRight = new EV3LargeRegulatedMotor(MotorPort.C);
		this.colorSensorLeft = new EV3ColorSensor(SensorPort.S1);
		this.colorSensorRight = new EV3ColorSensor(SensorPort.S2);
		this.colorSensorSide = new EV3ColorSensor(SensorPort.S4);
	}

	public static void main(String[] args) {
		DistanceTester robot = new DistanceTester();
		LCD.drawString("Press enter!", 0, 0);
		Button.ENTER.waitForPress();
		robot.drive(100, 5000); //first parameter: speed, second parameter: time

	}
	
	public void drive(int speed, int time) {
		motorLeft.setSpeed(speed);
		motorRight.setSpeed(speed);
		motorLeft.forward();
		motorRight.forward();
		Delay.msDelay(time);
		motorLeft.stop(true);
		motorRight.stop(true);
	}

}
