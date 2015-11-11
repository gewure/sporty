package at.sporty.team1.rmi.api;

import at.sporty.team1.rmi.dtos.DepartmentDTO;
import at.sporty.team1.rmi.dtos.MemberDTO;
import at.sporty.team1.rmi.dtos.TeamDTO;
import at.sporty.team1.rmi.exceptions.ValidationException;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by sereGkaluv on 02-Nov-15.
 */
public interface ITeamController extends Remote, Serializable {

    /**
     * Creates new or saves old team in data storage with data from the DTO.
     *
     * @param teamDTO DTO for team creation or save
     * @throws RemoteException
     * @throws ValidationException
     */
    void createOrSaveTeam(TeamDTO teamDTO)
    throws RemoteException, ValidationException;

    /**
     * Search for teamList by Department.
     *
     * @param departmentDTO department teams of which will be searched.
     * @return List<TeamDTO> List of all teams who are assigned to the given Department, or null.
     * @throws RemoteException
     */
    List<TeamDTO> searchByDepartment(DepartmentDTO departmentDTO)
    throws RemoteException;

    /**
     * Returns a list of all teams to which member with a given id is assigned.
     *
     * @param memberDTO target member (will be used for search)
     * @return List<TeamDTO> List of all teams
     * @throws RemoteException
     */
    List<TeamDTO> searchTeamsByMember(MemberDTO memberDTO)
    throws RemoteException;

    /**
     * Returns a list of all members assigned to the given team.
     *
     * @param teamDTO target team (will be used for search)
     * @return List<MemberDTO> List of all teams
     * @throws RemoteException
     */
    List<MemberDTO> loadTeamMembers(TeamDTO teamDTO)
    throws RemoteException;

    /**
     * Assigns member to selected team.
     *
     * @param memberDTO target member (will be used to update teams list)
     * @param teamDTO team to which member with given id will be assigned.
     * @throws RemoteException
     */
    void assignMemberToTeam(MemberDTO memberDTO, TeamDTO teamDTO)
    throws RemoteException;

    /**
     * Removes member from selected team.
     *
     * @param memberDTO target member (will be used to update teams list)
     * @param teamDTO team from which member with given id will be removed.
     * @throws RemoteException
     */
    void removeMemberFromTeam(MemberDTO memberDTO, TeamDTO teamDTO)
    throws RemoteException;
}
