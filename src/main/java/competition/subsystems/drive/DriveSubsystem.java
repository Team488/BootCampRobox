package competition.subsystems.drive;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.apache.log4j.Logger;

import xbot.common.command.BaseSubsystem;
import xbot.common.controls.actuators.XCANTalon;
import xbot.common.injection.wpi_factories.CommonLibFactory;
import xbot.common.properties.XPropertyManager;

@Singleton
public class DriveSubsystem extends BaseSubsystem {
    private static Logger log = Logger.getLogger(DriveSubsystem.class);

    public final XCANTalon leftMaster;
    public final XCANTalon leftFollower;
    public final XCANTalon leftFollower2;

    public final XCANTalon rightMaster;
    public final XCANTalon rightFollower;
    public final XCANTalon rightFollower2;

    @Inject
    public DriveSubsystem(CommonLibFactory factory, XPropertyManager propManager) {
        log.info("Creating DriveSubsystem");

        this.leftMaster = factory.createCANTalon(21);
        this.leftFollower = factory.createCANTalon(22);
        this.leftFollower2 = factory.createCANTalon(23);

        this.rightMaster = factory.createCANTalon(32);
        this.rightFollower = factory.createCANTalon(33);
        this.rightFollower2 = factory.createCANTalon(34);

        XCANTalon.configureMotorTeam("LeftDrive", "LeftMaster", leftMaster, leftFollower, 
        false, false, false);
        XCANTalon.configureMotorTeam("RightDrive", "RightMaster", rightMaster, rightFollower, 
        true, true, false);

        leftFollower2.configureAsFollowerMotor(leftMaster, false);
        rightFollower2.configureAsFollowerMotor(rightMaster, true);
    }

    public void tankDrive(double leftPower, double rightPower) {
        this.leftMaster.simpleSet(leftPower);
        this.rightMaster.simpleSet(rightPower);
    }
}
