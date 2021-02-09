/**
 * GoldMember is a subclass of Membership.
 * A gold member will have a 30% increase to the registered points if
 * their balance is less than 90000, 50% if it's equal to or more than 90000.
 * @author morten
 */
public class GoldMembership extends Membership{
    float POINTS_SCALING_FACTOR_1 = 1.3f;
    float POINTS_SCALING_FACTOR_2 = 1.5f;

    /**
     * Registers new bonuspoints to the member.
     * Multiplies the parameter {@code newPoints} by
     * {@code POINTS_SCALING_FACTOR_1} if the parameter {@code bonusPointBalance}
     * is less than 90000, {@code POINTS_SCALING_FACTOR_2} if not.
     *
     * @param bonusPointBalance The existing balance of bonuspoints
     * @param newPoints The amount of bonuspoints to be added
     * @return The new amount of bonuspoints
     */
    @Override
    int registerPoints(int bonusPointBalance, int newPoints) {
        if (bonusPointBalance < 90000){
            return Math.round(bonusPointBalance + newPoints * POINTS_SCALING_FACTOR_1);
        } else {
            return Math.round(bonusPointBalance + newPoints * POINTS_SCALING_FACTOR_2);
        }
    }

    /**
     * A method that is used to get an indication of the
     * current membership level.
     *
     * @return "Gold" (A string)
     */
    @Override
    String getMembershipName() {
        return "Gold";
    }

}
