import java.time.LocalDate;

public class BonusMember {
    private int memberNumber;
    private LocalDate enrolledDate;
    private int bonusPointsBalance = 0;
    private String name;
    private String eMailAddress;
    private String password;
    private Membership membership;
    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

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


    public boolean checkPassword(String password){
        boolean success = false;
        if (password.equals(getPassword())){success = true;}
        return success;
    }

    public void registerBonusPoints(int newPoints){
        this.bonusPointsBalance = getMembership().registerPoints(getBonusPointsBalance(),newPoints);
        checkAndSetMembership();
    }

    public String getMembershipLevel(){ return getMembership().getMembershipName(); }

    public void checkAndSetMembership(){
        if (!getMembershipLevel().equals("Gold") && bonusPointsBalance >= GOLD_LIMIT){
            membership = new GoldMembership();
        }
        else if (!getMembershipLevel().equals("Silver") && bonusPointsBalance >= SILVER_LIMIT){
            membership = new SilverMembership();
        }
        else if (!getMembershipLevel().equals("Gold") && !getMembershipLevel().equals("Silver") &&
                !getMembershipLevel().equals("Basic")){
            membership = new BasicMembership();
        }
    }

}
