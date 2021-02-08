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

    public int getMemberNumber() {
        return memberNumber;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    public String getName() {
        return name;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public String getPassword() {
        return password;
    }

    public Membership getMembership() {
        return membership;
    }

    public boolean checkPassword(String password){
        boolean success = false;
        if (password.equals(getPassword())){success = true;}
        return success;
    }
}
