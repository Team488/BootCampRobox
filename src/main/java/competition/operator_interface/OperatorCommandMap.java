package competition.operator_interface;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import competition.subsystems.drive.commands.ArcadeDriveCommand;
import competition.subsystems.drive.commands.TankDriveWithJoysticksCommand;

@Singleton
public class OperatorCommandMap {
    // For mapping operator interface buttons to commands

    // Example for setting up a command to fire when a button is pressed:
    
    @Inject
    public void setupMyCommands(
            OperatorInterface operatorInterface,
            TankDriveWithJoysticksCommand tank,
            ArcadeDriveCommand arcade)
    {
        operatorInterface.gamepad.getifAvailable(1).whenPressed(tank);
        operatorInterface.gamepad.getifAvailable(2).whenPressed(arcade);
    }

}
