package server;

import at.sporty.team1.application.controller.MemberController;
import at.sporty.team1.application.controller.TournamentController;
import at.sporty.team1.domain.Member;
import at.sporty.team1.domain.Tournament;
import at.sporty.team1.persistence.PersistenceFacade;
import at.sporty.team1.rmi.dtos.DTOPair;
import at.sporty.team1.rmi.dtos.DepartmentDTO;
import at.sporty.team1.rmi.dtos.MatchDTO;
import at.sporty.team1.rmi.dtos.TeamDTO;
import at.sporty.team1.rmi.exceptions.NotAuthorisedException;
import at.sporty.team1.rmi.exceptions.UnknownEntityException;
import org.junit.Test;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by sereGkaluv on 23-Nov-15.
 */
public class DAOTest {

    //This is a fast and dirty implementation of test for DAO methods

    @Test
    public void MatchLoadTest() {
        try {
            List<MatchDTO> l = new TournamentController().searchAllTournamentMatches(1);
            System.out.println("Received list of size: " + l.size());
        } catch (RemoteException | UnknownEntityException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void departmentTeamFetchedListTest() {
        try {
            List<DTOPair<DepartmentDTO, TeamDTO>> l = new MemberController().loadFetchedDepartmentTeamList(2328, null);
            System.out.println("Received list of size: " + l.size());
        } catch (RemoteException | UnknownEntityException | NotAuthorisedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isDepartmentHeadTest() {
        Member departmentHead = PersistenceFacade.getNewMemberDAO().findById(2000);
        Integer departmentId = 1001;

        System.out.println(
            "\nIs dept head: " + PersistenceFacade.getNewDepartmentDAO().isDepartmentHead(departmentHead, departmentId)
        );
    }

    @Test
    public void findBySportTest() {
        String sport = "Soccer";

        List<Tournament> tournamentList = PersistenceFacade.getNewTournamentDAO().findBySport(sport);

        System.out.println("\nSearch by sport: " + sport);
        for(Tournament tournament : tournamentList) {
            System.out.println("Id: " + tournament.getTournamentId());
        }
    }

    @Test
    public void findByEventDateTest() {
        String eventDate = "2016-01-01";

        List<Tournament> tournamentList = PersistenceFacade.getNewTournamentDAO().findByEventDate(eventDate);

        System.out.println("\nSearch by date: " + eventDate);
        for(Tournament tournament : tournamentList) {
            System.out.println("Id: " + tournament.getTournamentId());
        }
    }

    @Test
    public void findByLocationTest() {
        String location = "Au";

        List<Tournament> tournamentList = PersistenceFacade.getNewTournamentDAO().findByLocation(location);

        System.out.println("\nSearch by location: " + location);
        for(Tournament tournament : tournamentList) {
            System.out.println("Id: " + tournament.getTournamentId());
        }
    }
}
