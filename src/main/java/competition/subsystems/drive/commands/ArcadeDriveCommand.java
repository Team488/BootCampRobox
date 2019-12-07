package competition.subsystems.drive.commands;

import com.google.inject.Inject;

import competition.operator_interface.OperatorInterface;
import competition.subsystems.drive.DriveSubsystem;
import xbot.common.command.BaseCommand;

public class ArcadeDriveCommand extends BaseCommand {

    DriveSubsystem drive;
    OperatorInterface oi;

    @Inject
    public ArcadeDriveCommand(OperatorInterface oi, DriveSubsystem drive) {
        this.oi = oi;
        this.drive = drive;
        this.requires(drive);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        
        double left = oi.gamepad.getLeftVector().y + oi.gamepad.getRightVector().x;
        double right = oi.gamepad.getLeftVector().y - oi.gamepad.getRightVector().x;
        
        drive.tankDrive(left, right);
    }
}