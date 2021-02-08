public class GoldMembership extends Membership{
    float POINTS_SCALING_FACTOR_1 = 1.3f;
    float POINTS_SCALING_FACTOR_2 = 1.5f;

    @Override
    int registerPoints(int bonusPointBalance, int newPoints) {
        if (bonusPointBalance < 90000){
            return Math.round(bonusPointBalance + newPoints * POINTS_SCALING_FACTOR_1);
        } else {
            return Math.round(bonusPointBalance + newPoints * POINTS_SCALING_FACTOR_2);
        }
    }

    @Override
    String getMembershipName() {
        return "Gold";
    }

}
