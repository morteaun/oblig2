/**
 * BasicMember is a subclass of Membership.
 * A basic member is has no extra perks when registering points
 * @author morten
 */
public class BasicMembership extends Membership{

    /**
     * Registers new bonuspoints to the member.
     *
     * @param bonusPointBalance The existing balance of bonuspoints
     * @param newPoints The amount of bonuspoints to be added
     * @return The new amount of bonuspoints
     */
    @Override
    int registerPoints(int bonusPointBalance, int newPoints) {
        return bonusPointBalance + newPoints;
    }

    /**
     * A method that is used to get an indication of the
     * current membership level.
     *
     * @return "Basic" (A string)
     */
    @Override
    String getMembershipName() {
        return "Basic";
    }

}
