public class SilverMembership extends Membership{
    float POINTS_SCALING_FACTOR = 1.2f;

    @Override
    int registerPoints(int bonusPointBalance, int newPoints) {
        return Math.round(bonusPointBalance + newPoints * POINTS_SCALING_FACTOR);
    }

    @Override
    String getMembershipName() {
        return "Silver";
    }

}
