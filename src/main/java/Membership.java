import java.lang.*;

/**
 * Membership is an abstract class, created to be a super to
 * the basic-, silver- and gold membership classes.
 * @author morten
 */
public abstract class Membership {

    abstract int registerPoints(int bonusPointBalance, int newPoints);

    abstract String getMembershipName();
}
