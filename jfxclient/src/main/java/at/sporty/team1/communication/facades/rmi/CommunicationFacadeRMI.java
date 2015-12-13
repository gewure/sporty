package at.sporty.team1.communication.facades.rmi;

import at.sporty.team1.communication.facades.api.*;
import at.sporty.team1.communication.facades.rmi.adapters.*;
import at.sporty.team1.communication.util.RemoteCommunicationException;
import at.sporty.team1.communication.util.RemoteObjectRegistry;
import at.sporty.team1.shared.api.rmi.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

public class CommunicationFacadeRMI implements ICommunicationFacade {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String RMI_TARGET = "RMI_TARGET";
    private static final String PROPERTY_FILE = "rmi.properties";
    private static final Properties PROPERTIES = new Properties();

    public CommunicationFacadeRMI() {
        try {

            URL propertyURL = getClass().getClassLoader().getResource(PROPERTY_FILE);
            if (propertyURL != null) {

                PROPERTIES.load(new FileInputStream(propertyURL.getFile()));

            } else {
                throw new FileNotFoundException(PROPERTY_FILE + " was not found");
            }

        } catch (IOException e) {
            LOGGER.error("An error occurs while loading RMI properties from {}.", PROPERTY_FILE, e);
        }
	}
	
	public IMemberControllerUniversal lookupForMemberController()
    throws RemoteCommunicationException {
        try {

            IMemberControllerRMI controllerRMI = (IMemberControllerRMI) Naming.lookup(String.format(
                PROPERTIES.getProperty(RMI_TARGET),
                RemoteObjectRegistry.MEMBER_CONTROLLER.getNamingRMI()
            ));

            return new MemberControllerRMIAdapter(controllerRMI);

        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            throw new RemoteCommunicationException(e);
        }
    }
	
    public ITeamControllerUniversal lookupForTeamController()
    throws RemoteCommunicationException {
        try {

            ITeamControllerRMI controllerRMI = (ITeamControllerRMI) Naming.lookup(String.format(
                PROPERTIES.getProperty(RMI_TARGET),
                RemoteObjectRegistry.TEAM_CONTROLLER.getNamingRMI()
            ));

            return new TeamControllerRMIAdapter(controllerRMI);

        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            throw new RemoteCommunicationException(e);
        }
    }
	 
    public IDepartmentControllerUniversal lookupForDepartmentController()
    throws RemoteCommunicationException{
        try {

            IDepartmentControllerRMI controllerRMI = (IDepartmentControllerRMI) Naming.lookup(String.format(
                PROPERTIES.getProperty(RMI_TARGET),
                RemoteObjectRegistry.DEPARTMENT_CONTROLLER.getNamingRMI()
            ));

            return new DepartmentControllerRMIAdapter(controllerRMI);

        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            throw new RemoteCommunicationException(e);
        }
    }
	 
    public ILoginControllerUniversal lookupForLoginController()
    throws RemoteCommunicationException {
        try {

            ILoginControllerRMI controllerRMI = (ILoginControllerRMI) Naming.lookup(String.format(
                PROPERTIES.getProperty(RMI_TARGET),
                RemoteObjectRegistry.LOGIN_CONTROLLER.getNamingRMI()
            ));

            return new LoginControllerRMIAdapter(controllerRMI);

        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            throw new RemoteCommunicationException(e);
        }
    }

	public ITournamentControllerUniversal lookupForTournamentController()
	throws RemoteCommunicationException {
        try {

            ITournamentControllerRMI controllerRMI = (ITournamentControllerRMI) Naming.lookup(String.format(
                PROPERTIES.getProperty(RMI_TARGET),
                RemoteObjectRegistry.TOURNAMENT_CONTROLLER.getNamingRMI()
            ));

            return new TournamentControllerRMIAdapter(controllerRMI);

        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            throw new RemoteCommunicationException(e);
        }
	}
	
	public INotificationControllerUniversal lookupForNotificationController()
    throws RemoteCommunicationException {
        try {

            INotificationControllerRMI controllerRMI = (INotificationControllerRMI) Naming.lookup(String.format(
                PROPERTIES.getProperty(RMI_TARGET),
                RemoteObjectRegistry.NOTIFICATION_CONTROLLER.getNamingRMI())
            );

            return new NotificationControllerRMIAdapter(controllerRMI);

        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            throw new RemoteCommunicationException(e);
        }
    }
}
