package at.sporty.team1.shared.api.ejb;

import at.sporty.team1.shared.api.real.ITournamentController;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 * Created by f00 on 10.12.15.
 */
@Local
@Remote
public interface ITournamentControllerEJB extends ITournamentController, IRemoteControllerEJB {
}