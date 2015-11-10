package at.sporty.team1.rmi.api;


import at.sporty.team1.rmi.dtos.MemberDTO;
import at.sporty.team1.rmi.dtos.TeamDTO;
import at.sporty.team1.rmi.exceptions.ValidationException;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IMemberController extends Remote, Serializable {

    /**
     * Creates new or saves old member in data storage with data from the DTO.
     *
     * @param memberDTO DTO for member creation or save
     * @throws RemoteException
     * @throws ValidationException
     */
    void createOrSaveMember(MemberDTO memberDTO)
    throws RemoteException, ValidationException;

    /**
     * Search for memberList by String (first name and last name, first name or last name).
     *
     * @param searchString String to be searched.
     * @return List<MemberDTO> List of all members who's full name matched given data, or null.
     * @throws RemoteException
     */
    List<MemberDTO> searchMembersByNameString(String searchString, boolean notPaidCheckbox, boolean paidCheckbox)
    throws RemoteException, ValidationException;


    /**
     * Search for memberList by team name.
     *
     * @param teamName Team name to be searched.
     * @return List<MemberDTO> List of all members who are assigned to the given team, or null.
     * @throws RemoteException
     */
    List<MemberDTO> searchMembersByTeamName(String teamName, boolean notPaidCheckbox, boolean paidCheckbox)
    throws RemoteException, ValidationException;


    /**
     * Search for memberList by date of birth.
     *
     * @param dateOfBirth Date of birth to be searched.
     * @return List<MemberDTO> List of all members who's date of birth matched given data, or null.
     * @throws RemoteException
     */
    List<MemberDTO> searchMembersByDateOfBirth(String dateOfBirth, boolean notPaidCheckbox, boolean paidCheckbox)
    throws RemoteException, ValidationException;

    /**
     * Deletes member form the data storage with data from the DTO.
     *
     * @param memberDTO DTO of a member who will be deleted
     * @throws RemoteException
     */
    void deleteMember(MemberDTO memberDTO)
    throws RemoteException;

    /**
     * Search for all Members.
     *
     * @return List<MemberDTO> List of all members
     * @throws RemoteException
     */
    List<MemberDTO> searchAllMembers()
    throws RemoteException;

    /**
     * Returns a list of all teams to which member with a given id is assigned.
     *
     * @param memberId id of a target member (will be used for search)
     * @return List<TeamDTO> List of all teams
     * @throws RemoteException
     */
    List<TeamDTO> getTeams(Integer memberId)
    throws RemoteException;

    /**
     * Assigns member to selected team.
     *
     * @param memberId id of the target member (will be used to update teams list)
     * @param teamId id of a team to which member with given id will be assigned.
     * @throws RemoteException
     */
    void assignMemberToTeam(Integer memberId, Integer teamId)
    throws RemoteException;

    /**
     * Removes member from selected team.
     *
     * @param memberId id of the target member (will be used to update teams list)
     * @param teamId id of a team from which member with given id will be removed.
     * @throws RemoteException
     */
    void removeMemberFromTeam(Integer memberId, Integer teamId)
    throws RemoteException;
}
