/**
 * SilverMember is a subclass of Membership.
 * A silver member will have a 20% increase to the registered points
 * @author morten
 */
public class SilverMembership extends Membership{
    float POINTS_SCALING_FACTOR = 1.2f;

    /**
     * Registers new bonuspoints to the member.
     * Multiplies the parameter {@code newPoints} by
     * {@code POINTS_SCALING_FACTOR} which is equal to 1.2
     *
     * @param bonusPointBalance The existing balance of bonuspoints
     * @param newPoints The amount of bonuspoints to be added
     * @return The new amount of bonuspoints
     */
    @Override
    int registerPoints(int bonusPointBalance, int newPoints) {
        return Math.round(bonusPointBalance + newPoints * POINTS_SCALING_FACTOR);
    }

    /**
     * A method that is used to get an indication of the
     * current membership level.
     *
     * @return "Silver" (A string)
     */
    @Override
    String getMembershipName() {
        return "Silver";
    }

}
