import java.time.LocalDate;

/**
 * A bonus member is a class that provides the mean to store and
 * interact with the customer data. The class is also responsible
 * for updating a customers membership levels when asked to.
 *
 * @author morten
 */
public class BonusMember {
    private int memberNumber;
    private final LocalDate enrolledDate;
    private int bonusPointsBalance = 0;
    private String name;
    private String eMailAddress;
    private String password;
    private Membership membership;
    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;


    /**
     * Creates a new instance of BonusMember, and then runs
     * checkAndSetMembership() to make sure that a membership level is set.
     *
     * @param memberNumber The member number to be associated with this user
     * @param enrolledDate The date the user is created
     * @param bonusPoints The amount of bonusPoints the user has on creation
     * @param name The name to be associated with this user
     * @param eMailAddress The e-mail address to be associated with this user
     */
    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPoints, String name, String eMailAddress){
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.name = name;
        this.eMailAddress = eMailAddress;
        this.bonusPointsBalance += bonusPoints;
        checkAndSetMembership();
    }

    public int getMemberNumber() { return memberNumber; }

    public LocalDate getEnrolledDate() { return enrolledDate; }

    public int getBonusPointsBalance() { return bonusPointsBalance; }

    public String getName() { return name; }

    public String geteMailAddress() { return eMailAddress; }

    public String getPassword() { return password; }

    public Membership getMembership() { return membership; }

    /**
     * Checks if the parameter {@code password} is the correct password for
     * this user. If the passwords don't match {@code false} is returned.
     *
     * @param password The password that is entered
     * @return {@code true} if the passwords match
     *         {@code false} if the entered password is wrong.
     */
    public boolean checkPassword(String password){
        boolean success = false;
        if (password.equals(getPassword())){success = true;}
        return success;
    }

    /**
     * Takes the new points that is to be added, and uses the methods for
     * point registering that corresponds with the membership level of the user.
     *
     * @param newPoints The points that is to be added.
     *                  (Excluding membership-level-multipliers)
     */
    public void registerBonusPoints(int newPoints){
        bonusPointsBalance = getMembership().registerPoints(getBonusPointsBalance(),newPoints);
        checkAndSetMembership();
    }

    public String getMembershipLevel(){ return getMembership().getMembershipName(); }

    /**
     * This method is responsible for checking and updating the membership level if it turns out to be necessary.
     * It does NOT take into consideration that a member can loose points and therefore go down in level.
     *
     * It first checks if the user doesn't have any level assigned. If that's the case it then proceeds
     * to check where the point-balance is compared to the level-limits. When the right membership level
     * is found a new instance of that level is created and assigned to the user.
     *
     * If a membership level is already assigned to the user, it then checks if the balance is over the
     * {@code GOLD_LIMIT} and if the level isn't already gold. If that's the case a new instance of
     * GoldMember is created and assigned to the user.
     *
     * Lastly, if none of the above apply, it then checks if the balance is over the {@code SILVER_LIMIT}
     * and if the level is currently at "Basic". If that's the case a new instance of SilverMember is
     * created and assigned to the user.
     */
    public void checkAndSetMembership(){
        if (membership == null){
            if (bonusPointsBalance >= GOLD_LIMIT){membership = new GoldMembership();}
            else if (bonusPointsBalance >= SILVER_LIMIT){membership = new SilverMembership();}
            else {membership = new BasicMembership();}
        }
        else if (!(membership instanceof GoldMembership) && bonusPointsBalance >= GOLD_LIMIT){
            membership = new GoldMembership();
        }
        else if (membership instanceof BasicMembership && bonusPointsBalance >= SILVER_LIMIT){
            membership = new SilverMembership();
        }
    }

}
