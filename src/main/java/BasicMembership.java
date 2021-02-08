public class BasicMembership extends Membership{

    @Override
    int registerPoints(int bonusPointBalance, int newPoints) {
        return bonusPointBalance + newPoints;
    }

    @Override
    String getMembershipName() {
        return "Basic";
    }

}
